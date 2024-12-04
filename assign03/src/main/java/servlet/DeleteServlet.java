package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CandidateDao;
import daos.CandidateDaoImpl;

@WebServlet("/delcand")
public class DeleteServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doProcess(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doProcess(req,resp);

		 
	}
	
     protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candId = req.getParameter("id");
		int id= Integer.parseInt(candId);
		
		
		
		try(CandidateDao canddao = new CandidateDaoImpl()){
			
			int count = canddao.deleteById(id);
			String message  ="Candidate Deleted : "+count;
			req.setAttribute("msg", message);
				
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("result");
		rd.forward(req, resp);
	}
	
	
	
}
