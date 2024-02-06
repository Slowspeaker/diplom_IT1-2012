package kz.greetgo.xnkqionsbdarpbwmocho.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Data
public class Telephony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthYear;
    private String phoneNumber;
    private String secondaryPhoneNumber;
    private LocalDate creationDate;

    public Telephony(Long id, String name, LocalDate birthYear, String phoneNumber, String secondaryPhoneNumber, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.phoneNumber = phoneNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.creationDate = creationDate;
    }

    public Telephony() {

    }


}
