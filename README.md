 # Conversor de divisas 
<p align="left">
   <img src="https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green">
   </p>

El presente proyecto contempla mi segunda participación en el "ChallengeONE" organizado por Alura Latam para el programa ONE de Oracle.

Atentamente,

Carlos E. Sosa Sánchez

#### Descripción de la idea
Se trata de una aplicación de escritorio desarrollada con Java.

El usuario puede elegir entre diferentes herramientas de conversión. La principal de este proyecto es el conversor de divisas. 
<h4 align="center">
:construction: Proyecto en construcción :construction:
</h4>
También estará disponible un conversor de temperatura y otras herramientas de este tipo.


#### :hammer:Funcionamiento del proyecto
El sistema consiste en una una interfaz gráfica de usuario (en adelante GUI) sencilla donde se presentan campos de entrada, y de salida. El usuario podrá interactuar con la interfaz para ingresar la cantidad que desea convertir, así como el tipo de divisas que desea convertir. Al final, con presionar un botón, se tendrá el resultado y se mostrará información complementaria.  A continuación se presentan algunas capturas de la aplicación durante su ejecución.

Al correr el programa, se abrirá una ventana al centro de la pantalla con la lista desplegable. Aquí se pueden escoger las diferentes herramientas; para abrir la deseada, hay que hacer clic en aceptar.
-![Ventana inicial](/doc/OptionPane.png "la primera ventana que se muestra al ejecutar la aplicación")

Al seleccionar la opción de "Divisas" se abrirá la ventana del conversor de monedas. En esta se puede elegir la divisa de base y especificar el monto que se desea convertir.
-![Conversor de monedas](/doc/MainFrame_In.png "Ventana del conversor de monedas")

Al presionar el botón de "Convertir" se mostrará el resultado. También se muestra el tipo de cambio hasta el momento de abrir la aplicación para las monedas seleccionadas. 
-![Selección de divisas](/doc/MainFrame_Out.png "Selección de divisas a convertir") 

Aquí un ejemplo del programa en ejecución
-![Funcionamiento](/doc/Example.gif "Muestra del funcionamiento") 

#### Detalles Técnicos:
El desarrollo fue realizado utilizando Java como lenguaje de programación y haciendo uso de la biblioteca Swing para el desarrollo de la GUI. También se implementó el uso de una API para obtener la información del tipo de cambio de las divisas.

#### Sobre los íconos
Los íconos utilizados para el presente trabajo fueron obtenidos en https://www.flaticon.com/ . Aquí se presenta una lista con los iconos utilizados:

<ul></li>
<li>loading - <a href="https://www.flaticon.com/free-icons/reload" title="reload icons">Reload icons created by Creative Stall Premium - Flaticon</a></li>
<li>exchange - <a href="https://www.flaticon.com/free-icons/currency" title="currency icons">Currency icons created by Pixel perfect - Flaticon</a></li>
<li>MXN - <a href="https://www.flaticon.com/free-icons/mexico" title="mexico icons">Mexico icons created by Freepik - Flaticon</a></li>
<li>USD - <a href="https://www.flaticon.com/free-icons/flag" title="flag icons">Flag icons created by Freepik - Flaticon</a></li>
<li>GBP - <a href="https://www.flaticon.com/free-icons/uk" title="uk icons">Uk icons created by Freepik - Flaticon</a></li>
<li>EUR - <a href="https://www.flaticon.com/free-icons/europe" title="europe icons">Europe icons created by Freepik - Flaticon</a></li>
<li>JPY - <a href="https://www.flaticon.com/free-icons/japan" title="japan icons">Japan icons created by Freepik - Flaticon</a></li>
<li>KRW - <a href="https://www.flaticon.com/free-icons/nation" title="nation icons">Nation icons created by Freepik - Flaticon</a></li>
</ul>

#### Sobre la API utilizada
Para obtener el tipo de cambio para cada una de las divisas utilizadas se utilizó la API de "ExchangeRate-API", que permite obtener la información relacionada de diferentes maneras. Para más información, consultar 
<a href="https://www.exchangerate-api.com/docs/overview" title="API">la siguiente página</a>


#### Más información:
última actualizacón de este documento: 19-julio-2023