package com.example;

import java.io.IOException;
import jakarta.servlet.ServletException; // Change here
import jakarta.servlet.annotation.WebServlet; // Change here
import jakarta.servlet.http.HttpServlet; // Change here
import jakarta.servlet.http.HttpServletRequest; // Change here
import jakarta.servlet.http.HttpServletResponse; // Change here

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("greeting", "Hello, " + name + "!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
