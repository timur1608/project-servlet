package com.tictactoe;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(value="/start")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Field field = new Field();

        session.setAttribute("field", field);

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        //resp.sendRedirect("/index.jsp");
    }
}
