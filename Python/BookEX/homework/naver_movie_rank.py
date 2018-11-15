from bs4 import BeautifulSoup
import urllib.request as req
# pnt&date=20181001

def cnt_check() :
    day = input("원하는 날짜를 입력해주세요(ex>2017년5월8일 20170508) > ")
    parameters = "cnt&date="+day
    url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=" + parameters

    res = req.urlopen(url)
    soup = BeautifulSoup(res, 'html.parser')
    rank_tag = soup.select("tr > td.ac > img[width=14]")
    title_tag = soup.select("td.title > div.tit3 > a")

    print()
    for rank, title in zip(rank_tag, title_tag):
        print("%s등:%s" % (rank['alt'], title.string))
    print()

def cur_check() :
    day = input("원하는 날짜를 입력해주세요(ex>2017년5월8일 20170508) > ")
    parameters = "cur&date="+day
    url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=" + parameters

    res = req.urlopen(url)
    soup = BeautifulSoup(res, 'html.parser')
    rank_tag = soup.select("tr > td.ac > img[width=14]")
    title_tag = soup.select("td.title > div.tit5 > a")
    point_tag = soup.select("td.point")

    print()
    for rank, title, point in zip(rank_tag, title_tag, point_tag):
        print("%s등:%s / 평점:%s" % (rank['alt'], title.string, point.string))
    print()

def pnt_check() :
    day = input("원하는 날짜를 입력해주세요(ex>2017년5월8일 20170508) > ")
    parameters = "pnt&date="+day
    url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=" + parameters

    res = req.urlopen(url)
    soup = BeautifulSoup(res, 'html.parser')
    rank_tag = soup.select("tr > td.ac > img[width=14]")
    title_tag = soup.select("td.title > div.tit5 > a")
    point_tag = soup.select("td.point")

    print()
    for rank, title, point in zip(rank_tag, title_tag, point_tag):
        print("%s등:%s / 평점:%s" % (rank['alt'], title.string, point.string))
    print()


if __name__ == '__main__':
    while True:
        print("***메뉴 선택***")
        print("1.조회순으로 검색")
        print("2.평점순으로 검색(현재상영)")
        print("3.평점순으로 검색(모든영화)")
        print("4.나가기")
        menu = input("해당 번호를 눌러주세요 > ")

        if menu == '1':
            cnt_check()
        elif menu == '2':
            cur_check()
        elif menu == '3':
            pnt_check()
        elif menu == '4':
            print('종료,,,')
            break
        else:
            print('1~4사이의 수를 입력해주세요.')
            continue

"""
<teacher-code>
menu = input("\n영화랭킹 메뉴를 선택하세요!!! => ")
if menu == '1':
    sel = 'cnt'
elif menu == '2':
    sel = 'cur'
elif menu == '3':
    sel = 'pnt'
else:
    print('메뉴를 잘못선택하였습니다.')
    sys.exit()

menudate = input('조회할 날짜를 입력하세요(ex:yyyymmdd -> 20181001) => ')
url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=" + sel + "&date=" + menudate
print('\nurl :', url)

html = urllib.request.urlopen(url)
soup = BeautifulSoup(html, 'html.parser')
if sel == 'cnt':
    movie_list = soup.findAll('div', attrs={'class':'tit3'})
else:
    movie_list = soup.findAll('div', attrs={'class':'tit5'})

i = 1
print('\n순위\t 영화제목')
print('=========================')
for movie in movie_list:
    print(i, '\t\t', movie.a.string)
    i = i + 1
    if i>50:
        break
"""


