package bsm.bto.userbet.domain.repository;

import bsm.bto.userbet.domain.UserBet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBetRepository extends JpaRepository<UserBet, Long> {
}
