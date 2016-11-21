package ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.BlacklistService;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations.*;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.*;

import java.util.List;

/**
 * Created by 1 on 06.11.2016.
 */
public class BlacklistServiceImpl implements BlacklistService {
    private BlacklistDAO blacklistDAO = new BlacklistDAOImpl();

    @Override
    public List<User> getUsersByUser(long id) {
        return blacklistDAO.getUsersByUser(id);
    }

    @Override
    public void deleteUser(long q, long user) {
        blacklistDAO.deleteUser(q, user);
    }
}
