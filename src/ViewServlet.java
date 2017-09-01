

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<a href='index.html'>Add New Book</a>");
		response.getWriter().println("<h1>Book List</h1>");
		
		List<Book> list = BookDAO.getAllBook();
		
		response.getWriter().println("<table border='1' width='100%'");
		response.getWriter().println("<tr><th>Id</th><th>Name</th><th>Author</th><th>Price</th><th>Type</th><th>Edit</th><th>Delete</th></tr>");
	
		for(Book book : list){
			response.getWriter().println("<tr><td>"+book.getID()+"</td><td>"+book.getName()+"</td><td>"+book.getAuthor()+"</td><td>"+book.getPrice()+"</td><td>"+book.getType()+"</td><td><a href='EditServlet?id="+book.getID()+"'>edit</a></td><td><a href='DeleteServlet?id="+book.getID()+"'>delete</a></td></tr>");
		}
		response.getWriter().println("</table>");
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
