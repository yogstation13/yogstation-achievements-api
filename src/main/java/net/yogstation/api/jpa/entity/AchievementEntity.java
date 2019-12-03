package net.yogstation.api.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "erro_achievements")
public class AchievementEntity {
    @Id
    private int id;
    private String name;
    private String descr;
}
