package com.bikash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.CourseDetails;
import com.bikash.repository.CourseDetailsRepo;

@Service
public class CourseDetailsServiceImpl implements ICourseDetailsService {

	@Autowired
	private CourseDetailsRepo courseRepo;

	@Override
	public String addCourse(CourseDetails course) {

		// Check duplicate course exist or not
		if (courseRepo.existsByCourseName(course.getCourseName())) {
			return "Course already exist";
		}
		courseRepo.save(course);
		return course.getCourseName() + " Course has been added ";
	}

	@Override
	public String updateCourse(CourseDetails course) {

		// Check course exist or not
		Optional<CourseDetails> byId = courseRepo.findById(course.getCourseId());
		if (byId.isEmpty()) {
			return "Course details not found";
		}

		CourseDetails courseDetails = byId.get();
		BeanUtils.copyProperties(course, courseDetails);
		courseRepo.save(courseDetails);
		return course.getCourseName() + " Course has been updated ";
	}

	@Override
	public List<CourseDetails> findAll() {
		return courseRepo.findAll();
	}

	@Override
	public CourseDetails findCourseById(Integer courseId) {

		// Check course exist or not
		Optional<CourseDetails> byId = courseRepo.findById(courseId);
		if (byId.isEmpty()) {
			return null;
		}

		return byId.get();
	}

	@Override
	public String deleteCourse(Integer courseId) {

		// Check course exist or not
		Optional<CourseDetails> byId = courseRepo.findById(courseId);
		if (byId.isEmpty()) {
			return "Course not found for deletion";
		}

		CourseDetails courseDetails = byId.get();
		courseRepo.delete(courseDetails);
		return "Course has been remove";
	}
	
	@Override
	public CourseDetails findByCourseName(String courseName) {
	    return courseRepo.findByCourseName(courseName);
	}


}
