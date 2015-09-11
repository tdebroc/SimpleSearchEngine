package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import DAO.Message;
import Search.SearchEngine;

// Extend HttpServlet class
public class GetMessagesFromWordServlet extends HttpServlet {
	private static final long serialVersionUID = 7127214269849735591L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		if (!checkRights(userId)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		String word = request.getParameter("word");
		
		String idConversation = request.getParameter("idConversation");
		
		List<Message> messages = SearchEngine.find(idConversation, word);
		
		JSONObject responseJson = Message.messageListToJson(messages);
		
		
		out.println(responseJson);
	}

	private boolean checkRights(String userId) {
		return true;
	}
}

