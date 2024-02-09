### Kahvi-Tee Backend
Backend nettisivulle johon voi tallentaa tietoa lempikahvi- tai teelaaduista.

Löydät frontendin täältä: https://github.com/elinapekka/kahvitee-frontend

### Käyttöönotto-ohjeet

1. Avaa terminaali (esim. GitBash).

2. Siirry terminaalissa haluamaasi sijaintiin ja kloonaa Github-arkisto.
   ```sh
   git clone https://github.com/elinapekka/kahvitee-backend
   ```

3. Avaa EclipseIDE tai <a href="https://eclipseide.org/">lataa se</a> (valitse Eclipse IDE for Java EE Developers -package).

4. Valitse vasemmasta yläreunasta File > Import > Maven > Existing Maven file > Next

5. Valitse Root directory painamalla Browse-nappia ja valitse juuri kloonaamasi kahvitee-backend-kansio.

6. Etsi KahviTee-kansiosta src/main/java > com.example.CoffeeTea > CoffeeTeaApplication.java

7. Käynnistä CoffeeTeaApplication.java painamalla vihreää Run-painiketta.

8. Käynnistä frontend. Ohjeet: https://github.com/elinapekka/kahvitee-frontend

9. Kun haluat pysäyttää backendin, paina Eclipsen konsolin punaista Terminate-painiketta. Jos sinulla ei ole konsoli auki, löydät sen Window > Show View > Console