# 💰 API de Gastos Residenciais

## 📌 Visão Geral
A **API de Gastos Residenciais** é um serviço desenvolvido em **Spring Boot** que permite o cadastro e gerenciamento de **pessoas** e suas respectivas **transações financeiras** (despesas e receitas). O objetivo é facilitar o controle financeiro, permitindo que os usuários registrem e visualizem suas movimentações de forma organizada e eficiente.

Este projeto demonstra minha capacidade de desenvolver **APIs RESTful escaláveis**, utilizando boas práticas de desenvolvimento e integração com banco de dados. 🚀

---

## 🛠️ **Tecnologias Utilizadas**

- **Java 21** – Linguagem principal para construção da API
- **Spring Boot** – Framework para desenvolvimento rápido e eficiente
- **Spring Data JPA** – Integração com banco de dados
- **H2 Database** – Banco de dados em memória para testes
- **Maven** – Gerenciamento de dependências
- **Postman** – Testes de API
- **Git/GitHub** – Versionamento de código


---


## ⚙️ **Configuração e Execução do Projeto**

### **1️⃣ Clonar o Repositório**
```bash
git clone https://github.com/HumbertoMoreira/DesafioMaxiprod/tree/master
cd DesafioMaxiprod
```

### **2️⃣ Executar a Aplicação**
```bash
mvn spring-boot:run
```
A API estará disponível em: `http://localhost:8080`

---

## 🔍 **Endpoints da API**

### **👤 Pessoas**
- `GET /cadastropessoas` – Lista todas as pessoas cadastradas
- `GET /cadastropessoas/{id}` – Busca uma pessoa pelo ID
- `POST /cadastropessoas` – Cadastra uma nova pessoa
- `PUT /cadastropessoas/{id}` – Atualiza uma pessoa existente
- `DELETE /cadastropessoas/{id}` – Remove uma pessoa e remove todas as transações relacionadas a essa pessoa.

### **💵 Transações**
- `GET /cadastrotransacoes` – Lista todas as transações cadastradas
- `GET /cadastrotransacoes/{id}` – Busca uma transação pelo ID
- `POST /cadastrotransacoes` – Cadastra uma nova transação
- `PUT /cadastrotransacoes/{id}` – Atualiza uma transação existente
- `DELETE /cadastrotransacoes/{id}` – Remove uma transação

---

## 📝 **Documentação da API**
A API está documentada detalhada nas referências: [Documentação em PDF](https://github.com/HumbertoMoreira/DesafioMaxiprod/blob/master/src/main/java/com/example/DesafioMaxiprod/documentacao/Documenta%C3%A7%C3%A3o%20da%20API%20de%20Gastos%20Residenciais.pdf)


---

## 📩 **Contato**
Caso tenha interesse em saber mais sobre este projeto ou discutir oportunidades, entre em contato:
- **LinkedIn:** [Perfil](https://www.linkedin.com/in/humberto-moreira/)
- **GitHub:** [Repositório](https://github.com/HumbertoMoreira)
- **Email:** moreirahumbertoch@gmail.com

---

> _"A melhor maneira de prever o futuro é criá-lo." – Alan Kay_ ✨

---



