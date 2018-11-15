from selenium import webdriver

url = "http://www.goobne.co.kr/store/search_store.jsp"
br = webdriver.Chrome("C:\BigDeep\ChromeDriver\chromedriver.exe")
br.implicitly_wait(3)
br.get(url)
idx = 1
f = open("goobne_storelist.db", "w", encoding='utf-8')

while True:
    store_list = br.find_element_by_id("store_list")
    name_list = store_list.find_elements_by_css_selector("tr.lows td:nth-of-type(1)")
    # print("name_list",name_list)
    phone_list = store_list.find_elements_by_css_selector("tr.lows td.store_phone a")
    address_list = store_list.find_elements_by_css_selector("tr.lows td.t_left a")
    for name, phone, add in zip(name_list, phone_list, address_list):
       f.write(str(idx) + ". " + name.text + ", T." + phone.text + ", A." + add.text + "\n")
       idx +=1

    next = br.find_element_by_css_selector("ul.pager li.pager_next")
    href = next.find_element_by_tag_name("a").get_attribute("href")
    print(href)
    if href == "http://www.goobne.co.kr/store/search_store.jsp#":
        break

    next.click()

f.close()
br.quit()



