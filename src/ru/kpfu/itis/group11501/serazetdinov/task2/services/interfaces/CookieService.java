package ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces;

/**
 * Created by 1 on 11.11.2016.
 */
public interface CookieService {
    public void createRelation(long id, String cookie);

    public void deleteRelation(long id);

    public String getCookieById(long id);
}
