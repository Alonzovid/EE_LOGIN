CREATE DATABASE jsp_login;
USE jsp_login;

CREATE TABLE persona(
	id_persona INT AUTO_INCREMENT NOT NULL,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_persona)
);

CREATE TABLE usuario_sistema(
	usuario_sistema VARCHAR(30) NOT NULL,
    password VARCHAR(100) NOT NULL,
    id_persona INT UNIQUE,
    PRIMARY KEY (usuario_sistema)
);

ALTER TABLE usuario_sistema 
ADD CONSTRAINT fk_persona_usuario_sistema 
FOREIGN KEY (id_persona) 
REFERENCES persona(id_persona);

DELIMITER //
CREATE PROCEDURE insertar_persona(
	IN 	
		_nombres VARCHAR(50),
		_apellidos VARCHAR(50)
)BEGIN
	INSERT INTO persona(nombres, apellidos)
    VALUES(_nombres, _apellidos);
END
//DELIMITER ;


CALL insertar_persona("David", "Alonzo");


DELIMITER //
CREATE PROCEDURE insertar_usuario_sistema(
	IN
		_usuario_sistema VARCHAR(30),
		_password VARCHAR(100),
		_id_persona INT
)BEGIN 
	INSERT INTO usuario_sistema(usuario_sistema, password, id_persona)
    VALUES(_usuario_sistema, _password, _id_persona);
END
//DELIMITER ;


CALL insertar_usuario_sistema("Alonzovid","prueba",1);


DELIMITER //
CREATE PROCEDURE consultar_usuario_sistema(
	IN
		_usuario_sistema VARCHAR(30),
		_password VARCHAR(100)
)BEGIN 
	SELECT us.usuario_sistema, us.password 
    FROM usuario_sistema AS us 
    WHERE us.usuario_sistema = _usuario_sistema AND us.password = _password;
END
//DELIMITER ;


CALL consultar_usuario_sistema('Alonzovid','prueba');