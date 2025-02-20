package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ToDoDAOImpl;
import dao.ToDoDAOIntf;

public class MarkTaskCompletedServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int regId = Integer.parseInt(request.getParameter("regId"));
            int taskId = Integer.parseInt(request.getParameter("taskId"));
            
            ToDoDAOIntf dao = ToDoDAOImpl.getInstance();
            dao.updateTaskStatus(taskId, 3); // Assuming 3 represents "Completed"
            
            response.sendRedirect("viewTasks.jsp"); // Redirect back to the task list page
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error updating task status");
        }
    }
}
