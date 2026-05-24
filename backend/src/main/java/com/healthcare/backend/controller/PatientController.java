package com.healthcare.backend.controller;

import com.healthcare.backend.entity.Patient;
import com.healthcare.backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping
    public List<Patient> getPatients() {
        return service.getAllPatients();
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return service.savePatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(
            @PathVariable Long id,
            @RequestBody Patient patient
    ) {
        return service.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
    }
}