from konlpy.corpus import kolaw
from konlpy.tag import Kkma

kkma = Kkma()

print(kolaw.fileids())
c = kolaw.open("constitution.txt").read()

print(c[:200])
print()

print(kkma.nouns(c[:200]))