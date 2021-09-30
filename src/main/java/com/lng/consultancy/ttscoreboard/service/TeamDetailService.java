package com.lng.consultancy.ttscoreboard.service;


import com.lng.consultancy.ttscoreboard.model.PlayerDetail;
import com.lng.consultancy.ttscoreboard.model.TeamDetail;
import org.springframework.data.domain.Page;

public interface TeamDetailService {
    void saveteamDetails(TeamDetail teamDetail);
    Page<TeamDetail> pagination(int pageNo, int pageSize);
    TeamDetail getTeamById(int id);
//    PlayerDetail getPlayerById(int id);
    void savePlayerDetails(PlayerDetail playerDetail);

}
