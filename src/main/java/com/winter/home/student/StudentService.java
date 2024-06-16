package com.winter.home.student;

import java.util.List;

import com.winter.home.weather.WeatherDTO;

public class StudentService {

	private StudentDAO studentDAO;

	public StudentService() {
		studentDAO = new StudentDAO();
	}

	public List<StudentDTO> getStudents() {

		List<StudentDTO> list = null;

		try {
			list = studentDAO.getStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public StudentDTO getDetail(StudentDTO studentDTO) {
		try {
			studentDTO = studentDAO.getDetail(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			studentDTO = null;
		}
		return studentDTO;
	}

	public StudentDTO add(StudentDTO studentDTO) {
		try {
			studentDTO = studentDAO.add(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentDTO;
	}
	public StudentDTO delete(StudentDTO studentDTO) {
		try {
			studentDTO = studentDAO.delete(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentDTO;
		
		
	}
	public StudentDTO update(StudentDTO studentDTO) {
		
		try {
			studentDTO = studentDAO.update(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentDTO;
	}
	public void print(StudentDTO studentDTO)  {
		System.out.println("============ print start =============");
		System.out.println("num : " + studentDTO.getNum());
		System.out.println("getName : " + studentDTO.getName());
		System.out.println("getKor : " + studentDTO.getKor());
		System.out.println("getEng : " + studentDTO.getEng());
		System.out.println("getMath : " + studentDTO.getMath());
		System.out.println("getTotal : " + studentDTO.getTotal());
		System.out.println("getAvg : " + studentDTO.getAvg());
		System.out.println("============== print end =============");
	}
	
	

//	// 변경을 할 수도 있기 때문에 list
//	public List<StudentDTO> getStudents() {
//		// 학생들을 만들어서 리턴
//		ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();
//		Random random = new Random();
//		for (int i = 0; i < 5; i++) {
//			// 5명 만들어야해서 객체를 안에 생성
//			StudentDTO student = new StudentDTO();
//			student.setNum(i + 1);
//			student.setName("name" + i);
//			student.setAvg(random.nextInt(100) + random.nextDouble()); // 0~99까지,0.0~1.0 랜덤한 더블값
//
//			ar.add(student);
//		}
//		return ar;
//	}
//
//	public StudentDTO makeStudent() {
//		// 학생만들기
//		// db에서 꺼내올 데이터
//		// 밑 데이터를 하나로 뭉쳐서 student에 담음
//		StudentDTO student = new StudentDTO();
//		student.setNum(1);
//		student.setName("winter");
//		student.setAvg(56.32);
//
//		// 데이터가 모여있는 student를 리턴
//		return student;
//
//	}

}
