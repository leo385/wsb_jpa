package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.repository.PatientRepository;
import com.capgemini.wsb.service.PatientService;


import java.util.List;
import java.util.stream.Collectors;

public class PatientServiceImpl implements PatientService {


    private PatientRepository patientRepository;

    @Override
    public PatientTO findById(Long id) {
        return null;
    }

    @Override
    public List<PatientTO> findAll() {
        return patientRepository.findAll().stream()
                .map(PatientMapper::mapToTO)
                .collect(Collectors.toList());
    }

}
