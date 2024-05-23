package bsm.bto.oauth.presentation.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
