# Desafio Luizalabs

## Projeto para buscar endereços informando um CEP.

<p align="center">
 <a href="#tecnologias">Tecnologias</a> • 
 <a href="#comoUsar">Como utilizar</a> •
  <a href="#java">Escolha da linguagem</a>
</p>

<h3 id="tecnologias"> Tecnologias </h3>

<ul>
  <li>Spring (data, security, web e test)</li>
  <li>Banco em mémoria H2</li>
  <li>JWT para autenticações</li>
  <li> Java 11 </li>
  <li> Maven 3.8.1</li>
</ul>


<h3 id="comoUsar"> Como utilizar </h3>

<p>Foi preparado um cenário ao executar o programa que possui os seguintes dados: </p>

<h4> ADDRESS </h4>

| ID | CEP | DISTRICT | ROAD | CITY_ID
| ------------ | ------------- | ------------- | ------------- |  ------------- |
| 1 | 13167777 | LuizaLabs | Rua Magalu | 1 |

| ID | CEP | DISTRICT | ROAD | CITY_ID
| ------------ | ------------- | ------------- | ------------- |  ------------- |
| 2 | 15400000 | Ipanema | Rua Santos | 2 |

<h4> CITY </h4>

| ID | NAME | STATE_ID 
| ------------ | ------------- | ------------- |
| 1 | Franca | 1 | 

| ID | NAME | STATE_ID 
| ------------ | ------------- | ------------- |
| 2 | Rio de Janeiro | 2 | 

<h4> STATE </h4>

| ID | NAME | 
| ------------ | ------------- | 
| 1 | São Paulo |


| ID | NAME | 
| ------------ | ------------- | 
| 2 | Rio de Janeiro |

<h4> User </h4>

| USERNAME | NAME | PASSWORD 
| ------------ | ------------- | ------------- |
| lucassantoss | Lucas | $2a$10$4xuWUlQV05DrcAsMD7Zji.3tfM9sX25hjs5JDX43q3ajmDbb2jMRy | 


<p>Tendo tal cenário, precisamos estar logados na aplicação para poder acessar o serviço dos CEP's</p>

<h4> Login </h4>

<p>Nesse projeto temos o usuário "Lucas" com o cadastro feito na base de dados, precisamos do JSON dele para pode fazer o login</p>

    {
         "name" : "Lucas",
         "username" : "lucassantoss",
         "password" : "1537928154"
    }
    
<p> Com esse JSON em mãos precisamos executar uma requisção do tipo POST na seguinde URL </p>
          
    http://localhost:8080/login
    
<p> Após executar a requisição, receberemos em nosso header a KEY Authentication com o valor de nosso token JWT, como por exemplo </p>

| KEY | VALUE | 
| ------------ | ------------- | 
| Authentication | Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWNhc3qF...  |

<p> Copiamos então o token JWT sem o "Bearer", e usamos esse token em todas as outras requisições até que ele expire </p>

<h4> Buscando Endereço </h4>

<p> Para buscamos um endereço precisamos acessar a seguinte URL </p>
        
    http://localhost:8080/address/ceps/{cep}
    
<p> No lugar de {cep} é informado os números que compõem o cep desejado para a busca, nesse exemplo utilizaremos o cep 13167777 </p>
<p> Ao executar a requisição do tipo GET nessa URL, obtemos a seguinte resposta </p>


    {
        "id": 1,
        "road": "Rua Magalu",
        "district": "LuizaLabs",
        "cep": "13167777",
        "city": {
            "id": 1,
            "name": "Franca",
            "state": {
                "id": 1,
                "name": "São Paulo"
            }
        }
    }
    
    
<h3 id="java"> Escolha do Java </h3>

<p> Foi escolhida a linguagem Java para esse desenvolvimento por quê possuo uma maior familiaridade com ela, apesar de ter tipo uma vontade imensa de arriscar um node.js por conta de fazer muito tempo que não programo com essa linguagem, porém o prazo me fez recuar da ideia </p>
