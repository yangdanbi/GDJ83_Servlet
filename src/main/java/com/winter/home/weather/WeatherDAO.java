package com.winter.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

	public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception {// weathDTO를 받아옴
		// 파일을 읽어서 해당하는 정보를 전달하기
		List<WeatherDTO> ar = this.getWeathers(); // 목록들이 ar에 다 들어가있음

		WeatherDTO reault = null;

		for (WeatherDTO w : ar) {
			if (w.getNum() == weatherDTO.getNum()) {
				reault = w;

				break;
			}
		}
		// 못찾으면 null이 리턴
		// 무언갈 찾음 null 이 안뜨게 됨
		return reault;
	}

	public WeatherDTO add(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		// 도시명-기온-상태-습도
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(ar.size() + 1);// 번호

		stringBuffer.append(weatherDTO.getCity());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getGion());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getStatus());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getHuminity());

//		System.out.println(city + "-" + gion + "-" + status + "-" + huminity);
		System.out.println(stringBuffer.toString());
		File file = new File("C:\\study", "weather.txt");
		FileWriter fw = new FileWriter(file, true);
		fw.write(weatherDTO.getCity() + "\r\n");
		fw.write(weatherDTO.getGion() + "\r\n");
		fw.write(weatherDTO.getStatus() + "\r\n");
		fw.write(weatherDTO.getHuminity());
		fw.flush();
		return weatherDTO;

	}

}
