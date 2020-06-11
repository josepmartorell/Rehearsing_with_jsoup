import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author jmartorell
 */
public class JsoupTest {

    static short ID_SHOOT = 1;
    static short SHIFT = 0;
    static final String ZERO = "0";
    static final String SPOT = " ";
    static final String SKIP = "   ";
    static String DATER = "";
    static String TARGET = "";

    public static void main(String[] args) throws IOException {
        JsoupTest prg = new JsoupTest();
        prg.init();
    }

    void init() throws IOException {

        String id_shoot = "";

        System.out.println("Type no test: ");
        Scanner scan = new Scanner(System.in);
        SHIFT = scan.nextShort();

        //Downloads the html from wikipedia and parses it
        final Document doc1 = Jsoup.connect("https://offshoreleaks.icij.org/search?q=pharma").get();
        final Document doc2 = Jsoup.connect("https://offshoreleaks.icij.org/nodes/10170053 ").get();
        final Document doc3 = Jsoup.connect("https://medicaldevices.icij.org/search?q%5Bdisplay_cont%5D=bayer").get();
        final Document doc4 = Jsoup.connect("https://medicaldevices.icij.org/devices/col-medrad-bayer-contrast-media-injector-system").get();

        //Selects a bunch of a tags based on topic
        if(SHIFT == 0 || SHIFT == 1)
            System.out.println("\nIcij Search Engine Panama Papers \nSnapshoot: pharma - All countries\n");
        if(SHIFT == 2)
        //Selects an specific target
            System.out.println("\nIcij Search Engine Panama Papers \nSnapshoot: pharma - PHARMA VITAL, S.A.\n");
        if(SHIFT == 3)
            //Selects a bunch of a devices based on topic
            System.out.println("\nIcij International Medical Devices Database  \nSnapshoot: bayer\n");
        if(SHIFT == 4)
            //Selects an specific device
            System.out.println("\nIcij International Medical Devices Database  \nSnapshoot: MEDRAD-BAYER Contrast Media Injector System\n");

        Elements newsHeadlines = null;

        //Print to console
        if (SHIFT == 0) {
            newsHeadlines = doc1.select("td.description a");

            for (Element line : newsHeadlines) {
                id_shoot = Short.toString(ID_SHOOT);

                if (id_shoot.length() == 1) {
                    id_shoot = SPOT + ZERO + id_shoot + "";
                }
                if (id_shoot.length() == 2) {
                    id_shoot = SPOT + id_shoot + "  ";
                } else {
                    id_shoot = id_shoot + "  ";
                }

                String headline = line.text();
                System.out.println(id_shoot + headline);
                ID_SHOOT++;

            }


        } else if (SHIFT == 1){
            newsHeadlines = doc1.select("td");

            for (Element line : newsHeadlines) {

                String headline = line.getElementsByClass("description").text();
                String dateline = line.getElementsByClass("incorporation").text();
                String juryline = line.getElementsByClass("jurisdiction").text();
                String landline = line.getElementsByClass("country").text();
                System.out.println(headline + dateline + juryline + landline);
                ID_SHOOT++;
            }

        }

        if (SHIFT == 1){
            System.out.println("Total shots: " + ID_SHOOT / 5);

        }if (SHIFT == 2){
            newsHeadlines = doc2.select("tr");



            for (Element line : newsHeadlines) {
                /* garbage text replacement */
                String headline = line.text().replace("Role From To Data From", "");
                String skip = headline.replace("Status Data From", "");
                String skip2 = skip.replace("- Panama Papers", "");
                String skip3 = skip2.replace("Panama Papers", "");
                System.out.println(skip3);
            }
            System.out.println("Intermediary");

        }if(SHIFT == 3){
            newsHeadlines = doc3.select("td");
            int shoot = 0;
            int remainder = 0;

            for (Element line : newsHeadlines) {
                id_shoot = Short.toString(ID_SHOOT);
                String headline = line.text();
                remainder = shoot%6;
                if (remainder == 0) {
                    if (id_shoot.length() == 1) {
                        id_shoot = SPOT + ZERO + id_shoot + "";
                    }
                    if (id_shoot.length() == 2) {
                        id_shoot = SPOT + id_shoot + "  ";
                    } else {
                        id_shoot = id_shoot + "  ";
                    }
                    System.out.println(id_shoot + headline);
                    ID_SHOOT++;
                }

                shoot++;

            }

        }if(SHIFT == 4){
            newsHeadlines = doc4.select("div.float-right");

            System.out.println("Product Description:");
            String line = newsHeadlines.text();
            System.out.println(id_shoot + line);


        }if(SHIFT == 5){
            // creating a Calendar object
            Calendar c = Calendar.getInstance();

            // set Date
            c.set(Calendar.DATE, 14);

            // set Month
            // MONTH starts with 0 i.e. ( 0 - Jan)
            c.set(Calendar.MONTH, 1);

            // set Year
            c.set(Calendar.YEAR, 2008);

            // creating a date object with specified time.
            Date dateOne = c.getTime();
            System.out.println("Date 1: "
                    + dateOne);

            // creating a date of object
            // storing the current date
            Date currentDate = new Date();

            System.out.println("Date 2: "
                    + currentDate);

            // compares
            System.out.println("On Comparison: "
                    + currentDate
                    .compareTo(dateOne));
            /*Return Value: The function gives three return values specified below:

            It returns the value 0 if the argument Date is equal to this Date.
            It returns a value less than 0 if this Date is before the Date argument.
            It returns a value greater than 0 if this Date is after the Date argument.
            */

        }if(SHIFT == 6){

            //enter date
            System.out.println("Enter date: ");
            Scanner scan2 = new Scanner(System.in);
            DATER = scan2.nextLine();
            Date dater = ParseDater(DATER);
            System.out.println("ENTRY DATE: " + dater);

            //current date
            Date currentDate = new Date();
            System.out.println("CURRENT DATE: "
                    + currentDate);

            //compares
            System.out.println("On Comparison: "
                    + currentDate
                    .compareTo(dater));

            scan2.close();

        }if(SHIFT == 7){

            //enter date
            System.out.println("Enter date: ");
            Scanner scan2 = new Scanner(System.in);
            DATER = scan2.nextLine();

            String dater = DATER.replace('J', '1');

            Date newDater = ParseDater(dater);
            System.out.println("ENTRY DATE: " + newDater);

            //current date
            Date currentDate = new Date();
            System.out.println("CURRENT DATE: "
                    + currentDate);

            //compares
            System.out.println("On Comparison: "
                    + currentDate
                    .compareTo(newDater));

            scan2.close();


        }if(SHIFT == 8){

            //enter date
            System.out.println("Enter date: ");
            Scanner scan2 = new Scanner(System.in);
            DATER = scan2.nextLine();

            //check double quotes when no char are handled 'char', "string".
            String dater = DATER.replaceFirst("JAN", "1");

            Date newDater = ParseDater(dater);
            System.out.println("ENTRY DATE: " + newDater);

            //current date
            Date currentDate = new Date();
            System.out.println("CURRENT DATE: "
                    + currentDate);

            //compares
            System.out.println("On Comparison: "
                    + currentDate
                    .compareTo(newDater));

            scan2.close();


        }if (SHIFT == 9){
            String target_string = "JAN";
            String target_search = "09-JAN-1998";
            String[] words = target_search.split("\\W+");
            for (String word : words) {
                if (target_string.contains(word)) {
                    System.out.println("Found: " + word);
                }

            }


        }if (SHIFT == 10){
            newsHeadlines = doc1.select("td");

            for (Element line : newsHeadlines) {

                //String headline = line.getElementsByClass("description").text();
                String dateline = line.getElementsByClass("incorporation").text();
                String target_string = "JAN";
                String[] words = dateline.split("\\W+");
                for (String word : words) {
                    if (target_string.contentEquals(word)) {
                        System.out.println("Found word: " + word + " in " + dateline);
                    }
                    
                }

            }


        }if (SHIFT == 11){
            newsHeadlines = doc1.select("td");
            int no = 0;
            for (Element line : newsHeadlines) {

                String headline = line.getElementsByClass("description").text();
                String dateline = line.getElementsByClass("incorporation").text();
                String target_string = "JAN";
                String[] words = dateline.split("\\W+");
                for (String word : words) {
                    if (target_string.contentEquals(word)) {
                        no += 1;
                        System.out.println("Match " + no + ": " + word + " in " + dateline);
                    }

                }

            }


        }if (SHIFT == 12){

            //create object
            DataRecharger dataRecharger = new DataRecharger();
            //create object
            Recharger recharger = new Recharger();
            //assign the recharger the charge
            recharger.recharger = new String[dataRecharger.data.length][2];
            //initialize
            recharger.entity = 0;
            recharger.date = 1;
            for ( int i = 0; i < recharger.recharger.length; i++ ){
                recharger.recharger[i][0] = dataRecharger.data[i][recharger.entity];
                recharger.recharger[i][1] = dataRecharger.data[i][recharger.date];
            //show recharge
            }
            for ( int i = 0; i < recharger.recharger.length; i++ ){
                System.out.println(String.format("%-25s %-10s", recharger.recharger[i][0],
                        recharger.recharger[i][1]));
            }




        }






        System.out.println("\n\n----------------------------------------------------------------\n\n");

        //Print the outer html of the page
        if (SHIFT == 0 || SHIFT == 1) {
            System.out.println(doc1.outerHtml());
        }
        if(SHIFT == 2){
            System.out.println(doc2.outerHtml());
        }
        if(SHIFT == 3){
            System.out.println(doc3.outerHtml());
        }
        if(SHIFT == 4){
            System.out.println(doc4.outerHtml());

        }


    }

    public static Date ParseDater(String dater) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date daterDate = null;
        try {
            daterDate = formato.parse(dater);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return daterDate;
    }

    public class Recharger {
        String[][] recharger;
        int entity;
        int date;

    }

    public class DataRecharger {
        String[][] data = {
                {"VERTEX", "14-FEB-2001"},
                {"FALCON", "15-AUG-1987"},
                {"GOLDEN", "01-JUN-2013"},
                {"FREAKS", "23-JUL-2020"}

        };

    }


}
