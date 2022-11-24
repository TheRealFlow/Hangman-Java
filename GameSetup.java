import java.util.Arrays;

public class GameSetup {
    public static Game setupGame(String[] poolOfWords) {
        String currentWord = getRandomWord(poolOfWords);
        int lives = 5;
        System.out.println("Herzlich Willkommen bei Hangman! \nDein Wort hat " + currentWord.length() + " Zeichen, los gehts!");
        char[] currentSolution = new char[currentWord.length()];
        Arrays.fill(currentSolution, '_');

        return new Game(currentWord, lives, currentSolution);
    }
    //Ich möchte ein Wort aus einer Liste zufällig ausgeben.
    private static String getRandomWord(String[] listOfWords){
        return listOfWords[(int) (Math.random()*(listOfWords.length))];
    }
}
