package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.RoleDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.Role;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 1 on 03.11.2016.
 */
public class RoleDAOImpl implements RoleDAO {
    Connection conn = ConnectionSingleton.getConnection();

    @Override
    public Role getRoleByName(String role) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from roles where role like ?");
            st.setString(1, "%" + role + "%");
            ResultSet rs = st.executeQuery();
            Role rolle = null;
            while (rs.next()){
                rolle = new Role(rs.getLong("Id"), rs.getString("role"));
            }
            return rolle;
        } catch (SQLException e) {
            return null;
        }
    }
}
