package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import entities.Candidate;

@WebServlet("/newcand")
public class candservlet extends HttpServlet{

	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("cname");
		String party = req.getParameter("party");
	//	int votes = Integer.parseInt(req.getParameter("votes"));
		
		Candidate d= new Candidate(name,party,0);
		try(CandidateDao candeo = new CandidateDaoImpl()){
			int data = candeo.save(d);
			
			if(name != null && party !=null) {
				resp.setContentType("text/html");
				PrintWriter out =resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Candidate Data</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2> Candidate Added Successfully </h2>");
				out.println("</body>");
				out.println("</html>");
				
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out =resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Candidate Data</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2> Candidate Added Failed </h2>");
				out.println("</body>");
				out.println("</html>");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("cname");
		String party = req.getParameter("party");
		int votes = Integer.parseInt(req.getParameter("votes"));
		
		Candidate d= new Candidate(name,party,votes);
		try(CandidateDao candeo = new CandidateDaoImpl()){
			int data = candeo.save(d);
			
			if(name != null && party !=null) {
				resp.setContentType("text/html");
				PrintWriter out =resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Candidate Data</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2> Candidate Added Successfully </h2>");
				out.println("</body>");
				out.println("</html>");
				
				resp.sendRedirect("result");
				
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out =resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Candidate Data</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2> Candidate Added Failed </h2>");
				out.println("</body>");
				out.println("</html>");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	
}
