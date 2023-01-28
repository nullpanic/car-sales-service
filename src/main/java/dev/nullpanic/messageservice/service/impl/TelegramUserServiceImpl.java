package dev.nullpanic.messageservice.service.impl;

import dev.nullpanic.messageservice.persist.model.TelegramUser;
import dev.nullpanic.messageservice.persist.repository.TelegramUserRepository;
import dev.nullpanic.messageservice.service.TelegramUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TelegramUserServiceImpl implements TelegramUserService {

    private final TelegramUserRepository telegramUserRepository;

    @Override
    @Transactional
    public TelegramUser saveUser(TelegramUser user) {
        return telegramUserRepository.save(user);
    }

    @Override
    public Optional<TelegramUser> findUser(Long id) {
        return telegramUserRepository.findById(id);
    }
}
