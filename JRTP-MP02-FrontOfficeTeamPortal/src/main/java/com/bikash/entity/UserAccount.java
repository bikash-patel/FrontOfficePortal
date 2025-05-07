//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Generated;

@Entity
@Table(name = "FO_User_Account_Details")
public class UserAccount {
	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "FO_UA_SEQ1", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer userId;
	@Column(length = 30)
	private String userName;
	@Column(length = 40)
	private String mailId;
	private Long phoneNumber;
	@Column(length = 30)
	private String password;
	@Column(length = 30)
	private String accountStatus;
	@OneToMany(targetEntity = EnquiryDetails.class, cascade = {
			CascadeType.ALL }, mappedBy = "userAcccount", orphanRemoval = true, fetch = FetchType.EAGER)
	List<EnquiryDetails> enquiry;

	public String toString() {
		return "UserAccount [userId=" + this.userId + ", userName=" + this.userName + ", mailId=" + this.mailId
				+ ", phoneNumber=" + this.phoneNumber + ", password=" + this.password + ", accountStatus="
				+ this.accountStatus + "]";
	}

	@Generated
	public UserAccount() {
	}

	@Generated
	public Integer getUserId() {
		return this.userId;
	}

	@Generated
	public String getUserName() {
		return this.userName;
	}

	@Generated
	public String getMailId() {
		return this.mailId;
	}

	@Generated
	public Long getPhoneNumber() {
		return this.phoneNumber;
	}

	@Generated
	public String getPassword() {
		return this.password;
	}

	@Generated
	public String getAccountStatus() {
		return this.accountStatus;
	}

	@Generated
	public List<EnquiryDetails> getEnquiry() {
		return this.enquiry;
	}

	@Generated
	public void setUserId(final Integer userId) {
		this.userId = userId;
	}

	@Generated
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	@Generated
	public void setMailId(final String mailId) {
		this.mailId = mailId;
	}

	@Generated
	public void setPhoneNumber(final Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Generated
	public void setPassword(final String password) {
		this.password = password;
	}

	@Generated
	public void setAccountStatus(final String accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Generated
	public void setEnquiry(final List<EnquiryDetails> enquiry) {
		this.enquiry = enquiry;
	}

	@Generated
	public boolean equals(final Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof UserAccount)) {
			return false;
		} else {
			UserAccount other = (UserAccount) o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				label95: {
					Object this$userId = this.getUserId();
					Object other$userId = other.getUserId();
					if (this$userId == null) {
						if (other$userId == null) {
							break label95;
						}
					} else if (this$userId.equals(other$userId)) {
						break label95;
					}

					return false;
				}

				Object this$phoneNumber = this.getPhoneNumber();
				Object other$phoneNumber = other.getPhoneNumber();
				if (this$phoneNumber == null) {
					if (other$phoneNumber != null) {
						return false;
					}
				} else if (!this$phoneNumber.equals(other$phoneNumber)) {
					return false;
				}

				Object this$userName = this.getUserName();
				Object other$userName = other.getUserName();
				if (this$userName == null) {
					if (other$userName != null) {
						return false;
					}
				} else if (!this$userName.equals(other$userName)) {
					return false;
				}

				label74: {
					Object this$mailId = this.getMailId();
					Object other$mailId = other.getMailId();
					if (this$mailId == null) {
						if (other$mailId == null) {
							break label74;
						}
					} else if (this$mailId.equals(other$mailId)) {
						break label74;
					}

					return false;
				}

				label67: {
					Object this$password = this.getPassword();
					Object other$password = other.getPassword();
					if (this$password == null) {
						if (other$password == null) {
							break label67;
						}
					} else if (this$password.equals(other$password)) {
						break label67;
					}

					return false;
				}

				Object this$accountStatus = this.getAccountStatus();
				Object other$accountStatus = other.getAccountStatus();
				if (this$accountStatus == null) {
					if (other$accountStatus != null) {
						return false;
					}
				} else if (!this$accountStatus.equals(other$accountStatus)) {
					return false;
				}

				Object this$enquiry = this.getEnquiry();
				Object other$enquiry = other.getEnquiry();
				if (this$enquiry == null) {
					if (other$enquiry != null) {
						return false;
					}
				} else if (!this$enquiry.equals(other$enquiry)) {
					return false;
				}

				return true;
			}
		}
	}

	@Generated
	protected boolean canEqual(final Object other) {
		return other instanceof UserAccount;
	}
}
