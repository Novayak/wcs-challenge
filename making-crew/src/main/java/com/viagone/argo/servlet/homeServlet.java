package com.viagone.argo.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.viagone.argo.dao.ArgonautDAO;
import com.viagone.argo.model.Argonaut;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;

@WebServlet ("")
public class homeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ArgonautDAO argonautDAO;

    @Resource(name="jdbc/argo")
    DataSource datasource;
    
    @Override
    public void init() throws ServletException { 
        this.argonautDAO = new ArgonautDAO(this.datasource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

            try {                
                req.setAttribute("articles", this.argonautDAO.findAll());
            }
            catch (Exception e) {
                throw new ServletException(e);
            }    
            req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

            Argonaut newCrewman = new Argonaut();
            String fullname = req.getParameter("name");            
            try {
                newCrewman.setFullname(fullname);
                argonautDAO.saveCrewman(newCrewman);
            }
            catch (Exception e) {
                throw new ServletException(e);
            }
            req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
    }
}