package kaustubh;

import java.io.IOException;
import java.io.PrintWriter;

//import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ChangeStatusServlet
 */
@WebServlet("/ChangeStatusServlet")
public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ChangeStatusServlet() {
        // TODO Auto-generated constructor stub
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	int id = Integer.parseInt(request.getParameter("id"));
    	TaskFunctions tf = new TaskFunctions();
    	if(tf.ChangeStatusTask(id))
    	{
    		response.sendRedirect("ViewTask.jsp");
    	}
    	else
    	{
     		PrintWriter out = response.getWriter();
     		out.println("Cannot delete the task");
    	}

    	
    }

}
