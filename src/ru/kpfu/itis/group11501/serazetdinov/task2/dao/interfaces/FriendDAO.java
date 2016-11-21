package ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;

import java.util.List;

/**
 * Created by 1 on 11.11.2016.
 */
public interface FriendDAO {
    int countFriendsByUserId(long id);

    List<User> getFriendsById(long id);

    void deleteFromFriends(long user_id, long friend_id);

    void addFriend(long current_user, long fr_id);

    String isFriend(long id, long current_user);
}
