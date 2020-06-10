package Rehearsing_with_jsoup;

import java.io.IOException;

/**
 *
 * @author jmartorell
 */

class JsoupApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        JsoupApp prg = new JsoupApp ();
        prg.init();
    }

    void init() throws IOException {
        int option = 0;
        String[] menu = {
                "SWITCH SPIDER RUN MODE:",
                "1. THESIS ............... Enter targets manually - 3. to display - 0. exit",
                "2. AUTOMATIC ............ Automatically charges targets from the recharger"

        };

        JsoupThesis jsoupThesis = new JsoupThesis();
        JsoupManager jsoupManager = new JsoupManager();
        JsoupRecharger data = new JsoupRecharger ();
        jsoupManager.initializeData(jsoupThesis, data.targets.length,
                data.scope.length, data.scope[0].length);
        do{

            JsoupInterface.showMenu(menu);
            option = JsoupUtils.askEnter("Choose an option", "Error");
            switch (option){
                case 1:
                    // We will not implement anything
                    String keyword = JsoupUtils.askString("Enter keyword:", "Error");
                    jsoupManager.analyzeTargets(jsoupThesis, keyword);
                    break;
                case 2:
                    // we will not implement anything
                    break;
                case 3:
                    jsoupManager.loadTargets(jsoupThesis, data);
                    JsoupInterface.showRanking(jsoupThesis.targets);
                    break;
                case 0:
                    break;
                default:
            }

        }while ( option != 0 );

    }



}
