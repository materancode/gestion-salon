DROP TABLE IF EXISTS usuarios;
DROP INDEX IF EXISTS idx_email;


CREATE TABLE usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user TEXT NOT NULL,
    contrasenia TEXT NOT NULL,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    direccion TEXT NOT NULL,
    telefono TEXT NOT NULL,
);

--Insertar usuarios
INSERT INTO usuarios (user, contrasenia, nombre, apellido, email, direccion, telefono) VALUES
("bellaLila","123","Lila","Gutierrez", "lilabella@gmail.com","Calle hermosa 33","585812368");
("CarolineCute","1235","Caroline","Manson", "mansoncaro@gmail.com","Calle palermo 63","5654646");