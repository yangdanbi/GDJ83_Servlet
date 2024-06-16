package com.winter.home.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;
import com.winter.home.weather.WeatherDTO;

public class StudentController {
	private StudentService studentService;

	public StudentController() {
		this.studentService = new StudentService();// 내부에서 받아서 쓰겠다
		// studentService 객체가 소멸되면 같이 소멸
		// 여기서 만들었고 주소를 여기에 넣어놔서 controller가 소멸되면 주소도 같이 소멸
	}

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
		// 소멸되면 주소는 외부에 있기때문에 소멸x
	}

	public Action start(HttpServletRequest request) {
		System.out.println("Student Controller");
		// student /??? 가상의주소 개발자 마음대로 uri에서 꺼내오기 request
		// list => 학생정보전체출력
		// add => 학생 한명 정보 추가
		// delete => 학생 한명 삭제
		// detail => 학생 한명 정보출력

		// requst respons 는 톰캣이 만들게 됨

		String uri = request.getRequestURI();
//		uri = uri.substring(1, uri.lastIndexOf("/"));
		String[] result = uri.split("/");

		Action action = new Action();
		action.setFlag(true);

		String method = request.getMethod();
		if (result[2].equals("list")) {
			List<StudentDTO> list = studentService.getStudents(); // 변수명은 안맞춰도 됨
			request.setAttribute("list", list);// jsp로 보내기
			action.setPath("/WEB-INF/views/student/list.jsp");
			System.out.println("학생정보 전체출력");

		} else if (result[2].equals("add")) {
			if (method.toUpperCase().equals("POST")) {
				StudentDTO sDTO = new StudentDTO();

				// 파라미터 꺼내면 무조건 string
				// post방식으로 파라미터 넘기는법
				String name = request.getParameter("name");
				int kor = Integer.parseInt(request.getParameter("kor"));
				int eng = Integer.parseInt(request.getParameter("eng"));
				int math = Integer.parseInt(request.getParameter("math"));
				int total = Integer.parseInt(request.getParameter("total"));
				double avg = Double.parseDouble(request.getParameter("avg"));

				sDTO.setName(name);// student에 파라미터로 꺼낸 name을 넣음
				sDTO.setKor(kor);
				sDTO.setEng(eng);
				sDTO.setMath(math);
				sDTO.setTotal(total);
				sDTO.setAvg(avg);

				studentService.add(sDTO);

				/*
				 * System.out.println("radio : " + request.getParameter("ch"));
				 * System.out.println("option : " + request.getParameter("mobile"));
				 * System.out.println("textarea : " + request.getParameter("contents"));
				 */

				/*
				 * String[] ch2 = request.getParameterValues("ch2"); for (String s : ch2) { //
				 * 데이터타입 변수명: 어디서 찾을건지 System.out.println(s); }
				 */

				action.setPath("./list");
				action.setFlag(false);
			} else {

				action.setPath("/WEB-INF/views/student/add.jsp");
				System.out.println("학생정보 추가");
			}
		} else if (result[2].equals("delete")) {
			System.out.println("학생정보 삭제");
			String num = request.getParameter("num");
			StudentDTO sDTO = new StudentDTO();
			sDTO.setNum(Integer.parseInt(num));
			System.out.println("StudentController.start - result[delete] 삭제할 번호: " + sDTO.getNum() + 1);

			sDTO=studentService.delete(sDTO);
			
			action.setPath("/student/list");
			action.setFlag(false);
		} else if (result[2].equals("detail")) {

			// 지역변수라 소멸되기때문에 request
//			String name = "winter";
//			double avg = 89.23;
//			request.setAttribute("name", name);// key 중복x, value
//			request.setAttribute("avg", avg);

			// StudentDTO student = studentService.makeStudent();// 주소를 보내면 됨
			// request.setAttribute("s", student);// key value
			String num = request.getParameter("num");
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setNum(Integer.parseInt(num));
			studentDTO = studentService.getDetail(studentDTO);

			if (studentDTO != null) {

				request.setAttribute("dto", studentDTO);
				System.out.println("학생한명 정보출력");
				action.setPath("/WEB-INF/views/student/detail.jsp");
			} else {
				request.setAttribute("message", "정보가 없습니다.");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}
		}else if(result[2].equals("update")) {
			
			if (method.toUpperCase().equals("POST")) {
				int num = Integer.parseInt(request.getParameter("num"));
				System.out.println("num" + request.getParameter("num"));
				String name =request.getParameter("name");
				System.out.println("kor" + request.getParameter("kor"));
				int kor = Integer.parseInt(request.getParameter("kor"));
				
				System.out.println("eng" + request.getParameter("eng"));
				int eng = Integer.parseInt(request.getParameter("eng"));
				
				System.out.println("math" + request.getParameter("math"));
				int math = Integer.parseInt(request.getParameter("math"));
				
				System.out.println("total" + request.getParameter("total"));
				int total = Integer.parseInt(request.getParameter("total"));
				Double avg = Double.parseDouble(request.getParameter("avg"));
				
				StudentDTO sDTO = new StudentDTO();
				sDTO.setNum(num);
				sDTO.setName(name);
				sDTO.setKor(kor);
				sDTO.setEng(eng);
				sDTO.setMath(math);
				sDTO.setTotal(total);
				sDTO.setAvg(avg);
				
			sDTO=studentService.update(sDTO);
			studentService.print(sDTO);
				
				action.setPath("/student/list");// 상대경로 ./list - list 둘중 하나
				action.setFlag(false);
									
			}else {
				StudentDTO sDTO = new StudentDTO();
				sDTO.setNum(Integer.parseInt(request.getParameter("num")));
				
				sDTO = studentService.getDetail(sDTO);
				request.setAttribute("dto", sDTO);
				action.setPath("/WEB-INF/views/student/update.jsp");
			}
		}
		System.out.println("WeatherController.start - action 출력 : " + action.getPath());
		return action;

	}

}
