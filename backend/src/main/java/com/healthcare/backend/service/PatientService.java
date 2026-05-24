package com.healthcare.backend.service;

import com.healthcare.backend.entity.Patient;
import com.healthcare.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patient) {

        Patient existing = repository.findById(id)
                .orElseThrow();

        existing.setName(patient.getName());
        existing.setAge(patient.getAge());
        existing.setDisease(patient.getDisease());

        return repository.save(existing);
    }

    public void deletePatient(Long id) {
        repository.deleteById(id);
    }
}