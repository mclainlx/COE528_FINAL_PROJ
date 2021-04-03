/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 
 */
public class editCart {
    
    ArrayList<Book> booksToBuy = new ArrayList<>();
    
    public void addToCart(List<Book> list){
        booksToBuy.addAll(list);
        
    }
    
    public void removeFromCart(List<Book> list){
        booksToBuy.removeAll(list);
    }
    
    public ArrayList<Book> getCart(){
        return booksToBuy;
    }
}