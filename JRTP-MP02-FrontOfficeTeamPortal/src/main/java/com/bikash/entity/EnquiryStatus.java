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
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FO_Enquiry_Status")
@Getter
@Setter
public class EnquiryStatus {
	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "FO_ENQUIRYSTS_SEQ1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer enquiryId;
	@Column(length = 30)
	private String status;


	@Generated
	public boolean equals(final Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof EnquiryStatus)) {
			return false;
		} else {
			EnquiryStatus other = (EnquiryStatus) o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				Object this$enquiryId = this.getEnquiryId();
				Object other$enquiryId = other.getEnquiryId();
				if (this$enquiryId == null) {
					if (other$enquiryId != null) {
						return false;
					}
				} else if (!this$enquiryId.equals(other$enquiryId)) {
					return false;
				}

				Object this$status = this.getStatus();
				Object other$status = other.getStatus();
				if (this$status == null) {
					if (other$status != null) {
						return false;
					}
				} else if (!this$status.equals(other$status)) {
					return false;
				}

				return true;
			}
		}
	}

	@Generated
	protected boolean canEqual(final Object other) {
		return other instanceof EnquiryStatus;
	}

	@Generated
	public String toString() {
		Integer var10000 = this.getEnquiryId();
		return "EnquiryStatus(enquiryId=" + var10000 + ", status=" + this.getStatus() + ")";
	}
}
