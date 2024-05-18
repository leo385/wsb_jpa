package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    @Transactional
    @Test
    public void PatientShouldRemoveVisitTest() {
        // given
        // when
        patientService.deleteById(3L);
        // then
        assertThat(patientService.findAll().size()).isEqualTo(2);
        final DoctorTO doctorTO = doctorService.findById(3L);
        assertThat(doctorTO.getVisits().size()).isEqualTo(1);
    }

}