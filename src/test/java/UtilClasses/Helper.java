package UtilClasses;

public class Helper {

    private Helper(){}

    public static String getRandomString() {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabacdefghijklmnopqrstuvwxyz";
        char[] symbolsArray = symbols.toCharArray();
        int sizeResultString = 1 + (int) (Math.random() * 9);
        String resultString = "";
        int randomIndex;
        for (int i = 1; i <= sizeResultString; i++){
            randomIndex = (int) (Math.random() * (symbolsArray.length - 1));
            resultString += String.valueOf(symbolsArray[randomIndex]);
        }
        return resultString;
    }

}
