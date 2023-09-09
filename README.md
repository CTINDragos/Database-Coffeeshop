Proiect Baze de Date




Diagrama ER pe baza căreia a fost gândită și creată aplicația:


 

Elemente utilizate: 
⦁	DBMS PostgreSQL
⦁	Tabele SQL
⦁	Pachetul SQL din Java

Pentru rularea aplicației să se instaleze și să se folosească IntelliJ IDEA:
⦁	Deschiderea Proiectului
⦁	Click dreapta pe Proiect → Open Module Settings → Sub Platform Settings să se selecteze SDKs → Click pe + pe partea de sus → Download JDK… → Selectarea versiunii 17 furnizată de Amazon Correto → Download

Pentru	creearea si importarea bazei de date din backup să se instaleze și să se deschidă PgAdmin 4:
⦁	Se creează o nouă bază de date.
⦁	Click Dreapta pe noua  bază de date → Restore… → Selectarea fișierului   backup.sql → Restore 

Pentru crearea conexiunii între aplicație și baza de date:
⦁	Deschiderea Proiectului
⦁	În clasa src/FactoryDatabase să se modifice în variabila String url, denumirea, user și password în funcție de cele setate în PgAdmin 4. (Ex: “jdbc:postgresql://localhost/[denumire bază de date]?user=[utilizator]&password=[parolă]&ssl=false”)

Pași pentru folosirea aplicației:
Aplicatia se poate folosii prin chemarea functiilor desemnate operatiilor CRUD in main si rularea programului.
de exemplu daca vrem sa adaugam un obiect de tip water in tabela water vom chema functia CreateWater(nume:string,volum:int,id-ul cafelei la care se fol apa:int(foreign key);
Pt Read,Update si Delete se va face acelasi lucru dar cu id-ul obiectului pe care se vrea folosirea functiei, pt Update vom apela UpdateWater(1) s.a.m.d
