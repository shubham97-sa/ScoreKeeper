package com.lng.consultancy.ttscoreboard.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "playerdetail")
public class PlayerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;
    @Column(name = "teamid")
       private int teamId;
    @Column(name = "playername")
    @Pattern(regexp = "^[A-Za-z ]*", message = "player name should only be in characters")
    @Size(min=4 , max = 20)
       private String playerName;

    @Override
    public String toString() {
        return "PlayerDetail{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", playerName='" + playerName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
