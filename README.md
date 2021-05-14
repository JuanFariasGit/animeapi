## AnimeAPI - Projeto API REST de controle de animes assistidos com Spring Boot e Swagger UI 2 para o Bootcamp Code Anywhere da Digital Innovation One

### disponível em https://animeapi-project-spring-boot.herokuapp.com/swagger-ui.html

Para executar o projeto no terminal, digite o seguinte comando:
~~~
mvn spring-boot:run 
~~~
Após executar o comando acima, basta apenas abrir o seguinte endereço:
~~~
http://localhost:8080/swagger-ui.html
~~~
Animes
~~~
Verbo HTTP        Path             Action

   GET      /api/v1/animes         retorna uma lista de animes
   
   POST     /api/v1/animes         adiciona um anime
   
   DELETE   /api/v1/animes/{id}    exclui um anime
   
   GET     /api/v1/animes/{id}     retorna um anime unico
   
   PUT     /api/v1/animes/{id}     atualiza um anime
~~~
Categories
~~~
Verbo HTTP        Path                 Action

   GET      /api/v1/categories         retorna uma lista de categorias
   
   POST     /api/v1/categories         adiciona uma categoria
   
   DELETE   /api/v1/categories/{id}    exclui uma categoria
   
   GET     /api/v1/categories/{id}     retorna uma categoria unico
   
   PUT     /api/v1/categories/{id}     atualiza uma categoria
~~~
