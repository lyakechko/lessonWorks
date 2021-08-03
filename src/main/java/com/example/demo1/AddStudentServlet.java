package com.example.demo1;

import DBO.Student;
import util.HibernateUtil;
import util.StudentUtil;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "studentServlet", value = "/student-servlet")
public class AddStudentServlet extends HttpServlet {
    private int id;
    private int name;
    private String mark;
    private List<Student> studentList;

    public void init() {

        EntityManager entityManager = HibernateUtil.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Student> listStudent = StudentUtil.generateStudent(10);
        for (Student student : listStudent) {
            System.out.println(student.toString());
            entityManager.persist(student);
        }
        entityManager.getTransaction().commit();
        studentList = entityManager.createQuery("from Student").getResultList();
        entityManager.close();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (Student student : studentList) {
            out.println("<h2>" + student.getId() + " " + student.getName() + " " + student.getMark() + "</h2>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}