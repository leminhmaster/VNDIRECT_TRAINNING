package edu.java.web;

import javax.net.ssl.SSLParameters;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/j_security_check", name = "login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("j_username");
        String password = req.getParameter("j_password");
        resp.getWriter().write(username+"|||"+password);
        try {
            req.login(username, password);
            //resp.getWriter().println("login successful");
            req.setAttribute("say","Hi Ha Noi!");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/hello.jsp");
            dispatcher.forward(req,resp);
        }catch (Exception e) {
            resp.getWriter().write("Sorry! Login failed. Please try again!!");
            e.printStackTrace(resp.getWriter());
        }

    }
}
