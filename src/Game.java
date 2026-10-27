import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

//I will try to make this class object-oriented instead of static like all my other classes
// (their methods, I mean. I still don't know how static classes work/matter)
public class Game {

    //the final modifier here is super unnecessary, as my game can only reach an ending once it is started.
    // My IDE just listed it as a problem when missing
    private final Scanner tinydaddy;
    private final StatsClass gameStats;
    private final int introprintdelay = 120;
    String[] currentChoices;
    Boolean[] currentChoicesB;

    public Game(Scanner littledaddy) {
        this.tinydaddy = littledaddy;
        this.gameStats = new StatsClass();
    }

    public void intro() {
        FancyPrinter.println("Wake up, Wake Up! ", introprintdelay);
        String introscript = ("You find yourself in a disheveled apartment in New York City, at least that's what it looks like from your one, small window. You've got a piercing headache, and realize you have no idea who you are and why you're here. Looking around, your small apartment only contains a mattress on the floor (no cover), a bathroom, a poster, one cabinet, and a \"kitchen\", with a sink, fridge, and microwave. Nearest to your window, a personal computer is set up on a folding table and chair, with a sticky note pressed onto the black monitor. ");
        FancyPrinter.printWrapln(introscript, introprintdelay);
        FancyPrinter.printChars("You Chose: option " + choice());
    }

    //This checks the current list of choices based on gamestate, prints out each valid choice,
    //then checks if the user input a valid choice and sends that choice to the response method
    private String choice() {
        currentChoices = gameStats.GetChoices();
        currentChoicesB = gameStats.GetChoicesB();
        int selectnum = 1;
        List<String> selectnums = new ArrayList<>();
        FancyPrinter.println("\nYou can: ");
        for (int c = 0; c < currentChoices.length; c++) {
            if (currentChoicesB[c] == true) {
                FancyPrinter.println("" + selectnum + ") " + currentChoices[c]);
                String num = ("" + selectnum);
                selectnums.add(num);
                selectnum += 1;
            }
        }
        FancyPrinter.print("What do you do? : ");
        String input = tinydaddy.nextLine().trim();
        while (!selectnums.contains(input)) {
            FancyPrinter.print("You didn't choose a valid option. Select again: ");
            input = tinydaddy.nextLine().trim();
        }
        return input;
    }

}