-- 0 - EASY, 1 - MEDIUM, 2 - HARD
-- 0 - ARRAYS, 1 - STRINGS, 2 - STACKS
INSERT INTO TASK (name, content, category, difficulty, template) VALUES ( 'Pierniki', 'cont1', 1, 0, 'psvm');
INSERT INTO TASK (name, content, category, difficulty, template) VALUES ( 'Kocury', 'cont2', 2, 2, 'class Solution {}');
INSERT INTO TASK (name, content, category, difficulty, template) VALUES ( 'Motylki', 'cont3', 1, 1, 'templatka');
INSERT INTO TASK (name, content, category, difficulty, template) VALUES ( 'Czerwoy Kapturek', 'cont3', 1, 1, 'xd');
INSERT INTO TASK (name, content, category, difficulty, template) VALUES ( 'Pazerny Knur', 'cont3', 2, 2, 'Bandit');
INSERT INTO TASK (name, content, category, difficulty, template) VALUES ( 'Redaktor z Niemiec', 'cont3', 0, 0, 'dsdasd');

INSERT INTO HINT (content, level, task_id) VALUES ('Poszukaj w necie', 1, 3);
INSERT INTO HINT (content, level, task_id) VALUES ('Kup ksiazke', 2, 3);
INSERT INTO HINT (content, level, task_id) VALUES ('Pomysl dluzje', 3, 2);
INSERT INTO HINT (content, level, task_id) VALUES ('Essa', 1, 4);

INSERT INTO USERR (email, points) VALUES ('pelo@gmail.com', 10);
INSERT INTO USERR (email, points) VALUES ('grodzki@o2.pl', 120);

INSERT INTO SOLUTION (submition_date, content, language, task_id, solver_email) VALUES (convert('2012-06-18 10:34:09', DATETIME), 'cont1', 0, 2, 'pelo@gmail.com');
INSERT INTO SOLUTION (submition_date, content, language, task_id, solver_email) VALUES (convert('2014-06-18 08:22:33', DATETIME), 'cont1', 1, 3, 'pelo@gmail.com');
