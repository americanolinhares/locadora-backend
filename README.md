# CRUD Simples usando Java EE
Back-end criado para sistema de cadastro de carros

### Tecnologias/Ferramentas utilizadas:

* JDK 1.8.0_201
* Eclipse Version: 2019-03 (4.11.0)
* Apache Maven 3.5.3
* Apache Tomcat 8.5.40
* Jersey 1.18.3
* JUnit 4.12
* SonarLint 4.1
* EclEmma Java Code Coverage 3.1.2
* Checkstyle 8.18.0
* S.O. Windows

### Execução em ambiente de desenvolvimento usando Eclipse:

* Clonar o projeto:

```sh
$ git clone https://git@github.com:americanolinhares/locadora-backend.git
$ cd locadora-backend
```

1. Dentro do Eclipse com a perspectiva **Java EE** ir em *File*->*Import*->*Maven*->*Existing Maven Projects*->*Next*;
2. Em *Root Directory* selecionar a pasta com o projeto baixado e depois *Finish*;
3. Clicar com o botão direito na pasta do projeto->*Run as*->*Maven Install*;
4. Configurar Tomcat. Deve ser baixada a versão 8.5.40 em [Tomcat](https://tomcat.apache.org/download-80.cgi):
    - Na view *Servers* clicar com o botão direito->*New*->*Server*;
    - Selecionar *Tomcat v8.5 Server*->*Add*;
    - Em *Browse* selecionar o caminho de instalação do Tomcat. Depois *Finish*;
    - Clicar em *Next* e adicionar o recurso **locadora**. Depois *Finish*.
5. Clicar com o botão direito na pasta do projeto->*Run as*->*Run on Server*;
6. Selecionar *Choose an existing server* e clicar no servidor Tomcat configurado anteriormente;
7. *Finish*.

### Execução de testes unitários usando Eclipse:

Para testar os pacotes **bean** e **service** clicar com o botão direito na pasta do projeto->*Run as*->*Maven test*.

### Execução de testes de integração usando Eclipse:

1. Para testar o pacote **controller** deve-se primeiramente executar a aplicação;
2. Com a aplicação executando, clicar com o botão direito em cima da classe **VeiculoControllerTest** do pacote **com.infosistemas.veiculo.controller** e selecionar **Run as JUnit Test**.

### Possível Erro Tomcat:
Se ao tentar subir o servidor Tomcat ocorrer o erro:

```
Servlet [jersey] in web application [/locadora] threw load() exception java.lang.ClassNotFoundException: com.sun.jersey.spi.container.servlet.ServletContainer...
```
 verificar se na view *Markes* é exibida a mensagem:

 ```
Classpath entry org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER will not be exported or published. Runtime ClassNotFoundExceptions may result
 ```
Caso positivo, clicar com o botão direito na mensagem->*Quick Fix*->*Mark the associated raw classpath entry as a publish/export dependency*->*Finish*. Depois repetir os passos para a execução da aplicação.

### Inicialização/Gravação de dados
Ao iniciar a aplicação quatro registros(veículos) são inseridos automaticamente.
Os dados atualizados são salvos no arquivo texto:

* C:\temp\infosistemas.txt



### Testes (Postman)
![postman-test](https://i.ibb.co/z6RpqbC/backend.png)