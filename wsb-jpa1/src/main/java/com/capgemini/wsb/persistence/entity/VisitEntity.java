package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;


	/* Relacja dwustronna, wiele do jednego */
	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private DoctorEntity doctor;

	/* Relacja dwustronna, wiele do jednego */
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private PatientEntity patient;

	/* Relacja jednostronna ze strony Visit, jeden do jednego */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "medical_treatment_id", referencedColumnName = "id")
	private MedicalTreatmentEntity medicalTreatment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
