package UtilClasses;

import java.util.Random;

public class Helper {

    private Helper(){}

    public static String getRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabacdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        int sizeString = 1 + (int) (Math.random() * 9);
        while (salt.length() < sizeString) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static String getlastWordOfLink(String link){
        char[] linkAsChar = link.toCharArray();
        String result = "";
        for (int i = linkAsChar.length - 1; i >= 0; i--){
            if (linkAsChar[i] != '#'){result += String.valueOf(linkAsChar[i]);}
            else {break;}
        }
        char[] wordAsCharViceVersa = result.toCharArray();
        result = "";
        for(int i = wordAsCharViceVersa.length - 1; i >=0; i--){
            result += String.valueOf(linkAsChar[i]);
        }
        return result;
    }
}
