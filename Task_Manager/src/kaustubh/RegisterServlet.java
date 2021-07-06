package kaustubh;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }


    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	String name = request.getParameter("name");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	//make user object
    	User userModel = new User(name, email, password);

    	//create a database model
    	UserDatabase regUser = new UserDatabase();
    	if (regUser.saveUser(userModel)) {
    	   response.sendRedirect("index.jsp");
    	} else {
    	    String errorMessage = "User Available";
    	    HttpSession regSession = request.getSession();
    	    regSession.setAttribute("RegError", errorMessage);
    	    response.sendRedirect("index.jsp");
    	    }

    }
}
