package bsm.bto.userbet.domain.repository;

import bsm.bto.userbet.domain.UserBet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBetRepository extends JpaRepository<UserBet, Long> {
    List<UserBet> findAllByUserId(Long userId);
}
