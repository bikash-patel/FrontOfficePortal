//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.dto;

import lombok.Generated;

public class SignUpForm {
    private String userName;
    private String mailId;
    private Long phoneNumber;

    @Generated
    public SignUpForm() {
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
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SignUpForm)) {
            return false;
        } else {
            SignUpForm other = (SignUpForm)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$phoneNumber = this.getPhoneNumber();
                    Object other$phoneNumber = other.getPhoneNumber();
                    if (this$phoneNumber == null) {
                        if (other$phoneNumber == null) {
                            break label47;
                        }
                    } else if (this$phoneNumber.equals(other$phoneNumber)) {
                        break label47;
                    }

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

                Object this$mailId = this.getMailId();
                Object other$mailId = other.getMailId();
                if (this$mailId == null) {
                    if (other$mailId != null) {
                        return false;
                    }
                } else if (!this$mailId.equals(other$mailId)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof SignUpForm;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $phoneNumber = this.getPhoneNumber();
        result = result * 59 + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $mailId = this.getMailId();
        result = result * 59 + ($mailId == null ? 43 : $mailId.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getUserName();
        return "SignUpForm(userName=" + var10000 + ", mailId=" + this.getMailId() + ", phoneNumber=" + this.getPhoneNumber() + ")";
    }
}
