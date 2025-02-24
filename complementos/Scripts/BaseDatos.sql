CREATE TABLE persona (
    dni      SERIAL PRIMARY KEY,
    nombre         VARCHAR(100) NOT NULL,
    genero         VARCHAR(10) CHECK (genero IN ('M', 'F', 'Otro')) NOT NULL,
    edad           INT CHECK (edad >= 0),
    direccion      VARCHAR(255),
    telefono       VARCHAR(20)
);

CREATE TABLE cliente (
    cliente_id   SERIAL PRIMARY KEY,
    usuario_dni  INT UNIQUE NOT NULL,
    contrasena  VARCHAR(255) NOT NULL,
    estado      VARCHAR(10) CHECK (estado IN ('Activo', 'Inactivo')) NOT NULL,
    FOREIGN KEY (usuario_dni) REFERENCES persona(dni) ON DELETE CASCADE
);

CREATE TABLE clientes (
    cliente_id      SERIAL PRIMARY KEY,
    nombre         VARCHAR(100) NOT NULL,
    genero         VARCHAR(10) CHECK (genero IN ('M', 'F', 'Otro')) NOT NULL,
    edad           INT,
    identificacion VARCHAR(50) UNIQUE NOT NULL,
    direccion      VARCHAR(255),
    telefono       VARCHAR(20),
	contrasena  VARCHAR(255) NOT NULL,
	estado      VARCHAR(10) NOT NULL
);

CREATE TABLE cuentas (
    cliente_id      INT NOT NULL,
	cuenta_id		SERIAL PRIMARY KEY,
    numero_cuenta   VARCHAR(100) NOT NULL,
    tipo         VARCHAR(20) NOT NULL,
    saldo_inicial DECIMAL NOT NULL,
    estado BOOLEAN NOT NULL
);

CREATE TABLE movimientos (
    cuenta_id      BIGINT NOT NULL,
	movimiento_id  SERIAL PRIMARY KEY,
    tipo         VARCHAR(20) CHECK (tipo IN ('Deposito', 'Retiro')) NOT NULL,
	fecha        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor 		 DECIMAL(15,2) NOT NULL,
	saldo 		 DECIMAL(15,2) NOT NULL,
	FOREIGN KEY (cuenta_id) REFERENCES cuentas(cuenta_id) ON DELETE CASCADE
);