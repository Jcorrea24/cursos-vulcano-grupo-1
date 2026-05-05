package com.grupo1.cursosvulcano.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "class_schedules")
public class ClassSchedule extends BaseEntity {

    @Column
    private Long studentId;

    @Column
    private Long expertId;

    @Column
    private Long courseId;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private String status;

    @Column
    private String notes;
}