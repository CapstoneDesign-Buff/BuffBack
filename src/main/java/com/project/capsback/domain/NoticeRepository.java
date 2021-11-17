package com.project.capsback.domain;

import com.project.capsback.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long> {
    Notice findByNoticeIdx(Long id);
}
