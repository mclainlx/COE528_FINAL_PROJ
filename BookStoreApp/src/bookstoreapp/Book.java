/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draftproj;

/**
 *
 * @author karankarwal
 */
public class Book {
    double price;
    String title;
    
    public Book(double price, String title){
        this.price = price;
        this.title = title;
         
    }
    
    public void setPrice(double p){
        p = price;
    }
    
    public void setTitle(String t){
        t = title;
    }
    
    @Override
    public String toString(){
       return "Title: " + title + ", Price: $" + price;
    }
}
