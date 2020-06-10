package Rehearsing_with_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.io.IOException;

/**
 *
 * @author jmartorell
 */
public class JsoupScraper {

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";

    public static void shootTargets(String query) throws IOException {

        final Document page = Jsoup.connect("https://offshoreleaks.icij.org/search?q=" + URLEncoder.encode(query, StandardCharsets.UTF_8)).userAgent(USER_AGENT).get();
        final Elements newsHeadlines = page.select("td.description a");
        final PrintWriter out = new PrintWriter("results.txt");

        for (Element searchResult : newsHeadlines) {

            String target = searchResult.text();
            System.out.println(target.strip());

            out.write(target + "\n");
        }
        out.close();

    }


}

