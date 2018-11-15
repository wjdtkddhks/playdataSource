from selenium import webdriver

browser1 = webdriver.Chrome("C:\BigDeep\ChromeDriver\chromedriver.exe")
browser1.implicitly_wait(3)

browser1.get("https://google.com")
r = browser1.execute_script("return 100 + 50")
print(r)
browser1.quit()