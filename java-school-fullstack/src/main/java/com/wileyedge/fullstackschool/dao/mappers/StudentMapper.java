package com.wileyedge.fullstackschool.dao.mappers;

import com.wileyedge.fullstackschool.model.Student;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// YOUR CODE STARTS HERE

		int studentId = rs.getInt("sid");
		String studentFirstName = rs.getString("fName");
		String studentLastName = rs.getString("lName");
		

		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentFirstName(studentFirstName);
		student.setStudentLastName(studentLastName);

		return student;

		// YOUR CODE ENDS HERE
	}
}
