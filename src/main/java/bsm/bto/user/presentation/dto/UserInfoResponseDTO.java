package bsm.bto.user.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoResponseDTO {
    private Long id;
    private int grade;
    private int classNumber;
    private int studentNumber;
    private Long money;
    private String name;
    // Add other fields if needed
}
