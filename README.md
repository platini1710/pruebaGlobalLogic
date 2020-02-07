1.- 	para consultar http://localhost:8080/
2.-	para guardar datos http://localhost:8080/save
3.-	datos para insertat y probar con post


{"name":"Augusssto",
"email":"aespinozfffa3010@gmail.com",
"password":"AA34",
"phone":[{
	"idPhone":{ "number":123},
	"citycode":"2",
	"countrycode":"3"
},
{
	"idPhone":{ "number":78234563},
	"citycode":"2",
	"countrycode":"3"
}

]
 }






4.-	se inserta un registro por defecto en data-h2.sql al levanta la aplicacion

		INSERT INTO usuarios (id,
    name,
    email ,
    password) VALUES ( '9fb01de0-1d63-4d09-9415-90e0b4e93b9a','Augusto Espinoza','aespinoza3010@gmail.com','1234');
    
en  schema.sql se crean dos tablas usuarios y Phones

para levantar el proyecto es con::: 
gradle bootrun
