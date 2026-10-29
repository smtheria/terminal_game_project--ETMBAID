import java.util.Scanner;

//I know that I should have just created a class level scanner here, but I don't want to-
//rewrite the code so it's just gonna stay bad now. This problem will hopefully be fixed in the game class
//Gemini is flaming my shit for coding this with a bunch of static methods instead of as an OOP class;
//I will take this into account for rest of project
//The reason I was avoiding that was I thought I had to instantiate the class inside itself, but that's not how that works - 10/26/26
//I just learned about using while loops, so I will be using those to check user inputs in the future instead of recursion; 5:31pm, 10/26/26
public class StartScreen {

    //This is what gets called by the Main method to kick everything off
    //It just uses FancyPrinter to print out the opening text, then calls startinputcheck(Scanner)
    //This scanner continues getting passed around, because I didn't create the StartScreen as an object,
    //so every method must receive a System.in scanner to work - 12:53pm, 10/27/26
    public static void startScreen(Scanner littledaddy) {
        FancyPrinter.linebreak();
        FancyPrinter.printCenteredln(CenterString.space("Welcome To..." + "\n"));
        FancyPrinter.printCenteredln(CenterString.space("ESCAPE THE MAFIA"));
        FancyPrinter.printCenteredln(CenterString.space("BY AI DROPSHIPPING" + "\n"));
        Wait.ms(200);
        FancyPrinter.printCenteredln(CenterString.space("Start Game: 1"));
        FancyPrinter.printCenteredln(CenterString.space("Endings List: 2"));
        FancyPrinter.printCenteredln(CenterString.space("Close Game: 3"));
        FancyPrinter.printCentered(CenterString.space("Please select an option: "));
        StartScreen.startinputcheck(littledaddy);
    }

    private static void startinputcheck(Scanner littledaddy) {
        String input = littledaddy.nextLine().trim();
        while (!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3"))) {
            FancyPrinter.print("You didn't choose a valid option. Select again: ");
            input = littledaddy.nextLine().trim();
        }
        StartScreen.callevents(littledaddy, input);
    }

    private static void callevents(Scanner littledaddy, String input) {
        if (input.equals("1")) {
            FancyPrinter.linebreak();
            Game game = new Game(littledaddy);
            game.intro();
        } else if (input.equals("2")) {
            StartScreen.endingsScreen(littledaddy);
        } else {
            System.out.print(CenterString.space("---You closed the game.---"));
        }
    }

    private static void endingsScreen(Scanner littledaddy) {
        int customprintspeed = 60;
        FancyPrinter.linebreak();
        FancyPrinter.printCenteredln(CenterString.space("--POSSIBLE ENDINGS--"));
        FancyPrinter.println("Ending 1: ", customprintspeed);
        FancyPrinter.println("Ending 2: ", customprintspeed);
        FancyPrinter.println("Ending 3: ", customprintspeed);
        FancyPrinter.println("Ending 4: ", customprintspeed);
        FancyPrinter.println("Ending 5: ", customprintspeed);
        FancyPrinter.println("Secret Ending: ???" + "\n", customprintspeed);
        FancyPrinter.print("Press 1 to return to start screen; Press 2 to close the game: ");
        StartScreen.endingsinputcheck(littledaddy);
    }

    private static void endingsinputcheck(Scanner littledaddy) {
        String input = littledaddy.nextLine().trim();
        while (!(input.equals("1")) && !(input.equals("2"))) {
            FancyPrinter.print("You didn't choose a valid option. Select again: ");
            input = littledaddy.nextLine().trim();
        }
        if (input.equals("1")) {
            StartScreen.startScreen(littledaddy);
        } else {
            System.out.print(CenterString.space("---You closed the game.---"));
        }
    }
}