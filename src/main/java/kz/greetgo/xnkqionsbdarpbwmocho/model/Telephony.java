package kz.greetgo.xnkqionsbdarpbwmocho.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

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
}
