package bsm.bto.user.service.implementation;

import bsm.bto.user.domain.User;
import bsm.bto.user.domain.repository.UserRepository;
import bsm.bto.user.presentation.dto.*;
import bsm.bto.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserInfoResponseDTO getUserInfo(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserInfoResponseDTO.toDto(user);
    }

    @Override
    public int getUserRanking(Long userId) {
        return userRepository.findUserRanking(userId);
    }

    @Override
    public List<UserInfoResponseDTO> getAllUserRankings() {
        List<User> users = userRepository.findAllUserRankings();
        return users.stream()
                .map(UserInfoResponseDTO::toDto)
                .collect(Collectors.toList());
    }
}
