package com.chainsys.webapp.second;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CookiesDemo
 */
public class CookiesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookiesDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie[] allCookies = request.getCookies();
		if (allCookies == null) {
			System.out.println("no cookies found");
			// use logmanager and logmessage instead of sysout
			return;
		}
		int cookielength = allCookies.length;
		for (int i = 0; i < cookielength; i++) {
			System.out.println(allCookies[i].getName() + "_" + allCookies[i].getValue());

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie firstCookie = new Cookie("captain", "raina");
		firstCookie.setMaxAge(-1);
		// if value is zero or less than cookie will get deleted automatically after the
		// execution
		// if the value is positive then the cookie will expire after the specified
		// seconds(in seconds)
		response.addCookie(firstCookie);
		Cookie secondCookie = new Cookie("fruit", "cherry");
		secondCookie.setMaxAge(2 * 24 * 60 * 60);
		// life set for two days
		response.addCookie(secondCookie);
		Cookie thirdCookie = new Cookie("dress", "sleve");
		response.addCookie(thirdCookie);
		Cookie fourCookie = new Cookie("hot", "coffee");
		response.addCookie(fourCookie);
	}

}
