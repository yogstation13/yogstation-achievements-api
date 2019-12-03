package net.yogstation.api.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "erro_earned_achievements")
public class EarnedAchievementEntity {
    @Id
    private String ckey;

    @ManyToOne
    @JoinColumn(name = "id")
    private AchievementEntity achievement;
}
