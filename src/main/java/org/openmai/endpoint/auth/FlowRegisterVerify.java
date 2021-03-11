package org.openmai.endpoint.auth;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.*;

import org.openmai.endpoint.auth.flowBody;

public class FlowRegisterVerify 
{
    private String username , password , otp;

    public String registerUser(String username, String email , String password) {
        return "Initiate Password Recovery !";
    }

    public String sendVerificationCode(String verificationCode) {
        return "Initiate send Verification Code !";
    }

    public String userProfileUpdate(String email , Map<String, String> address)
    {
        address.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());  
        });
        return "Initiate Profile Update";
    }

    public String confirmAccountInfo(String username) {
        return "Initiate confirm Account Info !";
    }

    public String verifyUser(String verificationCode) {
        return "Initiate Verify User !";
    }
}
