package org.openmai.endpoint.auth;

import java.util.Map;

class flowBody
{
    String username, password , email;
    String currentPassword , newPassword;
    String otp , recoveryCode , verificationCode;
    Map<String, String> address , device;

    // Get & Set Address
    public Map<String, String> getaddress() {
        return this.address;
    }
    public void setaddress(Map<String, String> address) {
        this.address = address;
    }

    // Get & Set Device
    public Map<String, String> getdevice() {
        return this.device;
    }
    public void setdevice(Map<String, String> device) {
        this.device = device;
    }

    // Get & Set username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // Get & Set password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Get & Set currentPassword
    public String getcurrentPassword() {
        return this.currentPassword;
    }
    public void setcurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    // Get & Set New Password
    public String getnewPassword() {
        return this.newPassword;
    }
    public void setnewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    // Get & Set otp
    public String getotp() {
        return this.otp;
    }
    public void setotp(String otp) {
        this.otp = otp;
    }

    // Get & Set RecoveryCode
    public String getrecoveryCode() {
        return this.recoveryCode;
    }
    public void setrecoveryCode(String recoveryCode) {
        this.recoveryCode = recoveryCode;
    }

    // Get & Set Email
    public String getemail() {
        return this.email;
    }
    public void setemail(String email) {
        this.email = email;
    }

    // Get & Set verificationCode
    public String getverificationCode() {
        return this.verificationCode;
    }
    public void setverificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}