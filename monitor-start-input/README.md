**QUESTÕES**

1. Podemos utilizar uma estratégia com micro-serviços dividindo em responsabilidades 

2. Cartão de Crédito 

3. Escolhi esta funcionalidade pois como não há uma Analise monetária e quantitativa de fraudes por ser o serviço com maior 
número de fraudes bancárias

4. Requisitos Não Funcional: Kafka, Mongo, Fila de Processamento 
   Requisito Funcional: regras de bandeiras  (regras utilizadas para cada bandeira)
  

5. A integração com legado podemos trabalhar com 2 opções:
  - envio através de filas MQNativa Mainframe ou Kafka integrado em um db2 


6. Escala para o processamento de informações
   Padronização de implementação de novas features
   Facilidade na inclusão de integrações com novas tecnologias - através da arquitetura Hexagonal

7. JAVA ( porque é consolidada, padronizada e mão de obra abrangente )
   SPRING REST ( porque é consolidade, opensource, e todo o apoio para desenvolvimento microserviços/api ) 
   DOCKER ( facilita a subida dos microserviços em qualquer plataforma openshift, kubernetes )
   KAFKA -   por ser utilizado em grandes volumes de dados, é baseado em JMS e como usamos uma arquitetura hexagonal, pode 
   ser substituido facilmente, por qualquer outro provedor de fila jms (ActiveMQ, SQS)
   
   Mongo - versatilidade com Json com esquemas dinâmicos, de fácil uso, escalável, 

   Solução para monitoração dos containers (ELK consolidação do monitoramento de logs, Cloud Watch )

8. MongoDB modelo não relacional, porque considerando o volume de dados alto podemos disponibilizar os registros em uma 
Collection de saída para futuras visualizações exemplo via PowerBI, ou para ser lido via flume e jogado em um novo 
tópico para processamento

9. Através do Kafka e os micro-serviços conseguimos escalar horizontalmente 

10. Trabalhando o conceito de MVP, como são serviços de ponta a ponta, seria necessário focar em uma pequena parte do micro-serviço de cartão de crédito para gerar algum valor, e com apenas algumas de regras de validação, para chegar ao fluxo completo.


SOLUÇÃO:


Podemos ter alguns micro-serviços com responsabilidades:

[LEGADO]

Temos algumas opções para repassar os dados do legado:

1. Com Serviço de Fila / Tópico (Kafka, ActiveMQ) conseguimos plugar ele no DB2 se for o caso, e para não onerar muito o banco, podemos trabalhar com alguma view que pode ser carregada, ou uma tabela temporária

2. Podemos também colocar o Serviço de Fila / Tópico (Kafka, ActiveMQ) plugado para ler um diretório ao chegar um arquivo novo como lote

[Arquitetura de Microserviços]

Foi utilizado a arquitetura hexagonal, que permite a utilização adapters para diferentes tecnologias ( banco de dados, filas, email) a serem plugadas

[Microserviço Entrada]

Poderá escutar uma fila, que receberá cada novo registro incluído. Será 
gerado um registro de lote de processamento de arquivos de todos os registros que entraram na fila, e será armazenado no MongoDB

O MicroServiço será responsável para direcionar de acordo com o Tipo de
Transação e Canal

[Microserviço Cartão de Crédito]:

Responsável por fazer uma chamada no serviço de blacklist para verificar se passa pela blacklist
Caso ocorrer regras diferentes para bandeiras diferentes, podemos ter um microserviço para cada bandeira com com regras específicas, VISA, MASTER, ELO


[Microserviço Blacklist] - responsalvel apenas por efetuar consultas e validações para verificar se o usuário se encontra em alguma blacklist para bloqueio

- POST: inclusão de um cliente na blacklist
- GetArgs: busca por mais de um campo por argumentos 
- Get Id: recebe a chamada para consultar por id especificado do cliente, algum valor chave


[Microserviço Backoffice]:

Irá ler uma fila de backoffice que necessita de analise manual, ao receber o registro na fila, pode ser incluído em uma base de dados temporário, em um banco de dados, com seu descritivo. O usuário pode APROVAR ou REPROVAR,
dependendo do caso inclui para uma nova fila para bloqueio.



[Solução Big Data]

Também temos a possibilidade de plugar o Kafka em canais diferentes de
acordo com o registro que virá se for arquivo ou banco de dados.

Integrar via flume para jogar os dados no HDFS para processamento batch,
por exemplo no caso de pagamento de contas, ou transferências

No caso de processamento real time podemos jogar em um tópico para processamento real time através do Spark que será responsável pelo
processamento in-memory e fazer as validações necessária e chamadas
as regras específicas. O resultado poderá ser jogado em um banco NOSql
para rápida consulta, ou em alguma fila se for necessário.



