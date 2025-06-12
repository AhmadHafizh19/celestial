

## 🧪 **Pre-Test: Spring Data JPA & Spring Web Development**

---

### 📌 **Bagian A – Pilihan Ganda (10 Soal)**

Pilih jawaban yang paling tepat.

1. Apa anotasi untuk menandai class sebagai entitas JPA?
   a. `@Model`
   b. `@Entity`
   c. `@Table`
   d. `@Persistence`

2. Apa fungsi utama dari `@RestController`?
   a. Mengatur service logic
   b. Menyimpan data ke database
   c. Menyediakan endpoint berbasis REST
   d. Mengatur validasi input

3. Anotasi `@GetMapping("/user")` menunjukkan bahwa method:
   a. Menangani request GET ke endpoint `/user`
   b. Mengakses data user dari database
   c. Mengirimkan data dalam format XML
   d. Hanya bisa dipanggil dari controller biasa

4. Metode apa yang digunakan `JpaRepository` untuk mengambil semua entitas?
   a. `getAll()`
   b. `list()`
   c. `findAll()`
   d. `fetch()`

5. Untuk menangani relasi many-to-one antara `Product` dan `Category`, anotasi apa yang digunakan?
   a. `@ManyToOne`
   b. `@OneToMany`
   c. `@JoinMany`
   d. `@Relationship`

6. File konfigurasi default untuk Spring Boot adalah:
   a. `spring.config`
   b. `app.yaml`
   c. `application.properties`
   d. `boot.config`

7. Apa anotasi yang digunakan untuk melakukan injeksi dependency di Spring?
   a. `@Inject`
   b. `@Autowired`
   c. `@Override`
   d. `@ComponentScan`

8. Jika kita ingin membuat custom query di `JpaRepository`, kita bisa menggunakan:
   a. `@RequestQuery`
   b. `@CustomQuery`
   c. `@Query`
   d. `@Sql`

9. Apa fungsi dari `@RequestBody`?
   a. Menyisipkan parameter URL
   b. Mengambil data JSON dari body request
   c. Mengambil path variable
   d. Mengambil form-data

10. Apa tujuan dari anotasi `@PathVariable`?
    a. Mengambil data dari request body
    b. Mengambil data dari parameter URL
    c. Mengambil data dari path endpoint
    d. Mengakses objek service

---

### 📌 **Bagian B – Benar / Salah (5 Soal)**

Tentukan apakah pernyataan berikut benar atau salah.

11. `@Service` digunakan untuk mendefinisikan komponen yang berisi logika bisnis.
12. Spring Boot tidak memerlukan konfigurasi manual untuk koneksi database jika `application.properties` sudah diatur.
13. `@PostMapping` digunakan untuk mengambil data dari database.
14. `JpaRepository` adalah turunan dari `CrudRepository`.
15. `@Entity` dan `@Table` selalu wajib digunakan bersamaan.

---

### 📌 **Bagian C – Jawaban Singkat (5 Soal)**

Jawab pertanyaan berikut secara ringkas dan jelas.

16. Apa perbedaan antara `@Controller` dan `@RestController`?
17. Jelaskan fungsi dari `@GeneratedValue`.
18. Mengapa penting menggunakan DTO saat mengirim/terima data dari API?
19. Bagaimana cara Spring menangani method seperti `findByUsername` di repository?
20. Apa peran `@Column(name = "full_name")` di entitas JPA?

---

### 📌 **Bagian D – Analisis Kode dan Kelemahan (5 Soal)**

21. Apa kesalahan dari kode berikut?

```java
@Entity
public class User {
    private Long id;
    private String name;
}
```

> Jawaban: Belum menggunakan `@Id`, dan belum ada `@GeneratedValue`.

---

22. Apa kekurangan dari controller berikut?

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name) {
        return "Hello " + name;
    }
}
```

> Jawaban: Parameter `name` sebaiknya ditandai dengan `@RequestParam`.

---

23. Jelaskan cara membuat relasi OneToMany antara `Customer` dan `Order`.

---

24. Jelaskan output dari controller berikut jika user mengakses `/user/123`.

```java
@GetMapping("/user/{id}")
public String getUser(@PathVariable Long id) {
    return "User ID: " + id;
}
```

---

25. Jika Anda ingin menghandle error saat user tidak ditemukan dalam REST API, bagaimana pendekatan yang baik di Spring?

---

