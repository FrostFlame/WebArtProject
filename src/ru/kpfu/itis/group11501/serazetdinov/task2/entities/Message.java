package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by 1 on 02.11.2016.
 */
public class Message {
    private long id;
    private long from_user_id;
    private long to_user_id;
    private String text;
    private String date;
    private boolean status;
    private User from_user;
    private User to_user;

    public Message(long id, long from_user_id, long to_user_id, String text, Timestamp date, boolean status) {
        this.id = id;
        this.from_user_id = from_user_id;
        this.to_user_id = to_user_id;
        this.text = text;
        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        this.date = s.format(date);
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(long from_user_id) {
        this.from_user_id = from_user_id;
    }

    public long getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(long to_user_id) {
        this.to_user_id = to_user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getData() {
        return date;
    }

    public void setData(String data) {
        this.date = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
