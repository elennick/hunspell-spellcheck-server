# hunspell-spellcheck-server

RESTful spellcheck web service provider using Hunspell dictionaries

Implemented using Spring 4 (spring framework, spring boot)

Implemented using HunspellJNA java wrapper around hunspell: https://github.com/dren-dk/HunspellJNA

To run from the command line in linux/macOSX you must have maven and java already installed and set up properly... you can then run: 

    mvn clean install && java -jar target/hunspell-spellcheck-server-1.0-SNAPSHOT.jar
  
You can test by hitting the web service:

    http://localhost:8080/spellcheck/words/word1,word2,word3,etc
