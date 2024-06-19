package bsm.bto.user.domain.repository;

import bsm.bto.user.domain.User;

import java.util.List;

public interface UserRepositoryCustom {
    int findUserRanking(Long userId);
    List<User> findAllUserRankings();
}
