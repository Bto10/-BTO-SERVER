package bsm.bto.user.presentation;

import bsm.bto.user.presentation.dto.UserInfoRequestDTO;
import bsm.bto.user.presentation.dto.UserInfoResponseDTO;
import bsm.bto.user.presentation.dto.UserRankingRequestDTO;
import bsm.bto.user.presentation.dto.UserRankingResponseDTO;
import bsm.bto.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{user_id}")
    public ResponseEntity<UserInfoResponseDTO> getUserInfo(@PathVariable("user_id") Long userId) {
        UserInfoRequestDTO requestDTO = new UserInfoRequestDTO();
        requestDTO.setUserId(userId);

        UserInfoResponseDTO responseDTO = userService.getUserInfo(requestDTO.getUserId());
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/ranks/{user_id}")
    public ResponseEntity<UserRankingResponseDTO> getUserRanking(@PathVariable("user_id") Long userId) {
        UserRankingRequestDTO requestDTO = new UserRankingRequestDTO();
        requestDTO.setUserId(userId);

        int ranking = userService.getUserRanking(requestDTO.getUserId());
        UserRankingResponseDTO responseDTO = new UserRankingResponseDTO();
        responseDTO.setRanking(ranking);

        return ResponseEntity.ok(responseDTO);
    }
}