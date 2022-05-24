package com.ssaklog.api.ssaklogapi.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@Table(name = "USER")
@ApiModel(value = "회원")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userSeq")
    @ApiModelProperty(value = "회원 번호")
    private int userSeq;

    @Column(name = "userId")
    @ApiModelProperty(value = "회원 아이디")
    private String userId;

    @Column(name = "userName")
    @ApiModelProperty(value = "회원명")
    private String userName;

    @Column(name = "passWord")
    @ApiModelProperty(value = "비밀번호")
    private String password;

    @Column(name = "levelType") // TODO : shlee - levelTypeEnum 생성 필요
    @ApiModelProperty(value = "레벨")
    private String levelType;

    @Column(name = "email")
    @ApiModelProperty(value = "이메일")
    private String email;

    @Column(name = "birthDate")
    @ApiModelProperty(value = "생년월일")
    private LocalDateTime birthDate;

    @Column(name = "profileUrl")
    @ApiModelProperty(value = "프로필 url")
    private String profileUrl;

    @Column(name = "withdrawYn")
    @ApiModelProperty(value = "탈퇴 여부")
    private String withdrawYn;

    @Column(name = "dormantYn")
    @ApiModelProperty(value = "휴면 여부")
    private String dormantYn;

    @Column(name = "joinDate")
    @ApiModelProperty(value = "가입")
    private LocalDateTime joinDate;

}
