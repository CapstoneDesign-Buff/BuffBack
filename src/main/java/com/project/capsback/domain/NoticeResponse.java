package com.project.capsback.domain;

import com.project.capsback.entity.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeResponse {
    private String noticeTitle;
    private String noticeText;

    @Builder
    public NoticeResponse(final String noticeTitle,final String noticeText){
        this.noticeTitle=noticeTitle;
        this.noticeText=noticeText;
    }

    public static NoticeResponse from(Notice notice){
        NoticeResponse noticeResponse=NoticeResponse.builder()
                .noticeTitle(notice.getNoticeTitle())
                .noticeText(notice.getNoticeText())
                .build();
        return noticeResponse;
    }
}
