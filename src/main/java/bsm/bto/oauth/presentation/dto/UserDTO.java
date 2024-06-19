package bsm.bto.oauth.presentation.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private int grade;
    private int classNumber;
    private int studentNumber;
    private Long money;
    private String name;
}
