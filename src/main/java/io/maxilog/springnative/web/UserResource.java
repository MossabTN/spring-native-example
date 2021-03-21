package io.maxilog.springnative.web;

import io.maxilog.springnative.service.UserService;
import io.maxilog.springnative.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
        log.debug("REST request to save User : {}", userDTO);
        UserDTO newUser = userService.save(userDTO);
        return ResponseEntity.created(new URI("/api/users/" + newUser.getId())).body(newUser);
    }

    @GetMapping("/users")
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable) {


        final Page<UserDTO> page = userService.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable long id) {
        log.debug("REST request to get User by id: {}", id);
        UserDTO userDTO = userService.findById(id);
        return ResponseEntity.ok(userDTO);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        log.debug("REST request to delete User by id: {}", id);
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}