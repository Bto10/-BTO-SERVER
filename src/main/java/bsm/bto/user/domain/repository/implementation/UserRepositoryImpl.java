package bsm.bto.user.domain.repository.implementation;

import bsm.bto.user.domain.QUser;
import bsm.bto.user.domain.User;
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

        List<Long> userIds = queryFactory
                .select(user.id)
                .from(user)
                .orderBy(user.money.desc())
                .fetch();

        return userIds.indexOf(userId) + 1;
    }

    @Override
    public List<User> findAllUserRankings() {
        QUser user = QUser.user;

        List<User> users = queryFactory
                .selectFrom(user)
                .orderBy(user.money.desc())
                .fetch();

        return users;
    }
}
