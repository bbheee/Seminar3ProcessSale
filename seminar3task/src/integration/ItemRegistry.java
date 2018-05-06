/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author beibei
 * The handler for the database that contains all items in the store.
 */
public class ItemRegistry {
    private List<ItemDTO> items = new ArrayList <>();
    
    /**
    *Creates a new instance and add the items to the registry.
    **/
    ItemRegistry () {
        addItems();
    }
    
    /**
     *Find an item in the registry with an ID that matches the one entered by cashier.
     * @param itemID Item ID entered by cashier.
     * @return the item in the registry with the matching ID.
     **/
    public ItemDTO findItem (String itemID){
        for (ItemDTO item: items){
            if (item.getID().equals(itemID))
                return new ItemDTO(item);
        }
        /*
        *if there is no matching item.
        */
        return null;
    }
    /**
     * @param index the position in the list that the item is retrieved from
     * @return the item in the position of index in the list. 
     **/
    public ItemDTO getItem(int index){
        return items.get(index);    
    }
    
    private void addItems(){
        items.add(new ItemDTO(50,"macka skinka",0.12,"macka"));
        items.add(new ItemDTO(20,"cola zero",0.12,"cola"));
        items.add(new ItemDTO(15,"godis blåbär",0.12,"godis"));
    }
}
