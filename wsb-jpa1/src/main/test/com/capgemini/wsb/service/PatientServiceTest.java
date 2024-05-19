package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientServiceImpl patientServiceImpl;


    /* test usuwajacy pacjenta sprawdza czy usuniete zostaly wszystkie wizyty (kaskada) i czy nie zostali usunieci doktorzy */
    @Transactional
    @Test
    public void deletePatientWithVisitsWithoutDoctors() {

        // when
        patientService.deleteById(1L);

        // then
        assertThat(patientService.findAll().size()).isEqualTo(2);

        final DoctorTO doctorTO = doctorService.findById(1L);
        assertThat(doctorTO.getVisits().size()).isEqualTo(1);

    }

    /* pobranie pacjenta po ID powinno zwrocic struktore TO-sow odpowiadajaca wczesniejszym zalozeniom.
    W asercjach sprawdz poprawnosc odczytu dodanego przez Ciebie pola z punktu pierwszego
     */
    @Transactional
    @Test
    public void checkIntegrityWithNewAddedField() {

        // given
        // when
        final Integer age = patientService.findById(1L).getAge();

        // then - Pierwszy pacjent ma 23 lata w bazie - sprawdzanie poprawności pola.
        assertThat(age).isEqualTo(23);

    }


    /* Znajdz wszystkie wizyty pacjenta po jego ID */
    @Transactional
    @Test
    public void testFindAllVisitsByPatientId() {

        // when
        final List<VisitTO> listOfVisits = patientService.findVisitsByPatientId(1L);
        // then
        assertThat(listOfVisits.size()).isEqualTo(1);

    }


}