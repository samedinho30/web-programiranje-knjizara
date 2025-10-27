# 📚 Online Bookstore — Spring Boot MVC Demo

### 👥 Članovi tima
- **Student A:** [Eldar Alić]
- **Student B:** [Samed Zelkanović]

---

## 🧩 Opis aplikacije

Ova aplikacija demonstrira primjenu **MVC arhitekture u Spring Bootu** pomoću jednostavne teme *Online knjižara*.

Cilj projekta je prikaz rada sa **dvije povezane klase (modela)**, gdje su podaci prikazani kroz **Thymeleaf HTML stranice** i kontrolisani putem **Spring kontrolera**.  
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

---

## 🔗 Relacija između modela

Relacija između modela **Author** i **Book** je **1:N (jedan autor ima više knjiga)**.  
Svaka knjiga (`Book`) ima jednog autora (`Author`), dok jedan autor može imati više knjiga u svojoj kolekciji.

---

## 🌐 Rute u aplikaciji

| Ruta                      | Opis |
|---------------------------|------|
| `/autori`                 | Prikaz liste autora |
| `/knjige`                 | Prikaz liste knjiga |
| `/autori/autoriPoId/{id}` | Prikaz svih knjiga odabranog autora |

---

## 🖥️ Pogledi (HTML stranice)

- **listA.html** – prikaz svih autora
- **listB.html** – prikaz svih knjiga
- **action.html** – prikaz svih knjiga jednog autora

---

## ⚙️ Demo podaci

Aplikacija koristi klasu `DemoData.java` za generisanje testnih podataka (autori i knjige).  
Ovi podaci se učitavaju u memoriju pri pokretanju aplikacije, tako da aplikacija radi bez baze.

---

## 🚀 Pokretanje projekta

1. Otvori projekat u **IntelliJ IDEA** ili **Spring Tool Suite (STS)**.
2. Pokreni klasu `BookstoreApplication` kao **Spring Boot Application**.
3. Otvori u pregledniku:
    - [http://localhost:8080/autori](http://localhost:8080/autori) — lista autora
    - [http://localhost:8080/knjige](http://localhost:8080/knjige) — lista knjiga

---

## 🧑‍💻 Tehnologije

- **Java version 25**
- **Spring Boot**
- **Thymeleaf**
- **HTML5 / CSS3**
- **In-memory demo podaci**

---
##  Slika
<img width="2559" height="1439" alt="image" src="https://github.com/user-attachments/assets/233af494-35b9-4290-a0f5-8bff9a43d20a" />

---

📅 *Projekat izrađen za potrebe vježbe: Primjena MVC arhitekture u Spring Bootu.*
