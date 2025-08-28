package com.bikash.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "FO_Course_Details")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseDetails {

	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "FO_COURSE_SEQ1", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer courseId;

	@Column(length = 30)
	private String courseName;

	@ElementCollection(fetch = FetchType.EAGER) // <--- important for List<String>
	@CollectionTable(name = "course_modes", joinColumns = @JoinColumn(name = "course_id"))
	@Column(name = "mode")
	private List<String> courseMode; // will store modes like ["Online", "Offline"]

	@Column(length = 30)
	private String duration;

	private Double fees;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
}
