package com.project.capsback.entity;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Login implements Serializable{

    @Id
    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

    @UpdateTimestamp
    private Date loinDate;

    @Column(nullable = false)
    private String loinIp;

}
