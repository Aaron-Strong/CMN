package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession(false);//5Head
        Boolean isLogged = (httpSession != null && httpSession.getAttribute("role") == "patient");
        String loginURL = ((HttpServletRequest) servletRequest).getContextPath() + "/login";
        Boolean isLoginPage = ((HttpServletRequest) servletRequest).getRequestURI().endsWith("login.jsp");
        Boolean isLoginRequest = ((HttpServletRequest) servletRequest).getRequestURI().equals(loginURL);

        if(!isLogged)
        {
            servletRequest.getRequestDispatcher("/WEB-INF/login.jsp").forward(servletRequest,servletResponse);
        }
        if (isLogged && isLoginPage || isLogged && isLoginRequest) {
            ((HttpServletRequest) servletRequest).getRequestDispatcher("/WEB-INF/index.jsp").forward((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
        }
        else
        {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
