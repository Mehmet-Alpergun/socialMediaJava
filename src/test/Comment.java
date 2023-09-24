/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author DELL
 */
public class Comment {
    private User sender;
    private User receiver;
    private String comment;
    
    public Comment(User sender, String comment){
        this.sender = sender;
        this.comment = comment;
    }
    public Comment(User sender, String comment, User receiver){
        this.sender = sender;
        this.comment = comment;
        this.receiver = receiver;
    }
    
    public void setComment(String comment){
        this.comment = comment;
        
    }
    public String getComment(){
        return this.comment;
    }
    public User getSender(){
        return this.sender;
    }
    public User getReceiver(){
        return this.receiver;
    }
    
}
