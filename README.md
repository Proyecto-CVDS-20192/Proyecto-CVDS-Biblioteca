# GESTIÓN DE RECURSOS BIBLIOTECA 
# Proyecto CVDS 2019-II - Biblioteca

## Profesores 
	- Julian Velasco (Product Owner)
	- Santiago Alzate (Product Owner)
	
## Integrantes:
	- Juan Sebastián Gómez (Design)
	- Sebastián Herrera (Back)
	- Eduardo Ocampo (UX)
	- Juan David Navarro (Front)


## Descripción del producto:

### Descripción general:
	
El objetivo del sistema es permitir que los estudiantes, puedan reservar las salas de estudio, equipos de cómputo, tablero inteligente y demás recursos de la biblioteca. Deberían autenticarse con su correo institucional y hacer la reserva del recurso en el horario de su preferencia. Debe existir también una forma de gestionar aquellos recursos en caso de que se deseen agregar o modificar los mismos, así como asignar horarios de disponibilidad específicos. La plataforma de gestión de recursos debe contar con una interfaz de usuario amigable con los usuarios.

### Manual de usuario:

Para ingresar a la plataforma es necesario entrar al link de [heroku](https://cvds-proyecto-biblioteca.herokuapp.com/), estando en la página de inicio se puede visualizar todos los recursos de la biblioteca poniendo clic en el botón de ver recursos. Para poder reservar algún recurso es necesario iniciar sesión usando su correo electrónico institucional y su clave de Moodle, ya teniendo la sesión iniciada se pueden visualizar todos los recursos de la biblioteca, se pueden reservar y ver cuales recursos ya tienen reservaciones.

### Página de Inicio
![Pagina Inicio](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/Inicio.PNG)

En la página de inicio se puede visualizar todos los recursos de la biblioteca poniendo clic en el botón de ver recursos o iniciar sesión usando los cuadros de texto de Email y Password.

### Administrador
![Administrador](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/Admin.PNG)

En la página de administrador se pueden administrar todos los recursos, en los botones de la tabla se puede eliminar o editar un recurso y en el menú desplegable se tiene la opción de agregar un recurso, reservar un recurso y ver las estadísticas. 

### Agregar Recurso
![Agregar Recurso](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/AgregarRecurso.PNG)

En la ventana emergente de agregar recurso se tienen 6 campos de información, Nombre, Capacidad (si aplica), Ubicación, Tipo, Hora Inicial y Hora final.

### Estadísticas
![Estadisticas](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/Estadisticas.PNG)

### Usuario Regular
![Usuario Regular](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/Regular.PNG)

En la página de estudiantes se puede ver todos los recursos y se pueden reservar usando el botón de reservar recursos, en opciones se pueden ver las reservas que el usuario tiene activas.

### Mis Reservas
![Mis Reservas](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/MisReservas.PNG)

### Calendario
![Calendario](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/Calendario.PNG)

En la página del calendario se pueden ver todas las reservas que hay sobre un recurso y así mismo reservar recursos poniendo clic en el día en el que se quiera apartar el recurso.
	
## Arquitectura y Diseño detallado:
### Modelo E-R.
![Base de datos](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/Base%20de%20datos.png)
### Diagrama de clases
![Diagrama de clases](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/Diagrama%20de%20clases.png)	

### Tecnologías

 - Se utiliza Guice para hacer la inyección de los diferentes servicios de la biblioteca 
 junto con los elementos necesarios para usar MyBatis
 - MyBatis con el fin de hacer más eficiente las consultas y acciones sobre la base de datos
 - PostgreeSQL, se realizó una base de datos en Heroku de PostgreeSQL para la capa de persistencia
 - PrimeFaces se utilizó para que la pagina se viera mejor.

### Enlace a la aplicación en Heroku:
Heroku APP : [https://cvds-proyecto-biblioteca.herokuapp.com/](https://cvds-proyecto-biblioteca.herokuapp.com/)

### Enlace al repositorio en Github:
Github : [https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca)


### Alcance de pruebas:
![Jacoco](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/jacoco.PNG)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/936c2a405ca14b45a130fc6a40aaf9b9)](https://www.codacy.com/manual/JuanCe28/Proyecto-CVDS-Biblioteca?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca&amp;utm_campaign=Badge_Grade)

[![CircleCI](https://circleci.com/gh/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca.svg?style=svg)](https://circleci.com/gh/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca)


## Descripción del proceso:

### Integrantes:
	- Juan Sebastián Gómez (Design)
	- Sebastián Herrera (Back)
	- Eduardo Ocampo (UX)
	- Juan David Navarro (Front)

### Metodología
Nos reunimos antes de comenzar cada sprint y definimos cuales tareas va a hacer cada uno dentro del sprint, así mismo creamos más actividades dependiendo de si hay funcionalidades retrasadas o bugs. En el desarrollo cada uno trabaja y comparte lo que hace con los demás para que todos estén al tanto de los cambios y el estado del proyecto, así todos saben las funcionalidades faltantes y los bugs.

### Enlace al taiga:
Taiga: [https://tree.taiga.io/project/juance28-gestion-de-recursos-biblioteca/timeline](https://tree.taiga.io/project/juance28-gestion-de-recursos-biblioteca/timeline)

### Sprint1
![Sprint1](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/Sprint1.PNG)

Este sprint al ser el primero tuvimos que dedicarle arto tiempo a la creación de la estructura y corrección de errores.

### Sprint2
![Sprint2](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/Sprint2.PNG)

En este sprint ya teniendo la mayoría de la estructura terminamos adelantando algunas funcionalidades del siguiente sprint al intentar cumplir con las funciones de este sprint.

### Sprint3
![Sprint3](https://github.com/Proyecto-CVDS-20192/Proyecto-CVDS-Biblioteca/blob/master/img/Sprint3.PNG)

En este sprint se termino las funcionalidades restantes y se corrigieron los bugs.

### Información Base de Datos
 - Host: ec2-54-163-230-199.compute-1.amazonaws.com
 - Database: d4cnn66hp1d27l
 - User: scvtynbcreheid
 - Port: 5432
 - Password: 4921657fe3425e23700bbb5ad721ccf8e7bd41bc6fe01ad35df337393ffcfea2
 - URI: postgres://scvtynbcreheid:4921657fe3425e23700bbb5ad721ccf8e7bd41bc6fe01ad35df337393ffcfea2@ec2-54-163-230-199.compute-1.amazonaws.com:5432/d4cnn66hp1d27l
 - Heroku CLI: heroku pg:psql postgresql-objective-64170 --app cvds-proyecto-biblioteca
 
### Usuarios de la aplicacion

- Administrador 

	-Usuario: admin@cvds.com
    
    -Password: 1234
- Regular

	-Usuario: regular@cvds.com
    
    -Password: 1234
    
## Retrospectiva: 
En este proyecto hicimos un muy buen trabajo en la separación de cada una de las tareas, todos nosotros nos entendimos muy bien trabajando como grupo. Si bien tuvimos problemas con la implementación de algunos casos de uso, trabajamos en equipo para poder resolver los bugs que fueron surgiendo. Fuimos organizados al momento de la planeación de los Sprints, y si bien pudimos ser más específicos con las actividades planeadas, fuimos reformulando el tiempo de ejecución con forme íbamos trabajando para así tener una estimación más certera del tiempo que tomaba cada implementación.

