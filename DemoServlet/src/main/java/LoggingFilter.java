
import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LoggingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("Requête interceptée pour : " + httpRequest.getRequestURI());
        
        // Passer la requête au prochain filtre dans la chaîne, ou à la servlet si c'est le dernier filtre
        chain.doFilter(request, response);
        
        System.out.println("Requête terminée pour : " + httpRequest.getRequestURI());
    }

    public void destroy() {}
}
