package com.winter.home.weather;

import java.util.List;

public class WeatherService {
	// 생성자에서 객체 생성
	private WeatherDAO weatherDAO;

	public WeatherService() {
		weatherDAO = new WeatherDAO();

	}

//dao랑 controller 사이에서 데이터를 이동
	public List<WeatherDTO> getWeathers() {
//여러개 가지고 오는(list)  메서드
		List<WeatherDTO> list = null;
		try {
			list = weatherDAO.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	// detail 하나만가져오기
	public WeatherDTO getDetail(WeatherDTO weatherDTO) {// 받아오기
		// 생성자에서 객체 생성해서 또 안해도 됨
		try {
			weatherDTO = weatherDAO.getDetail(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weatherDTO;

	}

	// 폼에서 입력받은 데이터를 받아서 파일에 저장해주는 DAO로 보내주는 역할
	public WeatherDTO add(WeatherDTO weatherDTO) {// 매개변수로 받음
		try {
			weatherDTO = weatherDAO.add(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return weatherDTO;

	}

	public WeatherDTO delete(WeatherDTO weatherDTO) {
		try {
			weatherDTO = weatherDAO.delete(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weatherDTO;
	}
	public WeatherDTO update(WeatherDTO weatherDTO) {
		try {
			weatherDTO = weatherDAO.update(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return weatherDTO;
	}
	
	public void print(WeatherDTO weatherDTO)  {
		System.out.println("============ print start =============");
		System.out.println("num : " + weatherDTO.getNum());
		System.out.println("getCity : " + weatherDTO.getCity());
		System.out.println("getGion : " + weatherDTO.getGion());
		System.out.println("getStatus : " + weatherDTO.getStatus());
		System.out.println("getHuminity : " + weatherDTO.getHuminity());
		System.out.println("============== print end =============");
	}
	
	public void print(WeatherDTO weatherDTO, String name)  {
		System.out.println("============ "+name+" start =============");
		System.out.println("num : " + weatherDTO.getNum());
		System.out.println("getCity : " + weatherDTO.getCity());
		System.out.println("getGion : " + weatherDTO.getGion());
		System.out.println("getStatus : " + weatherDTO.getStatus());
		System.out.println("getHuminity : " + weatherDTO.getHuminity());
		System.out.println("============== "+name+" end =============");
	}


}
