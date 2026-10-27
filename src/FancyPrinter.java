import java.util.Scanner;

//This is my attempt at FancyPrintv2
//METHODS LIST:
//print, println, printWrap, printWrapln,
// printChars, printCharsln,linebreak, printCentered, printCenteredln
public class FancyPrinter {

    //I just learned about the final modifier, so I'll use it to sort out the default variables for FancyPrinter - 12:18pm, 10/25/26
    private static final int defSpaceDelayms = 90;
    private static final int defCharDelayms = 30;
    private static final int defWrapLength = 80;

    //FancyPrinter goes through each index and prints it, waiting a delay for each space
    public static void print(String input, int delayms) {
        for (int c = 0; c < input.length(); c++) {
            String character = input.substring(c, c + 1);
            if (character.equals(" ")) {
                Wait.ms(delayms);
            }
            System.out.print(character);
        }
    }

    public static void print(String input) {
        FancyPrinter.print(input, defSpaceDelayms);
    }

    //These ln methods just skip a line right after they do their thang
    public static void println(String input, int delayms) {
        FancyPrinter.print(input, delayms);
        System.out.println("");
    }

    public static void println(String input) {
        FancyPrinter.println(input, defSpaceDelayms);
    }

    //While writing this method, I asked Gemini how actual programs do text wrapping, which I originally called indentation
    //Standard approach is called Greedy Method; you look at line length, and if you print a character exceeding line length,
    //Then you insert a \n where you last passed a " "
    //To do that, I'm gonna have to play with the code a little bit; the printing method here may differ from the other methods
    //I'm starting by printing the space before waiting now; actually, I should change the other methods for consistency - 12:07am, 10/25/26
    //The way this prints currently actually makes implementing the Greedy method without changing anything very hard
    //To do so, I'll have to check for the length of the word that follows every space,
    //and check if printing that word would increase the lineindexcounter to wraplength
    //Cool trick from gemini! using .replaceAll(regex, replacement), a string method, I can make sure nothing input into printWrap has -
    //Weirdly formatted whitespace! This saves me the headache of accounting for not-normal strings getting printed - 12:50am, 10/25/26
    //FancyPrint v2 pretty much done - the last thing I am doing is having println just call print and then skipping to save lines of code - 1:00am, 12/25/26
    //Nevermind I had bugs - firstly, you can use .trim(), a string method, along with .replaceAll(regex, replacement) to cut whitespace from the front and back of the string
    //Also, you can manually check the next word with scanner.hasNext(), which returns a boolean for if the scanner has another word to read - 1:10am, 10/25/26

    //8:23, 10/26/26 - Shorter explanation of printWrap
    //This method takes in a string, trims off any whitespace at the beginning and end,
    //replaces all inner whitespace with single spaces using replaceAll(),
    //Then instantiates its own scanner to specifically read from this modified input;
    //If your printing away and hit a space index, FancyPrinter checks if printing the next-
    //word will send you over the wrap limit, and will move down a line automatically if so
    public static void printWrap(String input, int delayms, int wraplength) {
        input = input.trim().replaceAll("\\s+", " ");
        Scanner wordreader = new Scanner(input);
        if (wordreader.hasNext()) {
            wordreader.next();
        }
        int linelength = 0;
        for (int c = 0; c < input.length(); c++) {
            String character = input.substring(c, c + 1);
            if (character.equals(" ")) {
                Wait.ms(delayms);
                if (wordreader.hasNext()) {
                    String nextword = wordreader.next();
                    if (nextword.length() + linelength > wraplength) {
                        System.out.print(character);
                        System.out.println("");
                        linelength = 0;
                    } else {
                        linelength += 1;
                        System.out.print(character);
                    }
                }
            } else {
                linelength += 1;
                System.out.print(character);
            }
        }
    }

    public static void printWrap(String input) {
        FancyPrinter.printWrap(input, defSpaceDelayms, defWrapLength);
    }

    public static void printWrap(String input, int delayms) {
        FancyPrinter.printWrap(input, delayms, defWrapLength);
    }

    public static void printWrapln(String input, int delayms, int wraplength) {
        FancyPrinter.printWrap(input, delayms, wraplength);
        System.out.println("");
    }

    public static void printWrapln(String input) {
        FancyPrinter.printWrapln(input, defSpaceDelayms, defWrapLength);
    }

    public static void printWrapln(String input, int delayms) {
        FancyPrinter.printWrapln(input, delayms, defWrapLength);
    }

    //8:26, 10/26/26 - This has been changed to printing with delay on each character no matter what it is
    public static void printChars(String input, int delayms) {
        for (int c = 0; c < input.length(); c++) {
            String character = input.substring(c, c + 1);
            Wait.ms(delayms);
            System.out.print(character);
        }
    }

    public static void printChars(String input) {
        FancyPrinter.printChars(input, defCharDelayms);
    }

    public static void printCharsln(String input, int delayms) {
        FancyPrinter.printChars(input, delayms);
        System.out.println("");
    }

    public static void printCharsln(String input) {
        FancyPrinter.printCharsln(input, defCharDelayms);
    }

    //prints a linebreak in 1 second
    public static void linebreak() {
        FancyPrinter.printCharsln("================================================================================", 10);
        Wait.ms(200);
    }

    //This new method only delays non-spaces, replacing printChars
    public static void printCentered(String input, int delayms) {
        for (int c = 0; c < input.length(); c++) {
            String character = input.substring(c, c + 1);
            if (!character.equals(" ")) {
                Wait.ms(delayms);
            }
            System.out.print(character);
        }
    }

    public static void printCentered(String input) {
        FancyPrinter.printCentered(input, defCharDelayms);
    }

    public static void printCenteredln(String input, int delayms) {
        FancyPrinter.printCentered(input, delayms);
        System.out.println("");
    }

    public static void printCenteredln(String input) {
        FancyPrinter.printCenteredln(input, defCharDelayms);
    }
}