package com.project.capsback.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrvVersion {
    @Id
    @Column(nullable = false,columnDefinition = "varchar(20)")
    private String version;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date updateDate;
}
