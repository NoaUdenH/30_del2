

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Velkommen til Terninge Eventyret!");

        Game game = new Game();

        int optionSelected;

        while (true) {
            game.displayGameMenu();
            System.out.println();
            Scanner sc = new Scanner(System.in);
            optionSelected = sc.nextInt();

            while (optionSelected > 4 || optionSelected < 0) {

                System.out.print("Ugyldig mulighed, vælg venligst et nummer mellem 1 og 4: ");
                optionSelected = sc.nextInt();
            }

            if (optionSelected == 4) {
                System.out.println("Afslutter Spil");
                break;
            }

            game.selectGameOption(optionSelected);

            boolean anyoneWin = game.TjekHvisNogenHarVndet();
            if (anyoneWin) {
                System.out.println();
                System.out.println("Spillet sluttede.");
                break;
            }
        }
    }
}
