public class Responses {

    String choiceindex;
    private final StatsClass gameStats;

    public Responses(StatsClass gameStats) {
        this.gameStats = gameStats;
    }

    public void respond(String input) {
        choiceindex = input;
    }

    public boolean responses1(String choiceindex) {
        int input = Integer.parseInt(choiceindex);
        switch (input) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: {
                FancyPrinter.println("You open up the cabinet, finding a fishing rod and tackle box, along with a map. *fishing has been unlocked* ");
                gameStats.choices1b[5] = false;
                gameStats.choices1b[2] = true;
                return false;
            }
            case 6:
            case 7:
            case 8:
            default:
                return true;
        }
    }
}
