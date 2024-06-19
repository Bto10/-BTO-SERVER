//OAuth 토큰 데이터를 관리하기 위한 리포지토리 인터페이스입니다. Spring Data JPA를 사용하여 데이터베이스와의 상호작용을 처리합니다.

package bsm.bto.oauth.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OAuthTokenRepository extends JpaRepository<OAuthToken, Long> {
    Optional<OAuthToken> findByToken(String token);
}
