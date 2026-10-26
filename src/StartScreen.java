import java.util.Scanner;

public class StartScreen {
    public static void start(Scanner littledaddy) {
        FancyPrinter.linebreak();
        FancyPrinter.printCharsln(CenterString.space("Welcome To..." + "\n"));
        FancyPrinter.printCharsln(CenterString.space("ESCAPE THE MAFIA"));
        FancyPrinter.printCharsln(CenterString.space("WITH AI DROPSHIPPING" + "\n"));
        Wait.ms(200);
        FancyPrinter.printCharsln(CenterString.space("Start: 1"));
        FancyPrinter.printCharsln(CenterString.space("Endings List: 2"));
        FancyPrinter.printCharsln(CenterString.space("Exit: 3"));
        FancyPrinter.printChars(CenterString.space("Please select an option: "));
        String startinput = littledaddy.nextLine();
        startinput = startinput.trim();
        StartScreen.firstcheck(littledaddy, startinput);
    }

    private static void firstcheck(Scanner littledaddy, String input) {
        if (!((input.equals("1")) || (input.equals("2")) || (input.equals("3")))) {
            FancyPrinter.print("You didn't choose a valid option. Select again: ");
            StartScreen.check(littledaddy);
        } else {
            StartScreen.callevent(input);
        }
    }

    private static void check(Scanner littledaddy) {
        String input = littledaddy.nextLine();
        input = input.trim();
        if (!((input.equals("1")) || (input.equals("2")) || (input.equals("3")))) {
            FancyPrinter.print("You didn't choose a valid option. Select again: ");
            StartScreen.check(littledaddy);
        } else {
            StartScreen.callevent(input);
        }
    }

    private static void callevent(String input) {
        int event;
        if (input.equals("1")) {
            FancyPrinter.linebreak();
            event = 1;
        } else if (input.equals("2")) {
            FancyPrinter.linebreak();
            event = 2;
        } else {
            System.out.print(CenterString.space("---You closed the game.---"));
        }
    }
}