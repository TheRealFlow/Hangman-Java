import java.util.Locale;

public class Game {
    private final char[] currentSolution;
    private final char[] solution;
    private int lives;
    public Game(String currentWord, int lives, char[] currentSolution) {
        this.solution = currentWord.toLowerCase(Locale.GERMAN).toCharArray();
        this.currentSolution = currentSolution;
        this.lives = lives;
    }
    public int getLives() {
        return lives;
    }
    public char[] getCurrentSolution() {
        return currentSolution;
    }
    public char[] getSolution() {
        return solution;
    }
    public void removeLife() {
        lives--;
    }
    public void hit(int index) {
        currentSolution[index] = solution[index];
    }
}
