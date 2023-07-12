package com.construcao.financiase.project.repository;

import com.construcao.financiase.project.entity.Project;
import com.construcao.financiase.project.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long>{
    Optional<Project> findByTitle(String title);

    Optional<List<Project>> findByCategory(Category category);
}
