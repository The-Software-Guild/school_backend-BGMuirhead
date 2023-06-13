package com.wileyedge.fullstackschool.controller;

import com.wileyedge.fullstackschool.model.Course;
import com.wileyedge.fullstackschool.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

	@Autowired
	CourseServiceImpl courseService;

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		// YOUR CODE STARTS HERE

		// get list of courses
		List<Course> courses = courseService.getAllCourses();

		return courses;

		// YOUR CODE ENDS HERE
	}

	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable int id) {
		// YOUR CODE STARTS HERE

		Course course = courseService.getCourseById(id);

		// TODO ERROR HANDLING ?

		return course;

		// YOUR CODE ENDS HERE
	}

	@PostMapping("/add")
	public Course addCourse(@RequestBody Course course) {
		// YOUR CODE STARTS HERE
		Course course1 = courseService.addNewCourse(course);

		// TODO ERROR HANDLING ?

		return course1;

		// YOUR CODE ENDS HERE
	}

	@PutMapping("/{id}")
	public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
		// YOUR CODE STARTS HERE

		Course course1 = courseService.updateCourseData(id, course);

		// TODO ERROR HANDLING ?

		return course1;

		// YOUR CODE ENDS HERE
	}

	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable int id) {
		// YOUR CODE STARTS HERE

		courseService.deleteCourseById(id);

		// YOUR CODE ENDS HERE
	}
}
