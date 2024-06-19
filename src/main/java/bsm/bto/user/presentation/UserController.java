package bsm.bto.user.presentation;

import bsm.bto.user.presentation.dto.UserInfoResponseDTO;
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
        UserInfoResponseDTO responseDTO = userService.getUserInfo(userId);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/ranks")
    public ResponseEntity<?> getUserRanking(@RequestParam(value = "userId", required = false) Long userId) {
        if (userId == null) {
            return ResponseEntity.ok(userService.getAllUserRankings());
        } else {
            return ResponseEntity.ok(userService.getUserRanking(userId));
        }
    }
}