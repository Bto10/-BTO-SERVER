package bsm.bto.user.domain;

import bsm.bto.user.exception.InvalidAmountException;
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

    public void addMoney(Long amount) {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid Amount");
        }
        this.money += amount;
    }

    public void subtractMoney(Long amount) {
        if (amount < 0 || this.money < amount) {
            throw new InvalidAmountException("Invalid Amount");
        }
        this.money -= amount;
    }

}
