# README

Il programma ha un context-datasource.xml dove sono settate le proprietà del datasource utilizzato , funziona in Mysql tramite una tabella con i seguenti campi:

  - CREATE TABLE `prodotti` (
  
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `product_name` varchar(30) NOT NULL,
  
  `price` double NOT NULL,
  
  `state` tinyint(1) NOT NULL,
  
  `description` varchar(255) NOT NULL,
  
  `quantity` int(11) NOT NULL
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Txt file like this

Esempio1151Descri7ione18506
Esempio2251Descrizione23015
Esempio3301D65crizione37301
Esempio4401Descrizi9ne47871
Esempio5401Descrizi9ne47871
Esempio6401Descrizi9ne47871

# Job explain!

 Il programma tramite il Main.java mette in funzione i vari Job(specificati nel spring-batch-context.xml) che fanno diverse cose :

- Il txtToxmlJob tramite un reader flatFileItemReader e un writer xmlItemWriter  (settati anch' essi nello stesso xml), legge da un file .txt e converte in maniera posizionale  in un file .xml con i vari tag in modo corretto.


- il xmlTodbJob tramite reader xmlItemReader e writer databaseItemWriter , legge dal  file .xml appena creato e inserisce in DB tramite mappatura di appositi campi.


- il dbToxmlJob tramite reader databaseItemReader e writer xmlItemWriterLetturaDB, legge i record in db e li stampa tutti in un file listaletturaDB.xml con tutti i tag annessi.

- il partitionJob al momento tramite un reader flatFileItemReaderSplit e un writer flatFileItemWriter , legge dal file .txt e splitta il file in tanti file .xml per ogni riga, e tramite un rangePartitioner implementato nel programma divide ogni file .
 
- il dbupdateJob setta i record già letti in db ad uno state TRUE in modo da non essere letti nuovamenti .


Nel programma è anche compreso un ItemProcessor che tramite una classe apposita ProductResultItemProcessor , permette di processare i Job con delle precise direttive.

# Start Job From Command Line!
 - First of all clone the project and "mvn clean install" on command line inside the   project folder!
 - Verranno creati due .jar nella directory target dentro al progetto, per far partire i vari job elencati sotto bisogna utilizzare il jar "-executable".
 

 ## DATO UN FILE lista.txt CREA UN FILE .xml 

    java -jar target/SpringBatchXmlToDatabase-1.0.0-executable.jar spring-batch-context.xml txtToxmlJob file=(path with .txt file) output=(output path of .xml file)

 ## DATO UN FILE .xml LEGGE ED INSERISCE TUTTI I RECORD IN DB

    java -jar target/SpringBatchXmlToDatabase-1.0.0-executable.jar spring-batch-context.xml xmlTodbJob file=(path with .xml file)

 ## LEGGE DA DB TUTTI I RECORD E LI STAMPA IN UN file .xml 

    java -jar target/SpringBatchXmlToDatabase-1.0.0-executable.jar spring-batch-context.xml dbToxmlJob output=(path with .xml file)

 ## DATO UN FILE lista.txt SPLITTA OGNI RIGA IN UN FILE .xml SINGOLO .
 
    java -jar target/SpringBatchXmlToDatabase-1.0.0-executable.jar spring-batch-context.xml partitionJob file=(yourpath.txt)  output=(yourpath directory)

 ## LEGGE DA DB TUTTI I RECORD E FA L'UPDATE DI QUELLI Già LETTI SETTANDOLI A state TRUE, COSI' DA NON FARLI LEGGERE PIU'.

    java -jar target/SpringBatchXmlToDatabase-1.0.0-executable.jar spring-batch-context.xml dbupdateJob




