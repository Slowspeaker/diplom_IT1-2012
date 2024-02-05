package kz.greetgo.xnkqionsbdarpbwmocho.repository;

import kz.greetgo.xnkqionsbdarpbwmocho.model.Telephony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface TelephonyRepository extends JpaRepository<Telephony, Long> {
    Optional<Telephony> findByPhoneNumber(String phoneNumber);
    void deleteByPhoneNumber(String phoneNumber);
}
