import oauth2
import urllib.request
import json
import datetime
import time
from twitter.config import *

class TWoauth():

    def __init__(self, consumer_key, consumer_secret, access_key, access_secret):
        self.oauth_consumer = oauth2.Consumer(key=consumer_key, secret=consumer_secret)
        self.oauth_token = oauth2.Token(key=access_key, secret=access_secret)
        self.signature_method_hmac_sha1 = oauth2.SignatureMethod_HMAC_SHA1() # 암호화객체
        self.http_method = 'GET'
        self.http_handler = urllib.request.HTTPHandler(debuglevel=0)
        self.https_handler = urllib.request.HTTPSHandler(debuglevel=0)

    def getTWRequest(self, url, method, parameters):
        req = oauth2.Request.from_consumer_and_token(self.oauth_consumer,
                                                     token = self.oauth_token,
                                                     http_method = self.http_method,
                                                     http_url = url,
                                                     parameters = parameters)
        req.sign_request(self.signature_method_hmac_sha1, self.oauth_consumer, self.oauth_token) #암호화방식으로 요청

        if method == 'POST':
            encoded_post_data = req.to_postdata()
        else:
            encoded_post_data = None

        to_url = req.to_url()
        print('to_url:', to_url)

        opener = urllib.request.OpenerDirector()
        opener.add_handler(self.http_handler)
        opener.add_handler(self.https_handler)

        response = opener.open(to_url, encoded_post_data)

        return response

def getTwitterTwit(tweet, jsonResult):
    tweet_id = tweet['id_str']
    tweet_message = "" if 'text' not in tweet.keys() else tweet['text']
    screen_name = "" if 'user' not in tweet.keys() else tweet['user']['screen_name']

    tweet_link = ""
    if tweet['entities']['urls']:
        for i, val in enumerate(tweet['entities']['urls']):
            tweet_link = tweet_link+tweet['entities']['urls'][i]['url'] + " "
    else:
        tweet_link = ""

    hashtags = ""
    if tweet['entities']['hashtags']:
        for i, val in enumerate(tweet['entities']['hashtags']):
            hashtags = hashtags + tweet['entities']['hashtags'][i]['text'] + " "
    else:
        hashtags = ""

    if 'created_at' in tweet.keys():
        #Twitter used
        tweet_published = datetime.datetime.strptime(tweet['created_at'], '%a %b %d %H:%M:%S +0000 %Y')
        tweet_published = tweet_published + datetime.timedelta(hours=+9)
        tweet_published = tweet_published.strftime('%Y-%m-%d %H:%M:%S')
    else:
        tweet_published = ""

    num_favorite_count = 0 if 'favorite_count' not in tweet.keys() else tweet['favorite_count']
    num_comments = 0
    num_shares = 0 if 'retweet_count' not in tweet.keys() else tweet['retweet_count']
    num_likes = num_favorite_count
    num_loves = num_wows = num_hahas = num_sads = num_angrys = 0

    jsonResult.append({'post_id': tweet_id, 'message': tweet_message,
                       'name': screen_name, 'link': tweet_link,
                       'created_time': tweet_published, 'num_reactions': num_favorite_count,
                       'num_comments': num_comments, 'num_shares': num_shares,
                       'num_likes': num_likes, 'num_loves': num_loves,
                       'num_wows': num_wows, 'num_hahas': num_hahas,
                       'num_sads': num_sads, 'num_angrys': num_angrys, 'hashtags': hashtags})

def fetch(filter, jsonResult):
    twoauth = TWoauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_SECRET)

    url = "https://stream.twitter.com/1.1/statuses/filter.json"
    parameters = []
    parameters.append({'track', filter})

    try:
        f = twoauth.getTWRequest(url, 'GET', parameters)
        cnt = 0
        while True:
            line = f.readline()
            if line:
                try:
                    tweet = json.loads(line.decode('utf-8'))
                    print('####[Scrapped Time : %s]' % datetime.datetime.now())
                    print(tweet['text'])
                    getTwitterTwit(tweet, jsonResult)
                    cnt = cnt+1
                    if cnt == 5:
                        break
                except ValueError as ve:
                    print(ve)
                except KeyError as e:
                    print(e)
            else:
                print('#')
                time.sleep(0.1)

    except KeyboardInterrupt:
        f.close()
        with open('filter_twitter.json', 'w', encoding="utf-8") as outfile:
            retJson = json.dumps(jsonResult, indent=4, sort_keys=True, ensure_ascii=False)
            outfile.write(retJson)

        print('%s_twitter.json SAVED' % filter)

if __name__ == "__main__":
    jsonResult = []
    filter_name = '문재인,김정은,남북' # , 가 or연산, 공백은 and연산
    fetch(filter_name, jsonResult)

    with open('filter_twitter.json', 'w', encoding="utf-8") as outfile:
        retJson = json.dumps(jsonResult, indent=4, sort_keys=True, ensure_ascii=False)
        outfile.write(retJson)

    print('twitter SAVED')
