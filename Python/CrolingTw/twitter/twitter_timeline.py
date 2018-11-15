import oauth2
import json
import datetime
from twitter.config import *

def oauth2_request(consumer_key, consumer_secret, access_token, access_secret):
    try:
        consumer = oauth2.Consumer(key=consumer_key, secret=consumer_secret)
        token = oauth2.Token(key=access_token, secret=access_secret)
        client = oauth2.Client(consumer, token) # client는 인증정보
        return client
    except Exception as e:
        print(e)
        return None

def get_user_timeline(client, screen_name, count=50, include_rts='False'):
    base = 'https://api.twitter.com/1.1'
    node = '/statuses/user_timeline.json'
    fields = '?screen_name=%s&count=%s&include_rts=%s' % (screen_name, count, include_rts)
    # fields = '?screen_name=%s'%screen_name
    url = base + node + fields
    print("url:", url)
    response, data = client.request(url)
    print('response:', response)
    print('len(data):', len(data))
    print('data:', data)
    try:
        if response['status'] == '200' :
            return json.loads(data.decode('utf-8'))
    except Exception as e:
        print(e)
        return None

def getTwitterTwit(tweet, jsonResult):
    tweet_id = tweet['id_str']

    if 'text' not in tweet.keys():
        tweet_message = ""
    else:
        tweet_message = tweet['text']

    screen_name = '' if 'user' not in tweet.keys() else tweet['user']['screen_name']

    tweet_link = ""
    if tweet['entities']['urls']:
        for i, val in enumerate(tweet['entities']['urls']):
            tweet_link = tweet_link + tweet['entities']['urls'][i]['url'] + " "
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

    jsonResult.append({'post_id':tweet_id, 'message':tweet_message,
                       'name':screen_name, 'link':tweet_link,
                       'created_time':tweet_published, 'num_reactions':num_favorite_count,
                       'num_comments':num_comments, 'num_shares':num_shares,
                       'num_likes':num_likes, 'num_loves':num_loves,
                       'num_wows':num_wows, 'num_hahas':num_hahas,
                       'num_sads':num_sads, 'num_angrys':num_angrys, 'hashtags':hashtags})

def main():
    screen_name = 'JTBC_news' #정보 원하는 계정 넣기
    num_posts = 50
    jsonResult = []

    client = oauth2_request(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_SECRET) #인증준비
    tweets = get_user_timeline(client, screen_name) #토큰생성
    for tweet in tweets:
        getTwitterTwit(tweet, jsonResult)

    with open('%s_twitter.json' % screen_name, 'w', encoding='utf-8') as outline:
        str_ = json.dumps(jsonResult, indent=4, sort_keys=True, ensure_ascii=False)
        outline.write(str_)

    print('%s.twitter.json Saved' % screen_name)

if __name__ == '__main__':
    main()
