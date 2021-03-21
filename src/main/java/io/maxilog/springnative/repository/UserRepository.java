package io.maxilog.springnative.repository;

import io.maxilog.springnative.domaine.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
