package ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations.FriendDAOImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.FriendDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.FriendService;

/**
 * Created by 1 on 20.11.2016.
 */
public class FriendServiceImpl implements FriendService {
    FriendDAO friendDAO = new FriendDAOImpl();

    @Override
    public void deleteFromFriends(long current_user, long friend_id) {
        friendDAO.deleteFromFriends(current_user, friend_id);
    }

    @Override
    public void addFriend(long current_user, long fr_id) {
        friendDAO.addFriend(current_user, fr_id);
    }

    @Override
    public String isFriend(long id, long current_user) {
        return friendDAO.isFriend(id, current_user);
    }

    @Override
    public int countFriendsById(long id) {
        return friendDAO.countFriendsByUserId(id);
    }
}
