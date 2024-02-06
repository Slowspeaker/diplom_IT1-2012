package kz.greetgo.xnkqionsbdarpbwmocho.controller;

import kz.greetgo.xnkqionsbdarpbwmocho.dto.TelephonyDTO;
import kz.greetgo.xnkqionsbdarpbwmocho.model.Telephony;
import kz.greetgo.xnkqionsbdarpbwmocho.service.TelephonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/telephony-postgres")
public class TelephonyController {

    @Autowired
    private TelephonyService telephonyService;

    @PostMapping
    public ResponseEntity<Telephony> createTelephony(@RequestBody TelephonyDTO telephonyDTO) {
        Telephony createdTelephony = telephonyService.createTelephony(telephonyDTO);
        return ResponseEntity.ok(createdTelephony);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Telephony> getTelephonyById(@PathVariable Long id) {
        return telephonyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Изменил путь для уникальности и избежания конфликта
    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<Telephony> getTelephonyByPhoneNumber(@PathVariable String phoneNumber) {
        return telephonyService.findByPhoneNumber(phoneNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<Telephony>> getAllTelephony(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Telephony> telephonies = telephonyService.findAllWithFilter(size, page);
        return ResponseEntity.ok(telephonies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Telephony> updateTelephony(@PathVariable Long id, @RequestBody TelephonyDTO telephonyDTO) {
        return telephonyService.updateTelephony(id, telephonyDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelephonyById(@PathVariable Long id) {
        telephonyService.deleteTelephony(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/phone")
    public ResponseEntity<Void> deleteByPhoneNumber(@RequestParam String phoneNumber) {
        telephonyService.deleteByPhoneNumber(phoneNumber);
        return ResponseEntity.ok().build();
    }
}
