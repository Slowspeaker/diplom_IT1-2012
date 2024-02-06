package kz.greetgo.xnkqionsbdarpbwmocho.service;

import kz.greetgo.xnkqionsbdarpbwmocho.dto.TelephonyDTO;
import kz.greetgo.xnkqionsbdarpbwmocho.model.Telephony;
import kz.greetgo.xnkqionsbdarpbwmocho.repository.TelephonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelephonyService {
    @Autowired
    private TelephonyRepository telephonyRepository;

    public Telephony createTelephony(TelephonyDTO telephonyDTO) {
        Telephony telephony = new Telephony();
        copyDtoToEntity(telephonyDTO, telephony);
        return telephonyRepository.save(telephony);
    }

    public Optional<Telephony> findById(Long id) {
        return telephonyRepository.findById(id);
    }

    public Optional<Telephony> findByPhoneNumber(String phoneNumber) {
        return telephonyRepository.findByPhoneNumber(phoneNumber);
    }

    public void deleteTelephony(Long id) {
        telephonyRepository.deleteById(id);
    }

    public void deleteByPhoneNumber(String phoneNumber) {
        telephonyRepository.deleteByPhoneNumber(phoneNumber);
    }

    public Page<Telephony> findAllWithFilter(int limit, int offset) {
        return telephonyRepository.findAll(PageRequest.of(offset, limit));
    }

    public Optional<Telephony> updateTelephony(Long id, TelephonyDTO telephonyDTO) {
        return telephonyRepository.findById(id).map(telephony -> {
            copyDtoToEntity(telephonyDTO, telephony);
            return telephonyRepository.save(telephony);
        });
    }

    private void copyDtoToEntity(TelephonyDTO dto, Telephony entity) {
        entity.setName(dto.getName());
        entity.setBirthYear(dto.getBirthYear());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setSecondaryPhoneNumber(dto.getSecondaryPhoneNumber());
    }
}
