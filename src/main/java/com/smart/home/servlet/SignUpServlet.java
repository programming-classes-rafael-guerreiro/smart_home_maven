package com.smart.home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smart.home.database.UserDAO;
import com.smart.home.dto.SignUpUserDTO;
import com.smart.home.model.User;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/signUp/index.jsp").forward(req, resp);
	}

	@Override // POST = criação
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String passwordConfirmation = req.getParameter("password_confirmation");

		SignUpUserDTO dto = new SignUpUserDTO(name, email, password, passwordConfirmation);
		User user = new UserDAO().signUp(dto);

		if (user != null)
			req.getRequestDispatcher("WEB-INF/jsp/signUp/signUpSuccess.jsp").forward(req, resp);
		else {
			req.setAttribute("error", "Unable to create this user.");
			req.setAttribute("name", name);
			req.setAttribute("email", email);

			req.getRequestDispatcher("WEB-INF/jsp/signUp/index.jsp").forward(req, resp);
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
