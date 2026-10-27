public class StatsClass {

    //Time will be dealt with as military time internally
    public int gameState;
    public double currentTime;
    public int currentMoney;

    String[] nullchoices = new String[1];
    Boolean[] nullchoicesb = new Boolean[1];
    String[] choices1 = new String[9];
    Boolean[] choices1b = new Boolean[9];
    String[] choices2 = new String[0];
    Boolean[] choices2b = new Boolean[0];
    String[] choices3 = new String[0];
    Boolean[] choices3b = new Boolean[0];

    //I will create a constructor just in case I need it later - I ended up needing it later
    public StatsClass() {
        setStatsInit();
    }

    public String[] GetChoices() {
        //switch statements can just use returns instead of breaks if your returning something
        switch (gameState) {
            case 1:
                return choices1;
            default:
                return nullchoices;
        }
    }

    public Boolean[] GetChoicesB() {
        switch (gameState) {
            case 1:
                return choices1b;
            default:
                return nullchoicesb;
        }
    }

    private void setStatsInit() {
        gameState = 1;
        currentTime = 8.00;
        currentMoney = 50;
        setArraysInit();
    }

    private void setArraysInit() {
        nullchoices[0] = "this is from a placeholder array";
        nullchoicesb[0] = false;
        setArray1();
    }

    private void setArray1() {
        choices1[0] = "Read the note at the computer desk ";
        choices1[1] = "Use the computer ";
        choices1[2] = "Go out fishing ";
        choices1[3] = "Go to the Casino ";
        choices1[4] = "Read the poster ";
        choices1[5] = "Check the Cabinet ";
        choices1[6] = "Check your pockets ";
        choices1[7] = "Doomscroll";
        choices1[8] = "Go back to bed";
        choices1b[0] = true;
        choices1b[1] = false;
        choices1b[2] = false;
        choices1b[3] = false;
        choices1b[4] = true;
        choices1b[5] = true;
        choices1b[6] = true;
        choices1b[7] = true;
        choices1b[8] = true;
    }
}