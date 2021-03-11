package org.openmai.endpoint.auth;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.openmai.endpoint.auth.flowBody;

public class FlowForgotPassword 
{
    private String username , password , otp;

    public String recoverPassword(String recoveryCode, String newPassword) {
        return "Initiate Password Recovery !";
    }

    public String sendRecoveryCode() {
        return "Return a Recovery Code ! : 1235125";
    }

    public String forgotPassword(String username) 
    {
        return "Forgot Password needs to be added !";
    }   
}
