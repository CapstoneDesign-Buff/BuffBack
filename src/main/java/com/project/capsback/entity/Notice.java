package com.project.capsback.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
}
