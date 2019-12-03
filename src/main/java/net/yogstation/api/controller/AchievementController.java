package net.yogstation.api.controller;

import lombok.AllArgsConstructor;
import net.yogstation.api.controller.http.AchievementResponse;
import net.yogstation.api.jpa.AchievementRepository;
import net.yogstation.api.jpa.entity.EarnedAchievementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class AchievementController {

    private AchievementRepository achievementRepository;

    @GetMapping("/api/v1/player/{ckey}/achievements")
    public List<AchievementResponse> getAchievements(@PathVariable String ckey) {

        List<AchievementResponse> achievementResponses = new ArrayList<>();

        for(EarnedAchievementEntity earnedAchievementEntity : achievementRepository.findAllByCkey(ckey)) {
            achievementResponses.add(new AchievementResponse(earnedAchievementEntity.getAchievement().getName(),
                    earnedAchievementEntity.getAchievement().getDescr()));
        }

        return achievementResponses;
    }
}
