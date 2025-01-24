🌍 [Read in English](README.md)

# Tech Mech Api

Esta é uma API desenvolvida em java com o intuito de realizar manipulações no banco de dados para o projeto Tech Mech.

## Tecnologias utilizadas

- `Git` - Controle de Versão.
- `Java`- Desenvolvimento da API.
- `Maven` - Ferramenta de automação de build e gerenciamento de dependências para a api.

## Requisitos para instalação

Certifique-se de ter o `Java Development Kit`, `node`, `npm` instalado em sua máquina para executar o projeto.

## Passos para instalação e para execução da API

1. Clone o repositório da api:

```bash
git clone https://github.com/felipeclarindo/tech-mech-api.git
```

2. Entre no diretório:

```bash
cd tech-mech-api
```

3. Configure suas credenciais do banco de dados oracle em `src/main/java/resources/application.properties`.

4. Execute no seu banco de dados oracle o sql localizado em `sql/table/clients.sql`.

5. Execute o arquivo `Main.java`.

## Passos para a instalação e executação do Front-end.

1. Clone o repositorio do front end:

```bash
git clone https://github.com/felipeclarindo/tech-mech.git
```

2. Entre no diretório:

```bash
cd tech-mech
```

3. Instale as dependências:

```bash
npm install
```

4. Execute o projeto localmente. (Certifique-se de que a api já esteja sendo executada)

```bash
npm run dev
```

5. Clique no link disponibilizado no terminal, normalmente:

- `http://localhost:3000`

## Contribuição

Contribuições são bem-vindas! Se você tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Autores

- [Felipe Clarindo](https://github.com/felipeclarindo)
- [Victor Augusto](https://github.com/victoraugustogfavaro)
- [Jennie Suzuki](https://github.com/jenniesuzuki)

## Licença

Este projeto está licenciado sob a [GNU Affero License](https://www.gnu.org/licenses/agpl-3.0.html).
