package com.spring.CloudScale.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class userCreation {

    @Id
    @NotNull
    private long custid;

    @NotNull
    private String cust_name;
}
