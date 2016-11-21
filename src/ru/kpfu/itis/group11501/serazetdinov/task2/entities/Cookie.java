package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

/**
 * Created by 1 on 11.11.2016.
 */
public class Cookie {
    long user_id;
    String cookie;
    User user;

    public Cookie(long user_id, String cookie) {
        this.user_id = user_id;
        this.cookie = cookie;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
