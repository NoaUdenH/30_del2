package dasuki;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Dice and Roll game!");

        Game game = new Game();


        int optionSelected;

        while (true) {
            game.displayGameMenu();
            System.out.println();
            Scanner sc = new Scanner(System.in);
            optionSelected = sc.nextInt();

            while (optionSelected > 5 || optionSelected < 0) {

                System.out.print("Option entered invalid, please enter a number from 1 to 5: ");
                optionSelected = sc.nextInt();
            }


            if (optionSelected == 5) {
                System.out.println("Exiting Spill");
                break;
            }

            game.selectGameOption(optionSelected);

            boolean anyoneWin = game.TjekHvisNogenHarVndet();
            if (anyoneWin) {
                System.out.println();
                System.out.println("Spillet sluttede .");
                break;
            }

        }
    }
}
