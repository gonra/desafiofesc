# desafiofesc

Este projeto consta de 2 elementos

- desafio-be : Back-End Spring boot 

- desafio-fe : Front-End Vue2

Para a modelo das entidades foi construido no seguinte esquema, 

* Produto com seu tipo relacionado


| Product | 
|---------|
| id |
| code |
| description |
| providerPrice |
| stock |
| lastupdate |
| *TypeProduct*|


* Tipo de produto


| TypeProduct |
|----------|
| id |
| description |


* Operaçoes sobre o produto e os tipos de operaçoes relacionado (Movimentos)


|Operation |
|----------|
|id|
|salePrice|
|quantity|
|profit|
|datetime|
|*Product*|
|*TypeOperation*|


* Tipo de operaçoes


|TypeOperation|
|----------|
|id|
|description|


Para o tipo de movimento foi considerado o movimento de conferencia. A açao de Entrada e Saida, se distingue no valor positivo e negativo da quantidade.


---

## desafio-be

Para executar 

`mvn spring-boot:run`

Este projeto consta de um server API-REST com banco de dados HSQLDB em memoria. O banco de dados é povoado com dados de exemplo. A comunicaçao é realizada no porto 5000.

---

## desafio-fe

Para executar 

`npm run serve`

Este projeto Vue escuta no porto 8080. Consta de 4 seçoes :

- Produto : Lista de produto, Lista filtrada, Criaçao, Ediçao, Eliminaçao, Operaçoes no estoque do produto
- Tipo de produto : Lista, Criaçao, Eliminaçao
- Operaçoes : Lista, Lista filtrada
- Tipo de Operaçoes : Lista, Criaçao, Eliminaçao

No front-end sao realizadas as validaçoes de entrada e saida de estoque.
O modelo incorpora o lucro de cada operaçao