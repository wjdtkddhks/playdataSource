import re

r1 = re.compile(r"\b\\[u, xa]\D?\b")
str = '\\ua \\uaa \\wdfdfdf \\xaf udfasdf \\uffed \\u274f aaa\\xa0aaa'
print('before:', str)
st = re.sub(r"(\\u\w+)|(\\xa0)", '', str)
print('after:', st)

r2 = re.compile(r"\babc\b")
str2= "abc abcd ab"
print('before:', str2)
str3 = re.sub(r2, '1', str2)
print('after:', str3)