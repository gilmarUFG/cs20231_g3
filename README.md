### cs_20233
Repositório definido para a manutenção do controle de versão dos artefatos do projeto de construção de uma API Rest para:

uma plataforma de financiamento coletivo de projetos, em que os usuários poderão realizar o cadastro destes para receber contribuições de outros usuários cadastrados na plataforma. Ainda, será possível definir uma meta de arrecadação, receber apoio financeiro e oferecer recompensas personalizadas aos apoiadores.

### Grupo
Esta API será construída pelos componentes do grupo 3:

|Matrícula|Nome|Usuário Git|
|---|---|---|
|202105032|Gabriel Mesquita|[Gabriel-Mesq](https://github.com/Gabriel-Mesq)|
|202107678|Gabriel Reis do Valle Silvestre|[gabrielreisdvs](https://github.com/gabrielreisdvs)|
|202105040|Karla Loane Santos Lima|[karllaloane](https://github.com/karllaloane)|
|202105041|Kauã Junio da Silva Lima|[kauajuno](https://github.com/kauajuno)|
|202105050|Murilo Henrique de Sousa Freua|[murilofreua](https://github.com/murilofreua)|

### Requisitos Funcionais
1. RF001 - O sistema deve permitir que um usuário cadastre um projeto.
2. RF002 - O sistema deve permitir que um usuário cadastre recompensas para os apoiadores, de acordo com valor doado.
3. RF003 - O sistema deve permitir que os projetos recebam apoio de usuários, sendo uma única arrecadação por usuário.
4. RF004 - O sistema deve permitir que o usuário defina um prazo para a arrecadação.
5. RF005 - O sistema deve permitir que um usuário resgate o valor arrecadado em um projeto.
6. RF006 - O sistema deve permitir que o usuário busque projetos.

### Requisitos Não Funcionais
<Insira aqui os requisitos não funcionais>

### Regras de Negócio
1. RN01 - Valor mínimo para realizar doação em um projeto (definido pelo proprietário do projeto).
2. RN02 - Projetos só poderão realizar o resgate ao final do prazo para a arrecadação.
3. RN03 - A plataforma cobrará uma taxa de 5% do valor a ser resgatado.
4. RN04 - Ao encerrar a campanha ela não poderá receber mais contribuições.
5. RN05 - O usuário poderá contribuir somente uma vez para cada projeto

### Tecnologia de _Design_
Figma: A ferramenta mais conhecida para design de telas e design systems no meio do desenvolvimento web. Os designs utilizados para essa aplicação podem ser encontrados [aqui](https://www.figma.com/file/ME3Ae0ZAivrXC58XjK56Sf/financie.se?type=design&t=6y2lRszdo2QXK00K-6).

### Tecnologia de _Front-end_
React.js: É flexível e oferece desempenho rápido, tornando a experiência do usuário mais responsiva.

### Tecnologia de _Back-end_
Java Spring Boot: Uma das mais utilizadas ferramentas para a construção de APIs.

### Tecnologia de Persistência de Dados
Hibernate: Persistência de dados relacional de forma simplificada.

### Local do _Deploy_
<Descrever onde será feito o _deploy_ da API.>

### Cronograma de Desenvolvimento

|Iteração|Tarefa|Data Início|Data Fim|Responsável|Situação|
|---|---|---|---|---|---|
|1|Atualização README|28/04/2023|28/04/2023|Karlla && Gabriel Mesquita|Concluída|
|1|Criação da base do projeto (frontend, backend e banco de dados)|17/04/2023|05/05/2023|[Gabriel-Mesq](https://github.com/Gabriel-Mesq), [Karlla](https://github.com/karllaloane)|Concluída|
|1|Cadastro e login de usuários|17/04/2023|05/05/2023|[Gabriel-Mesq](https://github.com/Gabriel-Mesq), [Karlla](https://github.com/karllaloane)|Concluída|
|2|Modelagem de dados (RF001, RF002, RF003, RF004 e RF005)|06/05/2023|19/05/2023|[Karlla](https://github.com/karllaloane), [Gabriel-Reis](https://github.com/gabrielreisdvs)|Concluída|
|2|CRUD de usuários|06/05/2023|19/05/2023|[Gabriel-Mesq](https://github.com/Gabriel-Mesq), [Karlla](https://github.com/karllaloane)|Concluída|
|2|Especificação das histórias de usuário (RF002, RF005)|06/05/2023|19/05/2023|[Karlla](https://github.com/karllaloane), [Gabriel-Reis](https://github.com/gabrielreisdvs)|Concluída|
|2|Implementação do frontend do cadastro de projetos, página inicial e registro de usuário|06/05/2023|19/05/2023|[Kaua](https://github.com/kauajuno), [Murilo](https://github.com/murilofreua),[Gabriel-Mesq](https://github.com/Gabriel-Mesq)|Concluída|
|3|Especificação das histórias de usuário (RF003)|20/05/2023|02/06/2023|[Karlla](https://github.com/karllaloane), [Gabriel-Reis](https://github.com/gabrielreisdvs)|Concluída|
|3|Implementação do backend do CRUD de projetos|20/05/2023|02/06/2023|[Murilo](https://github.com/murilofreua), [Karlla](https://github.com/karllaloane)|Concluída|
|3|Testes - Cadastro de projetos|20/05/2023|02/06/2023|[Gabriel-Mesq](https://github.com/Gabriel-Mesq) [Karlla](https://github.com/karllaloane)|Concluída|
|3|Implementação do frontend do cadastro de recompensas|20/05/2023|02/06/2023|[Gabriel-Mesq](https://github.com/Gabriel-Mesq), [Kaua](https://github.com/kauajuno)|Concluída|
|3|Implementação do backend do CRUD de recompensas|20/05/2023|02/06/2023|[Gabriel-Reis](https://github.com/gabrielreisdvs)|Concluída|
|4|Especificação das histórias de usuário (RF001)|03/06/2023|16/06/2023|[Gabriel-Reis](https://github.com/gabrielreisdvs), [Karlla](https://github.com/karllaloane)|Concluída|
|4|Implementação do frontend da tela de moderação de projetos|03/06/2023|16/06/2023|[Gabriel-Mesq](https://github.com/Gabriel-Mesq), [Kaua](https://github.com/kauajuno)|Concluída|
|4|Implementação do backend de moderação dos projetos|03/06/2023|16/06/2023|[Murilo](https://github.com/murilofreua), [Karlla](https://github.com/karllaloane)|Concluída|
|5|Especificação das histórias de usuário (RF004)|17/06/2023|30/06/2023|[Gabriel-Reis](https://github.com/gabrielreisdvs)|Concluída|
|5|Implementação backend da funcionalidade de apoiar projetos|17/06/2023|30/06/2023|[Murilo](https://github.com/murilofreua), [Karlla](https://github.com/karllaloane)|Concluída|
|5|Implementação do frontend da tela de visualização de projetos|17/06/2023|30/06/2023|[Gabriel-Mesq](https://github.com/Gabriel-Mesq) [Kaua](https://github.com/kauajuno)|Concluída|
|5|Implementação do frontend da tela de pagamento|17/06/2023|30/06/2023|[Gabriel-Mesq](https://github.com/Gabriel-Mesq), [Kaua](https://github.com/kauajuno)|Concluída|
|5|Testes automatizados: RN01, RN02|17/06/2023|30/06/2023|[Murilo](https://github.com/murilofreua), [Karlla](https://github.com/karllaloane)|Concluída|
|6|Especificação das histórias de usuário (RF006)|01/07/2023|21/07/2023|[Gabriel-Reis](https://github.com/gabrielreisdvs)|Concluída|
|6|Implementação backend da funcionalidade de resgatar arrecadação|01/07/2023|21/07/2023|[Murilo](https://github.com/murilofreua), [Karlla](https://github.com/karllaloane) |Concluída|
|6|Implementação do frontend|01/07/2023|21/07/2023|[Gabriel-Mesq](https://github.com/Gabriel-Mesq) [Kaua](https://github.com/kauajuno)|Concluída|
|6|Testes automatizados: RN03, RN04, RN06|01/07/2023|21/07/2023|[Murilo](https://github.com/murilofreua), [Karlla](https://github.com/karllaloane)|Concluída|
|7|Implementação frontend de visualização de busca|22/07/2023|11/08/2023|[Gabriel-Mesq](https://github.com/Gabriel-Mesq), [Kaua](https://github.com/kauajuno)|Concluída|
|7|Integração do backend com o frontend|22/07/2023|11/08/2023|[Gabriel-Mesq](https://github.com/Gabriel-Mesq)|Em andamento|
