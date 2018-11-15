import urllib.request
import datetime
import json
from naver.config import *

def get_request_url(url):
    req = urllib.request.Request(url)
    req.add_header("X-Naver-Client-id", client_id)
    req.add_header("X-Naver-Client-Secret", client_secret)
    try:
        response = urllib.request.urlopen(req)
        if response.getcode() == 200 :
            print("[%s] Url Request Success" % datetime.datetime.now())
            return response.read().decode('utf-8')
    except Exception as e:
        print(e)
        print("[%s] Error for URL : %s" % (datetime.datetime.now(), url))
        return  None

def getNaverSearchResult(sNode, search_text, page_start, display):
    base = "https://openapi.naver.com/v1/search"
    node = "/%s.json" % sNode
    parameters = "?query=%s&start=%s&display=%s" % (urllib.parse.quote(search_text), page_start, display)
    url = base + node + parameters

    retData = get_request_url(url)

    if retData == None :
        return None
    else:
        print('retData:', retData)
        return json.loads(str(retData))

def getPostData(post, jsonResult):
    title = post['title']
    description = post['description']
    bl_link = post['bloggerlink']
    bl_name = post['bloggername']
    link = post['link']
    pDate = post['postdate']

    jsonResult.append({'title':title, 'description': description, 'bl_link':bl_link,
                       'link':link, 'bl_name':bl_name, 'postdate':pDate})
    return

def main():
    jsonResult = []

    sNode = 'blog'
    search_text = '문재인'
    display_count = 10

    jsonSearch = getNaverSearchResult(sNode, search_text, 1, display_count)
    print("jsonSearch:", jsonSearch)

    # while ((jsonSearch != None) and (jsonSearch['display'] != 0)) :
    for post in jsonSearch['items']: #items에 기사가 저장되어 있음
        getPostData(post, jsonResult)

        # nStart = jsonSearch['start'] + jsonSearch['display']
        # jsonSearch = getNaverSearchResult(sNode, search_text, nStart, display_count)

    with open('%s_naver_%s.json' % (search_text, sNode), 'w', encoding='utf-8') as outfile:
        retJson = json.dumps(jsonResult, indent=4, sort_keys=True, ensure_ascii=False)
        outfile.write(retJson)

    print('%s_naver_%s.json SAVED' % (search_text, sNode))

if __name__ == '__main__':
    main()