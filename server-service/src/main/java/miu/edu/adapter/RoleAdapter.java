package miu.edu.adapter;

import miu.edu.domain.Role;
import miu.edu.dto.RoleDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleAdapter {
    public RoleDTO entityToDTO(Role role){
        return new RoleDTO(role.getId(), role.getRoleType());
    }
    public Role dtoToEntity(RoleDTO roleDTO){
        return new Role(roleDTO.getId(), roleDTO.getRoleType());
    }
    public List<RoleDTO> entityToDTOAll(List<Role> roles){
        return roles.stream().map(role -> entityToDTO(role)).collect(Collectors.toList());
    }
    public List<Role> dtoToEntityAll(List<RoleDTO> roleDTO){
        return roleDTO.stream().map(role -> dtoToEntity(role)).collect(Collectors.toList());
    }
}
