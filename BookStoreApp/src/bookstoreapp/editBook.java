/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author karankarwal
 */
public class editBook {
    ArrayList<Book> books = new ArrayList<>();
    File myfi = new File("Books.txt");
    
    //It now takes user input, now need to implement this in UI
    public void addBook(){
        String title;
        double price;
        String contents; //I use this variable to store the contents of the Book object
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter price of book: ");
        price = scan.nextDouble();
        System.out.println("Enter Title of book: ");
        title = scan.next();
        title += scan.nextLine(); // Using this and the other scan method in tandem lets you take a whole sentence as input
        Book b = new Book(title, price);
        books.add(b);
        
        try { // This whole setup allows me to write the book object to the file books.txt
            FileWriter myWriter = new FileWriter(myfi, true);  // This constructor allows me to append to the file so that the data in it doesn't get overwritten
            contents = b.toString(); //by turning the book object b into a string I can easily write it into the file
            myWriter.write(contents);
            myWriter.close();
        } 
        catch (IOException e) { // This is to catch certain errors that result from accessing files
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // If there is an extra empty line in the file the method will throw an error, will fix that later
    public void loadBooks(){ //Populates the arrayList with the data from Books.txt
        try {
            String tempstr;
            String[] arrOfStr ;
            Scanner scan = new Scanner(myfi);
            while(scan.hasNextLine()){
                tempstr = scan.nextLine();
                arrOfStr = tempstr.split("\\|", 6);
                double price;
                price = Double.parseDouble(arrOfStr[3]);
                String title;
                title = arrOfStr[1];
                Book fileBook = new Book(title, price);
                books.add(fileBook);
            }
            
        } 
        catch (IOException e) {
                System.out.println("An error occurred");
                e.printStackTrace();
        }
    }  
    
    public void displayBooks(){
        System.out.println(books);
    }
    
    //Here I am simply testing the methods imlplemented in this class 
    public static void main(String[] args) {
        editBook ed = new editBook();
        ed.loadBooks();
        ed.addBook();
        ed.displayBooks();
    }
}
