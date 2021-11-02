package com.project.capsback.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticeException extends RuntimeException {
    public static final String NOTICE_SAVE_FAIL_MESSAGE = "공지 등록에 실패했습니다.";
    private static final Logger log = LoggerFactory.getLogger(NoticeException.class);

    public NoticeException() {
        super(NOTICE_SAVE_FAIL_MESSAGE);
        log.error(NOTICE_SAVE_FAIL_MESSAGE);
    }
}
