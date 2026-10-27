import java.util.List;
import java.util.ArrayList;

public class StatsClass {

    //Time will be dealt with as military time internally
    private double currentTime = 8.00;
    private int currentMoney = 50;
    private boolean wristwatch = false;
    private boolean wallet = false;

    //FOR NOW I will try to make a choice list using the List and Arraylist imports;
    //Ideally I should know everything in my game already and just use arrays
    private List<String> choiceList = new ArrayList<>();

    //I will create a constructor just in case I need it later - I ended up needing it later
    public void StatsClass() {
        choiceList.add("Read the note on the computer desk. ");
        choiceList.add("Read the poster. ");
        choiceList.add("Check the cabinet. ");
        choiceList.add("Check your pockets. ");
        choiceList.add("Go back to bed. ");
    }
}