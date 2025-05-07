//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.dto;

import lombok.Generated;

public class DashboardResponse {
    private Integer totalEnquiry;
    private Long enrollStudent;
    private Long lostStudent;

    @Generated
    public DashboardResponse() {
    }

    @Generated
    public Integer getTotalEnquiry() {
        return this.totalEnquiry;
    }

    @Generated
    public Long getEnrollStudent() {
        return this.enrollStudent;
    }

    @Generated
    public Long getLostStudent() {
        return this.lostStudent;
    }

    @Generated
    public void setTotalEnquiry(final Integer totalEnquiry) {
        this.totalEnquiry = totalEnquiry;
    }

    @Generated
    public void setEnrollStudent(final Long enrollStudent) {
        this.enrollStudent = enrollStudent;
    }

    @Generated
    public void setLostStudent(final Long lostStudent) {
        this.lostStudent = lostStudent;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DashboardResponse)) {
            return false;
        } else {
            DashboardResponse other = (DashboardResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$totalEnquiry = this.getTotalEnquiry();
                    Object other$totalEnquiry = other.getTotalEnquiry();
                    if (this$totalEnquiry == null) {
                        if (other$totalEnquiry == null) {
                            break label47;
                        }
                    } else if (this$totalEnquiry.equals(other$totalEnquiry)) {
                        break label47;
                    }

                    return false;
                }

                Object this$enrollStudent = this.getEnrollStudent();
                Object other$enrollStudent = other.getEnrollStudent();
                if (this$enrollStudent == null) {
                    if (other$enrollStudent != null) {
                        return false;
                    }
                } else if (!this$enrollStudent.equals(other$enrollStudent)) {
                    return false;
                }

                Object this$lostStudent = this.getLostStudent();
                Object other$lostStudent = other.getLostStudent();
                if (this$lostStudent == null) {
                    if (other$lostStudent != null) {
                        return false;
                    }
                } else if (!this$lostStudent.equals(other$lostStudent)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof DashboardResponse;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $totalEnquiry = this.getTotalEnquiry();
        result = result * 59 + ($totalEnquiry == null ? 43 : $totalEnquiry.hashCode());
        Object $enrollStudent = this.getEnrollStudent();
        result = result * 59 + ($enrollStudent == null ? 43 : $enrollStudent.hashCode());
        Object $lostStudent = this.getLostStudent();
        result = result * 59 + ($lostStudent == null ? 43 : $lostStudent.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        Integer var10000 = this.getTotalEnquiry();
        return "DashboardResponse(totalEnquiry=" + var10000 + ", enrollStudent=" + this.getEnrollStudent() + ", lostStudent=" + this.getLostStudent() + ")";
    }
}
