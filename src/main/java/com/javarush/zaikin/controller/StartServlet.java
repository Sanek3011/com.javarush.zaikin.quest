package com.javarush.zaikin.controller;

import com.javarush.zaikin.model.Game;
import com.javarush.zaikin.model.LevelsDB;
import com.javarush.zaikin.service.GameService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
