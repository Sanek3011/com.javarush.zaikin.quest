package com.javarush.zaikin.controller;


import com.javarush.zaikin.model.*;
import com.javarush.zaikin.service.GameService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/levelFirst")
public class StartServlet extends HttpServlet {
    private LevelsDB db;

    @Override
    public void init() throws ServletException {
        db = LevelsDB.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LOG:: стартовый сервлет запустился");
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        GameService service = new GameService(new Game(name, session, db));
        session.setAttribute("player", service);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/firstLevel.jsp");
        requestDispatcher.forward(req, resp);

    }
}
