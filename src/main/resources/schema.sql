CREATE TABLE Usuarios (
    id  uuid PRIMARY KEY, 
    name VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    password VARCHAR(20) NOT NULL,
      fecha_creacion date default CURRENT_DATE(),
     fecha_modificacion date default CURRENT_DATE(),
    last_login date default CURRENT_DATE(),
     isactive INT default 1
);
CREATE TABLE Phones (
number INT NOT NULL  ,
citycode VARCHAR(4) ,
countrycode VARCHAR(4),
    idUser  uuid , 
   PRIMARY KEY (number, idUser),
  CONSTRAINT FK_PHONE FOREIGN KEY (idUser) REFERENCES
Usuarios(id)
);

