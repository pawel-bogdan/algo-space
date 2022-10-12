# 0 - JAVA 1 - PYTHON 2 - CPP
# 0 - ARRAYS 1 - STRINGS 2 - STACKS
# 0 - EASY 1 - MEDIUM 2 - HARD
create table task (
    id bigint not null auto_increment,
    category integer,
    content varchar(255),
    difficulty integer,
    expected_output varchar(255),
    name varchar(255),
    template varchar(255),
    primary key (id)
    );
create table test (
    id bigint not null auto_increment,
    content varchar(255),
    language integer,
    task_id bigint,
    primary key (id)
    );

INSERT INTO task(category, content, difficulty, expected_output, name, template)
VALUES (1, 'task content', 1, 'expected output', 'test task', 'static String printInput() { }');
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(returnInput("siema"));', 0, 1);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(returnInput("elo"));', 0, 1);
INSERT INTO test(content, language, task_id) VALUES ('print(returnInput("siema"))', 1, 1);
INSERT INTO test(content, language, task_id) VALUES ('print(returnInput("elo"))', 1, 1);
INSERT INTO test(content, language, task_id) VALUES ('cout << returnInput("siema") << endl;', 2, 1);
INSERT INTO test(content, language, task_id) VALUES ('cout << returnInput("elo") << endl;', 2, 1);
