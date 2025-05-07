//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.dto;

import com.bikash.entity.UserAccount;
import lombok.Generated;

public class SearchCriteriaForm {
    private UserAccount userAccount;
    private String courseName;
    private String enquiryStatus;
    private String classMode;

    @Generated
    public SearchCriteriaForm() {
    }

    @Generated
    public UserAccount getUserAccount() {
        return this.userAccount;
    }

    @Generated
    public String getCourseName() {
        return this.courseName;
    }

    @Generated
    public String getEnquiryStatus() {
        return this.enquiryStatus;
    }

    @Generated
    public String getClassMode() {
        return this.classMode;
    }

    @Generated
    public void setUserAccount(final UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Generated
    public void setCourseName(final String courseName) {
        this.courseName = courseName;
    }

    @Generated
    public void setEnquiryStatus(final String enquiryStatus) {
        this.enquiryStatus = enquiryStatus;
    }

    @Generated
    public void setClassMode(final String classMode) {
        this.classMode = classMode;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SearchCriteriaForm)) {
            return false;
        } else {
            SearchCriteriaForm other = (SearchCriteriaForm)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$userAccount = this.getUserAccount();
                    Object other$userAccount = other.getUserAccount();
                    if (this$userAccount == null) {
                        if (other$userAccount == null) {
                            break label59;
                        }
                    } else if (this$userAccount.equals(other$userAccount)) {
                        break label59;
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

                Object this$enquiryStatus = this.getEnquiryStatus();
                Object other$enquiryStatus = other.getEnquiryStatus();
                if (this$enquiryStatus == null) {
                    if (other$enquiryStatus != null) {
                        return false;
                    }
                } else if (!this$enquiryStatus.equals(other$enquiryStatus)) {
                    return false;
                }

                Object this$classMode = this.getClassMode();
                Object other$classMode = other.getClassMode();
                if (this$classMode == null) {
                    if (other$classMode != null) {
                        return false;
                    }
                } else if (!this$classMode.equals(other$classMode)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof SearchCriteriaForm;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $userAccount = this.getUserAccount();
        result = result * 59 + ($userAccount == null ? 43 : $userAccount.hashCode());
        Object $courseName = this.getCourseName();
        result = result * 59 + ($courseName == null ? 43 : $courseName.hashCode());
        Object $enquiryStatus = this.getEnquiryStatus();
        result = result * 59 + ($enquiryStatus == null ? 43 : $enquiryStatus.hashCode());
        Object $classMode = this.getClassMode();
        result = result * 59 + ($classMode == null ? 43 : $classMode.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        UserAccount var10000 = this.getUserAccount();
        return "SearchCriteriaForm(userAccount=" + var10000 + ", courseName=" + this.getCourseName() + ", enquiryStatus=" + this.getEnquiryStatus() + ", classMode=" + this.getClassMode() + ")";
    }
}
