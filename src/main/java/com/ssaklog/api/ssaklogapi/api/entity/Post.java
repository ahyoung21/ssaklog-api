package com.ssaklog.api.ssaklogapi.api.entity;

import com.ssaklog.api.ssaklogapi.api.enums.DeleteYnEnum;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "POST")
@ApiModel(value = "게시글 정보")
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "게시글 시퀀스")
    private int postSeq;

    @Column
    @NotNull
    @ApiModelProperty(value = "유저 시퀀스")
    private int userSeq;

    @Column
    @NotNull
    @ApiModelProperty(value = "제목")
    private String title;

    @Column
    @NotNull
    @ApiModelProperty(value = "본문")
    private String contents;

    @Column
    @NotNull
    @ApiModelProperty(value = "조회수")
    private int viewCount;

    @Column
    @NotNull
    @ApiModelProperty(value = "삭제여부")
    private String deleteYn;

    @CreatedDate
    @Column(updatable = false)
    @ApiModelProperty(value = "등록일시")
    private LocalDateTime registerDate;

    @LastModifiedDate
    @Column
    @ApiModelProperty(value = "수정일시")
    private LocalDateTime updateDate;

    @Builder
    public Post(int userSeq, String title, String contents, int viewCount, String deleteYn) {
        this.userSeq = userSeq;
        this.title = title;
        this.contents = contents;
        this.viewCount = viewCount;
        this.deleteYn = deleteYn;
        this.registerDate = LocalDateTime.now();
    }

    public void modify(String title, String contents) {
        this.title = title;
        this.contents = contents;
        this.updateDate = LocalDateTime.now();
    }

    public void remove() {
        this.deleteYn = DeleteYnEnum.Y.getCode();
        this.updateDate = LocalDateTime.now();
    }
}
