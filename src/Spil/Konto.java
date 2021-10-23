package Spil;

public class Konto {
    int MIN=0 ;
    int Balance;

    public int minBalance() {
        if (Balance < 0)
            Balance=0;
        return Balance;
    }
}
