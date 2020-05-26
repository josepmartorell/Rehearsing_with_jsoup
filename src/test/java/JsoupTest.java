import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


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

    public static void main(String[] args) throws IOException {

        String id_shoot = "";

        //Downloads the html from wikipedia and parses it
        final Document doc = Jsoup.connect("https://offshoreleaks.icij.org/search?q=pharma").get();

        //Selects a bunch of a tags
        System.out.println("\nIcij Search Engine Panama Papers \nSnapshot: pharma - All countries\n");

        Elements newsHeadlines = null;

        if (SHIFT == 0){
            newsHeadlines = doc.select("td.description a");
        }else{
            newsHeadlines = doc.select("td");
        }


        //Print to console

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

            if (SHIFT == 0) {

                String headline = line.text();
                System.out.println(id_shoot + headline);
                ID_SHOOT++;

            } else if (SHIFT == 1){

                String headline = line.getElementsByClass("description").text();
                String dateline = line.getElementsByClass("incorporation").text();
                String juryline = line.getElementsByClass("jurisdiction").text();
                String landline = line.getElementsByClass("country").text();
                System.out.println(headline + dateline + juryline + landline);
                ID_SHOOT++;

            }

        }

        if (SHIFT != 0){
            System.out.println("Total shots: " + ID_SHOOT / 5);
        }


        System.out.println("\n\n----------------------------------------------------------------\n\n");

        //Print the outer html of the page
        System.out.println(doc.outerHtml());
    }

}

/*
 * FROM: DAM_J-repository/ASXM3B2_EAC6P2_Martorell_A/src/asxm3b2_eac6p2_martorell_a/:
 * System.out.println(String.format("%4s %-25s %10s %s %-40s", parts[0], parts[1], parts[2], "", descripcio));
 *  FROM: stars jhy/jsoup
 * jsoup/src/main/java/org/jsoup/nodes/Attribute.java /
 * */
