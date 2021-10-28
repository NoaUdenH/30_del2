package dasuki;

import org.junit.jupiter.api.Assertions;

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
                this.playOneRound(P1, B1);
                this.playOneRound(P2, B2);
                break;
            case 3:
                System.out.println("test1: Du kan kaste 1000 gange og få gennemsnittet");
                this.test1();
                break;
            case 4:
                System.out.println("test2: test om man kan  få balance med en negative balance");
                this.test2(B1);
                break;
            case 5:
            default:
                break;
        }
    }

    void displayGameMenu() {
        System.out.println();
        System.out.println("(1) Start et nyt spil");
        System.out.println("(2) Spil en runde");
        System.out.println("(3) Test (Tal-fordeling og negativ balance)");
        System.out.println("(4) Test (negativ balance)");
        System.out.println("(5) Afslut spil");
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


    public void playOneRound(Spiller P, Konto B) {
        B.setBalance(B2.getBalance());
        int result;
        int FørsteTerningKast = dice.rollDice();
        int AndenTerningKast = dice.rollDice();
        int m = FørsteTerningKast + AndenTerningKast;
        if (B.getBalance() < 0) {
            result = 0;
            B.setBalance(result);
            System.out.println("må ikke komme under 0 derfor skal lægges på 0 " + " du har nu " + B.getBalance() + "guldmønter tilbage");

        } else if (m == 2) {
            result = B.getTower();
            B.setBalance(result);
            System.out.println(P.getnavn() + " kastede " + m + " og støder på et tårn, i modsætning til i eventyr, så indeholder dette tårn ikke en prinsesse. Det indeholder derimod +250 guldmønter. Tag disse med dig på din søgen. " + " og du har nu " + B.getBalance() + " guldmønter tilbage .");


        } else if (m == 3) {
            result = B.getCrater();
            B.setBalance(result);
            System.out.println(P.getnavn() + " kastede " + m + " og støder nu på et krater. Du falder ned i det, og mens du falder ned, taber du -100 guldmønter" + " og har nu du " + B.getBalance() + " guldmønter tilbage. ");


        } else if (m == 4) {
            result = B.getPalaceGates();
            B.setBalance(result);
            System.out.println(P.getnavn() + " kastede  " + m + " Du støder på Palace Gates. Du lokker nogle til at betale dig et gebyr på +100 guldmønter, for at passere gennem portene " + "og nu har du " + B.getBalance() + " guldmønter tilbage. ");


        } else if (m == 5) {
            result = B.getColdDesert();
            B.setBalance(result);
            System.out.println(P.getnavn() + " kastede " + m + " Du har vandret ind i de kolde ørkener. For at holde dig varm, betaler du -20 guldmønter for at få ly natten over." + " Du har nu " + B.getBalance() + " guldmønter tilbage. ");

        } else if (m == 6) {
            result = B.getWalledCity();
            B.setBalance(result);
            System.out.println(P.getnavn() + " kastede  " + m + " Du støder på en befæstet by. Byen har desperat brug for udlændinge til at befolke deres genpulje. Derfor betaler de dig +180 guldmønter for at blive. " + "og nu har du " + B.getBalance() + " guldmønter tilbage. ");

        } else if (m == 7) {
            result = B.getMonastery();
            B.setBalance(result);
            System.out.println(P.getnavn() + " kastede " + m + " Du besøger et kloster på din rejse. De lader dig overnatte uden gebyrer. Du får dog 0 guldmønter denne runde " + " og nu har du " + B.getBalance() + " guldmønter tilbage. ");

        } else if (m == 8) {
            result = B.getBlackCave();
            B.setBalance(result);
            System.out.println(P.getnavn() + " kastede " + m + " Du er stødt på den sorte hule. Du opdager, at det er et bordel, og bruger heldigvis -70 guldmønter for at overnatte " + " og nu har du " + B.getBalance() + " guldmønter tilbage. ");

        } else if (m == 9) {
            result = B.getHutsInTheMountain();
            B.setBalance(result);
            System.out.println(P.getnavn() + " kastede " + m + " Du opdager nogle hytter i et bjerg. Du søger igennem dem og finder +60 guldmønter. Ingen bor her, så du putter dem i lommen " + " og nu har du " + B.getBalance() + " guldmønter tilbage. ");

        } else if (m == 10) {
            result = B.getTheWereWall();
            B.setBalance(result);
            System.out.println(P.getnavn() + " kastede " + m + " Du støder på Werewall. Varulvene skræmmer dig, og du taber -80 guldmønter. Du opdager, at de faktisk var Girl Scout, der prøvede nye metoder i stedet for at sælge cookies. Du løb så hurtigt, at du får en ekstra tur " + " og nu har du " + B.getBalance() + " guldmønter tilbage. ");
            playOneRound(P, B);

        } else if (m == 11) {
            result = B.getThePit();
            B.setBalance(result);
            System.out.println(P.getnavn() + " kastede " + m + " Du støder på en grube. Ligesom dine forbrugsvaner i den virkelige verden, smider du også penge ind i denne grube. Du bruger -50 guldmønter " + " og nu har du " + B.getBalance() + " guldmønter tilbage. ");

        } else if (m == 12) {
            result = B.getGoldmine();
            B.setBalance(result);
            System.out.println(P.getnavn() + " kastede " + m + " Du finder en forladt guldmine. Du går ind og finder guld til en værdi af +650 guldmønter. Det må være din heldige dag! " + " og nu har du " + B.getBalance() + " guldmønter tilbage. ");
        }


    }


    boolean TjekHvisNogenHarVndet() {
        int scoreForAtVinde = 3000;
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

    void test2(Konto B) {
        int IndsatBalance;
        System.out.print("Indtast venligst Balance du gerne vil teste  ");
        Scanner sc = new Scanner(System.in);
        IndsatBalance = sc.nextInt();
        B.setBalance(IndsatBalance);
        int Test = B.getBalance();
        if (IndsatBalance < 0) {
            System.out.println("ugyldig værdi");
            System.out.println("din blance må aldrig komme under null derfor sættes på " + Test);
        }
        if (IndsatBalance >= 0) {
            System.out.println("gyldig værdi");
            System.out.println("din blance sættes på " + Test);
        }


    }


    void test1() {
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

    }


}