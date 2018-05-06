/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;
import model.Sale;
/**
 *
 * @author beibei
 */
public class ExternalInventorySystem {
    
    private Sale sale; 
    
    public void updateInventory(Sale sale) {
        this.sale = sale;
    }   
}
