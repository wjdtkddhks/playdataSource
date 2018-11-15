import cx_Oracle as oci

conn = oci.connect('hr/123456@localhost:1521/xe')

print(conn.version)

cursor = conn.cursor()
cursor.execute('select * from employees')
print()
for i in cursor:
    print(i)

cursor.close()
conn.close()