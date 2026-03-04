package co.edu.uptc.util;

public class Helper {

    public static String isBlank(String msg){
        if (msg.isBlank())
            throw  new IllegalArgumentException(Constants.TYPING_BLANK);
        return msg;
    }

    public static int toInt(String number){
        try {
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(Constants.ERROR_FORMAT);
        }
    }
}