import pickle, os
from sungjuk.sungjuk4 import *

def sungjuk_inpickle():
    check = True
    sd = open('sungjuk.dat', 'wb')
    while True:
        sun = Sungjuk()
        check = sun.input_sungjuk()
        if check == False :
            del sun
            continue
        elif check == 'exit':
            break
        else:
            pickle.dump(sun, sd)


def sunjuk_outpickle():
    # totalAvg = 0.0
    jul = "=" * 60
    sd = open('sungjuk.dat', 'rb')
    print()
    print(("*** 성적표 ***").center(55))
    print(jul)
    print("%5s%5s%5s%5s%5s%5s%5s%5s" % ('학번', '이름', '국어', '영어', '수학', '총점', '평균', '등급'))
    print(jul)
    while True:
        if sd.tell() == os.fstat(sd.fileno()).st_size:
            break

        data = pickle.load(sd)
        data.output_sungjuk()
        # totalAvg += data.avg
    print(jul)
    # print(("총학생수 = %d,   전체 평균 = %.2f"%(len(sunlist), totalAvg/len(sunlist))).center(55))

if __name__ == '__main__':
  sungjuk_inpickle()
  sunjuk_outpickle()