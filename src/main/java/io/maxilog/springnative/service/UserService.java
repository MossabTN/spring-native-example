package io.maxilog.springnative.service;

import io.maxilog.springnative.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDTO save(UserDTO userDTO);

    Page<UserDTO> findAll(Pageable pageable);

    UserDTO findById(Long id);

    void delete(Long id);
}
