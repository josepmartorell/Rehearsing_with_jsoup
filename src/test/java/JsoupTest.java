import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
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
        final Document doc = Jsoup.connect("https://offshoreleaks.icij.org/search?q=pharma").get();
        final Document doc2 = Jsoup.connect("https://offshoreleaks.icij.org/nodes/10170053 ").get();

        //Selects a bunch of a tags
        if(SHIFT == 0 || SHIFT == 1)
            System.out.println("\nIcij Search Engine Panama Papers \nSnapshot: pharma - All countries\n");
        if(SHIFT == 2)
        //Selects an specific target
            System.out.println("\nIcij Search Engine Panama Papers \nSnapshot: pharma - PHARMA VITAL, S.A.\n");

        Elements newsHeadlines = null;

        //Print to console
        if (SHIFT == 0) {
            newsHeadlines = doc.select("td.description a");

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
            newsHeadlines = doc.select("td");

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

        }

        System.out.println("\n\n----------------------------------------------------------------\n\n");

        //Print the outer html of the page
        if (SHIFT == 0 || SHIFT == 1) {
            System.out.println(doc.outerHtml());
        }else{
            System.out.println(doc2.outerHtml());

        }


    }


}



/* TODO horizontal tabulation:
 * FROM: DAM_J-repository:
 * System.out.println(String.format("%4s %-25s %10s %s %-40s", parts[0], parts[1], parts[2], "", descripcio));
 *
 */
