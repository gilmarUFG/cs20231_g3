package com.construcao.financiase.moderation.entity;

import com.construcao.financiase.project.entity.Project;
import com.construcao.financiase.user.entity.Moderator;
import com.construcao.financiase.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class EvaluationResult {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate evaluationDate;

    @Column(nullable = false)
    private String rejectionComment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Moderator moderator;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
