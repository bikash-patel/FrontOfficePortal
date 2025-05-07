//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.dto;

import lombok.Generated;

public class UnlockAccountForm {
    private String mailId;
    private String temporaryPassword;
    private String newPassword;
    private String confirmPassword;

    @Generated
    public UnlockAccountForm() {
    }

    @Generated
    public String getMailId() {
        return this.mailId;
    }

    @Generated
    public String getTemporaryPassword() {
        return this.temporaryPassword;
    }

    @Generated
    public String getNewPassword() {
        return this.newPassword;
    }

    @Generated
    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    @Generated
    public void setMailId(final String mailId) {
        this.mailId = mailId;
    }

    @Generated
    public void setTemporaryPassword(final String temporaryPassword) {
        this.temporaryPassword = temporaryPassword;
    }

    @Generated
    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

    @Generated
    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UnlockAccountForm)) {
            return false;
        } else {
            UnlockAccountForm other = (UnlockAccountForm)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$mailId = this.getMailId();
                    Object other$mailId = other.getMailId();
                    if (this$mailId == null) {
                        if (other$mailId == null) {
                            break label59;
                        }
                    } else if (this$mailId.equals(other$mailId)) {
                        break label59;
                    }

                    return false;
                }

                Object this$temporaryPassword = this.getTemporaryPassword();
                Object other$temporaryPassword = other.getTemporaryPassword();
                if (this$temporaryPassword == null) {
                    if (other$temporaryPassword != null) {
                        return false;
                    }
                } else if (!this$temporaryPassword.equals(other$temporaryPassword)) {
                    return false;
                }

                Object this$newPassword = this.getNewPassword();
                Object other$newPassword = other.getNewPassword();
                if (this$newPassword == null) {
                    if (other$newPassword != null) {
                        return false;
                    }
                } else if (!this$newPassword.equals(other$newPassword)) {
                    return false;
                }

                Object this$confirmPassword = this.getConfirmPassword();
                Object other$confirmPassword = other.getConfirmPassword();
                if (this$confirmPassword == null) {
                    if (other$confirmPassword != null) {
                        return false;
                    }
                } else if (!this$confirmPassword.equals(other$confirmPassword)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof UnlockAccountForm;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $mailId = this.getMailId();
        result = result * 59 + ($mailId == null ? 43 : $mailId.hashCode());
        Object $temporaryPassword = this.getTemporaryPassword();
        result = result * 59 + ($temporaryPassword == null ? 43 : $temporaryPassword.hashCode());
        Object $newPassword = this.getNewPassword();
        result = result * 59 + ($newPassword == null ? 43 : $newPassword.hashCode());
        Object $confirmPassword = this.getConfirmPassword();
        result = result * 59 + ($confirmPassword == null ? 43 : $confirmPassword.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getMailId();
        return "UnlockAccountForm(mailId=" + var10000 + ", temporaryPassword=" + this.getTemporaryPassword() + ", newPassword=" + this.getNewPassword() + ", confirmPassword=" + this.getConfirmPassword() + ")";
    }
}
