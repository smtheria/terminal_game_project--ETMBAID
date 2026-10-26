import java.util.Scanner;

//I know that I should have just created a class level scanner here, but I don't want to
//rewrite the code so it's just gonna stay bad now. This problem will hopefully be fixed in the game class
//Gemini is flaming my shit for coding this with a bunch of static methods instead of as an OOP class;
//I will take this into account for rest of project
//The reason I was avoiding that was I thought I had to instantiate the class inside itself, but that's not how that works - 10/26/26
//I just learned about using while loops, so I will be using those to check user inputs in the future instead of recursion; 5:31pm, 10/26/26
public class StartScreen {
    public static void start(Scanner littledaddy) {
        FancyPrinter.linebreak();
        FancyPrinter.printCharsln(CenterString.space("Welcome To..." + "\n"));
        FancyPrinter.printCharsln(CenterString.space("ESCAPE THE MAFIA"));
        FancyPrinter.printCharsln(CenterString.space("BY AI DROPSHIPPING" + "\n"));
        Wait.ms(200);
        FancyPrinter.printCharsln(CenterString.space("Start: 1"));
        FancyPrinter.printCharsln(CenterString.space("Endings List: 2"));
        FancyPrinter.printCharsln(CenterString.space("Close Game: 3"));
        FancyPrinter.printChars(CenterString.space("Please select an option: "));
        String startinput = littledaddy.nextLine();
        startinput = startinput.trim();
        StartScreen.startinputcheck(littledaddy, startinput);
    }

    private static void startinputcheck(Scanner littledaddy, String input) {
        while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3"))) {
            FancyPrinter.print("You didn't choose a valid option. Select again: ");
            input = littledaddy.nextLine().trim();
        }
        StartScreen.callevent(littledaddy, input);
    }

    private static void callevent(Scanner littledaddy, String input) {
        if (input.equals("1")) {
            FancyPrinter.linebreak();
            Game GameStart = new Game(littledaddy);
            GameStart.go();
        } else if (input.equals("2")) {
            FancyPrinter.linebreak();
            StartScreen.displayendings(littledaddy);
        } else {
            System.out.print(CenterString.space("---You closed the game.---"));
        }
    }

    private static void displayendings(Scanner littledaddy) {
        int customprintspeed = 60;
        FancyPrinter.printCharsln(CenterString.space("--POSSIBLE ENDINGS--"));
        FancyPrinter.println("Ending 1: ", customprintspeed);
        FancyPrinter.println("Ending 2: ", customprintspeed);
        FancyPrinter.println("Ending 3: ", customprintspeed);
        FancyPrinter.println("Ending 4: ", customprintspeed);
        FancyPrinter.println("Ending 5: ", customprintspeed);
        FancyPrinter.println("Secret Ending: ???" + "\n", customprintspeed);
        FancyPrinter.print("Press 1 to return to start screen; Press 2 to close the game: ");
        String endinginput = littledaddy.nextLine().trim();
        StartScreen.endingsinputchecker(littledaddy, endinginput);
    }

    private static void endingsinputchecker(Scanner littledaddy, String endinginput) {
        while (!(endinginput.equals("1")) && !(endinginput.equals("2"))) {
            FancyPrinter.print("You didn't choose a valid option. Select again: ");
            endinginput = littledaddy.nextLine().trim();
        }
        if (endinginput.equals("1")) {
            StartScreen.start(littledaddy);
        } else {
            System.out.print(CenterString.space("---You closed the game.---"));
        }
    }
}