import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebFilter(urlPatterns = {"/index.jsp"})
public class GzipFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        Writer writer = servletResponse.getWriter();
//        writer.write("===========\n Filter intercepted! \n=================");
//        writer.flush();
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String encoding = httpRequest.getHeader("Accept-Encoding");
        if (true ){
            httpResponse.addHeader("Content-Encoding","gzip");
            GZipServletResponseWrapper gzip = new GZipServletResponseWrapper(httpResponse);
            filterChain.doFilter(servletRequest,gzip);
            gzip.flushBuffer();
//            writer.write("11111");

        }else{
            filterChain.doFilter(servletRequest,servletResponse);
//            writer.write("22222");

        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy filter");
    }
}
