package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import daos.UserDao;
import daos.UserDaoImpl;
import entities.User;

@WebServlet("/vote")
public class VoterServlet extends HttpServlet{

	private static final User UserDaoImpl = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);

	}
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candId= req.getParameter("candidate");
		
		int id=Integer.parseInt(candId);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		ServletContext app1=this.getServletContext();
		String appcolor = app1.getInitParameter("app.color");
		
		
		out.printf("<body bgcolor='%s'>",appcolor);
		
		// get app title from ctx param and display it
				ServletContext app = this.getServletContext();
				String appTitle = app.getInitParameter("app.title");
				out.printf("<h1>%s</h1>", appTitle);
		
		
		Cookie[] arr = req.getCookies();
		String userName = "", role = "";
		if(arr != null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname"))
					userName = c.getValue();
				if(c.getName().equals("role"))
					role = c.getValue();
			}
		}
		out.printf("Hello, %s (%s)<hr/>\n", userName, role);
		out.println("<h2>Voting Status</h2>");

		
		
//		try(CandidateDao candDao = new CandidateDaoImpl()) {
//			int count = candDao.incrVote(id);
//			if(count == 1)
//				out.println("<h4>You have successfully casted your vote.</h4>");
//			else
//				out.println("<h4>Your voting failed.</h4>");
//		}
		
	//	HttpSession session = req.getSession();
		HttpSession session = req.getSession(false);
		if(session == null) {
			resp.sendError(440);
			return;
		}
		User user=(User)session.getAttribute("curUser");
		
		if(user.getStatus() == 0) {
			try(CandidateDao candao=new CandidateDaoImpl()){
				int cout = candao.incrVote(id);
				
				if(cout == 1) {
					out.print("<h2> You have successfully caste vote</h2>");
					
					user.setStatus(1);
					out.print("<h2> You have successfully caste vote</h2>");
					
					try(UserDao userdao = new UserDaoImpl()){
						cout = userdao.update(user);
						
						if(cout == 1) {
							out.print("<h2>You are marked as voted.</h2>");
						}
						else {
							out.print("<h2>Voting Failed</h2>");
						}
					}catch (Exception e) {
						e.printStackTrace();
						throw new ServletException(e);
					}
					
				}
			}catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else {
			out.println("<h4>You have already voted.</h4>");
		}
		
		
		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
