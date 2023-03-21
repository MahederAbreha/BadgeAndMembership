package miu.edu.adapter;

import miu.edu.domain.Badge;
import miu.edu.dto.BadgeDTO;
import miu.edu.dto.BadgeDTOs;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BadgeDtosAdapter {

    public BadgeDTOs entityToDTO(Badge badge){
        return new BadgeDTOs(badge.getId(), badge.getIsActive());
    }
    public Badge dtoToEntity(BadgeDTOs badgeDTO){
        return new Badge(badgeDTO.getId(), badgeDTO.getIsActive());
    }
    public List<BadgeDTOs> entityToDTOAll(List<Badge> badges){
        return badges.stream().map(badge -> entityToDTO(badge)).collect(Collectors.toList());
    }
    public List<Badge> dtoToEntityAll(List<BadgeDTOs> badgeDTOS){
        return badgeDTOS.stream().map(badgeDTO -> dtoToEntity(badgeDTO)).collect(Collectors.toList());
    }
}
