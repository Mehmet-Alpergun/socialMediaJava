/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author DELL
 */
public class Image {
    private String time;
    private User uploader;
    private int pixel;
    private String imageName;
    
    
    public Image(User uploader, String imageName){
        this.uploader = uploader;
        this.imageName = imageName;
        Random r = new Random();
        this.pixel = r.nextInt(100);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        this.time = sdf.format(date);
    }
    public String getImageName(){
        return this.imageName;
    }
    public int getPixel(){
        return this.pixel;
    }
    public User getUploader(){
        return this.uploader;
    }
    public String getTime(){
        return this.time;
    }
    
   
}
