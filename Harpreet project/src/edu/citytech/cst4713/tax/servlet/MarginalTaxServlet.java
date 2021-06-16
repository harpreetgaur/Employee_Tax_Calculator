package edu.citytech.cst4713.tax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.citytech.cst4713.tax.service.MarginalTaxService;
import edu.citytech.sp2020.marginal.tax.EStatus;
import edu.citytech.sp2020.marginal.tax.ITaxPaid;

/**
 * Servlet implementation class MarginalTaxServlet
 */
@WebServlet("/tax")
public class MarginalTaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarginalTaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// String conversion
		String sSalary = request.getParameter("salary");
		sSalary = sSalary != null ? sSalary : "0";
		float salary = Float.parseFloat(sSalary);
		
		// Status conversion
		String sStatus = request.getParameter("status");
		EStatus status = EStatus.getStatus(sStatus);
		
		ITaxPaid service = new MarginalTaxService();

		float taxPaid = service.getTaxPaid(status, salary);
		
		response.getWriter().append("Tax paid: " + taxPaid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
