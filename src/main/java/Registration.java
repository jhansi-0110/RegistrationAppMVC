

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/Register")
public class Registration extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String p_w = request.getParameter("password");
		String city = request.getParameter("ucity");
		
		Model m = new Model();
		
		m.setCity(city);
		m.setEmailid(email);
		m.setName(uname);
		m.setPassword(p_w);
		
		int rows=m.register();
		HttpSession ses = request.getSession();
		ses.setAttribute("name", uname);
		
		if(rows==0) {
			response.sendRedirect("/RegistrationAppMVC/failed.jsp");
		}
		else {
			response.sendRedirect("/RegistrationAppMVC/success.jsp");
		}
		return;
	}

}
