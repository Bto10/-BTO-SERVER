package bsm.bto.around.config;

import bsm.bto.user.domain.User;
import bsm.bto.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataLoaderConfig {

    private final UserRepository userRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            // 더미 데이터 생성
            User user1 = User.builder()
                    .grade(3)
                    .classNumber(1)
                    .studentNumber(10)
                    .money(1000L)
                    .name("John Doe")
                    .build();

            User user2 = User.builder()
                    .grade(2)
                    .classNumber(2)
                    .studentNumber(20)
                    .money(1500L)
                    .name("Jane Smith")
                    .build();

            User user3 = User.builder()
                    .grade(1)
                    .classNumber(3)
                    .studentNumber(30)
                    .money(2000L)
                    .name("Alice Johnson")
                    .build();

            // 더미 데이터 저장
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        };
    }
}
