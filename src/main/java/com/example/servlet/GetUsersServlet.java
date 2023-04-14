package com.example.servlet;

import com.example.Warehouse;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {

    private static final String path = "/jsp/users.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Warehouse warehouse = Warehouse.getInstance();
        request.setAttribute("users", warehouse.getUsers());
        ServletContext servletContext = getServletContext();

        servletContext.getRequestDispatcher(path).forward(request, response);
    }
}
