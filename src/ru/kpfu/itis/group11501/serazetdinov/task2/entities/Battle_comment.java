package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by 1 on 02.11.2016.
 */
public class Battle_comment {
    private long id;
    private long user_id;
    private long battle_id;
    private String text;
    private String date;
    private User user;
    private Battle battle;

    public Battle_comment(long id, long user_id, long battle_id, String text, Timestamp date) {
        this.id = id;
        this.user_id = user_id;
        this.battle_id = battle_id;
        this.text = text;
        SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        String d = s.format(date);
        this.date = d;
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

    public long getBattle_id() {
        return battle_id;
    }

    public void setBattle_id(long battle_id) {
        this.battle_id = battle_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
