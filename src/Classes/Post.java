package Classes;

/**
 * Created by 1 on 28.10.2016.
 */
public class Post {
    String title;
    int likes;
    String src;
    java.sql.Date date;

    public Post(String title, int likes, String src, java.sql.Date date){
        this.title = title;
        this.likes = likes;
        this.src = src;
        this.date = date;
    }
}
