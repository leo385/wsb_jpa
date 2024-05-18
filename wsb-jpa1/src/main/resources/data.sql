

insert into address (id, city, address_line1, address_line2, postal_code) values
           (1, 'Koszalin', 'Przykładowa 12', '24', '34-123'),
           (2, 'Gdańsk', 'Porządna 7', '14', '51-112'),
           (3, 'Ełk', 'Smaczna 8', '21', '70-151');

insert into doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) values
           (1, 'doctor10', 'Dziecinny@wqe.pl', 'Andrzej', 'Dziecinny', 'pediatra', '12312332', 1),
           (2, 'doctor111', 'wqewq@wqe.pl', 'Kasia', 'Wilk', 'Okulista', '12312332', 2),
           (3, 'doctor231', 'rtwrt@wqe.pl', 'Janusz', 'Marek', 'Urolog', '5422341', 3);

insert into patient (id, age, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id) values
           (1, 23, '2001-01-23', 'bagietson@gmail.com', 'konrad', 'masicki', 'patient312', '12312312', 1),
           (2, 24, '2000-03-23', 'popoqw@gmail.com', 'dawid', 'knabowski', 'patient432', '43143123', 2),
           (3, 25, '1999-05-21', 'wrwerwe@gmail.com', 'paulina', 'chlebek', 'patient523', '5634524', 3);

insert into medical_treatment (id, description, type) values
           (1, 'Bilans 13 latka', 'zwykłe badanie'),
           (2, 'Sprawdzenie ciśnienia w oku', 'standardowe badanie'),
           (3, 'Sprawdzenie wielkości jąder', 'Stwierdzenie powikłań');

insert into visit (id, description, time, doctor_id, medical_treatment_id, patient_id) values
           (1, 'Badanie ogólne', '2024-08-21 9:21:00', 1, 1, 1),
           (2, 'Badanie wzroku', '2024-12-16 12:00:00', 2, 2, 2),
           (3, 'Badanie jąder', '2025-02-13 12:30:00', 3, 3, 3);

--- tabela łącząca
insert into DOCTOR_PATIENT (doctor_id, patient_id) values
           (1, 1),
           (2, 2),
           (3, 3);

insert into DOCTOR_TO_ADDRESS (doctor_id, address_id)
values (1, 1), (2, 2), (3, 3);


--- Znajdz pacjentow po nazwisku
SELECT * FROM patient WHERE last_name = 'chlebek';


--- Znajdz wszystkie wizyty pacjenta po jego ID
SELECT * FROM visit WHERE patient_id = 1;


--- Znajdz pacjentow ktorzy mieli wiecej niz X wizyt (X jest parametrem wejsciowym)
SELECT p.*, COUNT(v.id) AS visits_count
FROM patient p
         JOIN visit v ON p.id = v.patient_id
GROUP BY p.id
HAVING visits_count > 0;


--- Znajdz pacjentow po dodanym przez Ciebie polu - nie wyszukuj wprost po wartosci, uzyj zapytania typu wieksze/mniejsze/pozniej/wczesniej/zawiera, w zaleznosci od wybranego typu zmiennej.
SELECT * FROM patient WHERE age > 25;




