package com.winter.home.weather;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherService {

	public StringBuffer sb;

	public WeatherService() {
		this.sb = new StringBuffer();
		this.sb.append("서울 , 29.3 - 맑음 - 60"); // 0123
		this.sb.append("-부산 , 33.3 - 흐림 - 90");// 4567
		this.sb.append("-제주 , 26.5 - 눈 - 30");// 891011
		this.sb.append("-광주 , 10.6 - 태풍 - 80");
	}

	public List<WeatherDTO> getWeathers() {
		String info = sb.toString();
		info = info.replace(",", "-");
		StringTokenizer st = new StringTokenizer(info, "-");

		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();
		while (st.hasMoreElements()) {
			WeatherDTO wDTO = new WeatherDTO();

			wDTO.setCity(st.nextToken().trim());// 도시명
			wDTO.setGion(Double.parseDouble(st.nextToken().trim()));// 기온
			wDTO.setStatus(st.nextToken().trim());
			wDTO.setHuminity(Integer.parseInt(st.nextToken().trim()));

			ar.add(wDTO);
		}
		return ar;

	}

}
