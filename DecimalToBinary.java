import java.util.*;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        decimalToBinaryConverter(s);

        sc.close();
    }

    // here it is not clear how big enter decimal is 
    // so i am assuming enter decimal is perfectly fit in Integer
    static void decimalToBinaryConverter(String decimalString) {
        //check if decimalString is empty or not
        if(decimalString.equals("")) {
            System.err.println("please enter something it can not be empty");

            //return is use for breaking the flow of method
            return ;
        }

        //check it is valid decimal or not
        int validDecimal = 0;
        try {
            validDecimal = Integer.parseInt(decimalString);
        } catch (NumberFormatException ex) {
            System.out.println("please enter valid decimal");

            //return is use for breaking the flow of method
            return ;
        }

        //logic for converting decimal to binary
        // creating stringBuilder for storing binary values
        StringBuilder convertedBinary = new StringBuilder("");

        while(validDecimal > 0) {
            convertedBinary.append(validDecimal % 2);
            validDecimal /= 2;
        }

        // let converted binary is 1101 which is store in stringBuilder but correct binary is 1011 so we  use reverse method for revesing the string
        System.out.println("this is converted binary string : " + convertedBinary.reverse().toString() + " for " + decimalString);

    }

}