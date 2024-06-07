//사용자 데이터를 관리하기 위한 리포지토리 인터페이스입니다. Spring Data JPA를 사용하여 데이터베이스와의 상호작용을 처리합니다.

package bsm.bto.oauth.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
