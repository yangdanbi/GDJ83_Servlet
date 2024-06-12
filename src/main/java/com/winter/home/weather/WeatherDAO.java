package com.winter.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherDAO {
	public List<WeatherDTO> getWeathers() throws Exception {
		// WeatherDTO weatherDTO = new WeatherDTO();
		// DTO : Data Transfer Object
		// DAO : Data Access Object

		// getWeathers
		// 파일에 날씨정보들을 읽어와서 파싱한 후에 DTO에 담아서 리턴
		File file = new File("C:\\study", "weather.txt");
		FileReader fr = new FileReader(file);// 파일경로를 문자로
		BufferedReader br = new BufferedReader(fr);// 문자를 문자열로

		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();

		while (true) {
			String s = br.readLine();
			if (s == null) {// readLine읽어들인게 없다면 while문 실행x
				break;
			}
			s = s.replace(",", "-");// 한줄 읽어온 s에다가 ,를 -로 바꿈
			StringTokenizer st = new StringTokenizer(s, "-");
			WeatherDTO wDTO = new WeatherDTO();
			while (st.hasMoreTokens()) {
				wDTO.setNum(Long.parseLong(st.nextToken().trim()));
				wDTO.setCity(st.nextToken().trim());
				wDTO.setGion(Double.parseDouble(st.nextToken().trim()));
				wDTO.setStatus(st.nextToken().trim());
				wDTO.setHuminity(Integer.parseInt(st.nextToken().trim()));
			}
			ar.add(wDTO);

		}
		br.close();
		fr.close();
		return ar;

	}

}
