package com.tictactoe;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/logic"}, name="LogicServlet")
public class LogicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Field field = (Field)session.getAttribute("field");
        int index = getSelectedIndex(req);
        if (field.getWinner() != Sign.EMPTY){
            resp.sendRedirect("/start");
            return;
        }

        if (field.getField().get(index) != Sign.EMPTY){
            resp.sendRedirect("/index.jsp");
        }
        else {
            field.getField().put(index, Sign.CROSS);
            field.checkWin();
            if (field.getWinner() == Sign.CROSS){
                resp.sendRedirect("/index.jsp");
            }
            else {
                field.getField().put(field.getEmptyFieldIndex(), Sign.NOUGHT);
                field.checkWin();
                resp.sendRedirect("/index.jsp");
            }
        }
    }
    public int getSelectedIndex(HttpServletRequest request){
        String click = request.getParameter("click");
        boolean isNumeric = click.chars().allMatch(Character::isDigit);
        return isNumeric ? Integer.parseInt(click) : 0;
    }
}
