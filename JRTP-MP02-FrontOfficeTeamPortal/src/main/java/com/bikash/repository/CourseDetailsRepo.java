package com.bikash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bikash.entity.CourseDetails;

public interface CourseDetailsRepo extends JpaRepository<CourseDetails, Integer> {
	
	@Query("SELECT courseName FROM CourseDetails")
	public List<String> getCourses();
}
