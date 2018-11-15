from selenium import webdriver

USER = ""
PASS = ""
browser1 = webdriver.PhantomJS("C:\BigDeep\Phantomjs\phantomjs.exe")
browser1.implicitly_wait(3)

url_open = "https://nid.naver.com/nidlogin.login"
browser1.get(url_open)
print("로그인 페이지에 접근합니다.")
browser1.save_screenshot("before_login.png")
e = browser1.find_element_by_id("id")
e.clear()
e.send_keys(USER)
e = browser1.find_element_by_id("pw")
e.clear()
e.send_keys(PASS)
browser1.save_screenshot("after_login.png")
form = browser1.find_element_by_css_selector("input.btn_global[type=submit]")
form.submit()

browser1.get("https://order.pay.naver.com/home?tabMenu=SHOPPING")
browser1.save_screenshot("myshopping.png")
products = browser1.find_elements_by_css_selector(".p_info span")
print(products)
for product in products:
    print("-", product.text)
