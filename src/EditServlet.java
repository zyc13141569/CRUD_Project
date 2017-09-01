

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<h1>Update Book</h1>");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Book book = BookDAO.getBookById(id);
		
		response.getWriter().print("<form action='EditServlet2' method='post'>");
		response.getWriter().print("<table>");
		response.getWriter().print("<tr><td></td><td><input type='hidden' name='id' value='"+book.getID()+"'/></td></tr>");
		response.getWriter().print("<tr><td>Name:</td><td><input type='text' name='name' value='"+book.getName()+"'/></td></tr>");
		response.getWriter().print("<tr><td>Author:</td><td><input type='text' name='author' value='"+book.getAuthor()+"'/></td></tr>");
		response.getWriter().print("<tr><td>Price:</td><td><input type='double' name='price' value='"+book.getPrice()+"'/></td></tr>");
		response.getWriter().print("<tr><td>Type:</td><td>");
		response.getWriter().print("<select name='type' style='width:150px'>");
		response.getWriter().print("<option>A</option>");
		response.getWriter().print("<option>B</option>");
		response.getWriter().print("<option>C</option>");
		response.getWriter().print("<option>Other</option>");
		response.getWriter().print("</select>");
		response.getWriter().print("</td></tr>");
		response.getWriter().print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		response.getWriter().print("</table>");
		response.getWriter().print("</form>");
		
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
