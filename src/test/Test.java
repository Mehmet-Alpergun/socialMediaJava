/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date date = new Date();
        User user1 = new User("jason", "mckey", date, "whyNot@gmail.com", "California...");
        User user2 = new User("celine", "segel", date, "whyAmI@gmail.com", "los angeles...");

        user1.uploadPost("julyDump", "aSunnyDay");
        /*
        user2.addComment("You are such a beautiful girl", 0, user1);
        user2.likePost(0, user1);
        System.out.println(user1.getLikesCount());
        user1.getPost(0).showComments();
        */
        
        
        user2.addSaved(user1, 0);
        user2.showSaved(0);
    }

}
