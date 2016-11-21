package ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations.AdminDAOImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.AdminDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.AdminService;

import java.util.List;

/**
 * Created by 1 on 20.11.2016.
 */
public class AdminServiceImpl implements AdminService {
    AdminDAO adminDAO = new AdminDAOImpl();


    @Override
    public List<String> getTables() {
        return adminDAO.getTables();
    }

    @Override
    public List<String> getColumnsFromTable(String table) {
        return adminDAO.getColumnsFromTable(table);
    }

    @Override
    public List<Object> getObjectsFromTable(String table) {
        return adminDAO.getObjectsFromTable(table);
    }

    @Override
    public long getRoleId(long id) {
        return adminDAO.getRoleId(id);
    }
}
