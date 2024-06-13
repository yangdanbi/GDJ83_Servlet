package com.winter.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StudentDAO {
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

	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception {
		List<StudentDTO> ar = this.getStudents(); // 위에 메서드에서 저장한 학생들이 ar에 저장
		StudentDTO result = null;

		for (StudentDTO w : ar) {
			if (w.getNum() == studentDTO.getNum()) {
				result = w;
				break;
			}
			System.out.println(result);
		}
		return result;
//		for (int i = 0; i < ar.size(); i++) {
//
//			if (ar.get(i).getNum() == studentDTO.getNum()) {
//				result = ar.get(i).getNum();
//
//			}
//		}

	}
}
