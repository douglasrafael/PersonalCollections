# Personal Collections
### *Gerenciador de Coleções Pessoais*

###### - Contexto
Nem sempre temos um gerenciador eficiente para controlar as nossas coleções dos mais variados itens, bem como saber 
por onde anda e para quem emprestou determinado item, a ferramenta visa ter um melhor controle sobre esses itens.

###### - Descrição
O projeto consiste em ser um gerenciador de coleções pessoais, onde ele
conterá várias funções como: gerenciamento de empréstimos de itens, relações dos
itens cadastrados, quais estão faltando para completar a coleção, sistema de ranking,
itens repetidos e que podem ser vendidos, itens com defeito. Os desenvolvedores
deverão utilizar arquivos.

O sistema não poderá utilizar banco de dados. Todos os dados persistentes devem ser
armazenados em arquivo. É fortemente recomendado o uso de serialização de objetos.
Mesmo armazenando em arquivos, não devese utilizar bibliotecas que facilitam isso como XMLEnconder e afins. Os dados devem ser salvos em arquivos .txt. A idéia é que
você entenda como manipular informações dentro do mesmo.

## User Stories
#### *Caso de uso 1:*
- Manter registros dos itens do acervo
O usuário pode criar um novo registro de itens do acervo, bem como editar e excluir
esse registro. Esses itens podem ser: HQs, DVD, Jogos de videogame e DLC’s, Jogo
de Tabuleiro e o que você julgar mais interessante.

###### Atributos:
- **HQ:** Título, Número, Editora, Universo (Marvel, DC, Image, etc), Estado (novo,
rasurado, etc.), Preço de compra, Observações sobre o item e se já foi lido ou
não. Caso este pertença a uma saga, indicar o número dele com relação à saga.
Exemplo: Arqueiro Verde #33, Saga: Crise Infinita #12.

- **DVD/CD:** Título, Estado, Marca, Conteúdo, Preço de compra, Observações
sobre o item e se já foi assistido ou não.

- **Jogos de videogame:** Título, Console, Estado, Preço de compra, Observações
sobre o item e se já foi finalizado (zerado). Os jogos que possuem DLC’s
(D ownloadable Content ), deve ser indicado qual o jogo possui, seu título e sua
localização (Live, PSN, Steam, Disco).

- **Jogos de Tabuleiro:** Título, Estado, Preço de compra, Observações sobre o item.


#### *Caso de uso 2: Manter registros dos amigos* 
- O usuáriopode criar um novo registro de amigo, bem como editar e excluir esse
registro. O amigo terá nome, sexo, parentesco, endereço e telefone.

#### *Caso de uso 3: Ranking dos itens*
- O sistema deverá permitir um ranking dos itens do acervo, de forma a saber os mais
emprestados e para que o usuário possa marcar aqueles mais importantes.

#### *Caso de uso 4: Empréstimo dos itens*
- Deverá ser possível emprestar itens aos amigos e definir uma suposta data de
devolução.

#### *Caso de uso 5: Persistência*
- O sistema agora deverá persistir todas as informações em arquivos, para que as
mesmas não sejam perdidas quando o sistema for encerrado.

#### *Caso de uso 6: Relatório dos itens cadastrados*
- Deverá ser possível listar todos os itens cadastrados no sistema, além de poder
realizar a pesquisa utilizando filtros específicos por tipo de item. Exemplo: Se vou
pesquisar uma HQ, o sistema deve exibir como opção o filtro: Universo.

#### *Caso de uso 7: Relatório dos itens repetidos*
- O sistema deverá listar quando solicitado todos os itens repetidos, de forma que o
usuário possa se basear no que ele pode vender/trocar.

#### *Caso de uso 8: Gerenciamento de Séries*
- O sistema permitirá o cadastro de sagas/séries/trilogias/dlc’s etc, nele o usuário
informará quantos itens participam dele e quais são os itens necessários para
completála. Para facilitar, isso pode ser feito apenas quando o usuário possuir ao
menos um item da série.

#### *Caso de uso 9: WhishList*
- O sistema permitirá cadastrar itens que são desejo de compra do usuário. Se for um
produto a ser lançado, deverá ser informado a data de quando estará disponível para
compra. Será possível colocar uma URL para que o usuário possa acessar mais
rapidamente o item para compra.

#### *Caso de uso 10: Tela Inicial*
- Quando o usuário acessar o sistema, será listado para ele na tela inicial:
  - Itens da sua whishlist disponíveis atualmente para compra (ou até uma semana)
com seus respectivos preços e um total de todos os itens caso dê a doida no
usuário e ele decida comprar tudo naquele dia.
  - Itens que estão emprestados e que já deveriam ter sido devolvidos.
  
  
