# class Address:
#     name="Dominica"
#     addr='seoul'
#     tel="02-111-1111"
#
# print(Address.name, Address.addr, Address.tel)

class Address:
    name='alfred'

    def alPrn(self, name, addr, tel):
        self.name=name
        self.addr=addr
        self.tel=tel
        print(name, self.addr, self.tel)

if __name__ == '__main__':
    addr01 = Address()
    addr01.alPrn("Dominica", "seoul", "010-111-1111")
    print(Address.name, addr01.name, addr01.addr, addr01.tel)

    addr02 = Address()
    addr02.alPrn("Dominica", "busan", "010-222-2222")


