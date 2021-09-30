package com.lng.consultancy.ttscoreboard.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "matchdetail")
public class MatchDetail {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
@Column(name = "teamoneid")
 private int teamOneId;
@Column(name = "teamtwoid")
 private int teamTwoId;

@Column(name = "date")
private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamOneId() {
        return teamOneId;
    }

    public void setTeamOneId(int teamOneId) {
        this.teamOneId = teamOneId;
    }

    public int getTeamTwoId() {
        return teamTwoId;
    }

    public void setTeamTwoId(int teamTwoId) {
        this.teamTwoId = teamTwoId;
    }

    @Override
    public String toString() {
        return "MatchDetail{" +
                "id=" + id +
                ", teamOneId=" + teamOneId +
                ", teamTwoId=" + teamTwoId +
                '}';
    }
}
