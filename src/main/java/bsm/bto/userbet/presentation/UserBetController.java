package bsm.bto.userbet.presentation;

import bsm.bto.userbet.presentation.dto.PlaceUserBetRequestDto;
import bsm.bto.userbet.presentation.dto.UpdateUserBetRequestDto;
import bsm.bto.userbet.presentation.dto.UserBetInfoResponseDto;
import bsm.bto.userbet.service.UserBetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userbets")
@RequiredArgsConstructor
public class UserBetController {

    private final UserBetService userBetService;

    @PostMapping
    public ResponseEntity<UserBetInfoResponseDto> placeBet(
            @RequestBody PlaceUserBetRequestDto placeUserBetRequestDto
    ){
        UserBetInfoResponseDto placeBetResponseDto = userBetService.placeUserBet(placeUserBetRequestDto);
        return ResponseEntity.ok(placeBetResponseDto);
    }

    @GetMapping("placed/{user_id}")
    public ResponseEntity<List<UserBetInfoResponseDto>> getBetsPlaced(
            @PathVariable("user_id") Long userId
    ) {
        List<UserBetInfoResponseDto> bets = userBetService.getUserBetsPlacedByUser(userId);
        return ResponseEntity.ok(bets);
    }

    @GetMapping("/{user_bet_id}")
    public ResponseEntity<UserBetInfoResponseDto> getUserBetInfo(
            @PathVariable("user_bet_id") Long userBetId
    ) {
        UserBetInfoResponseDto userBetInfoResponseDto = userBetService.getUserBetInfoByUserBetId(userBetId);
        return ResponseEntity.ok(userBetInfoResponseDto);
    }

    @PutMapping
    public ResponseEntity<UserBetInfoResponseDto> updateUserBet(
            @RequestBody UpdateUserBetRequestDto updateUserBetRequestDto
    ) {
        UserBetInfoResponseDto userBetInfoResponseDto = userBetService.updateUserBet(updateUserBetRequestDto);
        return ResponseEntity.ok(userBetInfoResponseDto);
    }

    @DeleteMapping("/{user_bet_id}")
    public ResponseEntity<Void> deleteUserBet(
            @PathVariable("user_bet_id") Long userBetId
    ) {
        userBetService.deleteUserBet(userBetId);
        return ResponseEntity.noContent().build();
    }
}
