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
public class ExternalAccountingSystem {
    private Sale sale;
    
    /**
     * 
     * @param sale 
     */
    
    public void bookkeep(Sale sale) {
        this.sale = sale;
    }
    
}
