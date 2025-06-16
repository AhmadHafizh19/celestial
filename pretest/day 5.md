## 📄 Pretest Spring Boot Security & Unit Testing\*\*

### ✅ **A. Pilihan Ganda (12 Soal)**

1. Apa tujuan utama dari Spring Security?
2. Apa anotasi untuk mengaktifkan Web Security di Spring Boot?
3. Apa fungsi `HttpSecurity` dalam konfigurasi Spring Security?
4. Apa itu prinsip _Authentication Principal_ dalam Spring Security?
5. Apa peran dari anotasi `@PreAuthorize("hasRole('ADMIN')")`?
6. Apa fungsi dari class `UserDetails` di Spring Security?
7. Apa itu BCrypt?
8. Library utama yang digunakan untuk testing unit di Spring Boot adalah:
9. Apa kegunaan dari `@MockBean` dalam Spring Boot Test?
10. Apa yang dilakukan oleh anotasi `@WithMockUser`?
11. Apa perbedaan mendasar antara `@WebMvcTest` dan `@SpringBootTest`?
12. Apa tujuan dari anotasi `@BeforeEach` dalam unit test?

---

### ✅ **B. Benar/Salah (5 Soal)**

13. `BCryptPasswordEncoder` menghasilkan hash yang sama untuk password yang sama.
14. Spring Security dapat digunakan untuk endpoint berbasis REST API maupun form login.
15. `@WebMvcTest` bisa digunakan untuk menguji layer service dan repository.
16. `Principal` adalah representasi dari user yang sedang login.
17. `@MockBean` dan `@Mock` memiliki efek yang sama dalam Spring Boot Test.

---

### ✅ **C. Isian Singkat (5 Soal)**

18. Apa peran dari `AuthenticationManager` dalam Spring Security?
19. Jelaskan apa yang dilakukan oleh `PasswordEncoder` dan kenapa penting?
20. Apa yang dimaksud dengan "authorization" dalam konteks aplikasi?
21. Apa itu _test double_, dan apa perbedaannya dengan _mock_ di unit test?
22. Dalam pengujian REST API Spring Boot, apa fungsi utama `MockMvc`?

---

### ✅ **D. Koreksi Kode (8 Soal)**

Perhatikan kode berikut dan jelaskan apa yang salah.

23.

```java
@Autowired
private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
```

24.

```java
@WithMockUser(username = "user", roles = "USER")
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

26.

```java
@SpringBootTest
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

28.

```java
@Test
void testUnauthorizedAccess() {
    mockMvc.perform(get("/secure-data"))
           .andExpect(status().isOk());
}
```

29.

```java
@BeforeAll
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
