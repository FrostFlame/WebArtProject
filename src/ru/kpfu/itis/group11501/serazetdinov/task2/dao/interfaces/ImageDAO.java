package ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.Image;

/**
 * Created by 1 on 06.11.2016.
 */
public interface ImageDAO {
    Image getImageById(long id);

    void createImage(String link);

    Image getImageByLink(String link);
}
