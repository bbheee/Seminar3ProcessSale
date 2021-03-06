/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import integration.ItemDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author beibei
 */
public class SaleTest {
    
    public SaleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addItem method, of class Sale.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        ItemDTO registeredItem = new ItemDTO(50,"macka skinka",0.12,"skinka");
        Sale instance = new Sale();
        String expResult = "50, macka skinka, 50";
        String result = instance.addItem(registeredItem);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testAddSameItem() {
        System.out.println("addSameItem");
        ItemDTO registeredItem = new ItemDTO(50,"macka skinka",0.12,"skinka");
        Sale instance = new Sale();
        String expResult = "50, macka skinka, 100";
        instance.addItem(registeredItem);
        String result = instance.addItem(registeredItem);
        assertEquals(expResult, result);
       
    }
    
    public void testAddDifferentItem() {
        System.out.println("addDifferentItem");
        ItemDTO registeredItem1 = new ItemDTO(50,"macka skinka",0.12,"skinka");
        ItemDTO registeredItem2 = new ItemDTO(20,"cola zero",0.12,"cola");
        Sale instance = new Sale();
        String expResult = "50, cola zero, 70";
        instance.addItem(registeredItem1);
        String result = instance.addItem(registeredItem2);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of addItems method, of class Sale.
     */
    @Test
    public void testAdd2SameItems() {
        System.out.println("add2SameItems");
        ItemDTO registeredItem = new ItemDTO(20,"cola zero",0.12,"cola");
        Sale instance = new Sale();
        String expResult = "20, cola zero, 60";
        instance.addItem(registeredItem);
        String result = instance.addItems(registeredItem,2);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of caculateTaxes method, of class Sale.
     */
    @Test
    public void testCaculateTaxes() {
        System.out.println("caculateTaxes");
        ItemDTO registeredItem = new ItemDTO(20,"cola zero",0.12,"cola");
        Sale instance = new Sale();
        instance.addItem(registeredItem);
        double expResult = 2.4;
        double result = instance.caculateTaxes();
        assertEquals(expResult, result, 0.0);
     
    }
    @Test
    public void testCaculateTaxesWithMultiItems() {
        System.out.println("caculateTaxesWithMultiItems");
        ItemDTO registeredItem1 = new ItemDTO(50,"macka skinka",0.12,"skinka");
        ItemDTO registeredItem2 = new ItemDTO(20,"cola zero",0.12,"cola");
        ItemDTO registeredItem3 = new ItemDTO(15,"godis blåbär",0.12,"godis");
        Sale instance = new Sale();
        instance.addItem(registeredItem1);
        instance.addItem(registeredItem2);
        instance.addItem(registeredItem3);
        double expResult = 10.2;
        double result = instance.caculateTaxes();
        assertEquals(expResult, result, 0.0);
     
    }
}
