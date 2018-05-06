package view;

import controller.Controller;

/**
 * This is a placeholder for the view. It contains only hardcoded calls to the controller.
 */
public class View {
    private Controller contr;
    
    /**
     * Constructs a new view, using the specified controller.
     * 
     * @param contr This controller will be used for all system operations.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Simulates a sample execution containing calls to all system operations.
     */
    public void sampleExecution() {
        System.out.println("Starting sample execution.");
        contr.startSale();
        System.out.println("After call to sartSale()");
        System.out.println(contr.enterItemID("macka"));
        System.out.println(contr.enterItemIDAndQuantity("cola", 2));
        System.out.println(contr.enterItemIDAndQuantity("godis", 2));
        System.out.println(contr.indicateAllItemsRegistered());
        System.out.println(contr.enterPaidCash(200));
    }
}
