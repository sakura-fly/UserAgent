package act;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.UserAgent;


@WebServlet("/*")
public class Act extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userAgent = request.getHeader("User-Agent");
		String r = new UserAgent().getOsAndBrowserInfo(userAgent);
		System.out.println(userAgent);
		System.out.println(r);
		response.getWriter().print(userAgent + "\n" + r);
	}
}
