from selenium import webdriver

url = "http://www.naver.com/"

browser1 = webdriver.PhantomJS("C:\BigDeep\Phantomjs\phantomjs.exe")
browser1.implicitly_wait(3)
browser1.get(url)
browser1.save_screenshot("website1.png")
browser1.quit()

browser2 = webdriver.Chrome("C:\BigDeep\ChromeDriver\chromedriver.exe")
browser2.implicitly_wait(3)
browser2.get(url)
browser2.save_screenshot("website2.png")
browser2.quit()