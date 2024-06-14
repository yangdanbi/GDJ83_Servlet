package com.winter.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;

public class WeatherController {
	// 클라이언트에서 서버로 보내는 거 -> 파라미터
	// 리스트에서 넘어가는 데이터가 뭔지 모르니까 num을 보내줘야함

	public Action start(HttpServletRequest request) {// request받아옴
		System.out.println("WeatherController");
		String uri = request.getRequestURI();
		String result = uri.substring(uri.lastIndexOf("/") + 1);// weather 를 자름

		Action action = new Action();
		action.setFlag(true);// 나중에 배우면 다른걸로 바꿀예정
		// jsp 경로명을 action에 담아서 보냄

		// 메서드 형식을 다른 곳에서도 쓸 수 있으니 위에서 메서드 형식 나눠주기
		String method = request.getMethod().toUpperCase();

		WeatherService weatherService = new WeatherService();
		if (result.equals("list")) {
			List<WeatherDTO> list = weatherService.getWeathers();
			request.setAttribute("list", list);
			// System.out.println(ar.get(1).getCity());
			action.setPath("/WEB-INF/views/weather/list.jsp");

		} else if (result.equals("add")) {
			if (method.equals("POST")) {
				System.out.println("add  들어옴");
				// 메서드 형식이 post니 파일에 저장하기위해 데이터 보내주기
				// 파라미터 꺼내옴
				String city = request.getParameter("city");
				Double gion = Double.parseDouble(request.getParameter("gion"));
				int huminity = Integer.parseInt(request.getParameter("huminity"));
				String status = request.getParameter("status");

				// 꺼낸 파라미터 dto에 넣음
				// 입력받은 데이터 dto에 넣어주기
				WeatherDTO wDTO = new WeatherDTO();

				wDTO.setCity(city);
				wDTO.setGion(gion);
				wDTO.setHuminity(huminity);
				wDTO.setStatus(status);

				System.out.println("add 시작");
				weatherService.add(wDTO);
				System.out.println("add 끝");

//				weatherService.add(weatherDTO);

				// 만들어진 list를 jsp로 보내주는 작업
//				List<WeatherDTO> list = weatherService.getWeathers();
//				request.setAttribute("list", list);
//				action.setPath("/WEB-INF/views/weather/list.jsp");

				// url을 줘서 거기로 가라고 함
				action.setPath("/weather/list");// 상대경로 ./list - list 둘중 하나
				action.setFlag(false);// flag가 false가 되면 redirect 보낼 수 있음

			} else {
				// 메서드 형식이 get방식 이라면 jsp로 이동하기
				action.setPath("/WEB-INF/views/weather/add.jsp");
			}
			// 파일에 있는 정보들을 지울거임 DAO 까지 가야함
		} else if (result.equals("delete")) {
			String num = request.getParameter("num");
			WeatherDTO wDTO = new WeatherDTO();
			wDTO.setNum(Long.parseLong(num));
			wDTO = weatherService.delete(wDTO);
			System.out.println("delete 눌림");
			System.out.println("삭제할 번호: " + wDTO.getNum() + 1); // 삭제할 게시물 번호 나옴

//			action.setPath("/WEB-INF/views/weather/list.jsp");
			action.setPath("/weather/list");// 상대경로 ./list - list 둘중 하나
			action.setFlag(false);

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

		} else if (result.equals("update")) {
			if (method.toUpperCase().equals("POST")) {
				// 수정

			} else {
				WeatherDTO wDTO = new WeatherDTO();
				// weatherDTO 정보를 jsp로 보내야함
				// request
				wDTO.setNum(Long.parseLong(request.getParameter("num")));
				wDTO = weatherService.getDetail(wDTO);
				request.setAttribute("dto", wDTO);// jsp에 뿌려줌
				action.setPath("/WEB-INF/views/weather/update.jsp");

			}
		}
		System.out.println("action 출력:" + action.getPath());
		return action;
	}

}
