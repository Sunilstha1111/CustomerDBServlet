package CustomerDBServlet;
import java.sql.*;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerDBServlet
 */
@WebServlet("/CustomerDBServlet")
public class CustomerDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	
		 Connection connect = null;
	     Statement statement = null;
	     PreparedStatement preparedStatement = null;
	     ResultSet resultSet = null;
	     String lastname;
	     HttpSession session = request.getSession();
	     String nextURL = "/CustomerDB.jsp";
		
	  try{
			
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 connect = DriverManager.getConnection("jdbc:mysql://localhost/customers?user=root&password=password");
			 System.out.println("In the servlet");	 
			
	    lastname = request.getParameter("LastName");
		System.out.println(lastname);
		
		preparedStatement = connect.prepareStatement("select * from customers.Customers where LastName = ?");
	    preparedStatement.setString(1, lastname);
	    	
	    resultSet = preparedStatement.executeQuery();
	    
	    int count = 0;
	    Customer  c = new Customer();
	    int cust_ID = 0;
	    String cust_Fullname = null; 
	    String cust_Title = null;
	    String cust_Firstname = null;
	    String cust_Lastname = null;
	    String cust_StreetAddress = null;
	    String cust_State = null;
	    String cust_City = null;
	    String cust_ZipCode = null;
	    String cust_EmailAddress = null;
	    String cust_Position = null;
	    String cust_CompanyID = null;
	    
	    while(resultSet.next())
	  		
		{
	    	
	 cust_ID = Integer.parseInt(resultSet.getString("CustomerID"));
	 cust_Fullname = resultSet.getString("FullName");
	 cust_Title = resultSet.getString("Title");
	 cust_Firstname = resultSet.getString("FirstName");
	 cust_StreetAddress =resultSet.getString("StreetAddress");
	 cust_City = resultSet.getString("City");
	 cust_State = resultSet.getString("State");
	 cust_ZipCode = resultSet.getString("ZipCode");
	 cust_EmailAddress = resultSet.getString("EmailAddress");
	 cust_Position = resultSet.getString("Position");
	 cust_CompanyID = resultSet.getString("CompanyID");
	 
	 
	 
	 
	 
	
/*	c.setCustomerID(cust_Id);
	c.setFullName(cust_Fullname);
	c.setTitle(cust_Title);*/
	
	/*System.out.println(++count);
    System.out.println(cust_Id);
    System.out.println(cust_Fullname);*/
	
		}
	 
	session.setAttribute("message", cust_ID);
	session.setAttribute("message1", cust_Fullname);
	session.setAttribute("message2", cust_Title);
	session.setAttribute("message3", cust_Firstname);
	session.setAttribute("message4", cust_Lastname);
	session.setAttribute("message5", cust_StreetAddress);
	session.setAttribute("message6", cust_City);
	session.setAttribute("message7", cust_State);
	session.setAttribute("message8", cust_ZipCode);
	session.setAttribute("message9", cust_EmailAddress);
	session.setAttribute("message10", cust_Position);
	session.setAttribute("message11", cust_CompanyID);
	
	
	
	
	
//	Customer c = session.getAttribute("session_customer");

	
		
    
	    
	  }
	  
	  
	  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  finally
	  {
			
			
			try
			{
				getServletContext().getRequestDispatcher(nextURL).forward(request, response);
				resultSet.close();
				preparedStatement.close();
				connect.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
            }
	  
			catch(ServletException e)
			{
				e.printStackTrace();
            }
	 
			
		}
	  
	}
	
	
}
		
				
	

	    
	    
			
	 /*   String nextURL = "/CustomerDB.jsp";
	    resultSet.next();   
		request.setAttribute("CustomerID",request.getParameter("CustomerID"));
		System.out.println(request.getParameter("CustomerID"));
		session.setAttribute("FullName", request.getParameter("FullName"));
		/*request.setAttribute("Title"stNa,request.getParameter("Title"));
		request.setAttribute("Firme",request.getParameter("FirstName"));
		request.setAttribute("LastName",request.getParameter("LastName"));
		request.setAttribute("StreetAddress",request.getParameter("StreetAddress"));
		request.setAttribute("City", request.getParameter("City"));
		request.setAttribute("State", request.getParameter("State"));
		request.setAttribute("ZipCode", request.getParameter("ZipCode"));
		request.setAttribute("EmailAddress", request.getParameter("EmailAddress"));
		request.setAttribute("Position", request.getParameter("Position"));
		request.setAttribute("CompanyID", request.getParameter("CompanyID"));
	    
	
	
	*/	
        
           
      
		

