package com.project.capsback.entity;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserVersion implements Serializable{

    @Id
    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updateDate;

    private String userVersion;

    @Builder
    public UserVersion(String userVersion){
        this.userVersion=userVersion;
    }

}