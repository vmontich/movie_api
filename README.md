# MOVIE API

## Passo a passo para rodar a aplicação:
1. Importar em sua IDE o projeto como Maven (IDE utilizada: STS)
2. Novos conjuntos de dados devem ser inseridos na raiz do projeto, com o nome movielist.csv
3. Abrir o arquivo principal da aplicação (com.vitormontich.movieapi.MovieapiApplication.java) e executar como SPRING BOOT APP
4. Além do principal requisito da API, foram desenvolvidos 5 outros endpoints:
+ http://localhost:8080/worst-movies com requisição do tipo GET, trará a lista completa de concorrentes e vencedores do prênio
+ http://localhost:8080/worst-movies/15 com requisição do tipo GET, trará o registro de ID = 15 da base (o ID deve ser informado na URL)
+ http://localhost:8080/worst-movies/create com requisição do tipo POST, gravará um novo registro na base. Os dados para o novo registro devem ser passados no corpo da requisição, no formato JSON, sem informar o ID
+ http://localhost:8080/worst-movies/edit com requisição do tipo PUT, atualizará um registro da base. Os dados para alteração do registro devem ser passados no corpo da requisição, no formato JSON, informando o ID
+ http://localhost:8080/worst-movies/delete/50 com requisição do tipo DELETE, removerá o registro 50 da base (o ID deve ser informado na URL)
5. O principal requisito pode ser verificado acessando o seguinte endpoint:
<<<<<<< HEAD
+ http://localhost:8080/worst-movies/get-periods com requisição do tipo GET, trará o(s) produtor(es) vencedor(es) no menor e no maior período de tempo entre 2 vitórias consecutivas
=======
+ http://localhost:8080/worst-movies/get-periods com requisição do tipo GET, trará o(s) produtor(es) vencedor(es) no menor e no maior período de tempo entre 2 vitórias consecutivas
>>>>>>> 1a267aa9a53861d4ce651a6c6ede93d600380673
