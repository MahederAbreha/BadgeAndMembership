package miu.edu.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.adapter.BadgeAdapter;
import miu.edu.domain.Badge;
import miu.edu.domain.Member;
import miu.edu.dto.BadgeDTO;
import miu.edu.repository.BadgeRepository;
import miu.edu.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BadgeServiceImpl implements BadgeService {

    @Autowired
    private final BadgeRepository badgeRepository;

    @Autowired
    private final BadgeAdapter badgeAdapter;

    @Override
    public BadgeDTO addBadge(BadgeDTO badgeDTO) {
        Badge badge = badgeAdapter.DtoToEntity(badgeDTO);
        badgeRepository.save(badge);
        return badgeAdapter.entityToDTO(badge);
    }

    @Override
    public List<BadgeDTO> findAllBadges() {
        try {
            return badgeAdapter.entityToDTOAll(badgeRepository.findAll());
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to retrieve badges");
        }
    }

    @Override
    public BadgeDTO findBadgeById(long id) {
        try{
            Optional<Badge> badge = badgeRepository.findById(id);
            if (!badge.isPresent()) {
                throw new RuntimeException("Badge not found");
            } else {
                return badgeAdapter.entityToDTO(badge.get());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to retrieve badge");
        }
    }

    @Override
    public BadgeDTO updateBadge(long id, BadgeDTO badgeDTO) {
        try {
            Badge badge = badgeRepository.findById(id).orElseThrow(() -> new RuntimeException("Badge not found"));
            Badge updatedBadge = badgeAdapter.DtoToEntity(badgeDTO);
            updatedBadge.setIsActive(badge.getIsActive());
            badgeRepository.save(updatedBadge);
            return badgeAdapter.entityToDTO(updatedBadge);
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to update badge");
        }

    }

    @Override
    public void MakeBadgeInactive(long id) {
        try {
            Badge badge = badgeRepository.findById(id).orElseThrow(() -> new RuntimeException("Badge not found"));
            badge.setIsActive(false);
            badgeRepository.save(badge);
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to update badge");
        }
    }

}
