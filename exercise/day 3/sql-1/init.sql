Create tables
CREATE TABLE departments (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE employees (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  department_id INT REFERENCES departments(id),
  salary NUMERIC,
  hire_date DATE
);

CREATE TABLE projects (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  start_date DATE,
  end_date DATE
);

CREATE TABLE employee_projects (
  employee_id INT REFERENCES employees(id),
  project_id INT REFERENCES projects(id),
  assigned_date DATE,
  PRIMARY KEY (employee_id, project_id)
);

-- Seeding departments
INSERT INTO departments (name) VALUES
('Engineering'), ('Marketing'), ('HR');

-- Seeding employees
INSERT INTO employees (name, department_id, salary, hire_date) VALUES
('Alice', 1, 10000, '2020-01-10'),
('Bob', 1, 12000, '2019-07-15'),
('Charlie', 2, 9000, '2021-03-01'),
('Diana', 2, 9500, '2022-01-20'),
('Evan', 3, 8000, '2018-06-30'),
('Frank', 1, 13000, '2023-05-12'),
('Grace', 3, 7500, '2024-02-15');

-- Seeding projects
INSERT INTO projects (name, start_date, end_date) VALUES
('Project Apollo', '2023-01-01', '2023-12-31'),
('Project Zeus', '2022-06-01', '2023-06-01'),
('Project Hermes', '2023-08-01', '2024-01-31');

-- Seeding employee_projects
INSERT INTO employee_projects (employee_id, project_id, assigned_date) VALUES
(1, 1, '2023-01-10'),
(2, 1, '2023-01-15'),
(2, 2, '2022-06-15'),
(3, 3, '2023-08-05'),
(4, 2, '2022-06-10'),
(4, 3, '2023-08-10'),
(6, 1, '2023-06-01');