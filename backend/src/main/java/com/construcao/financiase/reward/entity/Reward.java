package com.construcao.financiase.reward.entity;

import com.construcao.financiase.entity.Auditable;
import com.construcao.financiase.project.entity.Project;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Reward extends Auditable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate expectedDeliveryDate;

    @Column(nullable = false)
    private Integer minValue;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Project project;

}
