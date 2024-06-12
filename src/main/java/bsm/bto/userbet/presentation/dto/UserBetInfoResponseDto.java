package bsm.bto.userbet.presentation.dto;

import bsm.bto.userbet.domain.UserBet;
import lombok.Builder;

@Builder
public record UserBetInfoResponseDto(
        Long id,
        Long userId,
        Long betId,
        Long investment,
        String teamC
) {
    public static UserBetInfoResponseDto toDTO(UserBet userBet) {
        return UserBetInfoResponseDto.builder()
                .id(userBet.getId())
                .userId(userBet.getUser().getId())
                .betId(userBet.getBet().getId())
                .investment(userBet.getInvestment())
                .teamC(userBet.getTeamC())
                .build();
    }
}
