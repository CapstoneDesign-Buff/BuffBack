package com.project.capsback.service;

import com.project.capsback.domain.NoticeRequest;
import com.project.capsback.domain.NoticeResponse;
import com.project.capsback.entity.Notice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoticeCreateService {
    private final NoticeService noticeService;

    public NoticeCreateService(final NoticeService noticeService){this.noticeService=noticeService;}

    public NoticeResponse create(NoticeRequest noticeRequest){
        Notice notice=noticeService.save(noticeRequest);
        return NoticeResponse.from(notice);
    }
}
