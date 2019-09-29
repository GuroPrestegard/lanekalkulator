# Enkel lånekalkulator

Kalkulerer lån basert på nominell rente, lånestørrelse, gebyr og start- og sluttdato. 
## Køring av prosjekt

1. Klon ned prosjektet. 
2. Åpne prosjektet some et Maven-prosjekt. Køyr oppgave/src/main/java/com/OppgaveApplication.java.
3. Send ein GET-request til localhost:8080/nedbetalingsplan med JSON(application/json) request i formatet
```json
{ 
      "laanebelop": 2000000, 
      "nominellRente": 3, 
      "terminGebyr":30, 
      "utlopsDato":"2045-01-01", 
      "saldoDato":"2020-01-01", 
      "datoForsteInnbetaling":"2020-02-01", 
      "ukjentVerdi":"TERMINBELOP",
 }
```
I respons vil ein få eit array med json-objekter av dette formatet: 

```json
[
    {
        "restgjeld": 7752191.575561703,
        "dato": "2020-03-01",
        "innbetaling": 124058.89912578915,
        "gebyr": 30.0,
        "rente": 19690.62618671873,
        "total": 143779.52531250787
    },
    ...,
]
```
### Test
For augeblikket ikkje implementert.

### Prerequisites

Java 11



## Bygd med
* [Spring Boot](https://spring.io)
* [Maven](https://maven.apache.org/) - Dependency Management
* [Tomcat](http://tomcat.apache.org/)

