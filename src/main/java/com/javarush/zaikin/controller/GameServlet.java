package com.javarush.zaikin.controller;

import com.javarush.zaikin.service.GameService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/gameServlet")
public class GameServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameService service = (GameService) session.getAttribute("player");
        String answer = req.getParameter("answer");
        if (!service.getCorrectAnswer().equals(URLDecoder.decode(answer))) {
            service.decreaseHealth();
        }
        if (service.checkLose() || service.checkWin()) {
            resp.sendRedirect("/views/loser.jsp");
            return;
        }
        service.levelUp();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/firstLevel.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameService service = (GameService) session.getAttribute("player");
        service.drinkEnergetic();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/firstLevel.jsp");
        requestDispatcher.forward(req, resp);

    }
}
