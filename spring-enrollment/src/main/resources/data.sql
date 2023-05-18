INSERT INTO subjects (name, description) VALUES ('CHEM1', 'General Chemistry');
INSERT INTO subjects (name, description) VALUES ('BIO1', 'General Biology');
INSERT INTO subjects (name, description) VALUES ('PROG1', 'Intro to Programming');

INSERT INTO users (firstname, lastname, email) VALUES ('John', 'Doe', 'jdoe@email.com');
INSERT INTO teachers (position, user_id) VALUES ('PROF1', 1);

INSERT INTO users (firstname, lastname, email) VALUES ('Alex', 'Smith', 'a.smith@email.com');
INSERT INTO students (year_level, program, user_id) VALUES (1, 'BSCS', 2);

INSERT INTO users (firstname, lastname, email) VALUES ('Tom', 'Jerry', 'tjerry@email.com');
INSERT INTO students (year_level, program, user_id) VALUES (1, 'BSCS', 3);

INSERT INTO users (firstname, lastname, email) VALUES ('Ben', 'White', 'bwhite@email.com');
INSERT INTO students (year_level, program, user_id) VALUES (1, 'BSCS', 4);

INSERT INTO users (firstname, lastname, email) VALUES ('Rob', 'Holding', 'rholding@email.com');
INSERT INTO students (year_level, program, user_id) VALUES (1, 'BSCS', 5);

INSERT INTO users (firstname, lastname, email) VALUES ('Keith', 'Harris', 'k.harris@email.com');
INSERT INTO students (year_level, program, user_id) VALUES (1, 'BSCS', 6);

INSERT INTO classes (subject_id, teacher_id, schedule, time) VALUES (1, 1, 'MWF', '10:00am to 11:00am');
INSERT INTO student_classes (classes_id, student_id) VALUES (1, 1);