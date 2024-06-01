package bsm.bto.user.service;

import bsm.bto.user.domain.User;

import java.util.List;

public interface UserService {
    User getUserById(Long userId); // 사용자 ID로 사용자 정보 조회
    List<User> getUsersByMoneyRanking(); // 사용자의 돈에 따른 랭킹 조회
}