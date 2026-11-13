import java.util.Scanner;

//I will try to make this class object-oriented instead of static like all my other classes
// (their methods, I mean. I still don't know how static classes work/matter)
public class Game {

    //the final modifier here is super unnecessary, as my game can only reach an ending once it is started;
    //I'll never be changing these values anyway I mean
    // My IDE just listed it as a problem when missing
    //I take it back; listing this as final makes it easier to sanity check my work everytime I reread it - 10/30/26
    private final Scanner tinydaddy;
    private final StatsClass gameStats;
    private final ChoiceLogic gameLogic;

    //This is a constructor, you can tell because it has no return type
    //Note to stop checking other class: in StartScreen, the game starts by these lines of code:
    //FancyPrinter.linebreak();
    // Game game = new Game(littledaddy);
    //game.start();
    public Game(Scanner littledaddy) {
        this.tinydaddy = littledaddy;
        this.gameStats = new StatsClass();
        this.gameLogic = new ChoiceLogic(tinydaddy, gameStats);
    }

    public void start() {
        FancyPrinter.println("Wake up, Wake Up! ");
        String introscript = ("You find yourself in a disheveled apartment in New York City, at least that's what it looks like from your one, small window. You've got a piercing headache, and realize you have no idea who you are and why you're here. Looking around, your small apartment only contains a mattress on the floor (no cover), a bathroom, a poster, one cabinet, and a \"kitchen\", with a sink, fridge, and microwave. Nearest to your window, a personal computer is set up on a folding table and chair, with a sticky note pressed onto the black monitor. ");
        FancyPrinter.printWrapln(introscript);
        boolean gamefinished = false;
        while (!gamefinished) {
            switch (gameStats.gameState) {
                case 1: {
                    gamefinished = gameLogic.responses1(gameLogic.choice());
                    break;
                }
                case 2: {
                    gamefinished = gameLogic.responses2(gameLogic.choice());
                }

            }
        }
        System.out.println(CenterString.space("---You closed the game.---"));
        System.out.println("");
    }
}