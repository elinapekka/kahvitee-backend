### Kahvi-Tee Backend
Backend nettisivulle johon voi tallentaa tietoa lempikahvi- tai teelaaduista.

Löydät frontendin täältä: https://github.com/elinapekka/kahvitee-frontend

### Käyttöönotto-ohjeet

1. Lataa kahvitee-backend zip-tiedostona painamalla vihreää Code-painiketta ja valitsemalla ***Download zip***.

2. Pura zip-tiedostosta ***kahvitee-backend-main*** haluamaasi kohteeseen. 

3. Avaa EclipseIDE tai <a href="https://eclipseide.org/">lataa se</a> (valitse Eclipse IDE for Java EE Developers -package).

4. Valitse vasemmasta yläreunasta ***File > Import > Maven > Existing Maven file > Next***

5. Valitse Root directory painamalla Browse-nappia ja valitse juuri purkamasi kahvitee-backend-main-kansio. 

6. Painettuasi Finish-nappia, sinun voit löytää KahviTee-kansio Project Explorerista. 

7. Etsi ja avaa kansiosta ***src/main/java > com.example.CoffeeTea > CoffeeTeaApplication.java***

8. Käynnistä CoffeeTeaApplication.java painamalla vihreää Run-painiketta. 

9. Backendin pitäisi nyt toimia osoitteessa http://localhost:8080/

9. Käynnistä frontend. Ohjeet: https://github.com/elinapekka/kahvitee-frontend

10. Kun haluat pysäyttää backendin, paina Eclipsen konsolin punaista Terminate-painiketta. Jos sinulla ei ole konsoli auki, löydät sen ***Window > Show View > Console***