import os

print(os.getcwd())
os.chdir('c:/BigDeep/Python36')
print(os.getcwd())
print(os.path.join(os.getcwd(), 'test'))
print(os.listdir())

os.chdir('c:/BigDeep')
os.mkdir(os.path.join(os.getcwd(), 'test'))
print(os.listdir())

os.remove(os.path.join(os.getcwd(), 'test'))
print(os.listdir())