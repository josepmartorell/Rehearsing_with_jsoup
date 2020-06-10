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
                    String keyword = JsoupUtils.askString("Enter keyword:", "Error");
                    System.out.print("Activating spider ...\n");
                    jsoupManager.analyzeTargets(keyword);
                    System.out.print("Spider disabled ...\n");
                    break;
                case 2:
                    jsoupManager.loadTargets(jsoupThesis, data);
                    System.out.print("Activating spider ...\n");
                    for (int i = 0; i < data.targets.length ; i++){
                        jsoupManager.analyzeTargets(jsoupThesis.targets[i]);
                    }
                    System.out.print("Spider disabled ...\n");
                    break;
                case 3:
                    jsoupManager.loadTargets(jsoupThesis, data);
                    JsoupInterface.showTargets(jsoupThesis.targets);
                    break;
                case 0:
                    break;
                default:
            }

        }while ( option != 0 );

    }



}
