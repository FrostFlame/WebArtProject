package ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;

import java.util.List;

/**
 * Created by 1 on 06.11.2016.
 */
public interface BlacklistService {
    public List<User> getUsersByUser(long id);

    void deleteUser(long q, long user);
}
