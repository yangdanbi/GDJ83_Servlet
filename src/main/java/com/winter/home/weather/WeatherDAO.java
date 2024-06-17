package com.winter.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
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
		BufferedReader br = new BufferedReader(fr);// 문자를 문자열로 스캐너랑 비슷

		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();

		while (true) {
			// readLine의 리턴값은 무조건 string
			// 다른 타입으로 받을시엔 형변환 필요
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
		// 도시명-기온-상태-습도
		StringBuffer stringBuffer = new StringBuffer();
		// 중복되지않는 수를 만들거임 시간을 이용해서
		Calendar ca = Calendar.getInstance();
		stringBuffer.append(ca.getTimeInMillis());// 중복되지않도록 년월일시분초를 Millis 바꿔줌
//		weatherDTO.setNum(ar.size() + 1);// 번호
//		stringBuffer.append(weatherDTO.getNum());
		// 있는 DTO에 새롭게 추가하기위해 append시키는것
		stringBuffer.append(",");
		stringBuffer.append(weatherDTO.getCity());
		stringBuffer.append(",");
		stringBuffer.append(weatherDTO.getGion());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getStatus());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getHuminity());

//		System.out.println(city + "-" + gion + "-" + status + "-" + huminity);
		System.out.println(stringBuffer.toString());
		File file = new File("C:\\study", "weather.txt");
		FileWriter fw = new FileWriter(file, true);
		fw.write("\r" + stringBuffer.toString());
//		fw.write(ar.size() + 1);
//		fw.write(weatherDTO.getCity() + "\r");
//		fw.write(weatherDTO.getGion() + "\r");
//		fw.write(weatherDTO.getStatus() + "\r");
//		fw.write(weatherDTO.getHuminity());
		fw.flush();
		fw.close();
		return weatherDTO;

	}

	// 서비스에도 delete
	// weatherDTO에 있는 num을 받아옴
	public WeatherDTO delete(WeatherDTO weatherDTO) throws Exception {// 매개변수로 weatherDTO 옴
		// list를 불러와서 지우려고 하는 num 과 일치하는 것을 리스트에서 삭제
		// 삭제하고 남은 list를 파일에 다시 저장
		// 지우고 나서 list로 돌아감 돌아갈땐 redirect
		List<WeatherDTO> ar = this.getWeathers();
		for (WeatherDTO w : ar) {
			if (w.getNum() == weatherDTO.getNum()) {
				// System.out.println("번호 같음" + w);
				ar.remove(w);
				break;
			}
		}

		File file = new File("C:\\study", "weather.txt");
		FileWriter fw = new FileWriter(file, false);

		StringBuffer stringBuffer = new StringBuffer();// 객체생성
		for (WeatherDTO w : ar) {
			// weatherDTO.setNum(ar.size());// 번호
			stringBuffer.append(w.getNum());
			stringBuffer.append(",");
			stringBuffer.append(w.getCity());
			stringBuffer.append(",");
			stringBuffer.append(w.getGion());
			stringBuffer.append("-");
			stringBuffer.append(w.getStatus());
			stringBuffer.append("-");
			stringBuffer.append(w.getHuminity());
			stringBuffer.append("\r\n");

		}
		fw.write(stringBuffer.toString());
		fw.flush();
		fw.close();
		return weatherDTO;
	}

	public WeatherDTO update(WeatherDTO weatherDTO) throws Exception {
		System.out.println("WeatherDAO.update - update 실행");
		List<WeatherDTO> ar = this.getWeathers();
		boolean flag = false;
		boolean isCityEqual = false;
		boolean isGionEqual = false;
		boolean isStatusEqual = false;
		boolean isHuminityEqual = false;

		// 프린트용 임시
		WeatherService ws = new WeatherService();
		for (WeatherDTO w : ar) {
//			System.out.println("WeatherDAO.update - update메서드 : " + w.getCity() + w.getStatus());

			if (w.getNum() == weatherDTO.getNum()) {
				ws.print(weatherDTO, "weatherDTO");
				ws.print(w, "파일");
				isCityEqual = w.getCity().equals(weatherDTO.getCity());
				isGionEqual = w.getGion() == weatherDTO.getGion();
				isStatusEqual = w.getStatus().equals(weatherDTO.getStatus());
				isHuminityEqual = w.getHuminity() == weatherDTO.getHuminity();

				// Check and update each field if it has changed
				if (!isCityEqual) {
					System.out.println("WeatherDAO.update - !isCityEqual");
					w.setCity(weatherDTO.getCity());
					flag = true;
				}
				if (!isGionEqual) {
					System.out.println("WeatherDAO.update - !isGionEqual");
					w.setGion(weatherDTO.getGion());
					flag = true;
				}
				if (!isStatusEqual) {
					System.out.println("WeatherDAO.update - !isStatusEqual");
					w.setStatus(weatherDTO.getStatus());
					flag = true;
				}
				if (!isHuminityEqual) {
					System.out.println("WeatherDAO.update - !isHuminityEqual");
					w.setHuminity(weatherDTO.getHuminity());
					flag = true;
				}
				break;
			}

		}

//		for (WeatherDTO w : ar) {
//			ws.print(w);
//		}

		if (flag) {
			File file = new File("C:\\study", "weather.txt");
			FileWriter fw = new FileWriter(file, false);
			StringBuffer stringBuffer = new StringBuffer();
			for (WeatherDTO w : ar) {
				stringBuffer.append(w.getNum());
				stringBuffer.append(",");
				stringBuffer.append(w.getCity());
				stringBuffer.append(",");
				stringBuffer.append(w.getGion());
				stringBuffer.append("-");
				stringBuffer.append(w.getStatus());
				stringBuffer.append("-");
				stringBuffer.append(w.getHuminity());
				stringBuffer.append("\r\n");

			}
			fw.write(stringBuffer.toString());
			fw.flush();
			fw.close();
		}
		return weatherDTO;
	}

}
