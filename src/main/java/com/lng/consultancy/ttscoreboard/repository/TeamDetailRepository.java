package com.lng.consultancy.ttscoreboard.repository;

import com.lng.consultancy.ttscoreboard.model.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDetailRepository extends JpaRepository<TeamDetail, Integer> {
}
