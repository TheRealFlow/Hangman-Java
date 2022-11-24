public class Main {
    private static final String[] POOL_OF_WORDS = new String[]{"Remote", "Bootcamp", "Backend", "Frontend", "Development", "NeueFische"};

    public static void main(String[] args) {
        playHangman();
    }
    //Das Spiel
    private static void playHangman() {
        boolean again = true;
        while (again) {
            Game currentGame = GameSetup.setupGame(POOL_OF_WORDS);
            GamePlay.playGame(currentGame);
            again = GamePlay.playAgain();
        }
    }
}
