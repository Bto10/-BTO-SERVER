package bsm.bto.user.service.implementation;

import bsm.bto.user.domain.User;
import bsm.bto.user.domain.repository.UserRepository;
import bsm.bto.user.presentation.dto.UserInfoResponseDTO;
import bsm.bto.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserInfoResponseDTO getUserInfo(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapUserToResponseDTO(user);
    }

    @Override
    public int getUserRanking(Long userId) {
        return userRepository.findUserRanking(userId);
    }

    private UserInfoResponseDTO mapUserToResponseDTO(User user) {
        UserInfoResponseDTO responseDTO = new UserInfoResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setGrade(user.getGrade());
        responseDTO.setClassNumber(user.getClassNumber());
        responseDTO.setStudentNumber(user.getStudentNumber());
        responseDTO.setMoney(user.getMoney());
        responseDTO.setName(user.getName());
        return responseDTO;
    }
}