## 📄 Pretest Spring Boot Security & Unit Testing\*\*
## Ahmad Hafizh Assa'ad

---

### ✅ **A. Isian Singkat (12 Soal)**

1. Apa tujuan utama dari Spring Security?

   - **Answer:** Memberikan mekanisme keamanan (authentication & authorization) pada aplikasi.
   
2. Apa anotasi untuk mengaktifkan Web Security di Spring Boot? 

   - **Answer:** `@EnableWebSecurity`

3. Apa fungsi `HttpSecurity` dalam konfigurasi Spring Security?

   - **Answer:** `HttpSecurity` digunakan untuk mengonfigurasi pengaturan keamanan HTTP, seperti endpoint yang dilindungi, otentikasi, dan otorisasi.

4. Apa itu prinsip _Authentication Principal_ dalam Spring Security?

   - **Answer:** Authentication Principal adalah representasi dari user yang sedang melakukan otentikasi, biasanya berupa object `UserDetails`.

5. Apa peran dari anotasi `@PreAuthorize("hasRole('ADMIN')")`?

   - **Answer:** mengatur otorisasi pada method, memastikan hanya user dengan role 'ADMIN' yang dapat mengakses method tersebut.

6. Apa fungsi dari class `UserDetails` di Spring Security?

   - **Answer:** Menyimpan detail informasi user yang digunakan untuk proses autentikasi.

7. Apa itu BCrypt?

   - **Answer:** BCrypt adalah algoritma hashing yang digunakan untuk mengamankan password dengan cara menghasilkan hash yang kuat dan aman.

8. Library utama yang digunakan untuk testing unit di Spring Boot adalah:

   - **Answer:** `JUnit`

9. Apa kegunaan dari `@MockBean` dalam Spring Boot Test?

   - **Answer:** `@MockBean` digunakan untuk membuat mock dari bean yang ada di context Spring, sehingga dapat digunakan dalam pengujian tanpa memerlukan implementasi asli.

10. Apa yang dilakukan oleh anotasi `@WithMockUser`?

    - **Answer:** Menyimulasikan user login dengan role tertentu saat pengujian.

11. Apa perbedaan mendasar antara `@WebMvcTest` dan `@SpringBootTest`?

    - **Answer:** `@WebMvcTest` digunakan untuk menguji layer web (controller) saja, sedangkan `@SpringBootTest` digunakan untuk menguji seluruh konteks aplikasi Spring Boot.

13. Apa tujuan dari anotasi `@BeforeEach` dalam unit test?

    - **Answer:** Menjalankan kode setup sebelum setiap method test dijalankan.

---

### ✅ **B. Benar/Salah (5 Soal)**

13. `BCryptPasswordEncoder` menghasilkan hash yang sama untuk password yang sama. **(false)**
14. Spring Security dapat digunakan untuk endpoint berbasis REST API maupun form login. **(True)**
15. `@WebMvcTest` bisa digunakan untuk menguji layer service dan repository. **(False)**
16. `Principal` adalah representasi dari user yang sedang login. **(True)**
17. `@MockBean` dan `@Mock` memiliki efek yang sama dalam Spring Boot Test. **(False)**

---

### ✅ **C. Isian Singkat (5 Soal)**

18. Apa peran dari `AuthenticationManager` dalam Spring Security?

    - **Answer:** `AuthenticationManager` bertugas memproses permintaan autentikasi dan memvalidasi kredensial user di Spring Security.
    
19. Jelaskan apa yang dilakukan oleh `PasswordEncoder` dan kenapa penting?

    - **Answer:** `PasswordEncoder` digunakan untuk meng-hash password sebelum disimpan di database, sehingga meningkatkan keamanan dengan mencegah penyimpanan password dalam bentuk teks asli.

20. Apa yang dimaksud dengan "authorization" dalam konteks aplikasi?

    - **Answer:** `Authorization` adalah proses menentukan apakah user yang telah terautentikasi memiliki izin untuk mengakses resource atau melakukan tindakan tertentu dalam aplikasi.

21. Apa itu _test double_, dan apa perbedaannya dengan _mock_ di unit test?

    - **Answer:** `Test double` adalah istilah umum untuk objek yang digunakan dalam pengujian untuk menggantikan objek nyata. `Mock` adalah salah satu jenis test double yang digunakan untuk memverifikasi interaksi dengan objek tersebut, seperti memeriksa apakah method tertentu dipanggil dengan argumen yang benar.

22. Dalam pengujian REST API Spring Boot, apa fungsi utama `MockMvc`?

    - **Answer:** `MockMvc` digunakan untuk menguji endpoint REST API dengan cara mensimulasikan permintaan HTTP dan memverifikasi respons yang diterima, tanpa perlu menjalankan server web secara nyata.

---

### ✅ **D. Koreksi Kode (8 Soal)**

Perhatikan kode berikut dan jelaskan apa yang salah.

23.

```java
@Autowired
private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
```

**Kesalahan:** `@Autowired` tidak dapat digunakan untuk menginisialisasi objek secara langsung. Seharusnya objek diinisialisasi di dalam method atau constructor.

**Perbaikan:**

```java
@Autowired
private PasswordEncoder passwordEncoder;
```

24.

```java
@WithMockUser(username = "user", roles = "USER")
@Test
void testAccessAdminEndpoint() {
    mockMvc.perform(get("/admin")).andExpect(status().isOk());
}
```

**Kesalahan:** Anotasi `@WithMockUser` digunakan untuk mensimulasikan user dengan role tertentu, namun endpoint yang diakses adalah `/admin`, yang seharusnya hanya dapat diakses oleh user dengan role 'ADMIN'.

**Perbaikan:**

```java
@WithMockUser(username = "admin", roles = "ADMIN")
@Test
void testAccessAdminEndpoint() {
    mockMvc.perform(get("/admin")).andExpect(status().isOk());
}
```

25.

```java
@Mock
UserService userService = new UserServiceImpl();
```

**Kesalahan:** `@Mock` digunakan untuk membuat mock dari objek, namun objek tersebut tidak boleh diinisialisasi secara langsung. Seharusnya hanya mendeklarasikan variabel.

**Perbaikan:**

```java
@Mock
UserService userService;
```

26.

```java
@SpringBootTest
@WebMvcTest
public class MyTest {
}
```

**Kesalahan:** `@SpringBootTest` dan `@WebMvcTest` tidak boleh digunakan bersamaan. `@WebMvcTest` sudah mencakup konteks aplikasi yang lebih kecil, sehingga tidak perlu menggunakan `@SpringBootTest`.

**Perbaikan:**

```java
@WebMvcTest
public class MyTest {
}
```

27.

```java
@Test
void testPasswordHash() {
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    assertEquals("mypassword", encoder.encode("mypassword"));
}
```

**Kesalahan:** `BCryptPasswordEncoder` menghasilkan hash yang berbeda setiap kali dipanggil, sehingga perbandingan langsung dengan string asli tidak akan berhasil.

**Perbaikan:**

```java
@Test
void testPasswordHash() {
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    String hashedPassword = encoder.encode("mypassword");
    assertTrue(encoder.matches("mypassword", hashedPassword));
}
```

28.

```java
@Test
void testUnauthorizedAccess() {
    mockMvc.perform(get("/secure-data"))
           .andExpect(status().isOk());
}
```

**Kesalahan:** Endpoint `/secure-data` seharusnya memerlukan otentikasi, sehingga status yang diharapkan adalah `401 Unauthorized`.

**Perbaikan:**

```java
@Test
void testUnauthorizedAccess() {
    mockMvc.perform(get("/secure-data"))
           .andExpect(status().isUnauthorized());
}
```

29.

```java
@BeforeAll
void setup() {
    MockitoAnnotations.openMocks(this);
}
```

**Kesalahan:** `@BeforeAll` digunakan untuk setup yang dijalankan sekali sebelum semua test, namun `MockitoAnnotations.openMocks(this)` seharusnya digunakan dengan `@BeforeEach` karena mock harus diinisialisasi sebelum setiap test.

**Perbaikan:**

```java
@BeforeEach
void setup() {
    MockitoAnnotations.openMocks(this);
}
```

30.

```java
@Test
void testLogin() {
    when(authService.login("user", "pass")).thenReturn(null);
    assertNotNull(authService.login("user", "pass"));
}
```

**Kesalahan:** Mocking `authService.login` mengembalikan `null`, sehingga `assertNotNull` akan gagal. Seharusnya mengembalikan objek user yang valid.

**Perbaikan:**

```java
@Test
void testLogin() {
    User user = new User("user", "pass");
    when(authService.login("user", "pass")).thenReturn(user);
    assertNotNull(authService.login("user", "pass"));
}
```
