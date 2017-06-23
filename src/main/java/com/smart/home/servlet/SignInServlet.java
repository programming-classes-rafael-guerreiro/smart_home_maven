package com.smart.home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smart.home.database.UserDAO;
import com.smart.home.dto.SignInUserDTO;
import com.smart.home.model.User;

@WebServlet("/sign-in")
public class SignInServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User loggedInUser = (User) session.getAttribute("logged_in_user");

		if (loggedInUser == null) {
			req.getRequestDispatcher("WEB-INF/jsp/signIn/index.jsp").forward(req, resp);
		} else {
			req.setAttribute("user", loggedInUser);
			req.getRequestDispatcher("WEB-INF/jsp/signIn/signInSuccess.jsp").forward(req, resp);
		}
	}

	@Override // POST = criação
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		SignInUserDTO dto = new SignInUserDTO(email, password);
		User user = new UserDAO().signIn(dto);

		if (user != null) {
			req.setAttribute("user", user);

			HttpSession session = req.getSession();
			session.setAttribute("logged_in_user", user);

			// Cookie cookie = new Cookie("smart-home-cookie", user.getEmail());
			// cookie.setMaxAge((int) TimeUnit.DAYS.toSeconds(14));
			// cookie.setHttpOnly(true);
			//
			// resp.addCookie(cookie);

			req.getRequestDispatcher("WEB-INF/jsp/signIn/signInSuccess.jsp").forward(req, resp);
		} else {
			req.setAttribute("error", "Unable to sign in. Email and password does not match.");
			req.setAttribute("email", email);

			req.getRequestDispatcher("WEB-INF/jsp/signIn/index.jsp").forward(req, resp);
		}
	}

	@Override // PUT = alteração
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	}

	@Override // DELETE = deleção
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	}
}
