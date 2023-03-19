package miu.edu.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.adapter.BadgeAdapter;
import miu.edu.domain.Badge;
import miu.edu.dto.BadgeDTO;
import miu.edu.repository.BadgeRepository;
import miu.edu.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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
        return badgeAdapter.entityToDTOAll(badgeRepository.findAll());
    }

    @Override
    public BadgeDTO findBadgeById(long id) {
        return badgeAdapter.entityToDTO(badgeRepository.findById(id).get());
    }

    @Override
    public BadgeDTO updateBadge(BadgeDTO badgeDTO) {
        
        return null;
    }

    @Override
    public void MakeBadgeInactive(long id) {

    }
}
