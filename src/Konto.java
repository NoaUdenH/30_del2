package dasuki;


public class Konto {

    int Balance;
    int Tower = 250;
    int Crater = 100;
    int PalaceGates = 100;
    int ColdDesert = 20;
    int WalledCity = 180;
    int Monastery = 0;
    int BlackCave = 70;
    int HutsInTheMountain = 60;
    int TheWereWall = 80;//	men spilleren får en ekstra tur.
    int ThePit = 50;
    int Goldmine = 650;

    public Konto() {
        Balance = 1000;
    }


    public int getTower() {
        return Balance + Tower;

    }

    public int getCrater() {
        return Balance - Crater;
    }

    public int getPalaceGates() {
        return Balance + PalaceGates;
    }

    public int getColdDesert() {
        return Balance - ColdDesert;
    }

    public int getWalledCity() {
        return Balance + WalledCity;
    }

    public int getMonastery() {
        return Balance + Monastery;
    }

    public int getBlackCave() {
        return Balance - BlackCave;
    }

    public int getHutsInTheMountain() {
        return Balance + HutsInTheMountain;
    }

    public int getTheWereWall() {
        return Balance - TheWereWall;
    }

    public int getThePit() {
        return Balance - ThePit;
    }

    public int getGoldmine() {
        return Balance + Goldmine;
    }

    public void setBalance(int point) {
        Balance = point;
        minBalance();
    }

    public int getBalance() {
        return Balance;
    }


    public void minBalance() {
        int MIN = 0;
        if (Balance <= MIN) {
            Balance = 0;
        }
    }

    public String toString() {
        return Integer.toString(Balance);
    }
}