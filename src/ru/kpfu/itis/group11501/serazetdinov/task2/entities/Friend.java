package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

/**
 * Created by 1 on 02.11.2016.
 */
public class Friend {
    private long id;
    private long user_id;
    private long follower_id;
    private boolean status;
    private User user;
    private User follower;

    public Friend(long id, long user_id, long follower_id, boolean is_friend) {
        this.id = id;
        this.user_id = user_id;
        this.follower_id = follower_id;
        this.status = is_friend;
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

    public long getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(long follower_id) {
        this.follower_id = follower_id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean is_friend) {
        this.status = is_friend;
    }
}
