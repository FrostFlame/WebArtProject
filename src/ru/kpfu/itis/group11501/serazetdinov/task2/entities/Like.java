package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

/**
 * Created by 1 on 02.11.2016.
 */
public class Like {
    private long id;
    private long user_id;
    private long image_id;
    private User user;
    private Image image;

    public Like(long id, long user_id, long image_id) {
        this.id = id;
        this.user_id = user_id;
        this.image_id = image_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }
}
