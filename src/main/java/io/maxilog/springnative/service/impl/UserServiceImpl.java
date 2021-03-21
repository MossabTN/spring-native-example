package io.maxilog.springnative.service.impl;

import io.maxilog.springnative.domaine.User;
import io.maxilog.springnative.repository.UserRepository;
import io.maxilog.springnative.service.UserService;
import io.maxilog.springnative.service.dto.UserDTO;
import io.maxilog.springnative.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Request to save User : {}", userDTO);
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Users");
        return userRepository.findAll(pageable)
                .map(userMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        log.debug("Request to get User : {}", id);
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete User : {}", id);
        userRepository.deleteById(id);
    }
}
