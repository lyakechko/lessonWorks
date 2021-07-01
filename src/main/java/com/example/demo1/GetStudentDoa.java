package com.example.demo1;

import DBO.Student;
import util.HibernateUtil;
import util.StudentUtil;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@WebServlet(name = "getStudents", value = "/getStudent-servlet")
public class GetStudentDoa extends HelloServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setAttribute("myParam", "Hi");
        Random random = new Random();
        //request.setAttribute("paramList", stringList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("example.jsp");
        requestDispatcher.forward(request, response);
    }
}
