import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

//I will try to make this class object-oriented instead of static like all my other classes
// (their methods, I mean. I still don't know how static classes work/matter)
public class Game {

    //the final modifier here is super unnecessary, as my game can only reach an ending once it is started;
    //I'll never be changing these values anyway I mean
    // My IDE just listed it as a problem when missing
    private final Scanner tinydaddy;
    private final StatsClass gameStats;
    private final int introprintdelay = 120;
    String[] currentChoices;
    Boolean[] currentChoicesB;

    //This is a constructor, you can tell because it has no return type
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

    private void setChoices() {
        currentChoices = gameStats.GetChoices();
        currentChoicesB = gameStats.GetChoicesB();
    }

    //This method sets the choice arrays inside the Game class equal to the corresponding choices in StatsClass
    //Different choices can be active at different times based on the gameState and a corresponding boolean
    //Then, it creates a String list to save the integers of each valid choice printed as Strings instead
    //I much prefer converting these possible input integers into Strings then checking against the user String input,
    //Since that's what I already did in the StartScreen checks - 1:00pm, 10/27/26
    //Also, this returns the "String" integer choice that was picked, which I will use for the return method
    private String choice() {
        setChoices();
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