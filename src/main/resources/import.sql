INSERT INTO role (id, name) VALUES(1, 'Admin');
INSERT INTO role (id, name) VALUES(2, 'Doctor');
INSERT INTO role (id, name) VALUES(3, 'Nurse');

INSERT INTO speciality (id, name) VALUES(1, 'Oncologist');
INSERT INTO speciality (id, name) VALUES(2, 'Orthopedist');
INSERT INTO speciality (id, name) VALUES(3, 'Traumatologist');
INSERT INTO speciality (id, name) VALUES(4, 'Surgeon');
INSERT INTO speciality (id, name) VALUES(5, 'Neurologist');


INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(1, 'Peter', 'Rogers', 2, 1);
INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(2, 'Robert', 'Black', 2, 1);
INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(3, 'Kate', 'Peterson', 2, 2);
INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(4, 'Harry', 'Smith', 2, 3);
INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(5, 'Jhon', 'Williamson', 2, 4);
INSERT INTO staff (id, name, last_name, id_role, id_speciality) VALUES(6, 'Gregory', 'House', 2, 5);

INSERT INTO patient (name, last_name, birth_date, id_doctor) VALUES('Pamela', 'Henderson', '1989-11-23', 6);
INSERT INTO patient (name, last_name, birth_date, id_doctor) VALUES('Richard', 'Nixon', '1975-10-05', 5);
INSERT INTO patient (name, last_name, birth_date, id_doctor) VALUES('Andrew', 'Smith', '2002-05-08', 5);
INSERT INTO patient (name, last_name, birth_date, id_doctor) VALUES('Jhon', 'Mayers', '2000-06-06', 5);
INSERT INTO patient (name, last_name, birth_date, id_doctor) VALUES('Giovani', 'Rogers', '1954-03-15', 1);
INSERT INTO patient (name, last_name, birth_date, id_doctor) VALUES('Luke', 'Skywalker', '1994-02-27',6);
INSERT INTO patient (name, last_name, birth_date, id_doctor) VALUES('Daniel', 'Reiskin', '1989-08-21', 4);
