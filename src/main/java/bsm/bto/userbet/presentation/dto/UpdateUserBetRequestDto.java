package bsm.bto.userbet.presentation.dto;

public record UpdateUserBetRequestDto(
        Long userBetId,
        Long investment,
        String teamC
) {
}
