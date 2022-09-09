-- 0 - EASY, 1 - MEDIUM, 2 - HARD
-- 0 - ARRAYS, 1 - STRINGS, 2 - STACKS
INSERT INTO TASK (name, content, category, difficulty) VALUES ( 'Pierniki', 'cont1', 1, 0);
INSERT INTO TASK (name, content, category, difficulty) VALUES ( 'Kocury', 'cont2', 2, 2);
INSERT INTO TASK (name, content, category, difficulty) VALUES ( 'Motylki', 'cont3', 1, 1);
INSERT INTO TASK (name, content, category, difficulty) VALUES ( 'Czerwoy Kapturek', 'cont3', 1, 1);
INSERT INTO TASK (name, content, category, difficulty) VALUES ( 'Pazerny Knur', 'cont3', 2, 2);
INSERT INTO TASK (name, content, category, difficulty) VALUES ( 'Redaktor z Niemiec', 'cont3', 0, 0);

INSERT INTO HINT (content, level, task_id) VALUES ('Poszukaj w necie', 1, 3);
INSERT INTO HINT (content, level, task_id) VALUES ('Kup ksiazke', 2, 3);
INSERT INTO HINT (content, level, task_id) VALUES ('Pomysl dluzje', 3, 2);
INSERT INTO HINT (content, level, task_id) VALUES ('Essa', 1, 4);