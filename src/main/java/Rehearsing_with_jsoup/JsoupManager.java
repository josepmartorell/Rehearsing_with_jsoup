package Rehearsing_with_jsoup;

import java.io.IOException;

/**
 *
 * @author jmartorell
 */
public class JsoupManager {


    public void initializeData(JsoupThesis jsoupThesis, int targetRows, int targetColumns, int scopeRows, int scopeColumns){
        jsoupThesis.targets = new String[targetRows][targetColumns];
        jsoupThesis.scope = new String[scopeRows][scopeColumns];


    }
    public void loadTargets(JsoupThesis jsoupThesis, JsoupRecharger data){
        for (int i = 0; i < data.targets.length ; i++){
            jsoupThesis.targets[i][0] = data.targets[i][0];
            jsoupThesis.targets[i][1] = data.targets[i][1];
            jsoupThesis.numberRankingEntries++;
        }

    }
    /* todo - add parameters: , String fromDate, String toDate */
    public void analyzeTargets(JsoupThesis jsoupThesis, String keyword) throws IOException {
        System.out.print("--------------------------------------------------------------------------\n" +
                         "Icij Search Engine Panama Papers - SNAPSHOOT: "+ keyword + "\n" +
                         "--------------------------------------------------------------------------\n\n" );
        JsoupScraper.shootTargets();
        System.out.print("\n");

    }


}
