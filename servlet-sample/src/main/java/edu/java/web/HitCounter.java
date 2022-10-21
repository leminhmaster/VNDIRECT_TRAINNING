package edu.java.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "counter",value = "/count")
public class HitCounter extends HttpServlet {
    private int hitCount;

    @Override
    public void init() throws ServletException {
        super.init();
        hitCount =0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        hitCount++;
        resp.setContentType("text/html");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<br>Hit count = "+hitCount);
        resp.getWriter().println("</html>");
    }
}
