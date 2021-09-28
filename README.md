##  <p align = center> Teste Prático GCB </p> <p align = "center"> 

 ### Link para documentação: [End-Points](https://github.com/GuilhermePontes1/teste-pratico-GCB/wiki/End-points-para-API:-teste-pratico-GCB)
   
  OBS: Infelizmente não foi possível utilizar o docker-compose, será necessário fazer um import de um arquivo SQL para que funcione no MySQL, o nome dele é export.sql, localizado na pasta resources 
  
## Requisitos cumpridos:

### Desenvolver um sistema que faça a gestão de cadastros de médicos. O Sistema deve suportar as seguintes operações:
#### •	Insert :chart:	
#### •	Update :chart:	
#### •	Select :chart:	
#### •	Soft Delete :chart:	
#### •	Get (Search) :chart:	
### No cadastro do médico, devem ser cadastrados os seguintes itens:
#### •	Nome: com no máximo 120 caractéres :white_check_mark:		
#### •	CRM: somente números com no máximo 7 caracteres :white_check_mark:	
#### •	Telefone fixo: somente números :white_check_mark:		
#### •	Telefone celular: somente números :white_check_mark:	
#### •	CEP: somente números (Ao cadastrar o CEP, deve ser feita uma reqisição via XHR para a API dos correios e retornar todos os dados de endereço do cliente). :white_check_mark:	
#### •	Especialidade médica (mínimo de duas, maximo infinitas) :white_check_mark:	
### Itens importantes:
#### •	Estar no padrão REST :white_check_mark:	
#### •	Criar mecanismo de busca por todos os campos do cadastro do médico, incluindo o endereço :white_check_mark:	
#### •	Utilizar ferramenta de validação que valide todos os dados vindos frontend :white_check_mark:	
#### •	Funções especialistas (Realizam somente uma operação) :white_check_mark:	
#### •	Para documentação e requisição utilizar o Postman, Insomnia ou Swagger (Enviar junto com o teste o workspace utilizado) :white_check_mark:	
#### •	Subir o código em repositório público do GitHub :white_check_mark:	
#### •	Criar arquivo docker compose para avaliação do teste  :x:	
#### •	Testes unitários :white_check_mark:	

### Diferenciais:
#### •	Estrutura e implementação autênticos :white_check_mark:	
#### •	Testes de integração :x:
#### •	Testes "end to end" :x:
#### •	Estruturação de banco de dados MySQL :white_check_mark:	

### Ferramentas para serem utilizadas no desenvolvimento
### •	Migrations e Seeds (Somente seeds) 
### •	SpringBoot :white_check_mark:
### •	Hibernate :white_check_mark:

### No banco de dados devem estar cadastradas as seguintes especialidades: :white_check_mark:
#### •	Alergologia
#### •	Angiologia
#### •	Buco maxilo
#### •	Cardiologia clínca
#### •	Cardiologia infantil
#### • Cirurgia cabeça e pescoço
#### •	Cirurgia cardíaca
#### •	Cirurgia de tórax
  
