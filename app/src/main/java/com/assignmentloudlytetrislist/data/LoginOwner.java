//Data class used to get the value of login name from inside JSON object of main JSON

package com.assignmentloudlytetrislist.data;

import com.google.gson.annotations.SerializedName;

public class LoginOwner {
    @SerializedName("login")
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
