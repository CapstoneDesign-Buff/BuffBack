package com.project.capsback.entity;

import com.project.capsback.domain.NoticeRequest;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long noticeIdx;

    @Column(nullable = false)
    private Date writeDate;

    @Column(nullable = false,columnDefinition = "varchar(50)")
    private String noticeTitle;

    @Column(nullable = false,columnDefinition = "varchar(5000)")
    private String noticeText;

    @Builder
    public Notice(Date writeDate,String noticeTitle,String noticeText){
        this.writeDate=writeDate;
        this.noticeTitle=noticeTitle;
        this.noticeText=noticeText;
    }

    public void update(NoticeRequest noticeRequest){
        this.noticeTitle=noticeRequest.getNoticeTitle();
        this.noticeText=noticeRequest.getNoticeText();
    }
}
