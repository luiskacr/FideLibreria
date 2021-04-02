//crear la base de datos, hecho por Luis Carlos Porras Castro 
//Para Proyecto CRUD de Ventas Libreria

CREATE DATABASE IF NOT EXISTS libreria;

USE libreria;

CREATE TABLE IF NOT EXISTS autores(
    idAutor INT(6) NOT NULL AUTO_INCREMENT,
    nombreAutor VARCHAR(60) NOT NULL,
    apellidoAutor VARCHAR(60) NOT NULL,
    pais VARCHAR(3) NOT NULL, 
    PRIMARY KEY (idAutor)
);

CREATE TABLE IF NOT EXISTS libros(
    idLibro INT(10) NOT NULL AUTO_INCREMENT,
    nombreLibro VARCHAR(70) NOT NULL,
    autor INT(6) NOT NULL, 
    editorial VARCHAR(40),
    genero VARCHAR(40),
    stock int(4) NOT NULL,
    precio FLOAT(6.2) NOT NULL,
    PRIMARY KEY (idLibro),
    FOREIGN KEY (autor) REFERENCES autores (idAutor)
);


CREATE TABLE IF NOT EXISTS cliente(
    idcliente INT(12) NOT NULL AUTO_INCREMENT,
    cedCliente INT(12) NOT NULL,
    nombreCliente VARCHAR(70) NOT NULL,
    apellidoCliente VARCHAR(70) NOT NULL,
    correoCliente VARCHAR(70) NOT NULL,
    direccion VARCHAR(250),
    usuario  VARCHAR(70),
    contrasena VARCHAR(70),
    PRIMARY KEY (idcliente)
);

CREATE TABLE IF NOT EXISTS vendedor(
    idVendedor INT(8) NOT NULL AUTO_INCREMENT,
    cedVendedor INT(12) NOT NULL,
    nombreVendedor VARCHAR(70) NOT NULL,
    apellidoVendedor VARCHAR(70) NOT NULL,
    estado TINYINT(1) NOT NULL,
    usuario  VARCHAR(70) NOT NULL,
    contrasena VARCHAR(70) NOT NULL,
    PRIMARY KEY (idVendedor)
);

CREATE TABLE IF NOT EXISTS ventas(
    idVentas INT(100) NOT NULL AUTO_INCREMENT,
    idCliente INT(12) NOT NULL,
    idVendedor INT(8) NOT NULL,
    fechaVenta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    montoVenta FLOAT(10.2) NOT NULL,
    PRIMARY KEY(idVentas),
    FOREIGN KEY (idVendedor) REFERENCES vendedor (idVendedor),
    FOREIGN KEY (idCliente) REFERENCES cliente (idcliente)
);

CREATE TABLE IF NOT EXISTS factura(
    idDetalle INT(100) NOT NULL AUTO_INCREMENT,
    ventaId INT(100) NOT NULL,
    producto INT(10) NOT NULL,
    cantidad INT(11) NOT NULL,
    precioVenta FLOAT(6.2) NOT NULL,
    PRIMARY KEY (idDetalle),
    FOREIGN KEY (ventaId) REFERENCES ventas (idVentas),
    FOREIGN KEY (producto) REFERENCES libros (idLibro)
);