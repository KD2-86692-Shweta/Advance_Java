package assign01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/marks")
public class ResultServlet extends HttpServlet {

	ArrayList<Marks> result;
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
		
		result = new ArrayList<>();
		result.add(new Marks("Java Programming",80.80));
		result.add(new Marks("Database Technologies",90.89));
		result.add(new Marks("Web Programming ",89.98));
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		

		PrintWriter out=resp.getWriter();
		for(Marks m: result) {
			
			out.println("<tr>");
			
			out.printf("<td>%s</td>",m.getSubject());
			out.printf("<td> %.2f</td>\r\n",m.getMarks());
			out.printf("</tr>");
		}
	}
	

 
 
}
