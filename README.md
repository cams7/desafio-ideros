# desafio-ideros
Desafio ÍDEROS [Desenvolvedor Java Web]

# Passo a passo

# Baixar o projeto
- Instale o Git, caso ainda não o tenha instalado.
- Para baixar o projeto, no CONSOLE do Linux ou no CMD do Windows, execute o comando "git clone https://github.com/cams7/desafio-ideros.git".

# Executar o primeiro desafio
- Abra a pasta 'AngularJS'.
- Abra o arquivo 'index.html' dentro de um navegado, preferencialmente Firefox ou Chrome.

# Executar o segundo desafio
- Baixe o Tomcat7, caso ainda não o tenha baixado.
- Inclua o usuario e senha "tomcat" no servidor Tomcat7. Para isso, inclua a tag "<user username="tomcat" password="tomcat" roles="manager-script"/>" dentro da tag "<tomcat-users>" no arquivo 'tomcat-users.xml'.
- Inicialize o Tomcat7.
- Instale o Maven, caso ainda não o tenha baixado.
- Atraves do comando "cd ../SpringRest", no CONSOLE do Linux ou no CMD do Windows entre no diretorio 'SpringRest'.
- Para compilar o projeto e baixar as dependencias, execute o comando "mvn clean install".
- Com o Tomcat7 inicializado e dentro do diretorio 'SpringRest' execute o comando "mvn tomcat7:deploy"
- Copie o endereco "http://localhost:8080/desafio_ideros" no navegador e teste a aplicação. Se o host e ou a porta do Tomcat7 forem diferentes, ocorrerar um erro, e entao sera necessario alterar os arquivos '../desafio-ideros/SpringRest/pom.xml' e '../desafio-ideros/SpringRest/src/main/webapp/js/value/configValue.js'. Para isso, altere a "linha 181" do 'pom.xml' e a "linha 2" do 'configValue.js', informando o endereco correto do Tomcat7. Caso as mudanças nesses arquivos sejam aplicadas, logo apos a alteração execute o comando "mvn clean install tomcat7:redeploy" dentro do diretorio 'SpringRest'.  
- Apos o teste finalizado, execute o comando "mvn tomcat7:undeploy" dentro do diretorio 'SpringRest' e pare o Tomcat7.
- Outra possibilidade e importar o modulo Maven para dentro do Eclipse.
