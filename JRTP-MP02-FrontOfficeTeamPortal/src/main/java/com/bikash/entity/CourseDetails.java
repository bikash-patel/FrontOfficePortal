//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Generated;

@Entity
@Table(name = "FO_Course_Details")
public class CourseDetails {
	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "FO_COURSE_SEQ1", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer courseId;
	@Column(length = 30)
	private String courseName;
	@Column(length = 30)
	private String courseMode;
	@Column(length = 30)
	private String duration;
	private Double fees;
	private LocalDate startDate;

	@Generated
	public CourseDetails() {
	}

	@Generated
	public Integer getCourseId() {
		return this.courseId;
	}

	@Generated
	public String getCourseName() {
		return this.courseName;
	}

	@Generated
	public String getCourseMode() {
		return this.courseMode;
	}

	@Generated
	public String getDuration() {
		return this.duration;
	}

	@Generated
	public Double getFees() {
		return this.fees;
	}

	@Generated
	public LocalDate getStartDate() {
		return this.startDate;
	}

	@Generated
	public void setCourseId(final Integer courseId) {
		this.courseId = courseId;
	}

	@Generated
	public void setCourseName(final String courseName) {
		this.courseName = courseName;
	}

	@Generated
	public void setCourseMode(final String courseMode) {
		this.courseMode = courseMode;
	}

	@Generated
	public void setDuration(final String duration) {
		this.duration = duration;
	}

	@Generated
	public void setFees(final Double fees) {
		this.fees = fees;
	}

	@Generated
	public void setStartDate(final LocalDate startDate) {
		this.startDate = startDate;
	}

	@Generated
	public boolean equals(final Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof CourseDetails)) {
			return false;
		} else {
			CourseDetails other = (CourseDetails) o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				Object this$courseId = this.getCourseId();
				Object other$courseId = other.getCourseId();
				if (this$courseId == null) {
					if (other$courseId != null) {
						return false;
					}
				} else if (!this$courseId.equals(other$courseId)) {
					return false;
				}

				Object this$fees = this.getFees();
				Object other$fees = other.getFees();
				if (this$fees == null) {
					if (other$fees != null) {
						return false;
					}
				} else if (!this$fees.equals(other$fees)) {
					return false;
				}

				Object this$courseName = this.getCourseName();
				Object other$courseName = other.getCourseName();
				if (this$courseName == null) {
					if (other$courseName != null) {
						return false;
					}
				} else if (!this$courseName.equals(other$courseName)) {
					return false;
				}

				label62: {
					Object this$courseMode = this.getCourseMode();
					Object other$courseMode = other.getCourseMode();
					if (this$courseMode == null) {
						if (other$courseMode == null) {
							break label62;
						}
					} else if (this$courseMode.equals(other$courseMode)) {
						break label62;
					}

					return false;
				}

				label55: {
					Object this$duration = this.getDuration();
					Object other$duration = other.getDuration();
					if (this$duration == null) {
						if (other$duration == null) {
							break label55;
						}
					} else if (this$duration.equals(other$duration)) {
						break label55;
					}

					return false;
				}

				Object this$startDate = this.getStartDate();
				Object other$startDate = other.getStartDate();
				if (this$startDate == null) {
					if (other$startDate != null) {
						return false;
					}
				} else if (!this$startDate.equals(other$startDate)) {
					return false;
				}

				return true;
			}
		}
	}

	@Generated
	protected boolean canEqual(final Object other) {
		return other instanceof CourseDetails;
	}

	@Generated
	public String toString() {
		Integer var10000 = this.getCourseId();
		return "CourseDetails(courseId=" + var10000 + ", courseName=" + this.getCourseName() + ", courseMode="
				+ this.getCourseMode() + ", duration=" + this.getDuration() + ", fees=" + this.getFees()
				+ ", startDate=" + this.getStartDate() + ")";
	}
}
