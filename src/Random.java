public class Random {
    
    //Returns a 0 or 1 (heads or tails)
    public static int coinflip() {
        if ((Math.random() * 2) > 1) {
            return 1;
        }
    return 0;
    }

    //returns 1 2 3 or 4 at hopefully a 25% chance each using coinflip()
    public static int random4() {
        String s = "" + coinflip() + coinflip();
        int i = Integer.parseInt(s);
        switch(i) {
            case 00:
                return 1;
            case 10:
                return 2;
            case 01:
                return 3;
            case 11:
                return 4;
        }
        return -1;
    }
}
