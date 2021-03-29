/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draftproj;
import java.util.ArrayList;

/**
 *
 * @author karankarwal
 */
public class editBook {
    ArrayList<Book> books = new ArrayList<>();
    
    //Right now hard coded, will comeback and make it use user input
    public void addBook(double price, String title){
        Book b = new Book(price, title);
        books.add(b);
    }
    
    public void displayBooks(){
        System.out.println(books);
    }
    
    //Testing the methods here, REMOVE LATER
    public static void main(String[] args) {
        editBook ed = new editBook();
        ed.addBook(15.00, "1984");
        ed.displayBooks();
    }
}
