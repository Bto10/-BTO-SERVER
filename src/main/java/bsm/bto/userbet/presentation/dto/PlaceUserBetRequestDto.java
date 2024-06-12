package bsm.bto.userbet.presentation.dto;

import bsm.bto.bet.domain.Bet;
import bsm.bto.user.domain.User;
import bsm.bto.userbet.domain.UserBet;

public record PlaceUserBetRequestDto(
        Long userId,
        Long betId,
        Long investment,
        String teamC
) {
    public UserBet toEntity(User user, Bet bet){
        return UserBet.builder()
                .user(user)
                .bet(bet)
                .investment(investment)
                .teamC(teamC)
                .build();
    }
}
