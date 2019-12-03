package net.yogstation.api.jpa;

import net.yogstation.api.jpa.entity.EarnedAchievementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<EarnedAchievementEntity, String> {
    List<EarnedAchievementEntity> findAllByCkey(String ckey);
}
