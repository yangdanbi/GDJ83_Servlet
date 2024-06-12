package com.winter.home.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;

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
			List<Student> list = studentService.getStudents(); // 변수명은 안맞춰도 됨
			request.setAttribute("list", list);// jsp로 보내기
			action.setPath("/WEB-INF/views/student/list.jsp");
			System.out.println("학생정보 전체출력");

		} else if (result[2].equals("add")) {
			if (method.toUpperCase().equals("POST")) {
				Student student = new Student();

				System.out.println("학생 등록데이터를 꺼내야함"); // 파라미터 꺼내면 무조건 string
				// post방식으로 파라미터 넘기는법
				String name = request.getParameter("name");
				student.setName(name);// student에 파라미터로 꺼낸 name을 넣음
				System.out.println("name : " + name);

				int num = Integer.parseInt(request.getParameter("num"));
				student.setNum(num);
				System.out.println("num : " + num);

				double avg = Double.parseDouble(request.getParameter("avg"));
				student.setAvg(avg);
				System.out.println("avg : " + avg);

				System.out.println("radio : " + request.getParameter("ch"));
				System.out.println("option : " + request.getParameter("mobile"));
				System.out.println("textarea : " + request.getParameter("contents"));

				String[] ch2 = request.getParameterValues("ch2");
				for (String s : ch2) { // 데이터타입 변수명: 어디서 찾을건지
					System.out.println(s);
				}

				action.setFlag(false);
				action.setPath("./list");
			} else {

				action.setPath("/WEB-INF/views/student/add.jsp");
				System.out.println("학생정보 추가");
			}
		} else if (result[2].equals("delete")) {
			System.out.println("학생정보 삭제");
		} else if (result[2].equals("detail")) {
			// 지역변수라 소멸되기때문에 request
//			String name = "winter";
//			double avg = 89.23;
//			request.setAttribute("name", name);// key 중복x, value
//			request.setAttribute("avg", avg);

			Student student = studentService.makeStudent();// 주소를 보내면 됨
			request.setAttribute("s", student);// key value

			System.out.println("학생한명 정보출력");
			action.setPath("/WEB-INF/views/student/detail.jsp");
		}
		return action;

	}

	private int setNum(String num) {
		// TODO Auto-generated method stub
		return 0;
	}
}
