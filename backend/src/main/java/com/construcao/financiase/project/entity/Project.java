package com.construcao.financiase.project.entity;

import com.construcao.financiase.entity.Auditable;
import com.construcao.financiase.moderation.entity.EvaluationResult;
import com.construcao.financiase.project.enums.Category;
import com.construcao.financiase.project.enums.Status;
import com.construcao.financiase.reward.entity.Reward;
import com.construcao.financiase.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Project extends Auditable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String title;

    @Column(nullable = false)
    private String subtitle;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Double fundraisingGoal;

    @Column
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<Reward> rewards;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private User owner;

    @OneToOne(mappedBy = "project")
    private EvaluationResult evaluation;
}