package ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations.ImageDAOImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.ImageDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.Image;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.ImageService;

/**
 * Created by 1 on 06.11.2016.
 */
public class ImageServiceImpl implements ImageService {
    private ImageDAO imageDao = new ImageDAOImpl();


    @Override
    public Image getImageById(long id) {
        return imageDao.getImageById(id);
    }

    @Override
    public void createImage(String link) {
        imageDao.createImage(link);
    }

    @Override
    public Image getImageByLink(String link) {
        return imageDao.getImageByLink(link);
    }
}
