package com.lng.consultancy.ttscoreboard.service;



import com.lng.consultancy.ttscoreboard.model.PlayerDetail;
import com.lng.consultancy.ttscoreboard.model.TeamDetail;
import com.lng.consultancy.ttscoreboard.repository.PlayerDetailRepository;
import com.lng.consultancy.ttscoreboard.repository.TeamDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamDetailImplementation implements TeamDetailService {
@Autowired
 private TeamDetailRepository teamDetailRepository;

@Autowired
private PlayerDetailRepository playerDetailRepository;
    @Override
    public void saveteamDetails(TeamDetail teamDetail) {
        this.teamDetailRepository.save(teamDetail);

    }

    @Override
    public Page<TeamDetail> pagination(int pageNo, int pageSize) {
       Pageable pageable= PageRequest.of(pageNo -1, pageSize);
       return this.teamDetailRepository.findAll(pageable);
    }

    @Override
    public TeamDetail getTeamById(int id) {
        Optional<TeamDetail> optional=teamDetailRepository.findById(id);
        TeamDetail teamDetail=null;
      if(optional.isPresent()){
       teamDetail=optional.get();
      }else {
          throw new RuntimeException(" Team not found for id :: " + id);
      }
        return teamDetail;
    }



    @Override
    public void savePlayerDetails(PlayerDetail playerDetail) {
        this.playerDetailRepository.save(playerDetail);

    }
}
