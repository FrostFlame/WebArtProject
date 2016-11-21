package ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations.CookieDAOImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.CookieDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.CookieService;

/**
 * Created by 1 on 11.11.2016.
 */
public class CookieServiceImpl implements CookieService {
    CookieDAO cookieDAO = new CookieDAOImpl();

    @Override
    public void createRelation(long id, String cookie) {
        cookieDAO.createRelation(id, cookie);
    }

    @Override
    public void deleteRelation(long id) {
        cookieDAO.deleteRelation(id);
    }

    @Override
    public String getCookieById(long id) {
        return cookieDAO.getCookieById(id);
    }
}
