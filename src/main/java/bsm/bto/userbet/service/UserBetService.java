package bsm.bto.userbet.service;

import bsm.bto.bet.presentation.dto.BetInfoResponseDto;
import bsm.bto.userbet.presentation.dto.PlaceUserBetRequestDto;
import bsm.bto.userbet.presentation.dto.UpdateUserBetRequestDto;
import bsm.bto.userbet.presentation.dto.UserBetInfoResponseDto;

import java.util.List;

public interface UserBetService {
    UserBetInfoResponseDto placeUserBet(PlaceUserBetRequestDto placeUserBetRequestDTO);
    List<UserBetInfoResponseDto> getUserBetsPlacedByUser(Long userId);
    List<BetInfoResponseDto> getBetsPlacedByUser(Long userId);
    UserBetInfoResponseDto getUserBetInfoByUserBetId(Long userBetId);
    UserBetInfoResponseDto updateUserBet(UpdateUserBetRequestDto updateUserBetRequestDTO);
    void deleteUserBet(Long userBetId);
}
