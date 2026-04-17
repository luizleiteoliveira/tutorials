# Primeiros Passos

### Documentação de Referência

Para mais informações, considere as seguintes seções:

* [Documentação oficial do Apache Maven](https://maven.apache.org/guides/index.html)
* [Guia de Referência do Plugin Maven do Spring Boot](https://docs.spring.io/spring-boot/4.0.5/maven-plugin)
* [Criar uma imagem OCI](https://docs.spring.io/spring-boot/4.0.5/maven-plugin/build-image.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/4.0.5/reference/using/devtools.html)
* [Spring REST Docs](https://docs.spring.io/spring-restdocs/docs/current/reference/htmlsingle/)
* [SpringDoc OpenAPI](https://springdoc.org/)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.5/reference/web/servlet.html)

### Guias

Os seguintes guias ilustram como usar alguns recursos de forma prática:

* [SpringDoc OpenAPI](https://github.com/springdoc/springdoc-openapi-demos/)
* [Construindo um Serviço Web RESTful](https://spring.io/guides/gs/rest-service/)
* [Servindo Conteúdo Web com Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Construindo serviços REST com Spring](https://spring.io/guides/tutorials/rest/)

### Sobrescritas do POM Pai do Maven

Devido ao design do Maven, elementos são herdados do POM pai para o POM do projeto.
Embora a maior parte da herança seja adequada, ela também herda elementos indesejados como `<license>` e `<developers>` do pai.
Para evitar isso, o POM do projeto contém sobrescritas vazias para esses elementos.
Se você mudar manualmente para um pai diferente e realmente quiser a herança, será necessário remover essas sobrescritas.
