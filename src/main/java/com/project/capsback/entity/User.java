package com.project.capsback.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor //기본생성자
public class User {
    public static final String INVALID_PASSWORD_MESSAGE = "비밀번호가 틀렸습니다.";

    @Id
    @Column(nullable = false,columnDefinition = "varchar(20)")
    private String userId;

    @CreationTimestamp
    @Column(nullable = false)
    private Date creationDateTime;

    @Column(nullable = false,columnDefinition = "varchar(20)")
    private String password;

    @Column(nullable = false,columnDefinition = "varchar(13)")
    private String phoneNumber;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private boolean loginStore;

    @Column(nullable = false)
    private boolean alarm;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updateDateTime;

    @Builder
    public User(String userId,String password,String phoneNumber){
        this.userId=userId;
        this.password=password;
        this.phoneNumber=phoneNumber;
    }

    public void update(String password,String phoneNumber){
        this.password=password;
        this.phoneNumber=phoneNumber;
    }

    public void matchPassword(String password) { //비밀번호 확인인
        if (!this.password.equals(password)) {
            throw new IllegalArgumentException(INVALID_PASSWORD_MESSAGE);
        }
    }

    public boolean matchId(Long id) { //아이디 확인
        return (id != null) && (id.equals(getUserId()));
    }

}
