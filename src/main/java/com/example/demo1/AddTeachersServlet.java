package com.example.demo1;

import DBO.Student;
import DBO.Teacher;
import util.HibernateUtil;
import util.StudentUtil;
import util.TeachersUtil;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "teacherServlet", value = "/teacher-servlet")
public class AddTeachersServlet extends HttpServlet {
    private List<Teacher> teacherList;

    public void init() {

        EntityManager entityManager = HibernateUtil.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Teacher> teacherList = TeachersUtil.generateTeachers(10);
        for (Teacher teacher : teacherList) {
            System.out.println(teacher.toString());
            entityManager.persist(teacher);
        }
        entityManager.getTransaction().commit();
        teacherList = entityManager.createQuery("from Teacher").getResultList();
        entityManager.close();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (Teacher teacher : teacherList) {
            out.println("<h2>" + teacher.getId() + " " + teacher.getName() + " " + teacher.getReview() + "</h2>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
