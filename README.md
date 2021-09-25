##  <p align = center> Teste Prático GCB </p> <p align = "center"> 

## Requisitos cumpridos:

### Desenvolver um sistema que faça a gestão de cadastros de médicos. O Sistema deve suportar as seguintes operações:
#### •	Insert
#### •	Update
#### •	Select
#### •	Soft Delete
#### •	Get (Search)
### No cadastro do médico, devem ser cadastrados os seguintes itens:
#### •	Nome: com no máximo 120 caractéres
#### •	CRM: somente números com no máximo 7 caracteres
#### •	Telefone fixo: somente números
#### •	Telefone celular: somente números
#### •	CEP: somente números (Ao cadastrar o CEP, deve ser feita uma reqisição via XHR para a API dos correios e retornar todos os dados de endereço do cliente).
#### •	Especialidade médica (mínimo de duas, maximo infinitas)
### Itens importantes:
#### •	Estar no padrão REST
#### •	Criar mecanismo de busca por todos os campos do cadastro do médico, incluindo o endereço
#### •	Utilizar ferramenta de validação que valide todos os dados vindos frontend
#### •	Funções especialistas (Realizam somente uma operação)
#### •	Para documentação e requisição utilizar o Postman, Insomnia ou Swagger (Enviar junto com o teste o workspace utilizado)
#### •	Subir o código em repositório público do GitHub
#### •	Criar arquivo docker compose para avaliação do teste
#### •	Testes unitários

### Diferenciais:
#### •	Estrutura e implementação autênticos
#### •	Testes de integração
#### •	Testes "end to end"
#### •	Estruturação de banco de dados MySQL

## Ferramentas para serem utilizadas no desenvolvimento
### -	Migrations e Seeds
### -	SpringBoot
### -	Hibernate

## No banco de dados devem estar cadastradas as seguintes especialidades:
### -	Alergologia
### -	Angiologia
### -	Buco maxilo
### -	Cardiologia clínca
### -	Cardiologia infantil
### -	Cirurgia cabeça e pescoço
### -	Cirurgia cardíaca
### -	Cirurgia de tórax
