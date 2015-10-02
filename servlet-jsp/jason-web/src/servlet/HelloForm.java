package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloForm
 */
@WebServlet(description = "test post data", urlPatterns = { "/HelloForm" })
public class HelloForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 为名字和姓氏创建 Cookies      
		response.setCharacterEncoding("utf-8");
        Cookie firstName = new Cookie("first_name",
                      request.getParameter("first_name"));
        Cookie lastName = new Cookie("last_name",
                      request.getParameter("last_name"));
		firstName.setMaxAge(60*60*24);
		lastName.setMaxAge(60*60*24);
		response.addCookie(firstName);
		response.addCookie(lastName);
		 PrintWriter out = response.getWriter();
	      String title = "设置 Cookies 实例";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "<ul>\n" +
	                "  <li><b>名字</b>："
	                + request.getParameter("first_name") + "\n" +
	                "  <li><b>姓氏</b>："
	                + request.getParameter("last_name") + "\n" +
	                "</ul>\n" +
	                "</body></html>");

		
		/*PrintWriter pw = response.getWriter();
		String first = request.getParameter("first_name");
		String second = request.getParameter("last_name");
		pw.println("firstname"+first+"<br>"+"lastname"+ second);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
