//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.dto;

import lombok.Generated;

public class AddEnquiryForm {
    private String studentName;
    private String studentMailId;
    private Long studPhoneNumber;
    private String classMode;
    private String courseName;
    private String enquiryStatus;

    @Generated
    public AddEnquiryForm() {
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
    public String getEnquiryStatus() {
        return this.enquiryStatus;
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
    public void setEnquiryStatus(final String enquiryStatus) {
        this.enquiryStatus = enquiryStatus;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AddEnquiryForm)) {
            return false;
        } else {
            AddEnquiryForm other = (AddEnquiryForm)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$studPhoneNumber = this.getStudPhoneNumber();
                Object other$studPhoneNumber = other.getStudPhoneNumber();
                if (this$studPhoneNumber == null) {
                    if (other$studPhoneNumber != null) {
                        return false;
                    }
                } else if (!this$studPhoneNumber.equals(other$studPhoneNumber)) {
                    return false;
                }

                Object this$studentName = this.getStudentName();
                Object other$studentName = other.getStudentName();
                if (this$studentName == null) {
                    if (other$studentName != null) {
                        return false;
                    }
                } else if (!this$studentName.equals(other$studentName)) {
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

                label62: {
                    Object this$classMode = this.getClassMode();
                    Object other$classMode = other.getClassMode();
                    if (this$classMode == null) {
                        if (other$classMode == null) {
                            break label62;
                        }
                    } else if (this$classMode.equals(other$classMode)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$courseName = this.getCourseName();
                    Object other$courseName = other.getCourseName();
                    if (this$courseName == null) {
                        if (other$courseName == null) {
                            break label55;
                        }
                    } else if (this$courseName.equals(other$courseName)) {
                        break label55;
                    }

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

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof AddEnquiryForm;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $studPhoneNumber = this.getStudPhoneNumber();
        result = result * 59 + ($studPhoneNumber == null ? 43 : $studPhoneNumber.hashCode());
        Object $studentName = this.getStudentName();
        result = result * 59 + ($studentName == null ? 43 : $studentName.hashCode());
        Object $studentMailId = this.getStudentMailId();
        result = result * 59 + ($studentMailId == null ? 43 : $studentMailId.hashCode());
        Object $classMode = this.getClassMode();
        result = result * 59 + ($classMode == null ? 43 : $classMode.hashCode());
        Object $courseName = this.getCourseName();
        result = result * 59 + ($courseName == null ? 43 : $courseName.hashCode());
        Object $enquiryStatus = this.getEnquiryStatus();
        result = result * 59 + ($enquiryStatus == null ? 43 : $enquiryStatus.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getStudentName();
        return "AddEnquiryForm(studentName=" + var10000 + ", studentMailId=" + this.getStudentMailId() + ", studPhoneNumber=" + this.getStudPhoneNumber() + ", classMode=" + this.getClassMode() + ", courseName=" + this.getCourseName() + ", enquiryStatus=" + this.getEnquiryStatus() + ")";
    }
}
