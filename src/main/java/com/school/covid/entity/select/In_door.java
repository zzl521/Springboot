package com.school.covid.entity.select;

import lombok.Data;

import java.io.Serializable;

@Data
public class In_door implements Serializable {
    private String temp;
    private String place;
}
