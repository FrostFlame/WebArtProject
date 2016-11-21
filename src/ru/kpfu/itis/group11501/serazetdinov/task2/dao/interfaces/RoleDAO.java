package ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.Role;

/**
 * Created by 1 on 03.11.2016.
 */
public interface RoleDAO {
    Role getRoleByName(String common_user);
}
