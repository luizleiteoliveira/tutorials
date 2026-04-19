# Base REST API - JDK 25

API REST base construída com **Spring Boot 4** e **Java 25**, servindo como ponto de partida para projetos que precisam de uma estrutura moderna, organizada e pronta para evoluir.

## Tecnologias

- Java 25
- Spring Boot 4.0.5
- Spring Data JPA
- H2 Database (em memória)
- Caffeine Cache
- SpringDoc OpenAPI (Swagger)

## Como executar

```bash
./mvnw spring-boot:run
```

A aplicação sobe na porta `8080`.

## Endpoints

### Products

| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/products` | Lista todos os produtos |
| GET | `/products/{id}` | Busca produto por ID (com cache) |
| POST | `/products` | Cria um novo produto |
| DELETE | `/products/cache` | Limpa o cache de produtos |

Exemplo de criação:
```bash
curl -X POST http://localhost:8080/products \
  -H 'Content-Type: application/json' \
  -d '{"name":"SSD 1TB","price":499.90}'
```

### Swagger UI

Disponível em: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Console H2

Disponível em: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

- JDBC URL: `jdbc:h2:mem:baserestapi`
- User: `sa`
- Password: (vazio)

## Dados iniciais

A aplicação já sobe com 5 produtos pré-cadastrados via `data.sql`:

| Nome | Preço |
|------|-------|
| Notebook | 4.599,90 |
| Teclado Mecânico | 349,90 |
| Mouse Gamer | 199,90 |
| Monitor 27" | 1.899,90 |
| Headset | 289,90 |

## Cache

O cache utiliza **Caffeine** com a seguinte configuração:

- Máximo de 500 entradas
- Expiração de 10 minutos após a escrita
- Busca por ID (`findById`) é cacheada automaticamente
- Criação/atualização de produto invalida a entrada no cache

## Estrutura de pastas

```
src/main/java/com/luizleiteoliveira/baserestapijdk25/
├── BaseRestApiJdk25Application.java
├── config/
│   └── CacheConfig.java
└── product/
    ├── Product.java
    ├── ProductController.java
    ├── ProductRepository.java
    └── ProductService.java
```

### Motivação

A organização segue o padrão **package by feature** (pacote por funcionalidade), onde cada domínio de negócio agrupa todas as suas camadas (entidade, repositório, serviço e controller) dentro de um mesmo pacote.

**Por que essa abordagem em vez de package by layer?**

- **Coesão**: tudo que diz respeito a `product` está junto. Ao abrir o pacote, você entende o domínio inteiro sem navegar entre pastas distantes.
- **Escalabilidade**: ao adicionar um novo domínio (ex: `order`, `customer`), basta criar um novo pacote com suas próprias classes. Nenhum pacote existente é alterado.
- **Encapsulamento**: no futuro, classes internas do domínio podem ter visibilidade `package-private`, expondo apenas o que é necessário para o resto da aplicação.
- **Facilidade de exclusão**: se um domínio for removido, basta deletar o pacote inteiro.

O pacote `config/` é a exceção — ele contém configurações transversais que não pertencem a nenhum domínio específico, como a configuração de cache que atende toda a aplicação.
