package com.example.web;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wei
 * Email: ghostwei@gmail.com
 * Project Name: java-demo
 * DateTime: 2022/9/20 10:10
 */
@WebServlet("/form")
public class Form extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("page opened");
		request.getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		String username = request.getParameter("username").toString().trim();
		String password = request.getParameter("password").toString().trim();

		//username = username.getBytes(StandardCharsets.UTF_8);


		System.out.println("用户名:" + username);
		System.out.println("密  码:" + password);

		Map<String, String> params = new TreeMap<String, String>();
		params.put("username", username);
		params.put("password", password);

		request.setAttribute("params", params.toString());
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
	}

}



