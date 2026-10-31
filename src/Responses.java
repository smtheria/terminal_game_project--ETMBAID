public class Responses {

    private final StatsClass gameStats;

    public Responses(StatsClass gameStats) {
        this.gameStats = gameStats;
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
                gameStats.currentTime +=0.25;
                return false;
            }
            case 1: {
                FancyPrinter.println("Nothing happens because this is placeholder code.");
                gameStats.currentTime +=0.25;
                return false;
            }
            case 2: {
                FancyPrinter.println("Nothing happens because this is placeholder code.");
                gameStats.currentTime +=0.25;
                return false;
            }
            case 3: {
                FancyPrinter.println("Nothing happens because this is placeholder code.");
                gameStats.currentTime +=0.25;
                return false;
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
                gameStats.currentTime +=0.25;
                return false;
            }
            case 5: {
                FancyPrinter.printWrapln("You open up the cabinet, finding a fishing rod and tackle box, along with a map. A yellow sticky note on the map says: [it takes an hour to get to the lake from here.] ");
                FancyPrinter.println("*fishing unlocked* ");
                gameStats.choices1b[5] = false;
                gameStats.choices1b[2] = true;
                gameStats.currentTime +=0.25;
                return false;
            }
            case 6: {
                FancyPrinter.printWrapln("You thumb around your pockets, finding your wallet and a wristwatch. Sadly, the wristwatch only reads in military time :( . ");
                FancyPrinter.println("*date, time and cash display unlocked* ");
                gameStats.choices1b[6] = false;
                gameStats.allowDTMdisplay = true;
                return false;
            }
            case 7:
            case 8:
            default:
                return true;
        }
    }
}