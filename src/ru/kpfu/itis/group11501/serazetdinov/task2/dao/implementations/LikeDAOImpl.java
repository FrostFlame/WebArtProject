package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.LikeDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 1 on 06.11.2016.
 */
public class LikeDAOImpl implements LikeDAO {
    Connection conn = ConnectionSingleton.getConnection();

    @Override
    public int getAmountOfLikesOfByImageId(long image_id) {
        try {
            PreparedStatement st = conn.prepareStatement("select count(*) from Likes where images_id = ?");
            st.setLong(1, image_id);
            ResultSet rs = st.executeQuery();
            int like = 0;
            if (rs.next()){
                like = rs.getInt("count(*)");
            }
            return like;
        } catch (SQLException e) {
            return 0;
        }
    }
}
