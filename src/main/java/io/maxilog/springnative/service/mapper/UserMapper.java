package io.maxilog.springnative.service.mapper;

import io.maxilog.springnative.domaine.User;
import io.maxilog.springnative.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class UserMapper implements EntityMapper<UserDTO, User> {


    @Override
    public UserDTO toDto(User entity) {
        return new UserDTO(entity);
    }

    @Override
    public List<User> toEntity(List<UserDTO> dtoList) {
        return dtoList.stream()
                .filter(Objects::nonNull)
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> toDto(List<User> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        } else {
            User user = new User();
            user.setId(dto.getId());
            user.setFirstname(dto.getFirstname());
            user.setLastname(dto.getLastname());
            return user;
        }
    }

}
