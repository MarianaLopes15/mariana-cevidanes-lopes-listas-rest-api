# Projeto Listas Rest API
Avaliação 03 – Acelera G&P
Projeto de um REST API para organizar listas e itens, realizado por Mariana Lopes.

## ✔️ Técnicas e tecnologias utilizadas

- ``Java 17``
- ``Spring Boot``
- ``Hibernate``
- ``MySql``
- ``Swagger``

## 🔨 Funcionalidades do projeto

## Listas
- `Funcionalidade 1` `Cadastro de Listas`: Para cadastrar uma lista, deve ser informado seu titulo. O campo titulo deve ter no maximo 100 caracteres e no minimo 1, sendo obrigatória sua inserção.
- `Funcionalidade 2` `Alteração de Listas pelo id`: Para a alteração de uma lista pelo seu id, é preciso informar obrigatoriamente o seu id. Podendo alterar seu titulo. O campo titulo deve ter no maximo 100 caracteres e no minimo 1, sendo obrigatória sua inserção.
- `Funcionalidade 3` `Buscar lista pelo id`: Para realizar a busca de uma lista pelo seu id, é preciso informar obrigatoriamente seu id.
- `Funcionalidade 4` `Listar todas as listas`: Lista todas as listas cadastradas na API. 
- `Funcionalidade 5` `Excluir uma lista pelo id`: Para a exclusão de uma lista pelo seu id, é preciso informar obrigatoriamente seu id. Resultando na exclusão da lista e de seus itens
- `Funcionalidade 6` `Listar todos os itens da lista pelo id da lista`: Para listar todos os itens de uma determinada lista é preciso informar obrigatoriamente o id da lista. O sistema ira retorna todos os itens da lista indicada que estão cadastrados. 

## Itens
- `Funcionalidade 7` `Cadastro de itens`: Para cadastrar um item na API, precisamos informar seu título e o id da lista que ele vai pertencer. A Lista precisa estar previamente cadastrada no sistema. O campo titulo deve ter no maximo 100 caracteres e no minimo 1. Todos os campos são obrigatórios.
- `Funcionalidade 8` `Alteração de item pelo id`: Para a alteração de um item pelo seu id, é preciso informar obrigatoriamente seu id. Podendo alterar seu titulo e sua lista. O campo titulo deve ter no maximo 100 caracteres e no minimo 1. Todos os campos são obrigatórios.
- `Funcionalidade 9` `Excluir um item pelo id`: Para a exclusão de um item pelo seu id, é preciso informar obrigatoriamente seu id. Resultando na exclusão do id solicitado.
- `Funcionalidade 10` `Marcar um item como concluido`: Para a marcação de um item como concluido, é preciso informar obrigatoriamente seu id. 
- `Funcionalidade 11` `Desmarcar um item como concluido`: Para a desmarcação de um item como concluido, é preciso informar obrigatoriamente seu id.


## 📁 Acesso ao projeto

Você pode acessar os arquivos do projeto clicando [aqui](https://github.com/MarianaLopes15/mariana-cevidanes-lopes-listas-rest-api/tree/main/src).

## 🛠️ Abrir e rodar o projeto

Após baixar o projeto, você pode abrir com o Eclipse ou o Spring Tool Suite. 
Para isso, na tela incial da IDE no 'Project Explorer' clique com o botão direito e em import > import...

- Selecione 'Existing Maven Projects' e next
- Clique em 'Browse..' e procure o local onde o projeto está e o selecione (Caso o projeto tenha baixado via zip, é necessário extraí-lo antes de procurá-lo)
- Por fim clique em Finish
- Também é necessário configurar a biblioteca Lombok na IDE
- Utilize as configurações do arquivo application.properties para configurar o banco de dados

A IDE deve baixar algumas dependencias para configurar o projeto, aguarde até finalizar. Ao finalizar, você pode executar a aplicação 🏆 

## 📚 Swagger
Após rodar a aplicação você pode acessar a documentação swagger pela url: http://localhost:8080/swagger-ui/index.html
