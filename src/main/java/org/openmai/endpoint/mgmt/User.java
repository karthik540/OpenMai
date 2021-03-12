package org.openmai.endpoint.mgmt;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import org.json.HTTP;
import org.json.JSONObject;
import org.openmai.endpoint.RequestFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class User {

    @PostMapping("/environments/{envID}/users")
    public String postUserHandler(HttpServletRequest request) {

        RequestFormat requestObj = new RequestFormat(request);

        System.out.println(requestObj.body.getString("email"));

        return "Endpoint works !";
    }

}
