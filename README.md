# Samba-Poke
[![CircleCI](https://circleci.com/gh/hjchanna/samba-poke.svg?style=shield)](https://circleci.com/gh/hjchanna/samba-poke)
![Release](https://img.shields.io/github/release/hjchanna/samba-poke.svg?style=flat)
>Samba poke is used to test samba connections *(smb://)* with Java. It will connect to a samba host which has passed as runtime arguments by using samba domain and credentials which are passed through same runtime arguments. Basic useage of samba-poke as follows. 

````
# download samba-poke
wget https://github.com/hjchanna/samba-poke/raw/master/release/samba-poke.jar

# run samba-poke
java -jar samba-poke.jar smb://whatever/your/path/ <domain> <username> <password> 
- or - 
java -jar samba-poke.jar smb://whatever/your/path/ <domain> <username> 
`````
#### Runtime Arguments
* [1] samba host *(Ex: smb://whatever/your/path/)*
* [2] samba domain 
* [3] username
* [4] password *(optional, it would prompt password if not passed as runtime arg)*

#### Runtime Dependencies
* Java Runtime *(Tested with JRE 1.8)* 

## Getting Started (Developer Section)
Java is the primary programming language of samba-poke. Apache Maven is used as the dependancy managment and build tool. The samba-poke uses `jcifs` library to connect samba protocol.

### Prerequisites
* JDK 1.8
* Apache Maven (Build)

### Installing
#### Build Command and the build process.
````
mvn clean package
````
Above build command will compile and generate the jar file in target directory similar to general maven projects. The build command also generate the relase package (jar) in *release/* folder in the project root. 

## Release
Samba-poke will be destributed through github with in the same repository in the *release/* directory. As mentioned above the build command will be automatically generate the release package in the *release/* directory of project root. Refer following release link to the samba-poke.

````
https://github.com/hjchanna/samba-poke/raw/master/release/samba-poke.jar
````

## Authors
* Channa Jayamuni 
