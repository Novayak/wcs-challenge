package com.viagone.argo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.viagone.argo.Exception.ArgoException;
import com.viagone.argo.dao.ArgonautDAO;
import com.viagone.argo.model.Argonaut;

@WebServlet ("")
public class homeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(homeServlet.class.getName()); 
    
    private ArgonautDAO argonautDAO;

    @Resource(name="jdbc/argo")
    DataSource datasource;
    
    @Override
    public void init() throws ServletException { 
        try {
            if (datasource == null) {
                Context initCtx = new InitialContext();
                Context envCtx = (Context) initCtx.lookup("java:comp/env");
                this.datasource = (DataSource) envCtx.lookup("jdbc/argo");
            }
        }
        catch (NamingException ne) {
            throw new ServletException(ne);
        }
        this.argonautDAO = new ArgonautDAO(this.datasource);
        LOGGER.info(datasource.toString());
        
    }
    
    /**
     * Populate the list of crew members stored in database
     * @param req
     */
    private void populateCrewMember(HttpServletRequest req) {
        try {                
            req.setAttribute("crew", this.argonautDAO.findAll());                
        }
        catch (SQLException sqle) {
            LOGGER.warning(sqle.getLocalizedMessage());
        } catch (ArgoException ae) {
            LOGGER.warning(ae.getLocalizedMessage());
        }   
    }
        
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
            
            populateCrewMember(req); 
            req.getRequestDispatcher("/WEB-INF/JSP/home.jsp").forward(req, resp);
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
            catch (ArgoException ae) {
                req.setAttribute("errorMessage", ae.getMessage());
            }
            catch (SQLException sqle) {
                LOGGER.warning(sqle.getLocalizedMessage());
            }
            if (newCrewman.getId() != null) {
                req.setAttribute("successMessage", "Welcome on board " +fullname);                
            }
            populateCrewMember(req);
            req.getRequestDispatcher("/WEB-INF/JSP/home.jsp").forward(req, resp);
    }
}