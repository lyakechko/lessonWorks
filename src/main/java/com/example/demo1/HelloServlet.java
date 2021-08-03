package com.example.demo1;

import DAO.StudentDao;
import DBO.Student;
import util.StudentUtil;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String notFoundMessage;
    private String errorMessage;
    private StudentDao studentDao;
    private List<Student> students;

    public void init() {
        message = "Найден студент: ";
        notFoundMessage = "Студент не найден.";
        studentDao = new StudentDao();
        errorMessage = "Что-то пошло не так...";
        students = StudentUtil.generateStudent(5);

    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        try {
//            for (Student s : students) {
//                studentDao.save(s);
//            }
//        } catch (SQLException sqlException) {
//            System.out.println(sqlException.getMessage());
//        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        //request.setAttribute("myParam", "Hi");
        PrintWriter out = response.getWriter();
        //Random random = new Random();
        String id = request.getParameter("id");
        try {
            if (Objects.nonNull(id)) {
                Student student = studentDao.get(id);
                out = response.getWriter();
                out.println("<html><body>");
                if (Objects.nonNull(student))
                    out.println("<h1>" + student.toString() + "</h1>");
                else
                    out.println("<h1>" + notFoundMessage + "</h1>");
                out.println("</body></html>");
            } else {
                out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + errorMessage + "</h1>");
                out.println("</body></html>");
            }
        } catch (SQLException e) {
            out.println("<html><body>");
            out.println("<h1>" + errorMessage + "</h1>");
            out.println("<h1>" + "Тип ошибки: " + e.getMessage() + "\n " + errorMessage + "</h1>");
            out.println("</body></html>");
        }

//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
    }

    private List<String> getStringList(Random random) {
        return Stream.generate(random::nextInt).map(String::valueOf).limit(10).collect(Collectors.toList());
    }

    public void destroy() {
    }
}