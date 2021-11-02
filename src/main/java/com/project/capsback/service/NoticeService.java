package com.project.capsback.service;

import com.project.capsback.domain.NoticeRepository;
import com.project.capsback.domain.NoticeRequest;
import com.project.capsback.entity.Notice;
import com.project.capsback.exception.NoticeDeleteException;
import com.project.capsback.exception.NoticeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(final NoticeRepository noticeRepository){ this.noticeRepository=noticeRepository; }

    public Notice save(final NoticeRequest noticeRequest){
        try {
            return noticeRepository.save(noticeRequest.toEntity());
        }
        catch (Exception e){
            throw new NoticeException();
        }
    }

    public void delete(final Long noticeIdx){
        try {
            noticeRepository.deleteById(noticeIdx);
        }
        catch (Exception e){
            throw new NoticeDeleteException();
        }
    }

    public Long update(Long noticeIdx, NoticeRequest noticeRequest) {
        Notice notice = noticeRepository.findById(noticeIdx).orElseThrow(
                () -> new IllegalArgumentException("공지가 존재하지 않습니다..")
        );
        notice.update(noticeRequest);
        return notice.getNoticeIdx();
    }
    public List<Notice> findByAll(){ //모든 공지사항 보기기
       return noticeRepository.findAll();
    }

    public Notice findById(Long noticeIdx){
        return noticeRepository.findByNoticeIdx(noticeIdx);
    }
}
