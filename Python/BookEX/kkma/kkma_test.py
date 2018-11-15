from konlpy.tag import Kkma
from konlpy.utils import pprint
from konlpy.tag import Okt #Twitter

# 참고사이트 > http://kkma.snu.ac.kr/

kkma = Kkma() #중복되는 단어는 하나만 출력
twitter = Okt()

print("kkma.nuous:", kkma.nouns(u'명사만을 추출하여 워드클라우드를 그려봅니다. 명사만을 추출하여 워드클라우드를 그려봅니다.'))
print("kkma.nuous:", kkma.nouns(u'김하나는 밥을 많이 좋아합니다. 김하나는 밥을 많이 좋아합니다. mbc people'))
print()
print("Okt.nuous:", twitter.nouns(u'명사만을 추출하여 워드클라우드를 그려봅니다. 명사만을 추출하여 워드클라우드를 그려봅니다.'))
print("Okt.nuous:", twitter.nouns(u'김하나는 밥을 많이 좋아합니다. 김하나는 밥을 많이 좋아합니다. mbc people'))
print()


# sentences() : 문장 추출
print("kkma.sentences:", kkma.sentences(u'네, 안녕하세요. 고맙습니다.'))
print()

# morphs() : 모든 품사의 형태소 추출
print("kkma.morphs:", kkma.morphs(u'오류보고는 실행환경, 에러메시지와 함께 설명을 최대한 상세히!^^'))
print()

# pos() : 모든 품사의 형태소 추출과 품사 부착
print("kkma.pos:", kkma.pos(u'오류보고는 실행환경, 에러메시지와 함께 설명을 최대한 상세히!^^'))