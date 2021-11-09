# Movies Compose 🎥
Um aplicativo de filmes utilizando princípios de Clean Architecture com Jetpack Compose para construção da UI.

## Contexto
Pessoas amam filmes, pricipalmente em época de pandemia, em que ficar em casa tornou-se mais comum, que tal um app para poder acompanhar os seus filmes favoritos? 😍

https://user-images.githubusercontent.com/49538805/140880033-fa50ad09-addd-4f42-ac62-85c5507f1b4e.mp4

Pensando nisso escolhi desenvolver uma aplicação de listagem de filmes com possibilidades de adicionar aos favoritos utilizando a nova lib de construção de UI's da Google para desenvolvimento Android Nativo, o [Jetpack Compose](https://developer.android.com/jetpack/compose?hl=pt-br). 🥰

A api utilizada foi a [The Movie Database API](https://developers.themoviedb.org/3).

## Como o app está estruturado? 🤔

O app é dividido por feature, e cada feature contém 3 packages: 
- Data: Contém tudo que seja de relevante para dados, como por exemplo o acesso a API e banco de dados;
- Domain: Um tipo de camada de conexão, contém as nossas regras de negócio (divididas em use cases), como por exemplo a lógica de obtenção dos filmes, definição de repositórios e modelo de classes (como entidades de bancos de dados);
- Presentation: Contém a representação de UI: estados de carregamento, erro e demais componentes.

## Como o app funciona hoje?
1) Ao entrar no app a primeira tela a carregar será a home com 2 listas de filmes requisitados da API, contendo 20 filmes cada (40 no total);
2) Ao clicar em algum filme o app irá ver se ele é um filme favorito, nesse caso basta puxar do banco de dados local do aparelho, caso contrário uma nova requisição será feita para obter os detalhes do filme;
3) Ao clicar no ícone de favoritos o filme poderá ser favoritado ou desfavoritado, caso seja favoritado o filme é salvo no banco de dados e fica disponível mesmo se o aparelho não estiver conectado à internet 😊

## E os testes? 🤔
O app contém testes unitários e de interface, os testes unitários estão focados em fazer o teste do caso de uso para a obtenção dos dados, já o de interface irá fazer todos os fluxos de navegação possíveis garantindo que não esteja nada quebrado ✔

## O que vem pro futuro?
- Buscar filme;
- Filtrar a lista de favoritos baseado em dta de aedição, nome e etc;
- Login com firebase mantendo os filmes favoritos remotamente;
- Integrar com a API internacionalizada para pegar os detalhes do filme em qualquer língua;
- Modularizar o app por feature;
- Dark theme.
