package com.winter.home.weather;

import java.util.List;

public class WeatherService {

	private WeatherDAO weatherDAO = new WeatherDAO();

	public WeatherService() {

	}

//dao랑 controller 사이에서 데이터를 이동
	public List<WeatherDTO> getWeathers() {

		List<WeatherDTO> list = null;
		try {
			list = weatherDAO.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}
