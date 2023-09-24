/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Message {
    private User sender;
    private User receiver;
    private Date date;
    private String content;
    
    public Message (User sender, String content, User receiver){
        this.sender = sender;
        this.content = content;
        this.receiver = receiver;
        this.date = date;
    }
    /*
        public void writeMessageToConsole(){
        System.out.println("sender:" +this.sender.getEmail());
        System.out.println("Receiver"+this.receiver.getEmail());
        System.out.println("Message Content:"+this.content);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String mDate = sdf.format(this.date);
        System.out.println("Message date:"+mDate);
    }
*/
    public Date getDate(){
        return this.date;
    }
    public String getContent(){
        return this.content;
    }
    
    public User getUserReceiver(){
        return this.receiver;
    }
    public User getUserSender(){
        return this.sender;
    }
    
    
}
