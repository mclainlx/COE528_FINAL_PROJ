/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

/**
 *
 * @author karankarwal
 */
public class Book {
    double price;
    String title;
    
    public Book(String title, double price){
        this.price = price;
        this.title = title;
         
    }
    
    public void setPrice(double p){
        price = p;
    }
    
    public void setTitle(String t){
        title = t;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString(){
       return "Title: |" + title + "|, Price: |$" + price + "|\n";
    }
}
