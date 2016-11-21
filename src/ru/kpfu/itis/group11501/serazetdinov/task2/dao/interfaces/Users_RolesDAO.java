package ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces;

/**
 * Created by 1 on 03.11.2016.
 */
public interface Users_RolesDAO {
    void createRelation(long id, long common_user);
}
