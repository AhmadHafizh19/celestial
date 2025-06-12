# **Jawaban Prestest Day 3**
## **Ahmad Hafizh Assa'ad**

---
## 📌 **Bagian A – Pilihan Ganda (10 Soal)**
1. (B) `@Entity`
2. (C) Menyediakan endpoint berbasis REST
3. (A) Menangani request GET ke endpoint `/user`
4. (C) `findAll()`
5. (A) `@ManyToOne`
6. (C) `application.properties`
7. (B) `@Autowired`
8. (C) `@Query`
9. (B) Mengambil data dari body request
10. (C) Mengambil data dari path endpoint

---
## 📌 **Bagian B – Benar / Salah (5 Soal)**

11. `@Service` digunakan untuk mendefinisikan komponen yang berisi logika bisnis. **(True)**
12. Spring Boot tidak memerlukan konfigurasi manual untuk koneksi database jika `application.properties` sudah diatur. **(True)**
13. `@PostMapping` digunakan untuk mengambil data dari database. **(False)**
14. `JpaRepository` adalah turunan dari `CrudRepository`. **(True)**
15. `@Entity` dan `@Table` selalu wajib digunakan bersamaan. **(False)**

---
## 📌 **Bagian C – Jawaban Singkat (5 Soal)**

16. `@Controller` digunakan untuk controller MVC yang mengembalikan view atau objek (HTML), sedangkan `@RestController` untuk REST API yang mengembalikan data (biasanya JSON atau XML) langsung ke client.
17. `@GeneratedValue` berfungsi untuk menghasilkan nilai otomatis pada field primary key, biasanya untuk ID.
18. DTO penting untuk memisahkan data API dari model internal, meningkatkan keamanan, dan memudahkan transfer data.
19. Spring membaca nama method seperti `findByUsername` dan secara otomatis membuat query yang sesuai.
20. `@Column(name = "full_name")` digunakan untuk memetakan field entity ke kolom full_name di database.

---

## 📌 **Bagian D – Analisis Kode dan Kelemahan (5 Soal)**


21. Apa kesalahan dari kode berikut?

**Before:**
```java
@Entity
public class User {
    private Long id;
    private String name;
}
```

**Kesalahan:**
- Field `id` dan `name` tidak memiliki anotasi JPA yang diperlukan seperti `@Id` untuk primary key.
- Tidak ada anotasi `@GeneratedValue` untuk ID.

**After:**
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
```
---
22. Apa kekurangan dari controller berikut?

**Before:**
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name) {
        return "Hello " + name;
    }
}
```

**Kekurangan:**
- Parameter `name` sebaiknya ditandai dengan `@RequestParam` agar Spring dapat mengikat nilai dari query parameter.

**After:**
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }
}
```
---
23. Jelaskan cara membuat relasi OneToMany antara `Customer` dan `Order`.

**Answer:**
- Untuk membuat relasi OneToMany antara Customer dan Order, tambahkan anotasi @OneToMany di kelas Customer dan @ManyToOne di kelas Order.

**Source Code Example:**
```java
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;
}

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
```
---
24. Jelaskan output dari controller berikut jika user mengakses `/user/123`.

**Source Code:**
```java
```java
@GetMapping("/user/{id}")
public String getUser(@PathVariable Long id) {
    return "User ID: " + id;
}
```

**Penjelasan:**
- Jika user mengakses `/user/123`, maka Spring akan menangkap nilai `123` sebagai parameter `id` dan mengembalikan string "User ID: 123".
- Outputnya akan menjadi "User ID: 123".

---
25. Jika Anda ingin menghandle error saat user tidak ditemukan dalam REST API, bagaimana pendekatan yang baik di Spring?

**Answer:**
- Gunakan `@ExceptionHandler` untuk menangani exception khusus seperti `UserNotFoundException`. Anda juga bisa menggunakan `ResponseEntity` untuk mengembalikan status HTTP yang sesuai.


