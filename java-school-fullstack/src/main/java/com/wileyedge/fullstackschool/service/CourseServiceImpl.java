package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.CourseDao;
import com.wileyedge.fullstackschool.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseServiceInterface {

	// YOUR CODE STARTS HERE
	Course returnedCourse;
	@Autowired
	CourseDao courseDao;

	public CourseServiceImpl(CourseDao courseDao) {
		this.courseDao = courseDao;
		this.returnedCourse = new Course();
	}

	// YOUR CODE ENDS HERE

	public List<Course> getAllCourses() {
		// YOUR CODE STARTS HERE

		List<Course> courses = courseDao.getAllCourses();

		return courses;

		// YOUR CODE ENDS HERE
	}

	public Course getCourseById(int id) {
		// YOUR CODE STARTS HERE
		returnedCourse.setCourseId(id);

		try {
			returnedCourse = courseDao.findCourseById(id);

		} catch (DataAccessException dae) {
			returnedCourse.setCourseName("Course Not Found");
			returnedCourse.setCourseDesc("Course Not Found");
		}

		return returnedCourse;

		// YOUR CODE ENDS HERE
	}

	public Course addNewCourse(Course course) {
		// YOUR CODE STARTS HERE

		returnedCourse = course;

		if (course.getCourseName().equals("")||course.getCourseDesc().equals("")) {
			returnedCourse.setCourseName("Name blank, course NOT added");
			returnedCourse.setCourseDesc("Description blank, course NOT added");
			return returnedCourse;
		}
	
		returnedCourse = courseDao.createNewCourse(course);
		return returnedCourse;

		// YOUR CODE ENDS HERE
	}

	public Course updateCourseData(int id, Course course) {
		// YOUR CODE STARTS HERE
		returnedCourse = course;

		if (id != returnedCourse.getCourseId()) {
			returnedCourse.setCourseName("IDs do not match, course not updated");
			returnedCourse.setCourseDesc("IDs do not match, course not updated");
			return returnedCourse;
		}
		courseDao.updateCourse(course);
		return returnedCourse;

		// YOUR CODE ENDS HERE
	}

	public void deleteCourseById(int id) {
		// YOUR CODE STARTS HERE

		courseDao.deleteCourse(id);
		System.out.println("Course ID:" + id + " deleted");
		// YOUR CODE ENDS HERE
	}
}
