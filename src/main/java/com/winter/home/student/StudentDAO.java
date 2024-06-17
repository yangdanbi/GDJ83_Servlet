package com.winter.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StudentDAO {
	// 파일 읽기
	public List<StudentDTO> getStudents() throws Exception {
		File file = new File("C:\\study", "student.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(s, ",");
			StudentDTO sDTO = new StudentDTO();
			while (st.hasMoreElements()) {
				sDTO.setNum(Integer.parseInt(st.nextToken().trim()));// num
				sDTO.setName(st.nextToken().trim());// name
				sDTO.setKor(Integer.parseInt(st.nextToken().trim()));// kor
				sDTO.setEng(Integer.parseInt(st.nextToken().trim()));// eng
				sDTO.setMath(Integer.parseInt(st.nextToken().trim()));// math
				sDTO.setTotal(Integer.parseInt(st.nextToken().trim()));// total
				sDTO.setAvg(Double.parseDouble(st.nextToken().trim()));// avg
			} // 안 while 끝

			ar.add(sDTO);
		} // 밖 while 끝
		return ar;
	}// getStudents() 끝

	// 특정 하나 읽기
	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception {
		List<StudentDTO> ar = this.getStudents(); // 위에 메서드에서 저장한 학생들이 ar에 저장
		StudentDTO result = null;

		for (StudentDTO w : ar) {
			if (w.getNum() == studentDTO.getNum()) {
				result = w;
				break;
			}
			// System.out.println(result);
		}
		return result;
	}

	// 학생추가
	public StudentDTO add(StudentDTO studentDTO) throws Exception {
		StudentService ss = new StudentService();
		// 파일 읽기
		List<StudentDTO> ar = this.getStudents();
		StringBuffer sb = new StringBuffer();
		System.out.println("studentDAO add 들어옴");
		// 학생정보 추가
		studentDTO.setNum(ar.size() + 1);
		sb.append(studentDTO.getNum());
		sb.append(",");
		sb.append(studentDTO.getName());
		sb.append(",");
		sb.append(studentDTO.getKor());
		sb.append(",");
		sb.append(studentDTO.getEng());
		sb.append(",");
		sb.append(studentDTO.getMath());
		sb.append(",");
		sb.append(studentDTO.getTotal());
		sb.append(",");
		sb.append(studentDTO.getAvg());

		ss.print(studentDTO);
		// 파일
		File file = new File("C:\\study", "student.txt");
		FileWriter fw = new FileWriter(file, true);// 파일 뒤에다 이어붙이기
		fw.write(sb.toString() + "\r\n");// \n까지 해줘야 밑에 이어붙이기가 됨

		fw.flush();
		fw.close();
		return studentDTO;

	}

	// 삭제
	public StudentDTO delete(StudentDTO studentDTO) throws Exception {
		List<StudentDTO> ar = this.getStudents();
		for (StudentDTO s : ar) {
			if (s.getNum() == studentDTO.getNum()) {
				System.out.println("번호같음" + s.getNum());
				ar.remove(s);
				break;
			}
		}
		File file = new File("C:\\study", "student.txt");
		StringBuffer sb = new StringBuffer();
		FileWriter fw = new FileWriter(file, false);

		for (StudentDTO s : ar) {

			sb.append(s.getNum());
			sb.append(",");
			sb.append(s.getName());
			sb.append(",");
			sb.append(s.getKor());
			sb.append(",");
			sb.append(s.getEng());
			sb.append(",");
			sb.append(s.getMath());
			sb.append(",");
			sb.append(s.getTotal());
			sb.append(",");
			sb.append(s.getAvg());
			sb.append("\r\n");
		}
		fw.write(sb.toString());
		fw.flush();
		fw.close();
		return studentDTO;

	}

	public StudentDTO update(StudentDTO studentDTO) throws Exception {
		System.out.println("update 들어옴");
		StudentService ss = new StudentService();
		ss.print(studentDTO);
		List<StudentDTO> ar = this.getStudents();
		boolean flag = false;
		for (StudentDTO s : ar) {
			if (s.getNum() == studentDTO.getNum()) {
				if (!s.getName().equals(studentDTO.getName())) {
					s.setName(studentDTO.getName());
					flag = true;
				}
				if (s.getKor() != studentDTO.getKor()) {
					s.setKor(studentDTO.getKor());
					flag = true;
				}
				if (s.getEng() != studentDTO.getEng()) {
					s.setEng(studentDTO.getEng());
					flag = true;
				}
				if (s.getMath() != studentDTO.getMath()) {
					s.setMath(studentDTO.getMath());
					flag = true;
				}
				if (s.getTotal() != studentDTO.getTotal()) {
					s.setTotal(studentDTO.getTotal());
					flag = true;
				}
				if (s.getAvg() != studentDTO.getAvg()) {
					s.setAvg(studentDTO.getAvg());
					flag = true;
				}
			}
		}
		if (flag) {
			File file = new File("C:\\study", "student.txt");
			FileWriter fw = new FileWriter(file, false);
			StringBuffer sb = new StringBuffer();
			for (StudentDTO s : ar) {
				sb.append(s.getNum());
				sb.append(",");
				sb.append(s.getName());
				sb.append(",");
				sb.append(s.getKor());
				sb.append(",");
				sb.append(s.getEng());
				sb.append(",");
				sb.append(s.getMath());
				sb.append(",");
				sb.append(s.getTotal());
				sb.append(",");
				sb.append(s.getAvg());
				sb.append("\r\n");

			}
			fw.write(sb.toString());
			fw.flush();
			fw.close();
		}
		return studentDTO;
	}
}
