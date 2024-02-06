package kz.greetgo.xnkqionsbdarpbwmocho.service;

import kz.greetgo.xnkqionsbdarpbwmocho.dto.TelephonyDTO;
import kz.greetgo.xnkqionsbdarpbwmocho.model.TelephonyMongo;
import kz.greetgo.xnkqionsbdarpbwmocho.repository.TelephonyMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelephonyMongoService {
    @Autowired
    private TelephonyMongoRepository telephonyMongoRepository;

    public TelephonyMongo createTelephonyMongo(TelephonyDTO telephonyDTO) {
        TelephonyMongo telephonyMongo = new TelephonyMongo();
        copyDtoToEntity(telephonyDTO, telephonyMongo);
        return telephonyMongoRepository.save(telephonyMongo);
    }

    public Optional<TelephonyMongo> findById(String id) {
        return telephonyMongoRepository.findById(id);
    }

    public Optional<TelephonyMongo> findByPhoneNumber(String phoneNumber) {
        return telephonyMongoRepository.findByPhoneNumber(phoneNumber);
    }

    public void deleteTelephonyMongo(String id) {
        telephonyMongoRepository.deleteById(id);
    }

    public void deleteByPhoneNumber(String phoneNumber) {
        telephonyMongoRepository.deleteByPhoneNumber(phoneNumber);
    }

    public Page<TelephonyMongo> findAllWithFilter(int limit, int offset) {
        return telephonyMongoRepository.findAll(PageRequest.of(offset, limit));
    }

    public Optional<TelephonyMongo> updateTelephonyMongo(String id, TelephonyDTO telephonyDTO) {
        return telephonyMongoRepository.findById(id).map(telephonyMongo -> {
            copyDtoToEntity(telephonyDTO, telephonyMongo);
            return telephonyMongoRepository.save(telephonyMongo);
        });
    }

    private void copyDtoToEntity(TelephonyDTO dto, TelephonyMongo entity) {
        entity.setName(dto.getName());
        entity.setBirthYear(String.valueOf(dto.getBirthYear()));
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setSecondaryPhoneNumber(dto.getSecondaryPhoneNumber());
    }
}
