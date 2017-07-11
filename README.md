# XY-INC API

Por: Tiago Vieira de Sousa

## Startando a Aplicação

Para o desenvolvimento foi utilizado o JDK 1.8.0_131 juntamente com a IDE Eclipse Oxygen 4.7.0.

Procedimentos necessários para inicializar a aplicação:<br />
<br />1º: Baixar o projeto e importá-lo como Maven Project no Eclipse.
<br />2º: Realizar um Maven Update Project a fim de atualizar as dependências.
<br />3º: Rodar a classe Application.java (localizado em /xy-inc-ws/src/main/java/br/com/xyinc/ws/Application) com Run As / Java Application.

Após a aplicação startada, realizar os procedimentos abaixo para testar:

## Rodar os serviços:

Visualizar todos os pontos de interesse existentes na base:
  * Acessar http://localhost:8080/xyinc/pois utilizando GET.

Inserir novos pontos de interesse na base:
  * Acessar http://localhost:8080/xyinc/pois utilizando de um método POST, Content-Type = application/json.
  * Informar o payload da requisição como no exemplo a seguir:
<pre class="prettyprint">
	{"poiList":[
		{"name":"Ponto de Interesse A","coordX":35,"coordY":40},
		{"name":"Ponto de Interesse B","coordX":5,"coordY":80},
		{"name":"Ponto de Interesse C","coordX":60,"coordY":10},
		{"name":"Ponto de Interesse D","coordX":90,"coordY":2},
		{"name":"Ponto de Interesse E","coordX":77,"coordY":100}
		]
	}
</pre>
  
Encontrar pontos de interesse próximos:
  * Acessar http://localhost:8080/xyinc/pois/prox utilizando de um método POST, Content-Type = application/json.
  * Informar o payload da requisição como no exemplo a seguir: <pre class="prettyprint">{"maxDistance":50,"coordX":72,"coordY":20}</pre>

Para realizar os testes, foi utilizado o plugin Advanced REST Client do Chrome.
