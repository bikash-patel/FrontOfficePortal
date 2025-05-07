//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.dto;

import lombok.Generated;

public class LoginForm {
    private String userName;
    private String password;

    @Generated
    public LoginForm() {
    }

    @Generated
    public String getUserName() {
        return this.userName;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    @Generated
    public void setPassword(final String password) {
        this.password = password;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof LoginForm)) {
            return false;
        } else {
            LoginForm other = (LoginForm)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$userName = this.getUserName();
                Object other$userName = other.getUserName();
                if (this$userName == null) {
                    if (other$userName != null) {
                        return false;
                    }
                } else if (!this$userName.equals(other$userName)) {
                    return false;
                }

                Object this$password = this.getPassword();
                Object other$password = other.getPassword();
                if (this$password == null) {
                    if (other$password != null) {
                        return false;
                    }
                } else if (!this$password.equals(other$password)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof LoginForm;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $userName = this.getUserName();
        result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
        Object $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getUserName();
        return "LoginForm(userName=" + var10000 + ", password=" + this.getPassword() + ")";
    }
}
