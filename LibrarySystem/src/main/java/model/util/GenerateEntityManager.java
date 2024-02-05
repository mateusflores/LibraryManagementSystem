package model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenerateEntityManager {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("librarymanagementsystem");

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
}
