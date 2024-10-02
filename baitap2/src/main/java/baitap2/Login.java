package baitap2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if ("admin".equals(username) && "123456".equals(password)) {
			String context = req.getContextPath();
			resp.sendRedirect(context + "/welcom");
		} else {
			resp.getWriter().println("<h1>Sai username hoặc mật khẩu!</h1>");

		}
	}
}