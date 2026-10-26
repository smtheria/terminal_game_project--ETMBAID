//Super useful static method! This way, I don't have to set up try-catch for every time I want to wait around
public class Wait {
    public static void ms(int input) {
        try {
            Thread.sleep(input);
        } catch (InterruptedException e) {
            System.out.print("  !something fucked up and you threw an InterruptedException error!  ");
        }
    }
}