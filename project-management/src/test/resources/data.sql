TRUNCATE TABLE project_employee RESTART IDENTITY;
TRUNCATE TABLE employee RESTART IDENTITY CASCADE;
TRUNCATE TABLE project RESTART IDENTITY CASCADE;

ALTER SEQUENCE employee_seq RESTART WITH 1;
ALTER SEQUENCE project_seq RESTART WITH 1;

INSERT INTO employee (employee_id, first_name, last_name, email)
VALUES 
    (nextval('employee_seq'), 'Alice', 'Johnson', 'alice.johnson@example.com'),
    (nextval('employee_seq'), 'Bob', 'Smith', 'bob.smith@example.com'),
    (nextval('employee_seq'), 'Charlie', 'Brown', 'charlie.brown@example.com'),
    (nextval('employee_seq'), 'Diana', 'Prince', 'diana.prince@example.com'),
    (nextval('employee_seq'), 'Ethan', 'Hunt', 'ethan.hunt@example.com'),
    (nextval('employee_seq'), 'Fiona', 'Gallagher', 'fiona.gallagher@example.com'),
    (nextval('employee_seq'), 'George', 'Miller', 'george.miller@example.com'),
    (nextval('employee_seq'), 'Hannah', 'Baker', 'hannah.baker@example.com'),
    (nextval('employee_seq'), 'Isaac', 'Newton', 'isaac.newton@example.com'),
    (nextval('employee_seq'), 'Julia', 'Roberts', 'julia.roberts@example.com');

INSERT INTO project (project_id, name, stage, description, start_date, end_date)
VALUES 
    (nextval('project_seq'), 'Website Redesign', 'INPROGRESS', 'Revamping the corporate website', '2024-03-01', '2024-06-30'),
    (nextval('project_seq'), 'Mobile App Development', 'NOTSTARTED', 'Developing a mobile shopping app', '2024-05-15', '2024-12-01'),
    (nextval('project_seq'), 'Cloud Migration', 'COMPLETED', 'Migrating on-premise services to AWS', '2023-06-01', '2023-12-31'),
    (nextval('project_seq'), 'AI Chatbot Integration', 'INPROGRESS', 'Integrating an AI chatbot for customer service', '2024-02-15', '2024-07-30'),
    (nextval('project_seq'), 'Data Warehouse Optimization', 'INPROGRESS', 'Improving the performance of data analytics systems', '2024-01-10', '2024-10-30'),
    (nextval('project_seq'), 'Cybersecurity Audit', 'COMPLETED', 'Conducting a full security review', '2023-08-01', '2023-11-15'),
    (nextval('project_seq'), 'HR Portal Enhancement', 'INPROGRESS', 'Enhancing the HR management system', '2024-04-01', '2024-09-30'),
    (nextval('project_seq'), 'Blockchain Implementation', 'NOTSTARTED', 'Exploring blockchain for secure transactions', '2024-06-15', '2025-03-01'),
    (nextval('project_seq'), 'IoT Device Integration', 'INPROGRESS', 'Integrating IoT devices for automation', '2024-02-01', '2024-10-15'),
    (nextval('project_seq'), 'CRM Upgrade', 'COMPLETED', 'Upgrading customer relationship management software', '2023-09-01', '2024-02-28'),
    (nextval('project_seq'), 'E-Learning Platform', 'INPROGRESS', 'Developing an online education portal', '2024-01-05', '2024-12-15'),
    (nextval('project_seq'), 'Smart City Initiative', 'NOTSTARTED', 'Implementing smart traffic and lighting systems', '2024-07-01', '2025-06-30'),
    (nextval('project_seq'), 'Payment Gateway Integration', 'INPROGRESS', 'Integrating new online payment options', '2024-03-15', '2024-09-30'),
    (nextval('project_seq'), 'Warehouse Automation', 'INPROGRESS', 'Introducing robotic process automation in warehouses', '2024-05-01', '2024-12-31'),
    (nextval('project_seq'), 'Green Energy Adoption', 'NOTSTARTED', 'Transitioning to renewable energy sources', '2024-08-10', '2025-08-01'),
    (nextval('project_seq'), 'Supply Chain Optimization', 'INPROGRESS', 'Enhancing logistics and supplier coordination', '2024-04-20', '2024-10-10'),
    (nextval('project_seq'), 'AI-Powered Analytics', 'INPROGRESS', 'Leveraging AI for big data analytics', '2024-02-05', '2024-12-20'),
    (nextval('project_seq'), '5G Network Expansion', 'COMPLETED', 'Rolling out 5G network infrastructure', '2023-05-01', '2023-12-31'),
    (nextval('project_seq'), 'Digital Marketing Revamp', 'INPROGRESS', 'Enhancing SEO, social media, and branding efforts', '2024-03-10', '2024-09-15'),
    (nextval('project_seq'), 'VR Training Simulation', 'NOTSTARTED', 'Developing a virtual reality training tool', '2024-07-01', '2025-05-01');

INSERT INTO project_employee (project_id, employee_id)
SELECT p.project_id, e.employee_id
FROM project p
JOIN employee e ON 
    (p.name = 'Website Redesign' AND e.first_name = 'Alice') OR
    (p.name = 'Website Redesign' AND e.first_name = 'Bob') OR
    (p.name = 'Mobile App Development' AND e.first_name = 'Charlie') OR
    (p.name = 'Cloud Migration' AND e.first_name = 'Diana') OR
    (p.name = 'AI Chatbot Integration' AND e.first_name = 'Alice') OR
    (p.name = 'AI Chatbot Integration' AND e.first_name = 'Charlie') OR
    (p.name = 'Data Warehouse Optimization' AND e.first_name = 'Ethan') OR
    (p.name = 'Cybersecurity Audit' AND e.first_name = 'Fiona') OR
    (p.name = 'HR Portal Enhancement' AND e.first_name = 'George') OR
    (p.name = 'Blockchain Implementation' AND e.first_name = 'Hannah') OR
    (p.name = 'IoT Device Integration' AND e.first_name = 'Isaac') OR
    (p.name = 'CRM Upgrade' AND e.first_name = 'Julia') OR
    (p.name = 'E-Learning Platform' AND e.first_name = 'Alice') OR
    (p.name = 'Smart City Initiative' AND e.first_name = 'Bob') OR
    (p.name = 'Payment Gateway Integration' AND e.first_name = 'Charlie') OR
    (p.name = 'Warehouse Automation' AND e.first_name = 'Diana') OR
    (p.name = 'Green Energy Adoption' AND e.first_name = 'Ethan') OR
    (p.name = 'Supply Chain Optimization' AND e.first_name = 'Fiona') OR
    (p.name = 'AI-Powered Analytics' AND e.first_name = 'George') OR
    (p.name = '5G Network Expansion' AND e.first_name = 'Hannah') OR
    (p.name = 'Digital Marketing Revamp' AND e.first_name = 'Isaac') OR
    (p.name = 'VR Training Simulation' AND e.first_name = 'Julia');
