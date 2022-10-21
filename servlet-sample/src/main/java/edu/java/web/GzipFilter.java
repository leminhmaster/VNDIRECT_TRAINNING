package edu.java.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(urlPatterns = {"/page"})
public class GzipFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
//        PrintWriter writer = servletResponse.getWriter();
//        writer.println("==================\n Filter intercepted! \n=====================");
//        writer.flush();
//        filterChain.doFilter(servletRequest,servletResponse);
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            String encoding = httpRequest.getHeader("Accept-Encoding");
            System.out.println(encoding);
            if (encoding != null && encoding.indexOf("gzip") > -1) {
                httpResponse.addHeader("Content-Encoding", "gzip");
                GZipServletResponseWrapper gZipResponse = new GZipServletResponseWrapper(httpResponse);
                filterChain.doFilter(servletRequest, gZipResponse);

                gZipResponse.close();
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
        //Filter.super.destroy();
        System.out.println("\n Destroy filter! \n");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig);
        System.out.println("\n Initialize filter \n");
    }
}
