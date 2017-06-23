package com.smart.home.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smart.home.model.User;

@WebFilter(urlPatterns = "/*")
public class AuthenticatedFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Entering filter");

		// ida, antes de invocar o servlet

		if (request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest) request;

			String path = req.getServletPath();
			boolean isSecure = !path.contains("sign");

			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("logged_in_user");

			boolean isLoggedIn = user != null;

			System.out.println("isSecure? -> " + isSecure);
			System.out.println("isLoggedIn? -> " + isLoggedIn);

			// isSecure = true, isLoggedIn = true -> A
			// isSecure = false, isLoggedIn = false -> A
			// isSecure = true, isLoggedIn = false -> B
			// isSecure = false, isLoggedIn = true -> C

			if (!(isSecure ^ isLoggedIn)) // A
				chain.doFilter(request, response);
			else if (!isLoggedIn) // B
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN);
			else // C
				chain.doFilter(request, response);
		}

		System.out.println("Leaving filter");

		// volta, depois de invocar o servlet
	}

	@Override
	public void destroy() {

	}

}
