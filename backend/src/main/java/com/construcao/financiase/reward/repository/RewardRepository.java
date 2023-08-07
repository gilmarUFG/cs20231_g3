package com.construcao.financiase.reward.repository;

import com.construcao.financiase.project.entity.Project;
import com.construcao.financiase.reward.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RewardRepository extends JpaRepository<Reward, Long> {

    Optional<Reward> findByMinValueAndProject(int value, Project project);
}
