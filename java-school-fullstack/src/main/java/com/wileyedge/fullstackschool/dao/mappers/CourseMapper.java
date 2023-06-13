package com.wileyedge.fullstackschool.dao.mappers;

import com.wileyedge.fullstackschool.model.Course;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements RowMapper<Course> {
	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		// YOUR CODE STARTS HERE

		int courseId = rs.getInt("cid");
		String courseName = rs.getString("courseCode"); //not course name but course code
		String courseDesc = rs.getString("courseDesc");
		int teacherId = rs.getInt("teacherId");

		Course course = new Course();

		course.setCourseId(courseId);
		course.setCourseName(courseName);
		course.setCourseDesc(courseDesc);
		course.setTeacherId(teacherId);

		return course;

		// YOUR CODE ENDS HERE
	}
}
