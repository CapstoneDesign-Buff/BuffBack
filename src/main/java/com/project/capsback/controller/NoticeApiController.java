package com.project.capsback.controller;

import com.project.capsback.domain.NoticeRequest;
import com.project.capsback.domain.NoticeResponse;
import com.project.capsback.entity.Notice;
import com.project.capsback.service.NoticeCreateService;
import com.project.capsback.service.NoticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeApiController {
    private final NoticeService noticeService;
    private final NoticeCreateService noticeCreateService;

    public NoticeApiController(final NoticeService noticeService,
                               final NoticeCreateService noticeCreateService){
        this.noticeService=noticeService;
        this.noticeCreateService=noticeCreateService;
    }

    @PostMapping
    public ResponseEntity<NoticeResponse> createNotice(@RequestBody NoticeRequest noticeRequest){
        NoticeResponse noticeResponse=noticeCreateService.create(noticeRequest);
        return ResponseEntity.ok().body(noticeResponse);
    }

    @PutMapping("/{id}")
    public Long updateNotice(@PathVariable Long id,@RequestBody NoticeRequest noticeRequest){
        noticeService.update(id,noticeRequest);
        return id;
    }

    @DeleteMapping("/{id}")
    public Long deleteNotice(@PathVariable Long id){
        noticeService.delete(id);
        return id;
    }

    @GetMapping
    public List<Notice> showAllNotice(){
        return noticeService.findByAll();
    }

    @GetMapping("/{id}")
    public Notice showNotice(@PathVariable Long id){
        return noticeService.findById(id);
    }


}
