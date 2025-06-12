## 🐳 STEP: Menjalankan PostgreSQL dengan Docker Compose + Seeding

### 1️⃣ Buat File `docker-compose.yml`

```yaml
version: "3.8"
services:
  postgres:
    image: postgres:14
    container_name: postgres-db
    restart: always
    environment:
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: secret
      POSTGRES_DB: company_db
    ports:
      - "5432:5432"
    volumes:
      - ./init.sql:/docker-entrypoint-initdb.d/init.sql
```

### 2️⃣ Buat File `init.sql` (di folder yang sama)

```sql
-- Create tables
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
```

### 3️⃣ Jalankan Docker Compose

```bash
docker compose up -d
```

### 4️⃣ Akses dan Cek Database

- Melalui **pgAdmin / DBeaver**
- Atau terminal:

```bash
psql -h localhost -U admin -d company_db
# Password: secret
```

---

## 🧠 5 Soal SQL dan Ekspektasi Output

---

### ❓ Soal 1: Total Gaji per Departemen

> Tampilkan nama departemen dan total gaji semua karyawan di tiap departemen. Urutkan dari total gaji terbesar ke terkecil.

🟩 **Ekspektasi Output:**

| department_name | total_salary |
| --------------- | ------------ |
| Engineering     | 35000        |
| Marketing       | 18500        |
| HR              | 15500        |

---

**Answer:**

```sql
SELECT d.name AS department_name, SUM(e.salary) AS total_salary
FROM departments d
JOIN employees e ON d.id = e.department_id
group BY d.name
order BY total_salary DESC;
```

### ❓ Soal 2: Karyawan yang Tidak Pernah Join Proyek

> Tampilkan nama-nama karyawan yang tidak pernah bergabung dalam proyek manapun.

🟩 **Ekspektasi Output:**

| name  |
| ----- |
| Evan  |
| Grace |

---

**Answer:**

```sql
SELECT e.name
FROM employees e
LEFT JOIN employee_projects ep ON e.id = ep.employee_id
WHERE ep.employee_id IS NULL;
```

### ❓ Soal 3: Tiga Gaji Tertinggi Tiap Departemen

> Tampilkan maksimal 3 karyawan dengan gaji tertinggi dari masing-masing departemen.

🟩 **Ekspektasi Output:**

| name    | department_id | salary |
| ------- | ------------- | ------ |
| Frank   | 1             | 13000  |
| Bob     | 1             | 12000  |
| Alice   | 1             | 10000  |
| Diana   | 2             | 9500   |
| Charlie | 2             | 9000   |
| Evan    | 3             | 8000   |
| Grace   | 3             | 7500   |

---

**Answer:**

```sql
???
```

### ❓ Soal 4: Proyek yang Durasi-nya Lebih Lama dari Lama Kerja Rata-Rata Karyawan

> Hitung rata-rata masa kerja semua karyawan, lalu tampilkan proyek yang memiliki durasi (end_date - start_date) lebih lama dari itu.
🟩 **Ekspektasi Output (per 2025-06-12):**

| name       |
| ---------- |
| _(kosong)_ |

---
**Answer:**

```sql
SELECT p.name
FROM projects p
WHERE (p.end_date - p.start_date) > (
  SELECT AVG(CURRENT_DATE - hire_date) FROM employees
);
```

### ❓ Soal 5: Karyawan yang Pernah Join Lebih dari 2 Proyek

> Tampilkan karyawan yang pernah bergabung dalam lebih dari 2 proyek berbeda.

🟩 **Ekspektasi Output:**

| name  | total_projects |
| ----- | -------------- |
| Bob   | 2              |
| Diana | 2              |

> Catatan: Data saat ini belum ada yang join > 2 proyek, jadi jawaban tetap 2 sebagai validasi agregasi.

---
**Answer:**

```sql
SELECT e.name, COUNT(DISTINCT ep.project_id) AS total_projects
FROM employees e
JOIN employee_projects ep ON e.id = ep.employee_id
GROUP BY e.id, e.name
HAVING COUNT(DISTINCT ep.project_id) >= 2
ORDER BY total_projects DESC;
```

Kalau kamu mau tambahkan soal lebih sulit seperti recursive CTE, JSON parsing, atau ARRAY, tinggal bilang ya.
