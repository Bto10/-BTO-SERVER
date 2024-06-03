package bsm.bto.user.service;

import bsm.bto.user.presentation.dto.*;

import java.util.List;

public interface UserService {
    UserInfoResponseDTO getUserInfo(Long userId);
    int getUserRanking(Long userId);
    List<UserInfoResponseDTO> getAllUserRankings();
}