import java.sql.*;
import java.util.*;

public class BookDAO {
	public static Connection getConnection(){
		Connection connect = null;
		try{
			Class.forName("oraclbook.jdbc.driver.OracleDriver");
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		} catch(Exception e){
			e.printStackTrace();
		}
		return connect;
	}
	
	public static int save(Book book){
		int status = 0;
		try{
			Connection connect = BookDAO.getConnection();
			PreparedStatement ps = connect.prepareStatement("insert into book(name,author,price,type) values (?,?,?,?)");
			ps.setString(1, book.getName());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPrice());
			ps.setString(4, book.getType());
			
			status = ps.executeUpdate();
			connect.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
	public static int update(Book book){
		int status=0;
		try{
			Connection connect = BookDAO.getConnection();
			PreparedStatement ps = connect.prepareStatement("update book set name=?,author=?,price=?,type=? where id=?");
			ps.setString(1, book.getName());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPrice());
			ps.setString(4, book.getType());
			ps.setInt(5, book.getID());
			status=ps.executeUpdate();
			connect.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con = BookDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from book where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
	public static Book getBookById(int id){
		Book book = new Book();
		try{
			Connection connect = BookDAO.getConnection();
			PreparedStatement ps = connect.prepareStatement("select * from book where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				book.setID(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getString(4));
				book.setType(rs.getString(5));
			}
			connect.close();
		}catch(Exception ex){ex.printStackTrace();}
		return book;
	}
	
	public static List<Book> getAllBook(){
		List<Book> list=new ArrayList<Book>();
		try{
			Connection connect = BookDAO.getConnection();
			PreparedStatement ps = connect.prepareStatement("select * from book");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setID(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getString(4));
				book.setType(rs.getString(5));
				list.add(book);
			}
			connect.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
