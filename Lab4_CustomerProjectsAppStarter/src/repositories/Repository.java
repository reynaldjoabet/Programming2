/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import daos.DAOTextImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author mga
 */
public class Repository {
    private List<Customer> items;    
    static char DELIMITER=',';
    
    public Repository() {
        
        this.items = new LinkedList<>();        
    }
    
    public Repository(List<Customer> items) {        
        this.items = items;
    }
    
    public Repository(String filename) {
        this();
        // Insert load code from controller
DAOTextImpl dAOTextImpl= new DAOTextImpl();
this.items=dAOTextImpl.load(filename).getItems();
        
        // Replace with dao creation & call
         //DAOTextImpl dAOTextImpl= new DAOTextImpl();
         //dAOTextImpl.store(filename, this);
    }
    
    public List<Customer> getItems() {        
        return this.items;
    }
    
    public void setItems(List<Customer> items) {        
        this.items = items;
    }
    
    public void add(Customer item) {
        this.items.add(item);
    }
       
    public void remove(int id) {
        Predicate<Customer> customerPredicate = c->c.getCustomerId() == id;       
        this.items.removeIf(customerPredicate);
    }
    
    public Customer getItem(int id) {
        for (Customer item:this.items) {
            if (item.getCustomerId() == id)
                return item;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "\nCustomers: " + this.items;
    }
    
    public String toString(char delimiter) {
        String output = "";
        for (Customer item: this.items) {
            output += item.toString(delimiter);
        }
        return output;
    }
    
    public void store(String filename) {
        // Insert store code from controller
        try (PrintWriter output = new PrintWriter(filename)) {
            output.print(this.toString(DELIMITER));
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }         
        // Replace with dao creation & call
        DAOTextImpl daotimImpl= new DAOTextImpl();
        daotimImpl.store(filename,this);
    }    
    
    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }     
}
