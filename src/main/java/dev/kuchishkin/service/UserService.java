package dev.kuchishkin.service;

import dev.kuchishkin.converter.UserEntityConverter;
import dev.kuchishkin.model.User;
import dev.kuchishkin.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserService {

    private final UserEntityConverter userEntityConverter;
    private final UserRepository userRepository;

    public User save(User user) {
        log.info("Save user: login = {}", user.login());
        var entity = userEntityConverter.toEntity(user);
        var savedUser = userRepository.save(entity);
        return userEntityConverter.toModel(savedUser);
    }

    public boolean isUserExistsByLogin(String login) {
        return userRepository.findByLogin(login)
            .isPresent();
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login)
            .map(userEntityConverter::toModel)
            .orElseThrow(() -> new EntityNotFoundException("User wasn't found by login = %s"
                .formatted(login)));
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
            .map(userEntityConverter::toModel)
            .orElseThrow(() -> new EntityNotFoundException("User wasn't found by id = %s"
                .formatted(userId)));
    }
}
