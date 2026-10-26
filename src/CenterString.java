public class CenterString {
    private static final int defTerminal_length = 80;

    //Strings outputted by space should only be printed using printChars and printCharsln in FancyPrinter
    //Because the spaces fuck it up
    //all this method does is return the string with spaces put in front of it to center it
    public static String space(String input, int termlength) {
        if (input.length() < termlength) {
            int indentnum = (termlength - input.length()) / 2;
            String spaces = " ".repeat(indentnum);
            String output = spaces + input;
            return output;
        }
        return input;
    }

    public static String space(String input) {
        return CenterString.space(input, defTerminal_length);
    }
}