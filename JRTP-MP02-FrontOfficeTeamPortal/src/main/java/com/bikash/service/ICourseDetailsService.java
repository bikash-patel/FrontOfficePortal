package com.bikash.service;

import java.util.List;

import com.bikash.entity.CourseDetails;

public interface ICourseDetailsService {

	public String addCourse(CourseDetails course);

	public String updateCourse(CourseDetails course);

	public List<CourseDetails> findAll();

	public CourseDetails findCourseById(Integer courseId);

	public String deleteCourse(Integer courseId);
	
	public CourseDetails findByCourseName(String courseName);


}
