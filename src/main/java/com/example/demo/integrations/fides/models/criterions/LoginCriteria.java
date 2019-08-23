package com.example.demo.integrations.fides.models.criterions;

import lombok.Getter;

@Getter
public class LoginCriteria
{
    private String password;
    private String companyName;
    private Boolean userDetail;

    public LoginCriteria(String password, String companyName, Boolean userDetail)
    {
        this.password = password;
        this.companyName = companyName;
        this.userDetail = userDetail;
    }
}