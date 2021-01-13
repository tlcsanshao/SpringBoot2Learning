package com.sanshao.logaop.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class SimpleUser implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    private int age;

    private float score;


}
