package ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;

/**
 * Created by 1 on 20.11.2016.
 */
public interface FriendService {
    void deleteFromFriends(long current_user, long friend_id);

    void addFriend(long current_user, long fr_id);

    String isFriend(long id, long current_user);

    int countFriendsById(long id);
}
