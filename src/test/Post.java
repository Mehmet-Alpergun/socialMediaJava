/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Post {
    private String postContent;
    private Date time;
    private User uploader;
    private Image image;
    private Comment [] comments = new Comment[100];
    private int commentCount;
    private User [] commmender = new User [100];
    private int commenderCount;
    private Post[] saved = new Post[100];
    private int savedCount;
    private User[] likes = new User[1000];
    private int likeCount;
    
    
    
    public Post(String postContent, User uploader,Image image){
        this.postContent = postContent;
        this.time = new Date();
        this.uploader = uploader;
        this.image = image;
    }
    
    
    public void doComment(User sender, String comment){
        Comment cmt = new Comment(sender, comment);
        if( comments.length - 1 < commentCount){
            Comment temp [] = this.comments;
            this.comments = new Comment[ temp.length * 2];
            for(int i =0; i < temp.length;i++){
                this.comments[i] = temp[i];
            }
        }
        this.comments[this.commentCount] = cmt;
        commentCount++;
        addCommender(cmt.getSender());
        
    }
    public void addCommender(User sender){
        if( this.commmender.length - 1 < commenderCount){
            User temp[] = this.commmender;
            this.commmender = new User[temp.length * 2];
            for(int i = 0; i < temp.length; i++){
                this.commmender[i] = temp[i];
            }
       }
        this.commmender[this.commenderCount] = sender;
        this.commenderCount++;
        
    }
    public void save(Post savedPost){
        if( this.saved.length - 1 < this.savedCount){
            Post temp [] = this.saved;
            this.saved = new Post [temp.length * 2];
            for(int i =0; i < temp.length; i++){
                this.saved[i] = temp[i];
            }
        }
        this.saved[this.savedCount] = savedPost;
        this.savedCount++;
    }
    public void like(User user){
        this.uploader.addToLike(user);
        
    }
    public void showPost(){
      System.out.println(this.image.getImageName());
      System.out.println(this.image.getPixel());
      System.out.println(this.image.getTime());
      System.out.println(this.image.getUploader());
      
      System.out.println(this.postContent);
      System.out.println(this.likeCount);


  }
    public void showComments(){
       for(int i = 0; i< commentCount; i++){
         System.out.println(this.comments[i].getComment());
                 
     } 
      }
    
    
    public void uploadPost(){
        this.uploader.addToProfile(this);
    }
    public int getLikeCount(){
        return this.likeCount;
        
    }
    public Image getImage(){
        return this.image;
    }
    public User getUploader(){
        return this.uploader;
        
    }
    public Date getTime(){
        return this.time;
    }
    public String getPostContent(){
        return this.postContent;
    }
}
