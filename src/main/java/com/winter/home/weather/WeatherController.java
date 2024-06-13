package com.winter.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;

public class WeatherController {

	public Action start(HttpServletRequest request) {// request받아옴
		System.out.println("WeatherController");
		String uri = request.getRequestURI();
		String result = uri.substring(uri.lastIndexOf("/") + 1);// weather 를 자름

		Action action = new Action();
		action.setFlag(true);// 나중에 배우면 다른걸로 바꿀예정
		// jsp 경로명을 action에 담아서 보냄

		WeatherService weatherService = new WeatherService();
		if (result.equals("list")) {
			List<WeatherDTO> list = weatherService.getWeathers();
			request.setAttribute("list", list);
			// System.out.println(ar.get(1).getCity());
			action.setPath("/WEB-INF/views/weather/list.jsp");

		} else if (result.equals("add")) {
			action.setPath("/WEB-INF/views/weather/add.jsp");

		} else if (result.equals("detail")) {// 도시이름 누르면 그 도시 정보 페이지로 이동
			String num = request.getParameter("num");
			WeatherDTO weatherDTO = new WeatherDTO();// num을 weatherDTO에 setNum에 넣으려는 목적
			weatherDTO.setNum(Long.parseLong(num));// service로 보내야함
			weatherDTO = weatherService.getDetail(weatherDTO);

			if (weatherDTO != null) {
				request.setAttribute("dto", weatherDTO);
				action.setPath("/WEB-INF/views/weather/detail.jsp");
			} else {
				request.setAttribute("message", "정보가 없습니다.");
				action.setPath("/WEB-INF/views/commons/message.jsp");

			}

		}
		return action;
	}

}
