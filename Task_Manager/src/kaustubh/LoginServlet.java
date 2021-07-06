package kaustubh;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }


    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	//Fetch data from login form
        
        String logemail = request.getParameter("email");
        String logpass = request.getParameter("password");
        UserDatabase db =  new UserDatabase();
        User user = db.login(logemail, logpass);
        //System.out.println(db);
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("logUser", user);
            response.sendRedirect("welcome.jsp");
        }else{
        	PrintWriter out = response.getWriter();
            out.println("user not found");
        }

    }

}
