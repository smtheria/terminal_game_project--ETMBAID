import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChoiceLogic {

    private final Scanner tinydaddy;
    private final StatsClass gameStats;
    String[] currentChoices;
    Boolean[] currentChoicesB;

    public ChoiceLogic(Scanner tinydaddy, StatsClass gameStats) {
        this.tinydaddy = tinydaddy;
        this.gameStats = gameStats;
    }

    public String choice() {
        //this if-else just checks if DTM can be displayed
        if (gameStats.allowDTMdisplay) {
            FancyPrinter.println("\n" + gameStats.showDTM() + "You can: ");
        } else {
            FancyPrinter.println("\nYou can: ");
        }
        List<String> selectnums = new ArrayList<>();
        List<String> choiceindex = new ArrayList<>();
        currentChoices = gameStats.GetChoices();
        currentChoicesB = gameStats.GetChoicesB();
        int selectnum = 1;
        for (int c = 0; c < currentChoices.length; c++) {
            if (currentChoicesB[c] == true) {
                FancyPrinter.println(selectnum + ") " + currentChoices[c]);
                String num = ("" + selectnum);
                selectnums.add(num);
                choiceindex.add("" + c);
                selectnum += 1;
            }
        }
        FancyPrinter.print("What do you do? : ");
        String input = tinydaddy.nextLine().trim();
        while (!selectnums.contains(input)) {
            FancyPrinter.print("You didn't choose a valid option. Select again: ");
            input = tinydaddy.nextLine().trim();
        }
        //I had to look this up cause I forgot, but .get for lists-
        //will return whatever the type of the list is;
        //choiceindex is a string list
        return (choiceindex.get((Integer.parseInt(input) - 1)));
    }

    //Right now, the game is iterating using this code:
    //while (!gamefinished) {
    //            gamefinished = responder.respond(choice());
    //        }
    //This will have to be changed later once other gameStates come into play, so more responses methdos will be required
    public boolean respond(String choiceindex) {
        int input = Integer.parseInt(choiceindex);
        System.out.println("");
        switch (input) {
            case 0: {
                FancyPrinter.println("Nothing happens because this is placeholder code.");
                gameStats.currentTime += 0.25;
                break;
            }
            case 1: {
                FancyPrinter.println("Nothing happens because this is placeholder code.");
                gameStats.currentTime += 0.25;
                break;
            }
            case 2: {
                FancyPrinter.println("Nothing happens because this is placeholder code.");
                gameStats.currentTime += 0.25;
                break;
            }
            case 3: {
                FancyPrinter.println("Nothing happens because this is placeholder code.");
                gameStats.currentTime += 0.25;
                break;
            }
            case 4: {
                FancyPrinter.println("The poster: ");
                FancyPrinter.printCenteredln(CenterString.space("------------------------------"));
                FancyPrinter.printCenteredln(CenterString.space("CASINO FORTUNA"));
                System.out.println("");
                FancyPrinter.printCenteredln(CenterString.space("Where fortune meets elegance;"));
                FancyPrinter.printCenteredln(CenterString.space("Tonight, anything is possible."));
                System.out.println("");
                FancyPrinter.printCenteredln(CenterString.space("COME TO PLAY"));
                FancyPrinter.printCenteredln(CenterString.space("BLACKJACK & WIN BIG!"));
                System.out.println("");
                FancyPrinter.printCenteredln(CenterString.space("148 Mulberry Street, New York"));
                FancyPrinter.printCenteredln(CenterString.space("------------------------------"));
                FancyPrinter.printWrapln("A yellow sticky note on the poster reads: [1 hour from here; remember to stay alert.] ");
                FancyPrinter.println("*casino unlocked* ");
                gameStats.choices1b[4] = false;
                gameStats.choices1b[3] = true;
                gameStats.currentTime += 0.25;
                break;
            }
            case 5: {
                FancyPrinter.printWrapln("You open up the cabinet, finding a fishing rod and tackle box, along with a map. A yellow sticky note on the map says: [it takes an hour to get to the lake from here.] ");
                FancyPrinter.println("*fishing unlocked* ");
                gameStats.choices1b[5] = false;
                gameStats.choices1b[2] = true;
                gameStats.currentTime += 0.25;
                break;
            }
            case 6: {
                FancyPrinter.printWrapln("You thumb around your pockets, finding your wallet and a wristwatch. Sadly, the wristwatch only reads in military time :( . ");
                FancyPrinter.println("*date, time and cash display unlocked* ");
                gameStats.choices1b[6] = false;
                gameStats.allowDTMdisplay = true;
                break;
            }
            case 7: {
                FancyPrinter.println("Nothing happens because this is placeholder code. this skips to 19:00");
                gameStats.currentTime = 19.0;
                break;
            }
            case 8: {
                FancyPrinter.println("Nothing happens because this is placeholder code.");
                gameStats.currentTime += 0.25;
                break;
            }
            default:
                FancyPrinter.println(" !!the default case of respond() was triggered!! ");
                break;
        }
        return mafiacheck(0);
    }

    private boolean mafiacheck(int deathNum) {
        if (gameStats.currentTime == 20.0) {
            switch (deathNum) {
                case 0: {
                    FancyPrinter.printWrapln("It's 8:00 PM, and you hear a loud banging on your door. \"Open up buddy! Daily protection fee, it's time to pay up!\" ");
                    if (gameStats.currentMoney >= 50) {
                        FancyPrinter.printWrapln("\"Alright, I'm coming!\" You check your pocket, whip your wallet out and strut to the door. \"Here you go dude.\" \"The man takes the money. \"Good, we'll be back tomorrow. Remember, 50 bucks at eight o' clock sharp, every day!\" ");
                        gameStats.currentMoney -= 50;
                        if (gameStats.choices1b[6] == true) {
                            gameStats.choices1b[6] = false;
                            gameStats.allowDTMdisplay = true;
                            FancyPrinter.println("*date, time and cash display unlocked* ");
                        }
                    } else {
                        FancyPrinter.printWrapln("\"I don't have it!\" You check your pockets, but you don't have enough money. \"What do you mean you don't have it? You know the rules!\" A flurry of bullets shreds your wooden door to pieces. You fall to the ground, and the mobster kicks you in the stomach. \"That's why you don't disrespect the mafia buddy.\" You feel your vision fading as the bullets punch into you, and realize that this is the end. ");
                        FancyPrinter.linebreak();
                        FancyPrinter.printCenteredln(CenterString.space("*GAME OVER* "));
                        FancyPrinter.printCenteredln(CenterString.space("*You unlocked the Swimming With the Fishes ending* "));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean end() {
        return false;
    }
}