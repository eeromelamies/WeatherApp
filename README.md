# WeatherApp
---
Yksinkertainen ja todella tyylikäs Android-sääsovellus, joka hakee reaaliaikaiset säätiedot OpenWeather API:sta kaupungin nimen perusteella.

---

## Mitä Retrofit tekee

Retrofit on Android-kehityksen standardikirjasto, joka muuttaa monimutkaiset verkkopyynnöt (HTTP) helposti hallittaviksi Kotlin-funktioiksi.

---

## Miten JSON muutetaan dataluokiksi

Palvelimet vastaavat yleensä JSON-muodossa, joka on vain pitkä pätkä tekstiä. Retrofit käyttää apunaan Gson-konvertteria, joka lukee tuon tekstin ja asettaa tiedot automaattisesti luotuihin Kotlin-dataluokkiin.

---

## Miten API-key on tallennettu

Sovelluksen API-avain on tallennettu projektin juuren local.properties-tiedostoon. Tämä tiedosto on lisätty .gitignore-listalle.
