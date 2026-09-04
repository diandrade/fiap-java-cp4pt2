# 🛒 Mercado Express - Spring MVC, Security e Deploy (CP4 Parte II)

## 📋 Descrição do Projeto

O **Mercado Express** é uma aplicação desenvolvida em **Java com Spring Boot** para o gerenciamento de produtos de um mercado.

O projeto é a continuação da **CP4 Parte I**, incorporando uma interface web desenvolvida com **Spring MVC e Thymeleaf**, além de **Spring Security**, containerização com **Docker** e deploy em ambiente de nuvem através do **Render**.

A aplicação disponibiliza:

* CRUD completo de produtos;
* API RESTful;
* Interface web com Thymeleaf;
* Persistência de dados utilizando Oracle;
* Validação de dados com Jakarta Validation;
* HATEOAS nas respostas da API;
* Spring Security para controle de acesso;
* Containerização utilizando Docker;
* Deploy da aplicação no Render.

---

## 👥 Integrantes do Grupo

* **Diego Andrade dos Santos** — RM: 566385
* **Grazielle de Alencar Silva** — RM: 561529
* **Julia Côrrea Souza** — RM: 564870
* **Rafael Kubagawa Ramos** — RM: 565572
* **Vinicius Soteras Braga** — RM: 566230

> **IDE utilizada para o desenvolvimento:** IntelliJ IDEA

---

## 🔗 Repositórios no GitHub

### CP4 — Parte I

https://github.com/BragaSoterasVinicius/cp4pt1

### CP4 — Parte II — Spring MVC

https://github.com/diandrade/fiap-java-cp4pt2

---

## 🎥 Vídeo de Demonstração

O vídeo de demonstração da **CP4 Parte II** está disponível no Google Drive:

https://drive.google.com/file/d/1K0iyqK-HiNOCxIoTVldMzscYIDyMLiWs/view?usp=sharing

---

## ⚙️ Tecnologias e Dependências

O projeto foi desenvolvido utilizando:

* **Java 21**
* **Maven**
* **Spring Boot**
* **Spring Web**
* **Spring MVC**
* **Spring Data JPA**
* **Spring Security**
* **Thymeleaf**
* **Thymeleaf Extras Spring Security**
* **Spring HATEOAS**
* **Jakarta Validation**
* **Lombok**
* **Oracle Database**
* **Docker**
* **Render**

### 📦 Principais dependências

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```

---

## 🗄️ Banco de Dados

O sistema utiliza o **Oracle Database**, reaproveitando a estrutura desenvolvida na CP4 Parte I.

### Tabela principal

`TDS_TB_mercado`

| Coluna    | Tipo                  | Descrição                  |
| :-------- | :-------------------- | :------------------------- |
| `ID`      | `Long`                | Chave primária             |
| `NOME`    | `String`              | Nome do produto            |
| `TIPO`    | `String`              | Categoria do produto       |
| `SETOR`   | `String`              | Setor/corredor do mercado  |
| `TAMANHO` | `String`              | Tamanho ou peso do produto |
| `PRECO`   | `Double / BigDecimal` | Valor unitário do produto  |

As informações de conexão com o banco são configuradas por meio do `application.properties` e, no ambiente de produção, devem ser fornecidas através de variáveis de ambiente.

---

## 🏗️ Arquitetura da Aplicação

A aplicação utiliza uma separação de responsabilidades entre as principais camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Essa organização permite separar as responsabilidades da aplicação, facilitando a manutenção, evolução e reutilização do código.

---

## 🌐 API REST

A API REST está disponível através do endpoint base:

```text
/mercado
```

### Endpoints

```text
GET     /mercado
GET     /mercado/{id}

POST    /mercado

PUT     /mercado/{id}

PATCH   /mercado/{id}/nome
PATCH   /mercado/{id}/tipo
PATCH   /mercado/{id}/setor
PATCH   /mercado/{id}/tamanho
PATCH   /mercado/{id}/preco

DELETE  /mercado/{id}
```

A API permite realizar o gerenciamento completo dos produtos cadastrados.

---

## 🖥️ Interface Web

A interface web foi desenvolvida utilizando **Spring MVC e Thymeleaf**.

O endpoint principal da aplicação web é:

```text
/mercado/web
```

A interface permite:

* Visualizar os produtos cadastrados;
* Cadastrar novos produtos;
* Atualizar produtos;
* Excluir produtos.

O template principal está localizado em:

```text
src/main/resources/templates/index.html
```

A página foi desenvolvida utilizando uma interface simples e responsiva para facilitar o gerenciamento dos produtos.

### 📸 Interface da aplicação

![Interface do Mercado Express](./imagens/interface.png)

---

## 🔐 Spring Security

O projeto utiliza **Spring Security** para controle de acesso às funcionalidades da aplicação.

A configuração de segurança está localizada em:

```text
src/main/java/fiap/com/tdspo/mexpress/config/SecurityConfig.java
```

O Spring Security é responsável por integrar os mecanismos de autenticação e autorização da aplicação, permitindo definir quais recursos podem ser acessados publicamente e quais necessitam de autenticação.

---

## 🧪 Validação de Dados

A aplicação utiliza **Jakarta Validation** para validar os dados recebidos nos DTOs.

A validação é realizada através das anotações disponibilizadas pela especificação, garantindo que os dados enviados para criação e atualização de produtos atendam aos requisitos definidos pela aplicação.

A dependência utilizada é:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

---

## 🔗 HATEOAS

A API utiliza **Spring HATEOAS** para disponibilizar links relacionados aos recursos retornados.

Dessa forma, além dos dados do produto, a resposta pode apresentar links para operações relacionadas ao recurso.

### Exemplo de resposta

```json
{
  "id": 1,
  "nome": "Maçã Gala",
  "tipo": "Fruta",
  "setor": "Hortifruti",
  "tamanho": "1kg",
  "preco": 8.50,
  "_links": {
    "self": {
      "href": "http://localhost:8080/mercado/1"
    },
    "atualizar": {
      "href": "http://localhost:8080/mercado/1"
    },
    "deletar": {
      "href": "http://localhost:8080/mercado/1"
    },
    "produtos": {
      "href": "http://localhost:8080/mercado"
    }
  }
}
```

---

## 🚀 Como Executar Localmente

### Pré-requisitos

* Java 21;
* Maven;
* Docker, caso deseje executar através de container;
* Acesso ao banco Oracle.

### Clonando o projeto

```bash
git clone https://github.com/diandrade/fiap-java-cp4pt2.git
```

Entre no diretório da aplicação:

```bash
cd fiap-java-cp4pt2/mexpress
```

### Executando com Maven

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

A porta utilizada pela aplicação é definida no `application.properties`.

### Interface Web

```text
http://localhost:8080/mercado/web
```

### API REST

```text
http://localhost:8080/mercado
```

---

## 🐳 Docker

O projeto possui um `Dockerfile` para criação da imagem da aplicação.

A estrutura atual do repositório é:

```text
fiap-java-cp4pt2/
├── Dockerfile
├── README.md
└── mexpress/
    ├── pom.xml
    ├── mvnw
    ├── .mvn/
    └── src/
```

Como o `Dockerfile` está na raiz e o código da aplicação está dentro de `mexpress`, a imagem pode ser construída utilizando o diretório `mexpress` como contexto:

```bash
docker build -f Dockerfile -t mercado-express mexpress
```

Para executar o container:

```bash
docker run -p 8080:8080 mercado-express
```

Após iniciar o container, a aplicação estará disponível em:

```text
http://localhost:8080/mercado/web
```

---

## ☁️ Deploy

A aplicação foi containerizada utilizando **Docker** e disponibilizada em ambiente de produção através da plataforma **Render**.

### 🚀 Plataforma utilizada

**Render**

### 🔗 Link do Deploy

https://fiap-java-cp4pt2-1.onrender.com

### 🖥️ Interface Web em produção

```text
https://fiap-java-cp4pt2-1.onrender.com/mercado/web
```

### 🔌 API REST em produção

```text
https://fiap-java-cp4pt2-1.onrender.com/mercado
```

### 🚢 Processo de Deploy

```text
GitHub
   ↓
Render
   ↓
Docker Build
   ↓
Java 21
   ↓
Spring Boot
   ↓
Aplicação Web + API REST
```

O Render realiza o build da aplicação utilizando o `Dockerfile` e executa o container em ambiente de produção.

A porta da aplicação é definida através da variável de ambiente `PORT` fornecida pelo ambiente de deploy.

---

## 📸 Evidências do Projeto

### Spring Initializr

![Configuração do Spring Initializr](./imagens/spring-initializr.png)

### Interface Web

![Interface do Mercado Express](./imagens/interface.png)

### API REST

![Evidência da API REST](./imagens/post-produto.png)

### Deploy no Render

![Deploy no Render](./imagens/render.png)

---

## 📚 Links da Entrega

### CP4 — Parte I

**GitHub:**
https://github.com/BragaSoterasVinicius/cp4pt1

### CP4 — Parte II

**GitHub:**
https://github.com/diandrade/fiap-java-cp4pt2

**Deploy — Render:**
https://fiap-java-cp4pt2-1.onrender.com

**Vídeo de demonstração — Google Drive:**
https://drive.google.com/file/d/1K0iyqK-HiNOCxIoTVldMzscYIDyMLiWs/view?usp=sharing

---

> *"Quem ouve, esquece. Quem vê, lembra. Quem faz, aprende."*
>
> **— Provérbio chinês**
