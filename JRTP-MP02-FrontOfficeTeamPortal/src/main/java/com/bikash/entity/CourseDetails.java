package com.bikash.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "FO_Course_Details")
public class CourseDetails {
	
	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "FO_COURSE_SEQ1", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "seq1",strategy = GenerationType.SEQUENCE)
	private Integer courseId;
	
	@Column(length = 30)
	private String courseName;
	
	@Column(length = 30)
	private String courseMode;
	
	@Column(length = 30)
	private String duration;
	
	private Double fees;
	
	private LocalDate startDate;
}
