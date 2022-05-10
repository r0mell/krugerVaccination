# Krugger Vaccination

Kruger Corporation requiere una aplicación para llevar un registro del inventario del estado de
vacunación de los empleados.


## Instalación

Dentro de este repositorio se encuentran todos los archivos necesarios para la instalación e implementación de la aplicación. 

Como primer paso, clone todo el repositorio en su computador lo puede descargar como ZIP o en una terminar de git digite el siguiente comando. 

```bash
git clone https://github.com/r0mell/krugerVaccination.git
```

Una vez clonado el repositorio ábralo con cualquier IDE de desarrollo para proceder a descargar las dependencias necesarias del proyecto.

Es necesario tener instalado el motor de base de datos PosgrestSQL debido a que toda la persistencia de datos se maneja dentro de esta base de datos.
Dentro del proyecto se encuentra un archivo llamado ScriptKruger.sql, cópielo y ejecute cada línea como se lo indica dentro del archivo.

Proceda a compilar la aplicación dentro de su IDE de desarrollo, asegúrese de ejecutar estas acciones en orden debido a que la aplicación no genera automáticamente la base de datos ni las tablas. 


## Implementación

krugerVaccination es la respuesta a una problemática planteada para el manejo del estado de vacunación de los empleados de la empresa Kruger.
Para esto se tuvo varios requerimientos en forma de historias de usuario las cuales se debían cumplir. El objetivo de esta aplicación es implementar una API que cumpla con todos los requerimientos planteados por la empresa para el manejo de esta información. 

Una vez comprendidos todos los requerimientos se plantea el siguiente diseño entidad-relación, en este se puede observar cómo se relacionan los datos y los atributos de cada entidad.  

![Logo](https://imgur.com/y2cyIw1.png)

En importante remarcar que el diseño que se proporciona obedece a la necesidad de los requisitos, pero además se debió tener en cuenta varios factores externos como la complejidad que los demás requerimientos de desarrollo y por último el tiempo limitado para la entrega de la aplicación.

Teniendo el modelo de datos se prosiguió con el desarrollo de la aplicación, lo primero que se hizo es el CRUD de las tablas employees y roles debidos que estas tablas se encargan del registro y autenticación de cada empleado.

![App Screenshot](https://imgur.com/rZTQPXm.jpg)

Para la implementación de la autenticación se decidió usar JWT (JsonWebToken) debido a que se necesita enviar cierta información dentro del token la cual servirá posteriormente para la verificación de los permisos a los tiene acceso cada empleado. Para proporcionar cierto nivel de seguridad se decidió encriptar la contraseña de cada empleado para esto se usó la librería Argon2, con la cual se hasheo cada contraseña antes de ingresarla a la base de datos.


Culminado esta parte de la aplicación se probó cada una de las direcciones proporcionadas por la API para cerciorarse del correcto funcionamiento y comportamiento de los métodos implementados y pasar a corregir errores que pudiesen darse. En este punto se pasó a sumar la entidad vaccines la cual trae consigo requisitos de verificación para lo cual se hizo uso del token con el que se logro controlar el acceso restringido a cada uno de los métodos.


![App Screenshot](https://imgur.com/E7sZACE.jpg)



## Autor

- Creado por: Rommel Pumisacho - [@r0mell](https://github.com/r0mell/)



## License
[MIT](https://choosealicense.com/licenses/mit/)
