package com.project.capsback.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeDeleteException extends RuntimeException{
    public static final String NOTICE_DELETE_FAIL_MESSAGE = "공지 삭제에 실패했습니다.";
    private static final Logger log = LoggerFactory.getLogger(NoticeDeleteException.class);

    public NoticeDeleteException() {
        super(NOTICE_DELETE_FAIL_MESSAGE);
        log.error(NOTICE_DELETE_FAIL_MESSAGE);
    }

}
