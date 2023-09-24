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
public class User {

    private String name;
    private String surname;
    private Date birthday;
    private String email;
    private String address;
    private User[] followers;
    private User[] followed;
    private int followersCount;
    private int followedCount;
    private Post[] posts = new Post[100];
    private int postCount;
    private Comment[] myComments = new Comment[100];
    private int myCommentCout;
    private Message[] outbox = new Message[0];
    private int outboxCount;
    private Message[] inbox = new Message[0];
    private int inboxCount;
    private Post[] mySaved = new Post[100];
    private int mySavedCount;
    private User[] likes = new User[100];
    private int likesCount;
    private Post[] myLikes = new Post[100];
    private int myLikesCount;

    public User(String name, String surname, Date birthday, String email, String address) {

        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.followers = new User[100];
        this.followed = new User[100];
        this.inbox = new Message[10];
        this.outbox = new Message[10];

    }

    public void addFollowers(User user) {
        if (this.followers.length - 1 < this.followersCount) {
            User temp[] = this.followers;
            this.followers = new User[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                this.followers[i] = temp[i];
            }
        }
        this.followers[this.followersCount] = user;
        this.followersCount++;

    }

    public void follow(User user) {
        if (this.followed.length - 1 < this.followedCount) {
            User temp[] = this.followed;
            this.followed = new User[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                this.followed[i] = temp[i];
            }
        }
        this.followed[this.followedCount] = user;
        this.followedCount++;
        user.addFollowers(user);

    }

    public void addToProfile(Post p) {
        if (this.posts.length - 1 < this.postCount) {
            Post temp[] = this.posts;
            this.posts = new Post[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                this.posts[i] = temp[i];
            }
        }
        this.posts[this.postCount] = p;
        this.postCount++;

    }

    public void uploadPost(String postContent, String imageName) {
        Image image = new Image(this, imageName);
        Post post = new Post(postContent, this, image);
        post.uploadPost();
    }

    public void addMyComments(String comment, User user) {
        Comment c = new Comment(user, comment);
        if (this.myComments.length - 1 < this.myCommentCout) {
            Comment temp[] = this.myComments;
            this.myComments = new Comment[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                this.myComments[i] = temp[i];
            }
        }
        this.myComments[this.myCommentCout] = c;
        this.myCommentCout++;
    }

    public void addComment(String comment, int i, User u) {
        u.getPost(i).doComment(this, comment);
        addMyComments(comment, this);
    }
    public void showMyComment(int i){
        System.out.println(this.myComments[i].getComment());
        
    }
    public void showAllComments(){
        int i = 0;
        while(i < this.myCommentCout){
            System.out.println(this.myComments[i].getComment());
            i++;
        }
        
    }

    public void sendMessage(User receiver, String content) {
        Message message = new Message(this, content, receiver);
        if (this.outbox.length - 1 < this.outboxCount) {
            Message temp[] = this.outbox;
            this.outbox = new Message[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                this.outbox[i] = temp[i];
            }
        }
        this.outbox[this.outboxCount] = message;
        this.outboxCount++;

    }

    public void receiverMessage(Message message) {
        if (this.inbox.length - 1 < this.inboxCount) {
            Message temp[] = this.inbox;
            this.inbox = new Message[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                this.inbox[i] = temp[i];
            }
        }
        this.inbox[this.inboxCount] = message;
        this.inboxCount++;

    }
/*
    public void showFromInbox(int index) {
        this.inbox[index].writeMessageToConsole();
    }

    public void showFromOutbox(int index) {
        this.outbox[index].writeMessageToConsole();
    }
*/

    public void addSaved(User user, int i) {
        if (this.mySaved.length - 1 < this.mySavedCount) {
            Post temp[] = this.mySaved;
            this.mySaved = new Post[temp.length * 2];
            for (int j = 0; j < temp.length; j++) {
                this.mySaved[j] = temp[j];
            }
        }
        this.mySaved[this.mySavedCount] = user.getPost(i);
        this.mySavedCount++;

    }
    public void showSavedPost(int i){
        this.mySaved[i].showPost();
    }

    public void addToLike(User user) {
        if (this.likes.length - 1 < this.likesCount) {
            User temp[] = this.likes;
            this.likes = new User[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                this.likes[i] = temp[i];
            }
        }
        this.likes[this.likesCount] = user;
        this.likesCount++;

    }

    public void myLikes(User user, int j) {
        if (this.myLikes.length - 1 < this.myLikesCount) {
            Post temp[] = this.myLikes;
            this.myLikes = new Post[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                this.myLikes[i] = temp[i];
            }
        }
        this.myLikes[this.myLikesCount] = user.getPost(j);
        this.myLikesCount++;

    }

    public void likePost(int i, User user) {
        user.getPost(i).like(this);
        myLikes(user, i);

    }
    public void showlikePost(int i){
        System.out.println(myLikes[i].getPostContent());
    }
    public void showSaved(int i) {
        this.mySaved[i].showPost();
    }
    public int getLikesCount(){
        return this.likesCount;
    }
    /*
    public int getSavedPost(){
        return this.getSavedPost();
    }
    public int getSavedCount() {
        return this.getSavedCount();
    }
    */

    public int getMyLikesCount() {
        return this.myLikesCount;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostCount() {
        return this.postCount;
    }

    public Post getPost(int i) {
        return this.posts[i];
    }

    public String getAddress() {
        return this.address;
    }

    public String getEmail() {
        return this.email;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

}
