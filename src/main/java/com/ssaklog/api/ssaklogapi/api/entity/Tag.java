package com.ssaklog.api.ssaklogapi.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "TAG")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagSeq;

    @Column
    private String tagName;

}
