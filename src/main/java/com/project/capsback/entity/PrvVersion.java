package com.project.capsback.entity;

import lombok.*;
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

    @Builder
    public PrvVersion(String version,Date updateDate){
        this.version=version;
        this.updateDate=updateDate;
    }

}
