package dev.nullpanic.messageservice.persist.repository;

import dev.nullpanic.messageservice.persist.model.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long> {
}
