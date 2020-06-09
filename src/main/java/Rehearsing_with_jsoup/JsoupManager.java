package Rehearsing_with_jsoup;

/**
 *
 * @author jmartorell
 */
public class JsoupManager {


    public void initializeData(JsoupThesis jsoupThesis, int rankingRows, int rankingColumns, int targetsRows, int targetsColumns){
        jsoupThesis.ranking = new String[rankingRows][rankingColumns];
        jsoupThesis.targets = new String[targetsRows][targetsColumns];


    }
    public void loadTargets(JsoupThesis jsoupThesis, JsoupRecharger data){
        for (int i = 0; i < data.ranking.length ; i++){
            jsoupThesis.ranking[i][0] = data.ranking[i][0];
            jsoupThesis.ranking[i][1] = data.ranking[i][1];
            jsoupThesis.numberRankingEntries++;
        }

    }


}
