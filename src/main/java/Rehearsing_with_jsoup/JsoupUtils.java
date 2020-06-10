package Rehearsing_with_jsoup;

import java.util.Scanner;

/**
 *
 * @author jmartorell
 */

public class JsoupUtils {

    /* Used in any main program, it allows you to capture an integer by keyboard after displaying the
     * message corresponding to the first parameter. In case of input error (this is not an integer)
     * displays the error message (second parameter) and asks for the integer again until the entry is correct.
     */
    public static int askEnter(String message, String errorMessage) {

        Scanner scan = new Scanner(System.in);
        boolean givenCorrect = true;
        int userOption = 0;
        System.out.println(message);
        givenCorrect = scan.hasNextInt();
        do{
            givenCorrect = scan.hasNextInt();
            if(!givenCorrect){
                System.out.println(errorMessage);
            }else{
                userOption = scan.nextInt();
            }
            scan.nextLine();
        }while(!givenCorrect);

        return userOption;
    };
    /* With the same behavior as above but with the String data type, it asks for a text string
     * having previously displayed the message corresponding to the first parameter and, in case it is empty,
     * insists on displaying the error message corresponding to the second parameter, until the entry is correct.
     */
    public static String askString(String message, String errorMessage){

        Scanner scan = new Scanner(System.in);
        boolean givenCorrect;
        String targetName = "";
        System.out.println(message);
        do{
            givenCorrect = scan.hasNextLine();
            if(!givenCorrect){
                System.out.println(errorMessage);
            }else{
                targetName = scan.nextLine();
            }
            //scan.nextLine();
        }while(!givenCorrect);

        return targetName;

    };


}
