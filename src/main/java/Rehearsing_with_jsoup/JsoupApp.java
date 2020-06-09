package Rehearsing_with_jsoup;

/**
 *
 * @author jmartorell
 */
class JsoupApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JsoupApp prg = new JsoupApp ();
        prg.init();
    }

    void init() {
        int option = 0;
        String[] menu = {
                "SWITCH SPIDER RUN MODE:",
                "1. THESIS ............... Enter targets manually - 3. to display - 0. exit",
                "2. AUTOMATIC ............ Automatically charges targets from the recharger"

        };

        JsoupThesis jsoupThesis = new JsoupThesis();
        JsoupManager jsoupManager = new JsoupManager();
        JsoupRecharger data = new JsoupRecharger ();
        jsoupManager.initializeData(jsoupThesis, data.ranking.length, data.ranking[0].length,
                data.targets.length, data.targets[0].length);
        do{

            JsoupInterface.showMenu(menu);
            option = JsoupUtils.askEnter("Choose an option", "Error");
            switch (option){
                case 1:
                    // We will not implement anything
                    break;
                case 2:
                    jsoupManager.loadTargets(jsoupThesis, data);
                    JsoupInterface.showRanking(jsoupThesis.ranking);
                    break;
                case 3:
                    // we will not implement anything
                    break;
                case 0:
                    break;
                default:
            }

        }while ( option != 0 );

    }



}
