package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

/**
 * Created by 1 on 02.11.2016.
 */
public class Notification {
    private long id;
    private long friend_id;
    private long like_id;
    private long news_comment_id;
    private long battle_comment_id;
    private long battle_id;
    private Friend friend;
    private Like like;
    private News_comment news_comment;
    private Battle_comment battle_comment;
    private Battle battle;

    public Notification(long id, long friend_id, long like_id, long news_comment_id, long battle_comment_id, long battle_id) {
        this.id = id;
        this.friend_id = friend_id;
        this.like_id = like_id;
        this.news_comment_id = news_comment_id;
        this.battle_comment_id = battle_comment_id;
        this.battle_id = battle_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(long friend_id) {
        this.friend_id = friend_id;
    }

    public long getLike_id() {
        return like_id;
    }

    public void setLike_id(long like_id) {
        this.like_id = like_id;
    }

    public long getNews_comment_id() {
        return news_comment_id;
    }

    public void setNews_comment_id(long news_comment_id) {
        this.news_comment_id = news_comment_id;
    }

    public long getBattle_comment_id() {
        return battle_comment_id;
    }

    public void setBattle_comment_id(long battle_comment_id) {
        this.battle_comment_id = battle_comment_id;
    }

    public long getBattle_id() {
        return battle_id;
    }

    public void setBattle_id(long battle_id) {
        this.battle_id = battle_id;
    }
}
