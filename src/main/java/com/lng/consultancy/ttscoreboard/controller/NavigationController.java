package com.lng.consultancy.ttscoreboard.controller;


import com.lng.consultancy.ttscoreboard.model.PlayerDetail;
import com.lng.consultancy.ttscoreboard.model.TeamDetail;
import com.lng.consultancy.ttscoreboard.service.TeamDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NavigationController {
    @Autowired
   private TeamDetailService teamDetailService;
    @GetMapping("/")
    public  String viewHomePage(Model model){

        return  "welcomePage";

    }
    @GetMapping("/Games")
    public String viewGamesPage(Model model){
        return  "games";
    }

    @GetMapping("/ScoreBoard")
    public String viewTableTennisScoreBoardPage(Model model){
        return  "ttScoreKeeper";
    }

    @GetMapping("/Games/tt_landing_page")
    public String viewTableTennisLandingPage(Model model){

        return  "tableTennisLandingPage";
    }


    @GetMapping("/Games/chessScoreboard")
    public String viewChessPage(Model model){
        return  "chessScoreboard";
    }
    @GetMapping("/Games/dartsScoreboard")
    public String viewDartsPage(Model model){
        return  "dartsScoreboard";
    }



    //handle addTeamForm
    @GetMapping("/Games/addTeamForm")
    public String viewTableTennisAddTeamForm(Model model){
        TeamDetail teamDetail=new TeamDetail();
       model.addAttribute("teamdetail",teamDetail);

        return  "addTeamForm";
    }
    //submit table tennis add team form
      @PostMapping("/saveteam")
    public  String saveTeam(@Valid @ModelAttribute("teamdetail") TeamDetail teamDetail, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addTeamForm";
        }else{
            teamDetailService.saveteamDetails(teamDetail);
            return "redirect:/teamlist";

        }

      }
      @GetMapping("/teamlist")
      public String showteamList(Model model){
          return pagination(1,model);

      }

      // for getting teams
    @GetMapping("/teamId/{id}")
    public  String  getTeamList(@PathVariable(value = "id") int id, Model model){
        PlayerDetail playerDetail = new PlayerDetail();
        playerDetail.setTeamId(id);
        model.addAttribute("playerdetail", playerDetail);
        return "addPlayerForm";


    }
    @GetMapping("/page/{pageNo}")
    public String pagination(@PathVariable(value = "pageNo") int pageNo, Model model){
        int pageSize=5;
        Page<TeamDetail> page=teamDetailService.pagination(pageNo,pageSize);
        List<TeamDetail> teamDetailList=page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("teamDetailList", teamDetailList);
        return  "getTeams";
    }


//    @GetMapping("/addPlayer/{id}")
//    public  String addPlayerById(@PathVariable(value = "id") int id, Model model){
////        TeamDetail teamDetail=teamDetailService.getTeamById(id);
////        model.addAttribute("teamdetail",teamDetail);
//
//        return "addPlayerForm";
//    }

    //    Add player for team in table tennis
//    @GetMapping("/addPlayer")
//    public  String addPlayer(Model model){
//        PlayerDetail playerDetail=new PlayerDetail();
//        model.addAttribute("playerdetail",playerDetail);
//        return "addPlayerForm";
//    }
    @PostMapping("/saveplayer")
    public  String savePlayer(@Valid @ModelAttribute("playerdetail") PlayerDetail playerDetail, BindingResult bindingResult){
                    if(bindingResult.hasErrors()){
                        return "addPlayerForm";
                    }else{
                        teamDetailService.savePlayerDetails(playerDetail);
                        return "redirect:/teamlist";

                    }




        }


//        for table tennis score board
    @GetMapping("/select_teams")
    public  String getTableTennisTeams(Model model){
        model.addAttribute("dropdownList",teamDetailService.getTeams());
        model.addAttribute("dropdownListPlayers",teamDetailService.getPlayers());
        return "tableTennisTeamDropdown";
    }

    }


