//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Generated;

@Entity
@Table(name = "FO_Enquiry_Details")
public class EnquiryDetails {
	@Id
	@SequenceGenerator(name = "enq_seq1", sequenceName = "FO_ENQUIRY_SEQ1", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "enq_seq1", strategy = GenerationType.SEQUENCE)
	private Integer enquiryId;
	@Column(length = 30)
	private String studentName;
	@Column(length = 40)
	private String studentMailId;
	private Long studPhoneNumber;
	@Column(length = 30)
	private String classMode;
	@Column(length = 30)
	private String courseName;
	private LocalDate enquiryDate;
	@Column(length = 30)
	private String enquiryStatus;
	@ManyToOne(targetEntity = UserAccount.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "USER_ID", referencedColumnName = "userId")
	private UserAccount userAcccount;

	public String toString() {
		return "EnquiryDetails [enquiryId=" + this.enquiryId + ", studentName=" + this.studentName + ", studentMailId="
				+ this.studentMailId + ", studPhoneNumber=" + this.studPhoneNumber + ", classMode=" + this.classMode
				+ ", courseName=" + this.courseName + ", enquiryStatus=" + this.enquiryStatus + "]";
	}

	@Generated
	public Integer getEnquiryId() {
		return this.enquiryId;
	}

	@Generated
	public String getStudentName() {
		return this.studentName;
	}

	@Generated
	public String getStudentMailId() {
		return this.studentMailId;
	}

	@Generated
	public Long getStudPhoneNumber() {
		return this.studPhoneNumber;
	}

	@Generated
	public String getClassMode() {
		return this.classMode;
	}

	@Generated
	public String getCourseName() {
		return this.courseName;
	}

	@Generated
	public LocalDate getEnquiryDate() {
		return this.enquiryDate;
	}

	@Generated
	public String getEnquiryStatus() {
		return this.enquiryStatus;
	}

	@Generated
	public UserAccount getUserAcccount() {
		return this.userAcccount;
	}

	@Generated
	public void setEnquiryId(final Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	@Generated
	public void setStudentName(final String studentName) {
		this.studentName = studentName;
	}

	@Generated
	public void setStudentMailId(final String studentMailId) {
		this.studentMailId = studentMailId;
	}

	@Generated
	public void setStudPhoneNumber(final Long studPhoneNumber) {
		this.studPhoneNumber = studPhoneNumber;
	}

	@Generated
	public void setClassMode(final String classMode) {
		this.classMode = classMode;
	}

	@Generated
	public void setCourseName(final String courseName) {
		this.courseName = courseName;
	}

	@Generated
	public void setEnquiryDate(final LocalDate enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	@Generated
	public void setEnquiryStatus(final String enquiryStatus) {
		this.enquiryStatus = enquiryStatus;
	}

	@Generated
	public void setUserAcccount(final UserAccount userAcccount) {
		this.userAcccount = userAcccount;
	}

	@Generated
	public boolean equals(final Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof EnquiryDetails)) {
			return false;
		} else {
			EnquiryDetails other = (EnquiryDetails) o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				label119: {
					Object this$enquiryId = this.getEnquiryId();
					Object other$enquiryId = other.getEnquiryId();
					if (this$enquiryId == null) {
						if (other$enquiryId == null) {
							break label119;
						}
					} else if (this$enquiryId.equals(other$enquiryId)) {
						break label119;
					}

					return false;
				}

				Object this$studPhoneNumber = this.getStudPhoneNumber();
				Object other$studPhoneNumber = other.getStudPhoneNumber();
				if (this$studPhoneNumber == null) {
					if (other$studPhoneNumber != null) {
						return false;
					}
				} else if (!this$studPhoneNumber.equals(other$studPhoneNumber)) {
					return false;
				}

				label105: {
					Object this$studentName = this.getStudentName();
					Object other$studentName = other.getStudentName();
					if (this$studentName == null) {
						if (other$studentName == null) {
							break label105;
						}
					} else if (this$studentName.equals(other$studentName)) {
						break label105;
					}

					return false;
				}

				Object this$studentMailId = this.getStudentMailId();
				Object other$studentMailId = other.getStudentMailId();
				if (this$studentMailId == null) {
					if (other$studentMailId != null) {
						return false;
					}
				} else if (!this$studentMailId.equals(other$studentMailId)) {
					return false;
				}

				label91: {
					Object this$classMode = this.getClassMode();
					Object other$classMode = other.getClassMode();
					if (this$classMode == null) {
						if (other$classMode == null) {
							break label91;
						}
					} else if (this$classMode.equals(other$classMode)) {
						break label91;
					}

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

				label77: {
					Object this$enquiryDate = this.getEnquiryDate();
					Object other$enquiryDate = other.getEnquiryDate();
					if (this$enquiryDate == null) {
						if (other$enquiryDate == null) {
							break label77;
						}
					} else if (this$enquiryDate.equals(other$enquiryDate)) {
						break label77;
					}

					return false;
				}

				label70: {
					Object this$enquiryStatus = this.getEnquiryStatus();
					Object other$enquiryStatus = other.getEnquiryStatus();
					if (this$enquiryStatus == null) {
						if (other$enquiryStatus == null) {
							break label70;
						}
					} else if (this$enquiryStatus.equals(other$enquiryStatus)) {
						break label70;
					}

					return false;
				}

				Object this$userAcccount = this.getUserAcccount();
				Object other$userAcccount = other.getUserAcccount();
				if (this$userAcccount == null) {
					if (other$userAcccount != null) {
						return false;
					}
				} else if (!this$userAcccount.equals(other$userAcccount)) {
					return false;
				}

				return true;
			}
		}
	}

	@Generated
	protected boolean canEqual(final Object other) {
		return other instanceof EnquiryDetails;
	}

	@Generated
	public EnquiryDetails(final Integer enquiryId, final String studentName, final String studentMailId,
			final Long studPhoneNumber, final String classMode, final String courseName, final LocalDate enquiryDate,
			final String enquiryStatus, final UserAccount userAcccount) {
		this.enquiryId = enquiryId;
		this.studentName = studentName;
		this.studentMailId = studentMailId;
		this.studPhoneNumber = studPhoneNumber;
		this.classMode = classMode;
		this.courseName = courseName;
		this.enquiryDate = enquiryDate;
		this.enquiryStatus = enquiryStatus;
		this.userAcccount = userAcccount;
	}

	@Generated
	public EnquiryDetails() {
	}
}
