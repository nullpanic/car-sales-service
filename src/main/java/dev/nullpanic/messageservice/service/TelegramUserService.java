package dev.nullpanic.messageservice.service;

import dev.nullpanic.messageservice.persist.model.TelegramUser;

import java.util.Optional;

public interface TelegramUserService {
    TelegramUser saveUser(TelegramUser user);

    Optional<TelegramUser> findUser(Long id);
}
