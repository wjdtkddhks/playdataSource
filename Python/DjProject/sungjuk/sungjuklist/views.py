from django.shortcuts import render

from django.shortcuts import render_to_response
from django.utils import timezone
from django.views.decorators.csrf import csrf_exempt
from django.http import HttpResponseRedirect
from .models import SungjukList
from .pagingHelper import PagingHelper
from django.urls import reverse
# Create your views here.

rowPerPage = 3
query = SungjukList.objects.all()

def process(kor, eng, math):
    sum = kor + eng + math
    avg = float("%0.2f" %(sum/3.0))
    grade = ""

    if avg >= 90:
        grade = "수"
    elif avg >= 80:
        grade = "우"
    elif avg >= 70:
        grade = "미"
    elif avg >= 60:
        grade = "양"
    else:
        grade = "가"

    return sum, avg, grade


def listPage(request, current_page=1, message=None):
    totalCnt = query.count()

    pageHelper = PagingHelper()
    totalPageList = pageHelper.getTotalPageList(totalCnt, rowPerPage)

    if current_page not in totalPageList :
        current_page = current_page - 1

    start = (current_page-1)*rowPerPage
    end = start + rowPerPage
    if end > totalCnt:
        end = totalCnt

    print("message:", message)
    print("current_page:", current_page)
    print("pageList:", totalPageList)
    print("totalCnt:", totalCnt)
    print("start:", start)
    print("end:", end)

    sungjukList = query.order_by("-hakbun")[start:end]

    return render_to_response('listPage.html', {'totalCnt':totalCnt,
                                            'totalPageList':totalPageList,
                                            'sungjukList':sungjukList,
                                            'current_page':current_page,
                                            'message':message})

#==================================================================================

def writeForm(request):

    return render_to_response('writeBoard.html')

#==================================================================================

@csrf_exempt
def writeBoard(request):
    sum, avg, grade = process(int(request.POST['kor']), int(request.POST['eng']), int(request.POST['math']))
    sun = SungjukList(hakbun = request.POST['hakbun'],
                      name = request.POST['name'],
                      kor = int(request.POST['kor']),
                      eng = int(request.POST['eng']),
                      math = int(request.POST['math']),
                      sum = sum,
                      avg = avg,
                      grade = grade)

    sun.save()

    return HttpResponseRedirect(reverse("list", args=(1, None)))

#==================================================================================

def viewBoard(request, current_page, hakbun):
    sungjuk = query.get(hakbun=hakbun)

    print(sungjuk)

    return render_to_response('viewBoard.html', {"current_page":current_page,
                                                 "sungjuk": sungjuk})

#==================================================================================

def updateForm(request):
    sungjuk = query.get(hakbun=request.GET['hakbun'])
    current_page = int(request.GET['current_page'])

    return render_to_response('updateForm.html', {"sungjuk":sungjuk,
                                                  "current_page": current_page})

#==================================================================================

@csrf_exempt
def updateSungjuk(request):
    sum, avg, grade = process(int(request.POST['kor']), int(request.POST['eng']), int(request.POST['math']))
    query.filter(hakbun=request.POST['hakbun']).update(kor=int(request.POST['kor']),
                                                                     eng=int(request.POST['eng']),
                                                                     math=int(request.POST['math']),
                                                                     sum=sum,
                                                                     avg=avg,
                                                                     grade=grade)

    return HttpResponseRedirect(reverse('list', args=(request.POST['current_page'], 'updated')))


#==================================================================================

def deleteSungjuk(request):
    query.filter(hakbun=request.GET['hakbun']).delete()

    return HttpResponseRedirect(reverse('list', args=(request.GET['current_page'], 'deleted')))
