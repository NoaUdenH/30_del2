import java.sql.SQLOutput;
import java.util.*;

public class Game {

    private Spiller P1;
    private Konto B1;
    private Spiller P2;
    private Konto B2;
    public Dice dice;


    void selectGameOption(int optionSelected) {
        switch (optionSelected) {
            case 1:
                this.VisSpilInstruktion();
                break;
            case 2:
             //   do {
                    this.playOneRound(P1, B1);
                    this.playOneRound(P2, B2);
               // } while (this.B1.getBalance() <= 100000 && this.B2.getBalance() <= 100000);
                break;
            case 3:
                this.test();
                break;
            case 4:
            default:
                break;
        }
    }

    void displayGameMenu() {
        System.out.println();
        System.out.println("(1) Start et nyt spil");
        System.out.println("(2) Spil en runde");
        System.out.println("(3) Test (Tal-fordeling og Negativ Balance)");
        System.out.println("(4) Afslut spil");
        System.out.print("Vælg en mulighed: ");
    }

    void VisSpilInstruktion() {
        String P1Navn;
        String P2Navn;

        Scanner sc = new Scanner(System.in);
        System.out.print("Indtast venligst første spillers navn: ");
        P1Navn = sc.nextLine();
        System.out.print("Indtast venligst anden spillers navn: ");
        P2Navn = sc.nextLine();


        P1 = new Spiller(P1Navn);
        P2 = new Spiller(P2Navn);
        B1 = new Konto();
        B2 = new Konto();
        dice = new Dice();
    }

    void playOneRound(Spiller P, Konto B) {

        int result;
        int FørsteTerningKast = dice.rollDice();
        int AndenTerningKast = dice.rollDice();
        int m = FørsteTerningKast + AndenTerningKast;

        if (m == 2) {
            result = B.getTower();
            System.out.println(P.getnavn() + " kastede " + m + " og støder på et tårn, i modsætning til i eventyr rummer dette tårn ikke en prinsesse. Det rummer dog 250 guldmønter. Tag disse med dig på din søgen. " + " og nu har du " + result + " guldmønter tilbage .");
            B.setBalance(result);

        } else if (m == 3) {
            result = B.getCrater();
            System.out.println(P.getnavn() + " kastede " + m + " nu støder på et krater. Du falder ind i det, og mens du falder ned taber du 100 guldmønter" + " og nu har du " + result + " guldmønter tilbage. ");
            B.setBalance(result);

        } else if (m == 4) {
            result = B.getPalaceGates();
            System.out.println(P.getnavn() + " kastede  " + m + " Du støder på Palace Gates. Du lurer nogen til at betale dig et gebyr på 100 guldmønter for at passere gennem portene " + "og nu har du " + result + " guldmønter tilbage. ");
            B.setBalance(result);

        } else if (m == 5) {
            result = B.getColdDesert();
            System.out.println(P.getnavn() + " kastede " + m + " Du har vandret ind i de kolde ørkener, for at holde dig varm, tænder du dine guldmønter i brand. Du brænder igennem 20 guldmønter, men er nu varm " + " og nu har du " + result + " guldmønter tilbage. ");
            B.setBalance(result);

        } else if (m == 6) {
            result = B.getWalledCity();
            System.out.println(P.getnavn() + " kastede  " + m + " Du støder på en befæstet by. Byen har desperat brug for udlændinge til at befolke deres genpulje, betaler de dig 180 guldnåle for at blive. " + "og nu har du " + result + " guldmønter tilbage. ");
            B.setBalance(result);

        } else if (m == 7) {
            result = B.getMonastery();
            System.out.println(P.getnavn() + " kastede " + m + " Du besøger et kloster på dine rejser. De lader dig overnatte uden gebyrer. Du får dog ingen guldmønter denne runde " + " og nu har du " + result + " guldmønter tilbage. ");
            B.setBalance(result);

        } else if (m == 8) {
            result = B.getBlackCave();
            System.out.println(P.getnavn() + " kastede " + m + " Du er stødt på den sorte hule. Du opdager, at det er et bordel, og bruger heldigvis 70 guldmønter for at overnatte " + " og nu har du " + result + " guldmønter tilbage. ");
            B.setBalance(result);

        } else if (m == 9) {
            result = B.getHutsInTheMountain();
            System.out.println(P.getnavn() + " kastede " + m + " Du opdager nogle hytter i et bjerg. Du søger igennem dem og finder 70 guldmønter. Ingen bor her, så du putter dem i lommen " + " og nu har du " + result + " guldmønter tilbage. ");
            B.setBalance(result);
        } else if (m == 10) {

            result = B.getTheWereWall();
            System.out.println(P.getnavn() + " kastede " + m + " Du støder på Werewall. Varulvene skræmmer dig, og du taber 80 guldmønter. Du opdager, at de faktisk var Girl Scout, der prøvede nye metoder i stedet for at sælge cookies. Du løb så hurtigt, at du får en ekstra tur " + " og nu har du " + result + " guldmønter tilbage. ");
            B.setBalance(result);
            playOneRound(P, B);

        } else if (m == 11) {
            result = B.getThePit();
            System.out.println(P.getnavn() + " kastede " + m + " Du støder på en grube. Ligesom dine forbrugsvaner i den virkelige verden, smider du også penge ind i denne pit. Du mister 50 guldmønter " + " og nu har du " + result + " guldmønter tilbage. ");
            B.setBalance(result);

        } else if (m == 12) {
            result = B.getGoldmine();
            System.out.println(P.getnavn() + " kastede " + m + " Du finder en forladt guldgrube. Du går ind og finder guld til en værdi af 650 guldmønter. Dette må være din heldige dag! " + " og nu har du " + result + " guldmønter tilbage. ");
            B.setBalance(result);
        }

    }

    boolean TjekHvisNogenHarVndet() {
        int scoreForAtVinde = 100000;
        if (B1.getBalance() >= scoreForAtVinde && B2.getBalance() >= scoreForAtVinde) {
            System.out.println("Det er uafgjort! Begge spillere har overskredet scoregrænsen");
            return true;
        } else if (B1.getBalance() >= scoreForAtVinde && B2.getBalance() < scoreForAtVinde) {
            System.out.format("%s vandt", P1.getnavn());
            return true;
        } else if (B1.getBalance() < scoreForAtVinde && B2.getBalance() >= scoreForAtVinde) {
            System.out.format("%s vandt ", P2.getnavn());
            return true;
        }
        return false;
    }

    public static void countFrequencies(ArrayList<Integer> list) {

        // hash set is created and elements of
        // arraylist are insert into it
        Set<Integer> st = new HashSet<>(list);
        for (Integer s : st)
            System.out.println(s + ": " + Collections.frequency(list, s));
    }

    void test() {
        ArrayList<Integer> rolls = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {


            int gen = dice.rollDice();
            int gen1 = dice.rollDice();
            int result = Integer.sum(gen, gen1);
            rolls.add(result);
        }

        Collections.sort(rolls);
        System.out.println(rolls);
        System.out.println(rolls.size());
        countFrequencies(rolls);

// Test af balancens mindsteværdi
        System.out.println("nuværende balance på konto: " + B1);
        System.out.println("sætter kontoens balance til -10 og printer balancen");
        B1.setBalance(-10);
        System.out.println(B1);
    }


}

