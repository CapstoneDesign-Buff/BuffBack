package com.project.capsback.domain;

import com.project.capsback.entity.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeRequest {
    private String noticeTitle;
    private String noticeText;

    @Builder
    public NoticeRequest(final String noticeTitle,final String noticeText){
        this.noticeTitle=noticeTitle;
        this.noticeText=noticeText;
    }

    public Notice toEntity(){
        return Notice.builder()
                .noticeTitle(noticeTitle)
                .noticeText(noticeText)
                .build();
    }
}
