package bsm.bto.user.domain.repository.implementation;

import bsm.bto.user.domain.QUser;
import bsm.bto.user.domain.repository.UserRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public int findUserRanking(Long userId) {
        QUser user = QUser.user;

        // 돈에 따라 내림차순으로 정렬하여 사용자 목록을 가져와 랭킹 계산
        List<Long> userIds = queryFactory
                .select(user.id)
                .from(user)
                .orderBy(user.money.desc())
                .fetch();

        // 사용자 목록에서 해당 사용자의 위치(랭킹)를 반환
        return userIds.indexOf(userId) + 1;
    }
}
