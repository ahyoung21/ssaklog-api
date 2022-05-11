package com.ssaklog.api.ssaklogapi.api.entity;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TAG")
@ApiModel(value = "태그 정보")
public class Tag {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "태그 시퀀스")
    private int tagSeq;

    @Column
    @NotNull
    @ApiModelProperty(value = "태그 명")
    private String tagName;

}
