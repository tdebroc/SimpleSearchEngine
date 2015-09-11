package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import Search.SearchEngine;

// Extend HttpServlet class
public class FocusOnSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 7127214269849735591L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		SearchEngine.buildWordsToMessages(userId);
		
		JSONObject responseJson = new JSONObject();
		
		responseJson.put("response", "All is good");
		
		PrintWriter out = response.getWriter();
		out.println(responseJson);
	}
}
