import java.util.Scanner;

//I will try to make this class object-oriented instead of static like all my other classes
// (their methods, I mean. I still don't know how static classes work/matter)
public class Game {

    //the final modifier here is super unnecessary, as my game can only reach an ending once it is started.
    // My IDE just listed it as a problem when missing
    private final Scanner tinydaddy;

    public Game(Scanner littledaddy) {
        this.tinydaddy = littledaddy;
        StatsClass stats = new StatsClass();
    }

    public void go() {
        FancyPrinter.println("Wake up, Wake Up! ", 140);
        String introscript = ("You find yourself in a disheveled apartment in New York City, at least that's what it looks like from your one, small window. You've got a piercing headache, and realize you have no idea who you are and why you're here. Looking around, your small apartment only contains a mattress on the floor (no cover), a bathroom, a poster, one cabinet, and a \"kitchen\", with a sink, fridge, and microwave. Nearest to your window, a personal computer is set up on a folding table and chair, with a sticky note pressed onto the black monitor. ");
        FancyPrinter.printWrapln(introscript, 140);
        System.out.println("");
        FancyPrinter.println("You can: ", 140);
        FancyPrinter.println("1) Read the note at the computer desk ");
        FancyPrinter.println("2) Read the poster ");
        FancyPrinter.println("3) Check the cabinet ");
        FancyPrinter.println("4) Check your pockets ");
        FancyPrinter.println("5) Go back to bed ");
        FancyPrinter.print("What do you do? : ");
        tinydaddy.nextLine();
    }
}
