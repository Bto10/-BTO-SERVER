package bsm.bto.userbet.service.implementation;

import bsm.bto.bet.domain.Bet;
import bsm.bto.bet.domain.repository.BetRepository;
import bsm.bto.bet.presentation.dto.BetInfoResponseDto;
import bsm.bto.user.domain.User;
import bsm.bto.user.domain.repository.UserRepository;
import bsm.bto.userbet.domain.UserBet;
import bsm.bto.userbet.domain.repository.UserBetRepository;
import bsm.bto.userbet.presentation.dto.PlaceUserBetRequestDto;
import bsm.bto.userbet.presentation.dto.UpdateUserBetRequestDto;
import bsm.bto.userbet.presentation.dto.UserBetInfoResponseDto;
import bsm.bto.userbet.service.UserBetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserBetServiceImpl implements UserBetService {

    private final UserBetRepository userBetRepository;
    private final UserRepository userRepository;
    private final BetRepository betRepository;

    @Override
    @Transactional
    public UserBetInfoResponseDto placeUserBet(PlaceUserBetRequestDto placeUserBetRequestDto) {
        User user = userRepository.findById(placeUserBetRequestDto.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Bet bet = betRepository.findById(placeUserBetRequestDto.betId())
                .orElseThrow(() -> new RuntimeException("Bet not found"));

        if (bet.getTeamA().equals(placeUserBetRequestDto.teamC())) {
            bet.addMoney(placeUserBetRequestDto.investment(),"A");
            bet.addPerson(1,"A");
        } else if (bet.getTeamB().equals(placeUserBetRequestDto.teamC())) {
            bet.addMoney(placeUserBetRequestDto.investment(),"B");
            bet.addPerson(1,"B");
        } else {
            throw new RuntimeException("Invalid team selected");
        }

        UserBet userBet = placeUserBetRequestDto.toEntity(user, bet);
        userBetRepository.save(userBet);

        return UserBetInfoResponseDto.toDTO(userBet);
    }

    @Override
    public List<UserBetInfoResponseDto> getUserBetsPlacedByUser(Long userId) {
        return userBetRepository.findAllByUserId(userId).stream()
                .map(UserBetInfoResponseDto::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BetInfoResponseDto> getBetsPlacedByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userBetRepository.findByUser(user).stream()
                .map(UserBet::getBet)
                .map(BetInfoResponseDto::toDto)
                .toList();
    }

    @Override
    public UserBetInfoResponseDto getUserBetInfoByUserBetId(Long userBetId) {
        return userBetRepository.findById(userBetId).stream()
                .map(UserBetInfoResponseDto::toDTO)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("UserBet not found"));
    }

    @Override
    @Transactional
    public UserBetInfoResponseDto updateUserBet(UpdateUserBetRequestDto updateUserBetRequestDto) {
        UserBet userBet = userBetRepository.findById(updateUserBetRequestDto.userBetId())
                .orElseThrow(() -> new RuntimeException("UserBet not found"));
        Bet bet = userBet.getBet();
        if (bet.getTeamA().equals(userBet.getTeamC())) {
            bet.addMoney(-userBet.getInvestment(),"A");
            bet.addPerson(-1,"A");
        }
        else if (bet.getTeamB().equals(userBet.getTeamC())) {
            bet.addMoney(-userBet.getInvestment(),"B");
            bet.addPerson(-1,"B");
        }

        userBet.update(updateUserBetRequestDto.investment(), updateUserBetRequestDto.teamC());

        if (bet.getTeamA().equals(updateUserBetRequestDto.teamC())) {
            bet.addMoney(updateUserBetRequestDto.investment(),"A");
            bet.addPerson(1, "A");
        }
        else if (bet.getTeamB().equals(updateUserBetRequestDto.teamC())) {
            bet.addMoney(updateUserBetRequestDto.investment(),"B");
            bet.addPerson(1, "B");
        }
        else {
            throw new RuntimeException("Invalid team selected");
        }

        return UserBetInfoResponseDto.toDTO(userBet);
    }

    @Override
    @Transactional
    public void deleteUserBet(Long userBetId) {
        UserBet userBet = userBetRepository.findById(userBetId)
                .orElseThrow(() -> new RuntimeException("UserBet not found"));

        Bet bet = userBet.getBet();

        if (bet.getTeamA().equals(userBet.getTeamC())) {
            bet.addMoney(-userBet.getInvestment(), "A");
            bet.addPerson(-1, "A");
        }
        else if (bet.getTeamB().equals(userBet.getTeamC())) {
            bet.addMoney(-userBet.getInvestment(), "B");
            bet.addPerson(-1, "B");
        }

        userBetRepository.deleteById(userBetId);
    }
}
