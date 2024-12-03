package assign01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Info")

public class ProfileServlet extends HttpServlet {
	
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		PrintWriter out=resp.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>INFO</title>");
//		out.println("</head>");
//		out.println("<body bgcolor=pink>");
//		out.println("<h3>First Name : Shweta</h3>");
//		 out.println("<h3>Last Name : Patil</h3>");
//		 out.println("<h3>Qualificaton : BTech </h3>");
//		 out.println("<h3>Birth Date : 09/10/2002</h3>");
//		 out.println("</body>");
//		 out.println("</html>");
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>INFO</title>");
		out.println("</head>");
		out.println("<body bgcolor=pink>");
		out.println("<h3>First Name : Shweta</h3>");
		 out.println("<h3>Last Name : Patil</h3>");
		 out.println("<h3>Qualificaton : BTech </h3>");
		 out.println("<h3>Birth Date : 09/10/2002</h3>");
		 out.println("</body>");
		 out.println("</html>");
	}
	
	

	

}
