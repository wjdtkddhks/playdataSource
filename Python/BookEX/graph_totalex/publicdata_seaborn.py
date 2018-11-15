import pandas as pd
import json
import matplotlib.pyplot as plt
import seaborn as sns

fv_CFileName = "중국(112)_해외방문객정보_2011_2016.json"
jsonFV = json.loads(open(fv_CFileName, 'r', encoding='utf-8').read())
china_table = pd.DataFrame(jsonFV, columns=['yyyymm', 'visit_cnt'])
print(china_table)

china_table.yyyymm = pd.to_datetime(china_table.yyyymm, format='%Y%m')
china_table['year'] = china_table.yyyymm.dt.year
china_table['month'] = china_table.yyyymm.dt.month
print(china_table)

# 피봇테이블 생성, 피봇테이블은 set_index(1번째 행, 2번째 열)과 unstack()을 사용해서 만든다.
china_table = china_table.set_index(['month', 'year'])['visit_cnt'].unstack(fill_value=0)
print(china_table)

sns.heatmap(china_table)
plt.show()