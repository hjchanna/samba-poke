#Samba-Poke
Samba poke is used to test samba connections with Java. Samba-Poke can be used as follows.

````
# download samba-poke
wget <url>

# run samba-poke
java -jar samba-poke.jar smb://whatever/your/path/ <domain> <username> <password> 
`````

##Getting Started
Samba-poke has developed using java and used maven as the dependency management and build tool. 

###Prerequisites
* Apache Maven
* JDK 1.8

###Installing

Use following commands to build samba-poke.

````
mvn clean package
````
##Release
Samba-poke will be released and destributed through github with in the same repository under **release** directory. The build command will be automatically build the release package in release directory. Samba-poke will be able to access in following link.

````
<url>
````

##Authors
* Channa Jayamuni 