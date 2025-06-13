# 📄 **PRE-TEST** – _Java Spring Boot & Spring Security_
#  Ahmad Hafizh Assa'ad

----

## ✳️ Bagian 1: Pilihan Ganda (Dasar)

1. Apa anotasi yang digunakan untuk mendefinisikan sebuah REST controller?

   - C. `@RestController`


2. Di Spring, anotasi apa yang digunakan untuk menyuntikkan dependency ke dalam class?

   - A. `@Autowired`
   

3. Di lapisan arsitektur Spring, Service berfungsi untuk:
   - D. Menyimpan logika bisnis
   

4. Class model di Java Spring biasanya digunakan untuk:

   - C. Menyimpan struktur data (seperti data user, produk, dll.)


5. Jika kita ingin membuat method yang bisa diakses oleh endpoint `/hello`, anotasi apa yang digunakan?

   - C. `@GetMapping("/hello")`

---

## ✳️ Bagian 2: Benar / Salah

6.  `@Service` digunakan untuk menandai class sebagai lapisan Controller. **(False)**
7. Kita bisa membuat class model tanpa anotasi apapun jika hanya digunakan sebagai POJO. **(True)**
8. `@Autowired` bisa digunakan di constructor maupun field. **(True)**
9. Spring Boot membutuhkan file `application.yml` agar bisa berjalan. **(False)**
10. `@GetMapping` hanya bisa digunakan di class dengan anotasi `@Service`. **(False)**

---

## ✳️ Bagian 3: Isian Singkat

11. Anotasi apa yang digunakan agar method bisa menangani permintaan POST?

**Jawaban:** `@PostMapping`

12. Apa nama file konfigurasi default di Spring Boot?

**Jawaban:** `application.properties` atau `application.yml`

13. Apa yang dimaksud dengan Dependency Injection?

**Jawaban:** Dependency Injection adalah teknik untuk menyuntikkan dependency (objek lain) ke dalam sebuah class secara otomatis oleh framework.

14. Bagaimana cara mendeklarasikan class `UserService` agar dikenali Spring sebagai Service?

**Jawaban:** Dengan menambahkan anotasi `@Service` pada class tersebut.

15. Apa perbedaan `@RestController` dan `@Controller`?

**Jawaban:** `@RestController` mengembalikan data (JSON/XML) langsung ke response body, sedangkan `@Controller` biasanya digunakan untuk mengembalikan view (HTML/jsp).

---

## ✳️ Bagian 4: Perbaiki Kode / Output

16. Perbaiki kode berikut agar dapat dijalankan sebagai Controller:

```java
public class HelloController {
   @GetMapping("/hello")
   public String hello() {
      return "Hello";
   }
}
```

**Perbaikan:**

```java
@RestController
public class HelloController {
   @GetMapping("/hello")
   public String hello() {
      return "Hello";
   }
}
```

17. Perbaiki kesalahan pada model berikut:

```java
public class Product {
    private String name;
    private int price;
}
```
**Perbaikan:**

```java
@Data
public class Product {

   private String name;
   private int price;

   public Product() {}

   public Product(String name, int price) {
      this.name = name;
      this.price = price;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }
}

```

18. Apa output dari method berikut?

```java
@GetMapping("/sum")
public int sum() {
    return 2 + 3;
}
```

**Output:** 5

19. Kode service berikut error. Apa yang salah?

```java
@Service
public class UserService {
    private UserRepository userRepository;
}
```

**Kesalahan:** Field `userRepository` tidak diinisialisasi. Harus ada anotasi `@Autowired` atau inisialisasi manual.

**Perbaikan:**

```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
```

20. Apa masalah pada potongan kode berikut?

```java
@RestController
public class BookController {

    @GetMapping
    public String listBooks() {
        return "books";
    }
}
```

**Masalah:** Anotasi `@GetMapping` harus memiliki path yang ditentukan, misal `@GetMapping("/books")`.

**Perbaikan:**

```java
@RestController
public class BookController {

    @GetMapping("/books")
    public String listBooks() {
        return "books";
    }
}
```

---

## 🔐 Bagian 5: Spring Security

### Pilihan Ganda

21. Apa anotasi yang digunakan untuk mengaktifkan Spring Security di aplikasi Spring Boot?

- A. `@EnableSecurity`

22. Komponen mana yang bertugas mengatur izin akses berdasarkan role atau otorisasi di Spring Security?

- D. `HttpSecurity`

23. Untuk membuat otentikasi berbasis user login yang dikustomisasi, interface apa yang harus diimplementasi?

- C. `UserDetailsService`

### Benar / Salah

24. Spring Security hanya bisa digunakan untuk REST API yang menggunakan JWT. **(False)**
25. `@PreAuthorize("hasRole('ADMIN')")` digunakan untuk membatasi method agar hanya bisa diakses oleh pengguna dengan role ADMIN. **(True)**
26. `BCryptPasswordEncoder` digunakan untuk mengenkripsi password agar tidak disimpan dalam bentuk plain text. **(True)**

### Isian Singkat

27. Apa class konfigurasi yang umum dibuat untuk menyesuaikan aturan login, logout, dan authorization di Spring Security?

**Jawaban:** `SecurityConfig` (atau class konfigurasi yang meng-extend WebSecurityConfigurerAdapter atau menggunakan SecurityFilterChain)
28. Apa anotasi yang digunakan agar method hanya bisa diakses jika pengguna memiliki hak tertentu?

**Jawaban:** `@PreAuthorize` atau `@Secured`

### Perbaiki Kode / Analisis

29. Perbaiki potongan konfigurasi ini:

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin();
    return http.build();
}
```

**Perbaikan:**

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests()
        .requestMatchers("/admin").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin();
    return http.build();
}
```

30. Apa yang salah dengan konfigurasi login berikut?

```java
http
  .authorizeHttpRequests()
  .anyRequest().permitAll()
  .and()
  .formLogin();
```

**Kesalahan:** Konfigurasi ini mengizinkan semua permintaan tanpa otentikasi, sehingga tidak ada proteksi untuk endpoint apapun. Seharusnya ada pembatasan akses untuk endpoint tertentu atau seluruh aplikasi harus diotentikasi terlebih dahulu.

**Perbaikan:**

```java
http
  .authorizeHttpRequests()
  .anyRequest().authenticated()
  .and()
  .formLogin();
```

---
