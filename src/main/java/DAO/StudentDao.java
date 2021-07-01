package DAO;

import DBO.Student;
import util.HibernateUtil;
import util.StudentUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class StudentDao implements IDao<Student> {

    @PersistenceContext(unitName = "hibernate")
    private EntityManager entityManager = HibernateUtil.entityManagerFactory.createEntityManager();

    @Override
    public void save(Student student) throws SQLException {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Student get(Serializable id) throws SQLException {
        Student student = entityManager.find(Student.class, id);
        entityManager.close();
        return student;
    }

    @Override
    public void delete(Student student) throws SQLException {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Student update(Student student) throws SQLException {
        entityManager.getTransaction().begin();
        Student student1 = entityManager.merge(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        return student1;
    }
}
