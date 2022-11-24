import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class GamePlay {
    private static final Scanner INPUT = new Scanner(System.in);
    public static void playGame(Game game) {
        boolean running = true;
        while (running) {
            System.out.println(game.getCurrentSolution());
            String givenSymbol = getInput();
            if (validInput(givenSymbol) && checkUnique(givenSymbol.charAt(0), game)) {
                char letter = givenSymbol.charAt(0);
                boolean hit = checkContains(letter, game);
                if (!hit) {
                    System.out.println("Leider nicht dabei");
                    game.removeLife();
                }
            }
            running = conclusion(game);
        }
    }
    private static String getInput() {
        System.out.println("Bitte gib deinen Buchstaben ein:");
        return INPUT.next().toLowerCase(Locale.ROOT);
    }
    private static boolean validInput(String inputToCheck) {
        if (inputToCheck.length() > 1 || inputToCheck.isBlank()) {
            System.out.println("Bitte genau einen Buchstaben eingeben");
            return false;
        } else if (!Character.isAlphabetic(inputToCheck.charAt(0))) {
            System.out.println("Bitte nur Buchstaben verwenden");
            return false;
        }
        return true;
    }
    //Ich möchte auf Dopplungen hingewiesen werden.
    private static boolean checkUnique(char charToCheck, Game game) {
        for (char letter : game.getCurrentSolution()) {
            if (letter == charToCheck) {
                System.out.println("Lösung schon verwendet.");
                return false;
            }
        }
        return true;
    }
    //Es soll kontrolliert werden ob der Buchstabe enthalten ist
    private static boolean checkContains(char whichChar, Game game) {
        boolean hit = false;
        char[] solution = game.getSolution();
        for (int i=0; i<solution.length; i++ ) {
            if (solution[i] == whichChar) {
                System.out.println("Treffer");
                game.hit(i);
                hit = true;
            }
        }
        return hit;
    }
    //Ich möchte ein Endergebnis bekommen
    private static boolean conclusion(Game game) {
        if (game.getLives() == 0) {
            System.out.println("Leider verloren");
            return false;
        } else if (Arrays.equals(game.getCurrentSolution(), game.getSolution())) {
            System.out.println("Glückwunsch, du hast das Wort gefunden!");
            return false;
        } else {
            System.out.println("Du hast noch " + game.getLives() + " Versuche");
            return true;
        }
    }
    //Nochmal?
    public static boolean playAgain() {
        System.out.println("Möchtest du noch eine Runde spielen? y für ja, alles andere für nein");
        String answer = getInput();

        return "y".equals(answer);
    }
}
