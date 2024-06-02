package bsm.bto.user.service;

import bsm.bto.user.presentation.dto.UserInfoResponseDTO;

public interface UserService {
    UserInfoResponseDTO getUserInfo(Long userId);
    int getUserRanking(Long userId);
}