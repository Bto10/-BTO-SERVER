package bsm.bto.user.presentation.dto;

import bsm.bto.user.domain.User;

public record UserInfoResponseDTO (
        Long id,
        int grade,
        int classNumber,
        int studentNumber,
        Long money,
        String name
) {
    public static UserInfoResponseDTO toDto(User user) {
        return new UserInfoResponseDTO(
                user.getId(),
                user.getGrade(),
                user.getClassNumber(),
                user.getStudentNumber(),
                user.getMoney(),
                user.getName()
        );
    }
}
