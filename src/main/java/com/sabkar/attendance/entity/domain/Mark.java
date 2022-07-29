package com.sabkar.attendance.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date markDate;
    private boolean isAbsent;
    private Integer studentId;
    private Integer lessonId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reason_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Reason reason;
}