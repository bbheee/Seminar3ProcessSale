package controller;

import model.Sale;
import model.Receipt;
import integration.ItemDTO;
import integration.RegistryCreator;
import integration.ItemRegistry;
import integration.Printer;
import integration.ExternalAccountingSystem;
import integration.ExternalInventorySystem;
/**
 * This is the application's only controller. All calls to the model pass through here.
 */
public class Controller {
    private Sale sale;
    private ItemRegistry itemRegistry;
    private Printer printer;
    private ExternalAccountingSystem accounting;
    private ExternalInventorySystem inventory;
    
    /**
     * Create a new instance.
     * @param regCreator the object responsible for creating the registries.
     * @param
     **/
            
    public Controller(RegistryCreator regCreator, Printer printer, ExternalAccountingSystem accounting,ExternalInventorySystem inventory){
        this.itemRegistry = regCreator.getItemRegistry();
        this.printer = printer;
        this.accounting = accounting;
        this.inventory = inventory;
       
    }
    
    /**
     * 
     * @param 
     * @param
     **/
    public Controller(RegistryCreator regCreator){
        this.itemRegistry = regCreator.getItemRegistry();
    }
    /**
     * Creates an empty instance of {@link Sale}, which will be used for all information regarding
     * the sale that is now started.
     */
    
    public void startSale() {
        sale = new Sale();
    }
    /**
     * @param itemID is a indentifier of an item that is bought 
     * @return uppdated sale information
     **/
    public String enterItemID(String itemID) {
        ItemDTO registeredItem = itemRegistry.findItem(itemID);
        return sale.addItem(registeredItem);
    }
     /**
    * @param itemID and quantity of the item
    * @return updated sale information with quantity
    **/
    public String enterItemIDAndQuantity(String itemID,int quantity) {
        ItemDTO registeredItem = itemRegistry.findItem(itemID);
        return sale.addItems(registeredItem,quantity);
    }
    /**
    * caculate total taxes when all items have been registered
    **/
    public double indicateAllItemsRegistered() {
        return sale.caculateTaxes();
    }
     /**
    * @param paidAmount is the cash that customer paid and cashier enter the amount in the system
    * @return the changes that caculated by system
    **/
    public int enterPaidCash(int paidAmount){
        int changeAmount = sale.caculateChange(paidAmount);
        sale.printReceipt(printer);
        accounting.bookkeep(sale);
        inventory.updateInventory(sale);
        return changeAmount;
    }
}
