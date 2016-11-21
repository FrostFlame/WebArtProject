package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.Users_RolesDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by 1 on 03.11.2016.
 */
public class Users_RolesDAOImpl implements Users_RolesDAO {
    Connection conn = ConnectionSingleton.getConnection();

    @Override
    public void createRelation(long user_id, long role_id) {
        try {
            PreparedStatement st = conn.prepareStatement("insert into users_roles(user_id, role_id)values(?, ?)");
            st.setLong(1, user_id);
            st.setLong(2, role_id);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
