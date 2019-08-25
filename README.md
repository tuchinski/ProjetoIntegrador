# Scrum

## 1. Introdução
A metodologia ágil é uma forma de acelerar as entregas durante o desenvolvimento de um projeto, fracionando o todo em entregas incrementais, trabalhando em partes auto-organizados e fazendo uso da Inteligência Coletiva.

Scrum é um framework que se baseia nessa metodologia, usada para ajudar as equipes de projetos e controlar a evolução do produto de forma eficaz, atentando para a qualidade e prazo de entrega.

No Scrum existem alguns termos específico que precisam ser entendido antes de ser aplicado.

## 1.1 Termos utilizados
* **Product Backlog**: Lista contendo funcionalidades desejada para um produto, não é necessário ter todos os requisitos completo. O Product Backlog é dinâmico e deve evoluir de acordo com a evolução do produto em si, para que se adeque ao novo formato e tenha a utilidade apropriada.

* **Scrum Master**: é o responsável por assegurar que a equipe siga os valores e as práticas do Scrum. Também protege a equipe para que ela não se comprometa excessivamente com relação ao que ela é capaz de fazer em uma Sprint.

* **Sprint**: é um período de tempo, um ciclo, em que um determinado conjunto de atividades deve ser cumprido. Geralmente esse período dura um mês, porém pode ser adaptado para cada caso.

* **Scrum Team**: é a equipe de desenvolvimento. Dentro da equipe, não é necessário uma divisão de papéis. Todos trabalham para juntos completarem o trabalho de uma Sprint.

* **Sprint Planning Meeting**: reunião que ocorre no início de cada Sprint. Serão descritas as funcionalidades de maior prioridade para toda a equipe. Nesta reunião é decidido o Sprint Backlog

* **Sprint Retrospective**: Serve para inspecionar e criar um plano de ação, ou seja, identificar o que pode ser melhorado e que ações serão tomados para melhorar próxima Sprint. 

* **Sprint Review Meeting**: Reunião de revisão realizada no final de cada Sprint para avaliar o que foi feito e fazer modificações no Product Backlog se for necessário.

* **Daily Scrum**: reuniões diárias com a equipe, que ficam em pé para acompanhar as Sprints. São feitas discussões rápidas para ter noção do que está sendo feito para atingir as metas e descobrir se tem algum obstáculo.

* **Product Owner ou P.O**: dono do produto, que será o principal intermediário entre a equipe e o cliente, responsável por gerenciar o Product Backlog.

* **Sprint Backlog**: Lista de atividades do projeto que devem ser realizada pela equipe, de acordo com os requisitos e prioridades do cliente.

* **Sprint Review Meeting**: Revisão do que foi feito, executada no final de cada Sprint. Nessa reunião haverá uma comparação entre os requisitos do cliente e o que já foi feito, se for necessário fazer modificação no Product Backlog.


## 2. Como funciona o Scrum
O Scrum funciona com um ciclo bem definido. A imagem a seguir apresenta este ciclo.

![](https://i.imgur.com/o1CHjlo.png)

### 2.1. Sprint Planning

![planning](https://i.imgur.com/Dc6tUff.jpg)

Toda Sprint do Scrum começa com uma reunião, para entendermos os itens a serem feitos e planejar o que cabe no tempo da Sprint. Todos do time devem participar desta reunião. Para o Planning Meeting, o Product Owner já deve ter olhado as histórias prioritárias do projeto, quebrando em funcionalidades menores que ainda agregam algum valor para o cliente.

A reunião começa com o P.O explicando o item de maior prioridade da aplicação. Então, os desenvolvedores tiram as dúvidas com o P.O, quebram a funcionlidade em sub-itens técnicos e discutem a dificuldade de implementação do item, para que consigam atribuir uma estimativa de esforço. Então os sub-itens são alocados dentro da Sprint. Isto se repete para os proximos itens prioritarios do Product backlog. Então os desevolvedores negociam com o P.O quais desses itens serão feitos na Sprint, definindo assim o Sprint Backlog.

Um outro ponto muito importante é definir um critério de Pronto. Isso deve ser um acordo entre os desenvolvedores e o Product Owner, e evita com que sejam entregues tarefas incompletas para o cliente. Cada time pode ter um critério diferente.

Uma dica é utilizar o método de criar histórias para cada funcionalidade do sistema. Essas histórias devem ter um título e 3 itens: 

* o porque é necessário;
* para quem será útil;
* o pedido de fato.

O modelo a seguir pode ser um exemplo:

**[TÍTULO]**

**Para que ...** [por que o pedido é importante]

**No papel de  ...**[para quem é importante]

**Quero que ...**[o pedido em si]


## 2.2 Sprint
Depois que os itens do Sprint Backlog foram decididos, é hora de começar a Sprint de fato. Nela temos um timebox, ou seja, um tempo pré-definido, que pode ser de até 1 mês, e deve ser seguido fielmente. Todas as tarefas que foram definidas na Sprint Backlog devem ser implementadas neste período e ao final de cada Sprint, deve ser entrege algo de valor para o cliente.

### 2.2.1 Daily Scrum
![daily scrum](https://i.imgur.com/kkfLWK0.png)

Durante toda a Sprint, acontece diariamente a Daily Scrum, que é uma reunião que geralmente todos ficam de pé e dura no máximo 15 minutos. Serve para alinhar todos do grupo, para que cada um saiba o que o outro está fazendo. Durante esse encontro, cada membro deve responder responder 3 perguntas:
* O que você fez ontem?
* O que vai fazer hoje?
* Existe algum impedimento no caminho?

O Daily Scrum não deve ser utilizado para resolver problemas, estes devem ser somente levantados, e fora da reunião podem ser resolvidos.
Os impedimentos que surgirem na reunião devem ser tratados pelo Scrum Master o mais rápido possível.

É recomendado que a Daily Scrum ocorra sempre na mesma hora e no mesmo local, com todos os integrantes do grupo.


## 2.3 Review Meeting
![review-meeting](https://i.imgur.com/DvULtEc.jpg)


Realizado após o término de uma Sprint, e é onde apresentamos tudo o que ficou pronto para o cliente. Além do Cliente, participam o Scrum Master, P.O, e equipe de desenvolvedores.

A mecânica geralmente é bem simples. O usuário final testa cada uma das funcionalidades prontas e apresenta seu feedback, que pode ser variado.
O cliente pode ter uma nova ideia ou até encontrar um bug. Caso isso aconteça, o Product Owner deve anotar tudo para posteriormente adicionar ao Product Backlog como novas histórias.

Uma dica é ao inves de os desenvolvedores apresentarem as funcionalidades através de slides, deixar que o cliente ou o próprio usuário testarem as funcionalidades. Isto pode ajudar na verificação de bugs que não tinham sido encontrados ou uma possível melhora na interação do usuário com o sistema.

## 2.4 Retrospective Meeting

![retrospective](https://i.imgur.com/FgO2bcn.png)

O último timebox de uma Sprint, é onde colocamos em prática o conceito de melhoria conínua. Aqui, o time todo se junta para descobrir como melhorar ainda mais o time. Existem alguns métodos para a realização deste encontro. 

Um deles é toda a equipe levantar os pontos positivos e negativos da Sprint que passou e escrever cada ponto em um papel diferente.  

Depois o time inteiro analisa os pontos negativos, o que aconteceu para causá-los, e o que pode ser feito para que isso não aconteça mais. 

Os pontos positivos podem ser destacados, e caso seja necessário, definir lembretes para os pontos que ainda não são rotina entre o time.

Também é comum discutir os itens da retrospectiva passada, validando se os problemas ainda estão ocorrendo ou se as ações tomadas tiveram efeito.

Para terminar a reunião, o time cria uma lista de ações para realizar na próixma Sprint. Esta lista deve ficar visível para que todo o time se relembre delas. 

Vale lembrar que uma ação deve ser uma atividade que os membros do time irão realizar para obter algum resultado. 

## 3. Dica de Como Utilizar o Scrum

* **Determinar os cargos:** Escolher quem vai assumir o papel de Product Owner e Scrum Master.
*  **Iniciando Contato:** Nesse momento deve ser feito uma reunião para iniciar o contato com o cliente e conhecer a demanda do produto. Essa reunião deve ser realizada pelo Product Owner, que deve anotar o maximo de informação com o cliente, mas não tem problema se houver alteração ao longo do processo.
*  **Lista de Prioridades:** Após a conversa com o cliente, o Product Owner vai analisar e priorizar o product backlog de acordo com a necessidade do cliente.
*  **Planejamento:** No Sprint Planning o Product Owner irá levar a lista contendo os itens de maior prioridade para a equipe de desenvolvimento. Juntamente com a equipe é indicado dividir as tarefas em partes menores. Nessa reunião pode ser utilizado pela equipe o Planning Poker para estimar o tempo de cada tarefa a ser realizada na Sprint. É recomendado também definir o responsavel por cada atividade.
*  **Quadro de Visibilidade** Uma dica é usar o trello ou kanban para fazer um quadro de divisão contendo “A fazer”, “Fazendo” e “Feito”, assim poderá ter controle das atividades que estão sendo realizadas.
*  **Realizando as tarefas:** Agora é a hora de colocar a mão na massa, mas lembrem-se de sempre passar para a equipe os seus avanços na Daily Scrum.
*  **Reuniões:** Nessa etapa serão feita as reuniões(Sprint Meeting Review e o Sprint Retrospective), para a analise da Sprint finalizada e traçar novas metas para Sprint futura, não esqueça de rever os obstaculos e as melhorias realizadas.
*  **Outro ciclo:** terminado o Sprint e feitas as reuniões finais, é feito um novo planejamento com Backlog referente às próximas atividades do Sprint. Todo o processo é feito visando uma melhoria contínua da produção.

