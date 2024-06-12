package com.winter.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;

public class WeatherController {

	public Action start(HttpServletRequest request) {
		System.out.println("WeatherController");
		String uri = request.getRequestURI();
		String result = uri.substring(uri.lastIndexOf("/") + 1);

		Action action = new Action();
		action.setFlag(true);// 나중에 배우면 다른걸로 바꿀예정
		// jsp 경로명을 action에 담아서 보냄

		if (result.equals("list")) {
			WeatherService weatherService = new WeatherService();
			List<WeatherDTO> list = weatherService.getWeathers();
			request.setAttribute("list", list);
			// System.out.println(ar.get(1).getCity());
			action.setPath("/WEB-INF/views/weather/list.jsp");
		} else if (result.equals("add")) {
			action.setPath("/WEB-INF/views/weather/add.jsp");
		} else if (result.equals("detail")) {
			action.setPath("/WEB-INF/views/weather/detail.jsp");
		}
		return action;
	}

}
