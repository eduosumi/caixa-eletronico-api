#Descrição
Api de teste com swagger e sem acesso/armazenamento de dados(banco, fila,..) para testes e customizaçōes do SonarQube.

##SonarQube
A UI deve estar em http://localhost:9000

##Rodando o scanner
 - mvn clean install
 - mvn sonar:sonar \
    -Dsonar.projectKey=ApiCaixaEletronico \
    -Dsonar.host.url=http://localhost:9000 \
    -Dsonar.login=b75d85ba5edd9c3d0c301d3aaa8cc8dab458841a
 - Obs.: o "login" informado acima é o obtido no cadastro/configurações iniciais da UI do SonarQube.

##Outras considerações
Existem 3 formas de de ignorar verificações de Quality Gate:
 - no código -> @SuppressWarnings("all")
 - no projeto -> pom.xml
 - na UI do SonarQube -> esse caso não consegui validar.

Sobre a segunda forma via pom.xml:
 - 2 asteriscos(**) significa qualquer pasta;
 - 1 asterisco(*) significa qualquer nome de arquivo;
 - sonar.cpd.exclusions: ignora somente a Duplications;
 - sonar.exclusions: ignora tudo(Duplications, rules, Coverage,...)
 - segue exemplo de build.gradle.kts:
```
subprojects {
    sonarqube {
        properties {
            property("sonar.cpd.exclusions", "**/controller/**")
        }
    }
}
```