## 🔸 **A. Pilihan Ganda (5 Soal)**

1. (B) Mengelola logika aplikasi dan komunikasi data dengan database
2. (A) Menyembunyikan detail implementasi dan menyediakan akses lewat method
3. (C) Meng-inject dependency otomatis ke dalam bean
4. (A) Agar controller lebih ringan dan fokus pada request/response
5. (C) `@GetMapping("/api")`

## 🔸 **B. True / False (5 Soal)**

6. Dalam arsitektur backend, service biasanya dipanggil langsung dari frontend. **(False)**
7. Constructor Injection adalah cara yang direkomendasikan untuk dependency injection di Spring. **(True)**
8. `@Service` digunakan untuk menandai sebuah class sebagai penyedia logika bisnis. **(True)**
9. Semua logika bisa ditaruh dalam controller agar tidak perlu membuat banyak file. **(False)**
10. Spring Boot memerlukan `main()` method untuk menjalankan aplikasinya. **(True)**

## 🔸 **C. Jawaban Singkat Penjelasan (10 Soal)**

11. Backend adalah bagian aplikasi yang menangani logika bisnis, pengolahan data, dan komunikasi dengan database. Perannya adalah memastikan data diproses dan dikirim ke frontend sesuai kebutuhan.

12. Class adalah blueprint atau template, sedangkan object adalah instance nyata dari class tersebut.

13. Dua prinsip OOP lainnya:
 - Inheritance: Pewarisan sifat dan method dari class induk (superclass) ke class anak ().
 - Polymorphism: Kemampuan objek untuk memiliki banyak bentuk, misal method yang sama bisa memiliki implementasi berbeda.
14. @RestController digunakan agar Spring mengenali class sebagai controller REST dan otomatis mengembalikan data dalam format JSON atau XML.

15. Spring Boot memudahkan setup, menyediakan banyak konfigurasi otomatis, dan mempercepat pengembangan aplikasi tanpa harus membuat server dari nol.

16. Dependency injection di Spring Boot bekerja dengan mengelola objek (bean) secara otomatis dan menyuntikkannya ke class yang membutuhkan, misal lewat constructor.

17. Memisahkan controller dan service membuat kode lebih terstruktur, mudah diuji, dan dipelihara.

18. Jika tidak menambahkan @Service, Spring tidak akan mengenali class tersebut sebagai bean, sehingga tidak bisa di-inject ke komponen lain.

19. @RequestParam digunakan untuk mengambil parameter dari query string pada request HTTP, biasanya pada endpoint GET.

20. Dengan membuat constructor di controller yang menerima parameter bertipe service, lalu Spring akan meng-inject service tersebut secara otomatis. 

## 🔸 **D. Koreksi Kode (5 Soal)**

### 21.
**Before**
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello(); // error
    }
}
```
**Kesalahan:**
- `helloService` tidak dideklarasikan dan tidak di-inject.

**After**
```java
@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHello();
    }
}
```

### 22.
**Before**
```java
public class Person {
    public String name;

    public void Person(String name) {
        this.name = name;
    }
}
```
**Kesalahan:**
- Constructor tidak dideklarasikan dengan benar (seharusnya tanpa tipe return).

**After**
```java
public class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}
```

### 23.
**Before**
```java
@RestController
public class GreetController {
    @PostMapping("/greet")
    public String greet(@RequestBody name) {
        return "Hello, " + name;
    }
}
```
**Kesalahan:**
- `@RequestBody` harus menerima tipe data yang sesuai, misal `String` atau objek.

**After**
```java
@RestController
public class GreetController {
    @PostMapping("/greet")
    public String greet(@RequestBody String name) {
        return "Hello, " + name;
    }
}
```

### 24.
**Before**

```java
@Service
public class InfoService {
    public String getInfo() {
        return "Info OK";
    }
}

// controller
@RestController
public class InfoController {
    @GetMapping("/info")
    public String get() {
        InfoService info = new InfoService(); // langsung di-new
        return info.getInfo();
    }
}
```
**Kesalahan:**
- Service diinisialisasi manual, seharusnya di-inject oleh Spring

**After**
```java
@Service
public class InfoService {
    public String getInfo() {
        return "Info OK";
    }
}

@RestController
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/info")
    public String get() {
        return infoService.getInfo();
    }
}
```
### 25.
**Before**
```java
@RestController
public class MathController {
    @GetMapping("/add")
    public int addNumbers(int a, int b) {
        return a + b;
    }
}
```
**Kesalahan:**
- Parameter `a` dan `b` tidak didefinisikan dengan benar untuk diambil dari query string.

**after**
```java
@RestController
public class MathController {
    @GetMapping("/add")
    public int addNumbers(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }
}
```