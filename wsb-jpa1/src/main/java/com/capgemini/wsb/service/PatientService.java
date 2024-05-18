package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientService {

    // find operation
    List<PatientTO> findAll();
    PatientTO findById(final Long id);
    List<VisitTO> findVisitsByPatientId(final Long id);

    // delete operation
    Boolean deleteById(final Long id);

}
