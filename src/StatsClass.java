public class StatsClass {

    //Time will be dealt with as military time internally
    public int gameState;
    public int currentDay;
    public double currentTime;
    public int currentMoney;
    public boolean allowDTMdisplay;
    public int lastFridgemeal;
    public int chiliGodcount;

    //The plan is for gameState 1 to be the room, gameState 2 as the computer,
    // gameState 3 as fishing and gameState 4 as blackjack
    //11/12/26 - You can actually make arrays as big as you want when you instantiate them, just the extra slots are
    //treated as null values inside the index. So imma just set these to 25 (so I don't have to worry about array size when I put new Strings and stuff in)
    String[] nullchoices = new String[1];
    Boolean[] nullchoicesb = new Boolean[1];
    String[] choices1 = new String[25];
    Boolean[] choices1b = new Boolean[25];
    String[] choices2 = new String[25];
    Boolean[] choices2b = new Boolean[25];
    String[] choices3 = new String[25];
    Boolean[] choices3b = new Boolean[25];
    String[] choices4 = new String[25];
    Boolean[] choices4b = new Boolean[25];

    public StatsClass() {
        setStatsInit();
    }

    public String[] GetChoices() {
        //switch statements can just use returns instead of breaks if your returning something
        switch (gameState) {
            case 1:
                return choices1;
            case 2:
                return choices2;
            case 3:
                return choices3;
            case 4:
                return choices4;
            default:
                return nullchoices;
        }
    }

    public Boolean[] GetChoicesB() {
        switch (gameState) {
            case 1:
                return choices1b;
            case 2:
                return choices2b;
            case 3:
                return choices3b;
            case 4:
                return choices4b;
            default:
                return nullchoicesb;
        }
    }

    public String showDTM() {
        double time = currentTime;
        if (time % 1 == 0) {
            return ("Day " + currentDay + ", " + ("" + time).replace(".", ":") + "0, $" + currentMoney + " - ");
        } else if (time % 1 == .25) {
            return ("Day " + currentDay + ", " + ("" + time).replace(".25", ":15") + ", $" + currentMoney + " - ");
        } else if (time % 1 == .5) {
            return ("Day " + currentDay + ", " + ("" + time).replace(".5", ":30") + ", $" + currentMoney + " - ");
        } else if (time % 1 == .75) {
            return ("Day " + currentDay + ", " + ("" + time).replace(".75", ":45") + ", $" + currentMoney + " - ");
        }
        return ("!ERROR! check showDTM() in StatsClass");
    }

    private void setStatsInit() {
        gameState = 1;
        currentDay = 1;
        currentTime = 8.00;
        currentMoney = 100;
        allowDTMdisplay = false;
        //I don't want the ice-soup thing to be the first option cause player might think that's the only one
        lastFridgemeal = 5;
        chiliGodcount = 0;
        setArraysInit();
    }

    private void setArraysInit() {
        nullchoices[0] = "!ERROR! the nullchoices arrays were used";
        nullchoicesb[0] = true;
        setArray1();
        setArray2();
    }

    private void setArray1() {
        choices1[0] = "Read the note at the computer desk ";
        choices1[1] = "Use the computer ";
        choices1[2] = "Go out fishing ";
        choices1[3] = "Go to the casino ";
        choices1[4] = "Read the poster ";
        choices1[5] = "Check the cabinet ";
        choices1[6] = "Check your pockets ";
        choices1[7] = "Eat something out the fridge ";
        choices1[8] = "Doomscroll";
        choices1[9] = "Go back to bed";
        choices1b[0] = true;
        choices1b[1] = false;
        choices1b[2] = false;
        choices1b[3] = false;
        choices1b[4] = true;
        choices1b[5] = true;
        choices1b[6] = true;
        choices1b[7] = true;
        choices1b[8] = true;
        choices1b[9] = true;
    }

    private void setArray2() {
        choices2[0] = "Test choice 1";
        choices2[1] = "Test choice 2";
        choices2b[0] = true;
        choices2b[1] = true;
    }
}