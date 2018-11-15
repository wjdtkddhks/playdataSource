import os, time

print(os.listdir('c:/'))

path='c:/BigDeep/Python36'
file_list = os.listdir(path)
for file in file_list:
    file = os.path.join(path, file)
    if os.path.isdir(file):
        print(file, " / dir / ", time.ctime(os.stat(file).st_mtime))
    else:
        print(file, " / ", os.stat(file).st_size, " / ", time.ctime(os.stat(file).st_mtime))

print('=======================================')

if __name__ == '__main__':
    file = 'c:/BigDeep/Python36/python.exe'
    if os.path.isfile(file):
        print("basename:", os.path.basename(file))
        print("split:", os.path.split(file))
        print("splitdrive:", os.path.splitdrive(file))
        print("splitext:", os.path.splitext(file))
        print("normpath:", os.path.normpath(file))
        print("getctime:", os.path.getctime(file))
        print("time.ctime(getctime):", time.ctime(os.path.getctime(file))) #파일 생성시간
        print("time.ctime(getatime):", time.ctime(os.path.getatime(file))) #파일 최근 엑세스 시간
        print("time.ctime(getmtime):", time.ctime(os.path.getmtime(file))) #파일 변경시간
        print("getsize:", os.path.getsize(file))
