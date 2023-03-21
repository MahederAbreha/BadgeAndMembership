package miu.edu.service;

import miu.edu.dto.BadgeDTO;

import java.util.List;

public interface BadgeService {

    BadgeDTO addBadge(BadgeDTO badgeDTO);
    List<BadgeDTO> findAllBadges();
    BadgeDTO findBadgeById(long id);
    BadgeDTO updateBadge(long id, BadgeDTO badgeDTO);
    void MakeBadgeInactive(long id);
}
