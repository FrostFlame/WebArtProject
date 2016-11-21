package ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces;

import java.util.List;

/**
 * Created by 1 on 20.11.2016.
 */
public interface AdminDAO {
    List<String> getTables();

    List<String> getColumnsFromTable(String table);

    List<Object> getObjectsFromTable(String table);

    long getRoleId(long id);
}
