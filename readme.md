# 📚 Online Bookstore — Spring Boot MVC Demo

### 👥 Članovi tima
- **Student A:** [Eldar Alić]
- **Student B:** [Samed Zelkanović]

---

## 🧩 Opis aplikacije

Ova aplikacija demonstrira primjenu **MVC arhitekture u Spring Bootu** pomoću jednostavne teme *Online knjižara*.

Cilj projekta je prikaz rada sa **više povezanih klasa (modela)**, gdje su podaci prikazani kroz **Thymeleaf HTML stranice** i kontrolisani putem **Spring kontrolera**.  
Aplikacija koristi **in-memory podatke** iz klase `DemoData.java`, bez baze podataka.

---

## 🧠 Modeli i relacija

### 1️⃣ `Author`
Predstavlja autora knjiga.  
**Atributi:**
- `id` — jedinstveni identifikator autora
- `name` — ime autora
- `nationality` — nacionalnost
- `birthYear` — godina rođenja
- `email` — kontakt e-mail
- `books` — lista knjiga koje je autor napisao

### 2️⃣ `Book`
Predstavlja pojedinačnu knjigu.  
**Atributi:**
- `id` — jedinstveni identifikator knjige
- `title` — naslov knjige
- `genre` — žanr
- `year` — godina izdavanja
- `price` — cijena knjige
- `author` — referenca na autora
- `reviews` — lista recenzija za knjgu

### 3️⃣ `Review`
Predstavlja recenziju za pojedinačnu knjigu.  
**Atributi:**
- `id` — jedinstveni identifikator recenzije
- `book` — referenca na knjgu
- `content` — tekst recenzije
- `rating` — ocjena (1-5 zvjezdica)

---

## 🔗 Relacije između modela

- **Author ↔ Book:** Relacija **1:N** (jedan autor ima više knjiga)
- **Book ↔ Review:** Relacija **1:N** (jedna knjiga ima više recenzija)

Svaka knjiga (`Book`) ima jednog autora (`Author`), a svaka recenzija (`Review`) pripada jednoj knjizi. Jedan autor može imati više knjiga, a jedna knjiga može imati više recenzija.

---

## 🌐 Rute u aplikaciji

### 📄 MVC Rute (HTML Pogledi)

| Ruta                      | Opis |
|---------------------------|------|
| `/`                       | Početna stranica |
| `/autori`                 | Prikaz liste autora |
| `/knjige`                 | Prikaz liste knjiga |
| `/autori/autoriPoId/{id}` | Prikaz svih knjiga odabranog autora |
| `/recenzije`              | Prikaz liste recenzija |
| `/recenzije/id/{id}`      | Pregled recenzije po ID-u |

### 📡 REST API Endpoints

| Endpoint | Metoda | Opis |
|----------|--------|------|
| `/api/authors` | GET | Preuzmi sve autore u JSON formatu |

---

## 🖥️ Pogledi (HTML stranice)

- **index.html** – početna stranica sa navigacijom
- **listA.html** – prikaz svih autora
- **listB.html** – prikaz svih knjiga
- **action.html** – prikaz svih knjiga jednog autora
- **review-list.html** – prikaz liste recenzija
- **review-form.html** – forma za dodavanje nove recenzije
- **book-details.html** – detalji knjige sa recenzijama

---

## ⚙️ Demo podaci

Aplikacija koristi klasu `DemoData.java` za generisanje testnih podataka (autori, knjige i recenzije).  
Ovi podaci se učitavaju u memoriju pri pokretanju aplikacije, tako da aplikacija radi bez baze.

---

## 🚀 Pokretanje projekta

1. Otvori projekat u **IntelliJ IDEA** ili **Spring Tool Suite (STS)**.
2. Pokreni klasu `KnjizaraApplication` kao **Spring Boot Application**.
3. Otvori u pregledniku:
    - [http://localhost:8080/](http://localhost:8080/) — početna stranica
    - [http://localhost:8080/autori](http://localhost:8080/autori) — lista autora
    - [http://localhost:8080/knjige](http://localhost:8080/knjige) — lista knjiga
    - [http://localhost:8080/recenzije](http://localhost:8080/recenzije) — lista recenzija

---

## 🧑‍💻 Tehnologije

- **Java version 25**
- **Spring Boot**
- **Spring REST API**
- **Thymeleaf**
- **HTML5 / CSS3**
- **In-memory demo podaci**
- **Jackson** (za JSON serijalizaciju)

---

## ✨ Nove funkcionalnosti (u odnosu na originalnu verziju)

### Dodane klase:
- **`Review.java`** — Model za recenzije
- **`ReviewService.java`** — Servis za rukovanje recenzijama
- **`ReviewRestController.java`** — REST API kontroler za recenzije
- **`AuthorRestController.java`** — REST API kontroler za autore
- **`BookRestController.java`** — REST API kontroler za knjige

### Dodani REST API endpointi:
- `/api/authors` — Pregled svih autora u JSON formatu
- `/api/reviews` — Pregled svih recenzija u JSON formatu
- `/api/reviews` (POST) — Dodavanje nove recenzije
- `/api/reviews/{id}` — CRUD operacije na recenzijama

### Dodane HTML stranice:
- **index.html** — Početna stranica sa navigacijom i dugmadima za REST API
- **review-list.html** — Lista recenzija
- **review-form.html** — Forma za dodavanje recenzije
- **book-details.html** — Detalji knjige sa povezanim recenzijama

### Poboljšanja:
- JSON serijalizacija sa `@JsonIgnore` i `@JsonIgnoreProperties` anotacijama
- Sprječavanje kružnih referenci između modela
- Modal forme za kreiranje recenzija preko REST API-ja
- Dinamički prikaz podataka kroz JavaScript

---

## 🔧 Primjer REST API poziva

### Preuzmi sve autore:
\`\`\`bash
curl -X GET http://localhost:8080/api/authors
\`\`\`

### Preuzmi sve recenzije:
\`\`\`bash
curl -X GET http://localhost:8080/api/reviews
\`\`\`

### Kreiraj novu recenziju:
\`\`\`bash
curl -X POST http://localhost:8080/api/reviews \
  -H "Content-Type: application/json" \
  -d '{
    "bookId": 1,
    "content": "Odličan roman!",
    "rating": 5
  }'
\`\`\`

---
