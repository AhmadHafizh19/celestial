---
# 🔖 REST API Challenge 1
---

## 🧩 GROUP 1 – Library Management System

### 📁 Recommended Repository Name:

`library-management-api`

### 🎯 Product Requirements

Aplikasi ini digunakan untuk:

- Mencatat data buku yang tersedia di perpustakaan
- Mendaftarkan anggota perpustakaan
- Memfasilitasi peminjaman dan pengembalian buku
- Mengetahui buku apa saja yang sedang dipinjam oleh anggota

### 🧠 Fitur Utama

- Admin dapat menambahkan dan mengelola data buku
- Anggota dapat meminjam dan mengembalikan buku
- Sistem mencatat transaksi pinjam/kembali
- Stok buku berkurang saat dipinjam dan bertambah saat dikembalikan
- Admin bisa melihat daftar buku yang dipinjam oleh masing-masing anggota

---

### 📡 API Specification

**Base URL**: `/api/v1`

#### 📘 Book API

| Method | Endpoint      | Description                     |
| ------ | ------------- | ------------------------------- |
| GET    | `/books`      | List all books (search, paging) |
| POST   | `/books`      | Add new book                    |
| GET    | `/books/{id}` | Get book detail                 |
| PUT    | `/books/{id}` | Update book info                |
| DELETE | `/books/{id}` | Delete a book                   |

**Book Schema (snake_case)**

```json
{
  "title": "the_hobbit",
  "author": "j.r.r._tolkien",
  "year": 1937,
  "stock": 5
}
```

---

#### 👤 Member API

| Method | Endpoint                       | Description                |
| ------ | ------------------------------ | -------------------------- |
| POST   | `/members`                     | Register a new member      |
| GET    | `/members/{id}`                | Get member detail          |
| GET    | `/members/{id}/borrowed-books` | Get list of books borrowed |

**Member Schema (snake_case)**

```json
{
  "name": "alice",
  "email": "alice@example.com",
  "join_date": "2025-06-12"
}
```

---

#### 📚 Borrow API

| Method | Endpoint  | Description   |
| ------ | --------- | ------------- |
| POST   | `/borrow` | Borrow a book |
| POST   | `/return` | Return a book |

**Borrow Schema (snake_case)**

```json
{
  "member_id": 1,
  "book_id": 3
}
```

---

## 🧩 GROUP 2 – Task Tracker System

### 📁 Recommended Repository Name:

`task-tracker-api`

### 🎯 Product Requirements

Aplikasi ini bertujuan membantu pengguna dalam:

- Menyusun dan mengatur daftar tugas
- Mengelompokkan tugas berdasarkan status (TO_DO, IN_PROGRESS, DONE)
- Melacak kemajuan tugas berdasarkan status
- Menampilkan ringkasan progres user

---

### 📡 API Specification

**Base URL**: `/api/v1`

#### 👤 User API

| Method | Endpoint                   | Description                          |
| ------ | -------------------------- | ------------------------------------ |
| POST   | `/users`                   | Register new user                    |
| GET    | `/users`                   | List all users                       |
| GET    | `/users/{id}/task-summary` | Show summary of task count by status |

**User Schema (snake_case)**

```json
{
  "name": "bob",
  "email": "bob@example.com"
}
```

---

#### ✅ Task API

| Method | Endpoint      | Description                                      |
| ------ | ------------- | ------------------------------------------------ |
| POST   | `/tasks`      | Create a new task                                |
| GET    | `/tasks`      | List tasks (filter by user_id, status, due_date) |
| GET    | `/tasks/{id}` | Get task detail                                  |
| PUT    | `/tasks/{id}` | Update a task                                    |
| DELETE | `/tasks/{id}` | Delete a task                                    |

**Task Schema (snake_case)**

```json
{
  "title": "submit_report",
  "description": "send_pdf_to_manager",
  "status": "to_do",
  "due_date": "2025-06-15",
  "user_id": 2
}
```

---

## 🧩 GROUP 3 – Simple E-Commerce Order System

### 📁 Recommended Repository Name:

`simple-ecommerce-api`

### 🎯 Product Requirements

Sistem ini dirancang untuk:

- Menyediakan fitur katalog produk
- Mencatat data pelanggan
- Memproses pesanan (order) dari pelanggan
- Menampilkan riwayat pesanan
- Menyediakan dashboard statistik penjualan

---

### 📡 API Specification

**Base URL**: `/api/v1`

#### 📦 Product API

| Method | Endpoint         | Description         |
| ------ | ---------------- | ------------------- |
| POST   | `/products`      | Add new product     |
| GET    | `/products`      | List all products   |
| PUT    | `/products/{id}` | Update product info |
| DELETE | `/products/{id}` | Delete product      |

**Product Schema (snake_case)**

```json
{
  "name": "wireless_mouse",
  "description": "usb_mouse",
  "price": 200000,
  "stock": 15
}
```

---

#### 👤 Customer API

| Method | Endpoint                 | Description       |
| ------ | ------------------------ | ----------------- |
| POST   | `/customers`             | Register customer |
| GET    | `/customers/{id}/orders` | Get order history |

**Customer Schema (snake_case)**

```json
{
  "name": "john",
  "email": "john@example.com"
}
```

---

#### 🧾 Order API

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| POST   | `/orders`      | Place a new order |
| GET    | `/orders/{id}` | Get order detail  |

**Order Request Schema (snake_case)**

```json
{
  "customer_id": 1,
  "items": [
    { "product_id": 2, "quantity": 1 },
    { "product_id": 3, "quantity": 2 }
  ]
}
```

**Order Response Sample**

```json
{
  "order_id": 101,
  "customer_id": 1,
  "order_date": "2025-06-12T13:45:00Z",
  "total_price": 550000,
  "items": [
    {
      "product_id": 2,
      "product_name": "wireless_mouse",
      "quantity": 1,
      "unit_price": 150000
    },
    {
      "product_id": 3,
      "product_name": "usb_keyboard",
      "quantity": 2,
      "unit_price": 200000
    }
  ]
}
```

---

#### 📊 Dashboard (Bonus)

| Method | Endpoint     | Description                                       |
| ------ | ------------ | ------------------------------------------------- |
| GET    | `/dashboard` | Show summary: total orders, revenue, top products |

**Dashboard Response**

```json
{
  "total_orders": 120,
  "total_revenue": 12500000,
  "best_selling_products": [
    { "product_id": 3, "name": "usb_keyboard", "quantity_sold": 65 },
    { "product_id": 2, "name": "wireless_mouse", "quantity_sold": 40 }
  ]
}
```

---
