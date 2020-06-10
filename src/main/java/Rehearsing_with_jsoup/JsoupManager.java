package Rehearsing_with_jsoup;

import java.io.IOException;

/**
 *
 * @author jmartorell
 */
public class JsoupManager {


    public void initializeData(JsoupThesis jsoupThesis, int targetRows, int scopeRows, int scopeColumns){
        jsoupThesis.targets = new String[targetRows];
        jsoupThesis.scope = new String[scopeRows][scopeColumns];


    }
    public void loadTargets(JsoupThesis jsoupThesis, JsoupRecharger data){
        for (int i = 0; i < data.targets.length ; i++){
            jsoupThesis.targets[i] = data.targets[i];
            jsoupThesis.numberTargetsEntries++;
        }

    }
    /* todo - add parameters: , String fromDate, String toDate */ //Activating spider ...
    public void analyzeTargets(String keyword) throws IOException {
        System.out.print("--------------------------------------------------------------------------\n" +
                         "Icij Search Engine Panama Papers - SNAPSHOOT: "+ keyword + "\n" +
                         "--------------------------------------------------------------------------\n" );
        JsoupScraper.shootTargets(keyword);

    }


}
