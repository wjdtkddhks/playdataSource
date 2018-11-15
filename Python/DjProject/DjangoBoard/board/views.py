from django.shortcuts import render

from django.shortcuts import render_to_response
from django.utils import timezone
from django.views.decorators.csrf import csrf_exempt
from django.http import HttpResponseRedirect
from board.models import DjangoBoard
from board.pagingHelper import PagingHelper

# Create your views here.
rowsPerPage = 2
def home(request):
    boardList = DjangoBoard.objects.order_by('-id')[0:2]
    current_page = 1
    totalCnt = DjangoBoard.objects.all().count()

    pagingHelperlns = PagingHelper()
    totalPageLIst = pagingHelperlns.getTotalPageList(totalCnt, rowsPerPage)
    print('totalPageList:', totalPageLIst)

    return render_to_response('listPage.html', {'boardList':boardList,
                                                'totalCnt':totalCnt,
                                                'totalPageList':totalPageLIst,
                                                'current_page':current_page})

#===================================================================================

def writeForm(request):
    return render_to_response('writeBoard.html')

#===================================================================================

@csrf_exempt
def writeBoard(request):
    br = DjangoBoard(subject=request.POST['subject'],
                     name=request.POST['name'],
                     email=request.POST['email'],
                     memo=request.POST['memo'],
                     created_date=timezone.now(),
                     hits=0)
    br.save()

    url= "/listPage?current_page=1"
    return HttpResponseRedirect(url)

#===================================================================================

def listPage(request):
    current_page = request.GET['current_page']
    totalCnt = DjangoBoard.objects.all().count()

    print('current_page:', current_page)

    if int(current_page) != 0:
        start = (int(current_page)-1) * rowsPerPage
        end = int(current_page) * rowsPerPage
        boardList = DjangoBoard.objects.order_by("-id")[start:end]

        # print("boardList:", boardList, ", count:". str(totalCnt))

        pagingHelperIns = PagingHelper()

        totalPageList = pagingHelperIns.getTotalPageList(totalCnt, rowsPerPage)

        print("totalPageList:", totalPageList)

        return render_to_response('listPage.html', {"boardList":boardList,
                                                    "totalPageList":totalPageList,
                                                    "current_page":current_page,
                                                 "totalCnt": totalCnt})

    else:
        render_to_response('listPage.html', {'current_page':current_page})


# ===================================================================================

def viewBoard(request):
    pk = request.GET['memo_id']
    boardData = DjangoBoard.objects.get(id=pk)

    print("boardData.hits:", boardData.hits)
    DjangoBoard.objects.filter(id=pk).update(hits=boardData.hits +1)
    boardData = DjangoBoard.objects.get(id=pk)

    return render_to_response('viewBoard.html', {'memo_id': request.GET['memo_id'],
                                                 'current_page':request.GET['current_page'],
                                                 'searchStr':request.GET['searchStr'],
                                                 'boardData':boardData})

# ===================================================================================

def updateForm(request):
    memo_id = request.GET['memo_id']
    current_page = request.GET['current_page']
    searchStr = request.GET['searchStr']

    boardData = DjangoBoard.objects.get(id=memo_id)

    return render_to_response('updateForm.html', {'memo_id':memo_id,
                                                  'current_page':current_page,
                                                  'searchStr':searchStr,
                                                  'boardData':boardData})

# ===================================================================================

@csrf_exempt
def updateBoard(request):
    memo_id = request.POST['memo_id']
    current_page = request.POST['current_page']
    searchStr = request.POST['searchStr']

    DjangoBoard.objects.filter(id=memo_id).update(
        email=request.POST['email'],
        subject=request.POST['subject'],
        memo=request.POST['memo']
    )

    url = '/listPage?current_page='+ str(current_page)

    return HttpResponseRedirect(url)


# ===================================================================================

def deleteBoard(request):
    memo_id = request.GET['memo_id']
    current_page = request.GET['current_page']

    p  = DjangoBoard.objects.get(id=memo_id)
    p.delete()

    totalCnt = DjangoBoard.objects.all().count()
    pagingHelperIns = PagingHelper()

    totalPageList = pagingHelperIns.getTotalPageList(totalCnt, rowsPerPage)
    print('totalPageList:', totalPageList)

    if int(current_page) in totalPageList:
        pass
    else:
        current_page = int(current_page) - 1

    url = "/listPage?current_page=" + str(current_page)

    return HttpResponseRedirect(url)

# ===================================================================================

@csrf_exempt
def searchSubject(request):
    searchStr = request.POST['searchStr']

    url = "/listSearchPage?searchStr=" + searchStr + "&pageForView=1"
    return HttpResponseRedirect(url)

# ===================================================================================

def listSearchPage(request):
    searchStr = request.GET['searchStr']
    pageForView = request.GET['pageForView']

    totalCnt = DjangoBoard.objects.all().count()

    pagingHelperIns = PagingHelper()
    totalPageList = pagingHelperIns.getTotalPageList(totalCnt, rowsPerPage)

    start = (int(pageForView) - 1) * rowsPerPage
    end = int(pageForView) * rowsPerPage
    boardList = DjangoBoard.objects.filter(subject__contains=searchStr).order_by("-id")[start:end]

    return render_to_response('listSearchPage.html', {"boardList":boardList,
                                                      "totalCnt":totalCnt,
                                                      "searchStr":searchStr,
                                                      "pageForView":pageForView,
                                                      "totalPageList":totalPageList})