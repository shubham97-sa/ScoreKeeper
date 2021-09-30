package com.lng.consultancy.ttscoreboard.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teamdetail")
public class TeamDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "teamname")
//    @NotEmpty
    @Pattern(regexp = "^[A-Za-z ]*", message = "your team name should only be in characters")
    @Size(min=4 , max = 20)
    private String teamName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "TeamDetail{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
