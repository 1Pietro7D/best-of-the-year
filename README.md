"# best-of-the-year" 

Esercitazione di oggi: Spring MVC - Best of the year
Nome repo: best-of-the-year
Le modalità di consegna sono le solite, con repo github da associare alla cartella di progetto java.
Cosa fare?
Step 1
Creare un nuovo progetto Spring Boot MVC + Thymeleaf (vedi tutorial sulle slide).
Il nome del progetto è best-of-the-year (stesso nome del repo).
Nel progetto aggiungere un controller che risponde alla root dell’applicazione, con un metodo che restituisce una view fatta con Thymeleaf in cui viene stampato un titolo: “Best of the year by …” (al posto dei puntini deve apparire il vostro nome, passato come attributo dal controller attraverso il Model).
Step 2
Creare all’interno del controller due metodi privati :
- uno restituisce una lista di oggetti di tipo Movie - getBestMovies()
- l’altro restituisce una lista di  oggetti di tipo Song - getBestSongs()
Creare le classi Movie e Song aventi almeno :
- un id
- un titolo
Aggiungere al controller altri due metodi, che rispondono agli url
- “/movies”
- “/songs”
In ognuno di questi metodi aggiungere al Model un attributo stringa con una lista di titoli di migliori film o canzoni (in base al metodo che stiamo implementando) separati da virgole.
Utilizzare i due metodi getBest… per recuperare i film e le canzoni.
Creare i rispettivi template Thymeleaf.
Testare chiamando dal browser i diversi url.