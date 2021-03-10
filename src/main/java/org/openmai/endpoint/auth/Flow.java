package org.openmai.endpoint.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

class jsonBody
{
    String username, password;
    String currentPassword , newPassword;
    String otp;
    
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
}


@RestController
public class Flow 
{
    private String envID , flowID;

    private String username , password , otp;

    @GetMapping("/{envID}/flows/{flowID}")
	public String readFlow(@PathVariable String envID , @PathVariable String flowID ) {
        
        if(envID == null || flowID == null || envID == "" || flowID == "")
            return "Invalid Arguments";

		return "Valid Arguments !, It works";
	}

    //  Handler for All Post Requests...
    @PostMapping("/{envID}/flows/{flowID}")
    public String postFlowHandler(@RequestHeader("Content-Type") String contentType , @RequestBody jsonBody body) {
        
        if(contentType.equals(new String("application/vnd.pingidentity.usernamePassword.check+json")))
        {
            return checkUsernamePassword(body.username, body.password);
        }
        else if(contentType.equals(new String("application/vnd.pingidentity.user.lookup+json")))
        {
            return signOnUsername(body.username, body.password);
        }
        else if(contentType.equals(new String("application/vnd.pingidentity.password.reset+json")))
        {
            return resetPassword(body.currentPassword, body.newPassword);
        }
        else if(contentType.equals(new String("application/vnd.pingidentity.otp.check+json")))
        {
            return checkOtp(body.otp);
        }
        else{
            return "Invalid Arguments !";
        }
	}


    String checkUsernamePassword(String username , String password)
    {
        System.out.println(this.username + "-" + this.password);
        if(username == null || password == null)
            return "Invalid Credentials !";

        if(username.equals(this.username) && password.equals(this.password))
            return "Valid Credentials !";
        else
            return "Incorrect Credentials !";
    }

    String signOnUsername(String username , String password)
    {
        if(username == null || password == null)
        {
            return "Invalid Credentials !";
        }
        else
        {
            //  Add a new User...
            this.username = username;
            this.password = password;
            
            System.out.println(this.username + "-" + this.password);
            return "SignOn Success !";
        }        
    }

    String resetPassword(String currentPassword , String newPassword)
    {
        if(currentPassword == null || newPassword == null)
            return "Invalid Credentials !";
        else
        {
            if(this.password.equals(currentPassword))
            {
                this.password = newPassword;
                return "Password Changed !";
            }
            else
                return "Invalid Current password";
        }
    }

    String checkOtp(String otp)
    {
        if(otp == null)
            return "Invalid Data !";
        else
        {
            if(this.otp.equals(otp))
                return "Valid Otp !";
            else
                return "Invalid Otp";
        }
    }



}
