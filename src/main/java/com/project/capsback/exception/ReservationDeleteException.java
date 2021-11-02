package com.project.capsback.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReservationDeleteException extends RuntimeException{
    public static final String RESERVATION_DELETE_FAIL_MESSAGE = "예약 삭제에 실패했습니다.";
    private static final Logger log = LoggerFactory.getLogger(ReservationDeleteException.class);

    public ReservationDeleteException() {
        super(RESERVATION_DELETE_FAIL_MESSAGE);
        log.error(RESERVATION_DELETE_FAIL_MESSAGE);
    }

}
