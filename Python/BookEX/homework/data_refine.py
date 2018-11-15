import pandas as pd

pericana_table = pd.read_csv("pelicana.csv", encoding='utf-8',index_col=0, header=0)
kyochon_table = pd.read_csv("kyochon.csv", encoding='utf-8',index_col=0, header=0)
goobne_table = pd.read_csv("goobne_1.csv", encoding='utf-8',index_col=0, header=0)
cheogajip_table = pd.read_csv("cheogajip.csv", encoding='utf-8',index_col=0, header=0)
print(cheogajip_table.sido.unique())

print("=========================================================")
print(pericana_table[pericana_table['sido'] == " "])
remove_indexes = list(pericana_table[pericana_table['sido'] == " "].index) \
                 + list(pericana_table[pericana_table['sido'] == "00"].index) \
                 + list(pericana_table[pericana_table['sido'] == "테스트"].index)
print(remove_indexes)
for idx in remove_indexes:
    pericana_table = pericana_table.drop(idx)
print("=========================================================")
print(pericana_table[pericana_table['sido'] == "00"])
print(pericana_table[pericana_table['sido'] == "테스트"])
print("=========================================================")
pericana = pericana_table.apply(lambda r: r['sido'] + " " + r['gungu'], axis=1).value_counts()
kyochon = kyochon_table.apply(lambda r: r['sido'] + " " + r['gungu'], axis=1).value_counts()
goobne = goobne_table.apply(lambda r: r['sido'] + " " + r['gungu'], axis=1).value_counts()
cheogajip = cheogajip_table.apply(lambda r: r['sido'] + " " + r['gungu'], axis=1).value_counts()
print(goobne)

chicken_table = pd.DataFrame({'chegajip':cheogajip, 'pericana':pericana, "kyochon":kyochon, "goobne":goobne}).fillna(0)
print(chicken_table)