# -*- coding:utf-8 -*-

import facebook

graph = facebook.GraphAPI(access_token="EAAHHcm1Iy9EBAFssCLudpDcHo5FUeSa7dzeHzZCK15SaVVZBuEkKTn2VmAEqsbyVcCIz3opOwKuZA7qSBN8hlSYHrx1zycpa78gATq4QouuzZAkh6Ffe09ZAVGGbwdffQCQAPZCP9WX3HfICM6vvRG9GrUIt1DvlIbC6xZAseEJ2TDHXmdszJ7YAjZAj4fvpt6zYRvhQ2XvZB7gZDZD", version="3.0")

site_info = graph.get_object(id="me", field=["id", "name"])

print(type(site_info), site_info)