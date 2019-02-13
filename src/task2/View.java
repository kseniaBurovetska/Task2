package task2;

public class View {

    public static final String RANGE_STRING = "Range is: ";
    public static final String INPUT_STRING = "Input int value!";
    public static final String WRONG_INPUT_STRING = "Wrong input! ";
    public static final String WRONG_RANGE_STRING = "Out of range! ";
    public static final String MORE_STRING = "More! ";
    public static final String LESS_STRING = "Less! ";
    public static final String TRIES_STRING = "Tries - ";
    public static final String WON_STRING = "You won! Number is - ";
    public static final String INPUT_RANGE = "Input range if format \'num;num\' ";
    public static final String EXIT_STRING = "Press \'q\' to use default ";


    public void printMessage(String message){
        System.out.println(message);
    }

    public void printRange(int rangeLow, int rangeTop){
        printMessage(View.RANGE_STRING+"]"+rangeLow+";"+rangeTop+"[");
    }
}
