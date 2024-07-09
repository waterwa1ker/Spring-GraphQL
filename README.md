# Spring & GraphQL

![Static Badge](https://img.shields.io/badge/Java-white)
![Static Badge](https://img.shields.io/badge/Spring-white)
![Static Badge](https://img.shields.io/badge/GraphQL-white)
![Static Badge](https://img.shields.io/badge/Spqr-white)


## Обоснование выбора GraphQL

Есть несколько страниц с отображением одного и того же товара, однако с разной информацией на ней.

![catalog-list](./images/catalog-list.png)
![product-page](./images/product-page.png)

С одной стороны, никаких проблем с этим нет, однако при большом количестве данных будет страдать производительность. Можно, используя REST, создать два разных DTO, и проблема вроде решена, однако количество DTO сущностей зависит от количества страниц с выводом информацией о продукции:

```java
public class ProductCatalogDTO {

  private String commonName;

  private String description;

  private String casNumbers;

  private String companyName;

  //Getters & Setters
}
```

```java
public class ProductPageDTO {

  private String commonName;

  private String description;

  private String casNumbers;

  private String companyName;

  private int price;

  //Another fields, Getters & Setters
}
```

Тут на помощь приходит GraphQL, который решает проблемы с предоставлением только нужной информации со своим языком запросов, например:

```graphql
query {
  products {
    commonName
    description
    companyName
    casNumbers
  }
}
```

Или

```graphql
query {
  product(ARGUMENT) {
    commonName
    description
    casNumbers
    companyName
    casNumbers
    price
  }
}
```

Очевидно, что это удобная вещь, которая помогает не создавать ненужные методы или POJO классы.

## Manual GraphQL

Есть два способа взаимодействия Spring & GraphQL:

- с помощью .graphqls файла
- с помощью аннотаций, используя [spqr](https://github.com/leangen/graphql-spqr?tab=readme-ov-file)

Начнем с .graphqls файла:

```
type Product {
    id: ID!
    smiles: String
    formula: String
    commonName: String
    molecularWeight: Float
    russianCommonName: String
    description: String
}

input ProductDTO {
    smiles: String
    formula: String
    commonName: String
    molecularWeight: Float
    russianCommonName: String
    description: String
}

type Query {
    products: [Product]!
    product(id: ID!) : Product
}

type Mutation {
    addProduct(productDTO: ProductDTO!) : Product
}
```

Здесь мы описываем наши сущности, взаимодействия с ними.

Query - запросы, при которых мы никак не меняем БД (аналог GET запроса).
Mutation - аналог POST/PUT/PATCH запросов.
