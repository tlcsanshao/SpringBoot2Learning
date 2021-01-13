package com.sanshao.basicweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    public long classid;
    public long studentid;
    public int age;
    public List<String> inters;


}
