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
    int points;
    double totalPrice = 0;
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
    
    public double getTotalPrice(){
        totalPrice = 0;    
        
        for(Book bk : booksToBuy){
            totalPrice += bk.getPrice();
        }
        System.out.println("total price " + totalPrice);
        return totalPrice;
    }
    
    
    public void setPoints(int po){
        po = points;
    }
    
    public double redeemPoints(){
        while(points >= 100){
            totalPrice = totalPrice - 1;
            points = points - 100;
        }
        return totalPrice;
    }
    
    public void Checkout(){
        booksToBuy.clear();
        totalPrice = 0;
    }
    
}
