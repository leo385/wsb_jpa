package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService {

    // find operation
    PatientTO findById(final Long id);

    List<PatientTO> findAll();
    List<VisitTO> findVisitsByPatientId(final Long id);

    // delete operation
    void deleteById(final Long id);

}
