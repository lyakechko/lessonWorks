package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    public static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");
    ;


}
