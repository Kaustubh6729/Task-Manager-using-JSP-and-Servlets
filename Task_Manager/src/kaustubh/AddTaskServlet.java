package kaustubh;

import java.io.IOException;
import java.io.PrintWriter;

//import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class AddTaskServlet
 */
@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddTaskServlet() {
        // TODO Auto-generated constructor stub
    }


    
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	String title = request.getParameter("title");
    	String desc = request.getParameter("desc");
    	int nod = Integer.parseInt(request.getParameter("no_of_days"));
    	HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("logUser");
    	String username = user.getName();
    	Boolean status = false;
    	
    	Task task = new Task(title,username,desc,nod,status);
    	
    	TaskFunctions tf = new TaskFunctions();
    	
    	if (tf.task_add(task)) {
     	   response.sendRedirect("welcome.jsp");
     	} else {
     		PrintWriter out = response.getWriter();
     		out.println("Cannot create the task");
     	    }

    	
    }
    

}
