package kz.greetgo.xnkqionsbdarpbwmocho.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TelephonyDTO {
    private String name;
    private LocalDate birthYear;
    private String phoneNumber;
    private String secondaryPhoneNumber;
}
