## AnimeAPI - Projeto API REST de controle de animes assistidos com Spring Boot e Swagger UI 2 para o Bootcamp Code Anywhere da Digital Innovation One

### disponível em https://animeapi-project-spring-boot.herokuapp.com/swagger-ui.html

SGDB utilizado : PostgreSQL

Configuração localhost:
~~~
Database : animeapi
Username : postgres
Password : 1234
~~~

Para executar o projeto no terminal, digite o seguinte comando:
~~~
mvn spring-boot:run 
~~~
Após executar o comando acima, basta apenas abrir o seguinte endereço:
~~~
http://localhost:8080/swagger-ui.html
~~~
Anime:
~~~
Verbo HTTP        Path             Action

   GET      /api/v1/animes         retorna uma lista de animes
   
   POST     /api/v1/animes         adiciona um anime
   
   DELETE   /api/v1/animes/{id}    exclui um anime
   
   GET     /api/v1/animes/{id}     retorna um único anime
   
   PUT     /api/v1/animes/{id}     atualiza um anime
~~~
Category:
~~~
Verbo HTTP        Path                 Action

   GET      /api/v1/categories         retorna uma lista de categorias
   
   POST     /api/v1/categories         adiciona uma categoria
   
   DELETE   /api/v1/categories/{id}    exclui uma categoria 
   
   GET     /api/v1/categories/{id}     retorna uma única categoria
   
   PUT     /api/v1/categories/{id}     atualiza uma categoria
~~~
