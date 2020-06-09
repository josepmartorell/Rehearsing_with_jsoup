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

    public static void showRanking(String[][]ranking){
        System.out.print("--------------------------------------------------------------------------\n" +
                         "CLUSTER 4.                                                 JACK CONNECTION\n" +
                         "--------------------------------------------------------------------------\n");
        int i = 0;
        while ( i < ranking.length){
            System.out.print(String.format("%-18s", ranking[i][ID_NAME]) + "\t\t");
            System.out.print(String.format("%50s",ranking[i][ID_PUNCTUATION ]) + "\n");
            i++;
        }

    }


}
