package Rehearsing_with_jsoup;

/**
 *
 * @author jmartorell
 */
public class JsoupInterface {

    static final short ID_NAME = 0;
    static final short ID_PUNCTUATION = 1;
    /* From a String array that contains the different menu options, display this properly formatted.
     * The first position in that array is the title of the menu, not an option.
     */
    public static void showMenu(String[] menu){
        System.out.print("--------------------------------------------------------------------------\n" +
                         "* * * * * *    JTECH web scraping panel (www.jtech.network)    * * * * * *\n" +
                         "--------------------------------------------------------------------------\n");

        for (int i = 0; i < menu.length; i++){
            System.out.print(menu[i] + "\n");
        }

    }
    /* From an array containing a ranking of names and punctuation (1st and 2nd column), display it on the screen
     * properly formatted, with the columns well aligned regardless of the length of the characters.
     */

    public static void showRanking(String[][]targets){
        System.out.print("--------------------------------------------------------------------------\n" +
                         "KEYWORDS                                                           RESULTS\n" +
                         "--------------------------------------------------------------------------\n");
        int i = 0;
        while ( i < targets.length){
            System.out.print(String.format("%-18s", targets[i][ID_NAME]) + "\t\t");
            System.out.print(String.format("%50s",targets[i][ID_PUNCTUATION ]) + "\n");
            i++;
        }

    }


}
