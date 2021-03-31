/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

/**
 *
 * @author kasey
 */
public class Customer {
    int points;
    String username;
    String password;
    
    public Customer(String username, String password, int points){
        this.username = username;
        this.password = password;
        this.points = points;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public int getPoints(){
        return points;
    }
    
    public void setPoints(int points){
        this.points = points;
    }
    
    public String customerStatus(int p){
        if(p < 1000){
            return "Silver";
        }
        else{
            return "Gold";
        }
    }
    
}
