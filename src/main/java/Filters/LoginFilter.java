package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession(false);//5Head

        Boolean isLogged = (httpSession != null && httpSession.getAttribute("role") == "patient");
        String loginURL = ((HttpServletRequest) servletRequest).getContextPath() + "/login";
        Boolean isLoginPage = ((HttpServletRequest) servletRequest).getRequestURI().endsWith("login.jsp");
        Boolean isLoginRequest = ((HttpServletRequest) servletRequest).getRequestURI().equals(loginURL);
        System.out.println( "[Login Filter] : Request URL : "+((HttpServletRequest) servletRequest).getRequestURL());

if(((HttpServletRequest)servletRequest).getRequestURI().matches(".*(css|jpg|png|gif|js|map)"))
{
    System.out.println("[Login Filter] : Requested URI matches asset Regex");
filterChain.doFilter(servletRequest,servletResponse);
return;
}

         if(!isLogged)
        {
            System.out.println("[Login Filter] : Not Logged request forwarded to login.jsp");
            servletRequest.getRequestDispatcher("/WEB-INF/login.jsp").forward(servletRequest,servletResponse);

          // don't ((HttpServletResponse)servletResponse).sendRedirect("/login"); can't create a session if i lose the data

        }

      if (isLogged && isLoginPage || isLogged && isLoginRequest) {
    System.out.println("[Login Filter] :  Connected with id :"+((HttpServletRequest) servletRequest).getSession().getId());
           ((HttpServletRequest) servletRequest).getRequestDispatcher("/WEB-INF/index.jsp").forward((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
           // ((HttpServletResponse) servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath()+"/");

        }
        else
        {
            filterChain.doFilter(servletRequest,servletResponse);
        }


    }
}
