package com.winter.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.home.student.StudentController;
import com.winter.home.weather.WeatherController;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	// 기본생성자
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 사용자의 요청이 있어야 doget 실행
	// get방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// ip:port 를 제외한것 uri
		// TODO Auto-generated method stub
		System.out.println("request");
		System.out.println(request.getRequestURI());
		System.out.println(request.getMethod());
		System.out.println("실행 됨");
		// url method는 필수 파라미터는 없어도 됨
		// url- ip,port = uri
		String uri = request.getRequestURI();
		String method = request.getMethod();
		String path = "";
		Action action = new Action();
		if (!uri.equals("/favicon.ico")) {

			String[] result = uri.split("/");
			if (uri.equals("/")) {
				// path = "/WEB-INF/views/index.jsp";
				action.setFlag(true);
				action.setPath("/WEB-INF/views/index.jsp");
			} else if (result[1].equals("student")) {
				StudentController sc = new StudentController();

				// path = "/WEB-INF/views/student/list.jsp";
				System.out.println("student.list 실행");
				action = sc.start(request);
			} else if (result[1].equals("weather")) {
				WeatherController wc = new WeatherController();

				// path = "/WEB-INF/views/weather/list.jsp";
				System.out.println("weather.list 실행");
				action = wc.start(request);
			}

			if (action.isFlag()) {

				RequestDispatcher view = request.getRequestDispatcher(action.getPath());// 무조건 절대경로 jsp로 이동하자
				view.forward(request, response);

			} else {
				response.sendRedirect(action.getPath());
			}
			System.out.println(uri);
			System.out.println(method);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// post방식
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
