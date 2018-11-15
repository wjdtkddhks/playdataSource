import sqlite3

dbconn = sqlite3.connect('tel.db')
dbcursor = dbconn.cursor()

dbcursor.execute("create table if not exists tel \
                (id integer primary key autoincrement, name text, \
                tel text, addr text, input_time text, memo text)")

dbcursor.close()
dbconn.close()