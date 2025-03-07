-- INSERT EMPLOYEES (Auto-generate employee_id)
insert into employee (first_name, last_name, email) values ('John', 'Warton', 'warton@gmail.com');
insert into employee (first_name, last_name, email) values ('Mike', 'Lanister', 'lanister@gmail.com');
insert into employee (first_name, last_name, email) values ('Steve', 'Reeves', 'Reeves@gmail.com');
insert into employee (first_name, last_name, email) values ('Ronald', 'Connor', 'connor@gmail.com');
insert into employee (first_name, last_name, email) values ('Jim', 'Salvator', 'Sal@gmail.com');
insert into employee (first_name, last_name, email) values ('Peter', 'Henley', 'henley@gmail.com');
insert into employee (first_name, last_name, email) values ('Richard', 'Carson', 'carson@gmail.com');
insert into employee (first_name, last_name, email) values ('Honor', 'Miles', 'miles@gmail.com');
insert into employee (first_name, last_name, email) values ('Tony', 'Roggers', 'roggers@gmail.com');

-- INSERT PROJECTS (Auto-generate project_id)
insert into project (name, stage, description) values ('Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production');
insert into project (name, stage, description) values ('New Employee Budget', 'COMPLETED', 'Decide on a new employee bonus budget for the year and figure out who will be promoted');
insert into project (name, stage, description) values ('Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to a hurricane in the region. This needs to be reconstructed');
insert into project (name, stage, description) values ('Improve Intranet Security', 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');

-- INSERT PROJECT_EMPLOYEE_RELATION (Dynamically fetch employee_id and project_id)
insert into project_employee (employee_id, project_id) 
values ((SELECT employee_id FROM employee WHERE email = 'warton@gmail.com'), 
        (SELECT project_id FROM project WHERE name = 'Large Production Deploy'));

insert into project_employee (employee_id, project_id) 
values ((SELECT employee_id FROM employee WHERE email = 'warton@gmail.com'), 
        (SELECT project_id FROM project WHERE name = 'New Employee Budget'));

insert into project_employee (employee_id, project_id) 
values ((SELECT employee_id FROM employee WHERE email = 'warton@gmail.com'), 
        (SELECT project_id FROM project WHERE name = 'Office Reconstruction'));

insert into project_employee (employee_id, project_id) 
values ((SELECT employee_id FROM employee WHERE email = 'Reeves@gmail.com'), 
        (SELECT project_id FROM project WHERE name = 'Large Production Deploy'));

insert into project_employee (employee_id, project_id) 
values ((SELECT employee_id FROM employee WHERE email = 'henley@gmail.com'), 
        (SELECT project_id FROM project WHERE name = 'Office Reconstruction'));

insert into project_employee (employee_id, project_id) 
values ((SELECT employee_id FROM employee WHERE email = 'henley@gmail.com'), 
        (SELECT project_id FROM project WHERE name = 'Improve Intranet Security'));
