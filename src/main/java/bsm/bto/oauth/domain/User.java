//사용자 정보를 담는 엔티티 클래스입니다. 데이터베이스의 user 테이블에 매핑됩니다.
package bsm.bto.oauth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int grade;

    private int classNumber;

    private int studentNumber;

    private Long money;

    private String name;

}