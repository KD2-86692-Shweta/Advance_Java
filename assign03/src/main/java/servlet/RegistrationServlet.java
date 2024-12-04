package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.UserDao;
import daos.UserDaoImpl;
import entities.User;

@WebServlet("/newuserr")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doProcess(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname=req.getParameter("fName");
		String lname=req.getParameter("lName");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		Date d=Date.valueOf(req.getParameter("dob"));
		
		
		//int status=Integer.parseInt("0");
		String role=req.getParameter("role");
		User u=new User(fname,lname,email,pass,d,0,role);
		
		try(UserDao userdao=new UserDaoImpl()){
			int cnt=userdao.save(u);
			
			if(fname !=null && email !=null && pass !=null) {
				
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Register</title>");
			out.println("</head>");
			
			ServletContext app1=this.getServletContext();
			String appcolor = app1.getInitParameter("app.color");
			
			
			out.printf("<body bgcolor='%s'>",appcolor);
			out.println("<h2>User Register Successfully</h2>");
			out.println("<p><a href='index.html'>Register  Again</a></p>");
			out.println("</body>");
			out.println("</html>");
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Register</title>");
				out.println("</head>");
				ServletContext app1=this.getServletContext();
				String appcolor = app1.getInitParameter("app.color");
				
				
				out.printf("<body bgcolor='%s'>",appcolor);
				out.println("<h2>User Register Failed</h2>");
				out.println("<p><a href='index.html'>Register  Again</a></p>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException(e);
			
		}
	} 
	
	

}
