from fighter import Fighter
from bomber import Bomber

def war_game(airforce):
    airforce.take_off()
    airforce.fly()
    airforce.attack()
    airforce.land()

if __name__ == '__main__':
    F15 = Fighter(3)
    war_game(F15)
    print()

    b29 = Bomber(5)
    war_game(b29)