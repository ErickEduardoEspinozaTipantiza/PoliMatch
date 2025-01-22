-- database: ../database/POLITINDER.sqlite
DROP TABLE IF EXISTS PersonaRol;
DROP TABLE IF EXISTS PersonaSexo;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS RelacionTipo;
DROP TABLE IF EXISTS Relacion;
DROP TABLE IF EXISTS Cita;


--Catalogo
CREATE TABLE PersonaRol(
        IdPersonaRol            INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdPersonaRolPadre      INTEGER  REFERENCES PersonaRol (IdPersonaRol)
        ,Nombre                 TEXT  NOT NULL UNIQUE
        ,Observacion            TEXT
        ,Estado                 CHAR(1) NOT NULL DEFAULT ('A')
        ,FechaCrea              DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica          DATE

);

CREATE TABLE PersonaSexo(
        IdPersonaSexo           INTEGER PRIMARY KEY AUTOINCREMENT
        ,Nombre                 TEXT  NOT NULL UNIQUE
        ,Observacion            TEXT
        ,Estado                 CHAR NOT NULL DEFAULT ('A')
        ,FechaCrea              DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica          DATE
);

CREATE TABLE Persona(
    IdPersona               INTEGER PRIMARY KEY AUTOINCREMENT,
    IdPersonaRol           INTEGER NOT NULL REFERENCES PersonaRol(IdPersonaRol),
    IdPersonaSexo          INTEGER REFERENCES PersonaSexo(IdPersonaSexo),
    Nombre                 TEXT NOT NULL,
    Apellido               TEXT NOT NULL,
    FechaNacimiento        DATETIME,
    Correo                 VARCHAR(70) UNIQUE NOT NULL,
    Contrasenia            VARCHAR(70) UNIQUE NOT NULL,
    Observacion            TEXT,
    Estado                 CHAR(1) NOT NULL DEFAULT ('A'),
    FechaCrea              DATETIME NOT NULL DEFAULT (datetime('now')),
    FechaModifica          DATE,
    RutaImagen             TEXT  DEFAULT ('')
);

CREATE TABLE RelacionTipo(
        IdRelacionTipo          INTEGER PRIMARY KEY AUTOINCREMENT
        ,Nombre                 TEXT  NOT NULL UNIQUE
        ,Observacion            TEXT
        ,Estado                 CHAR(1) NOT NULL DEFAULT ('A')
        ,FechaCrea              DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica          DATE
);

CREATE TABLE Relacion(
        IdRelacion              INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdRelacionTipo         INTEGER  NOT NULL REFERENCES RelacionTipo(IdRelacionTipo)
        ,IdPersona1             INTEGER  NOT NULL REFERENCES Persona(IdPersona)
        ,IdPersona2             INTEGER  NOT NULL REFERENCES Persona(IdPersona)
        ,Observacion            TEXT
        ,Estado                 CHAR(1) NOT NULL DEFAULT ('A')
        ,FechaInicioRelacion    DATE NOT NULL DEFAULT (datetime('now'))
        ,FechaCrea              DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica          DATE
);

CREATE TABLE Cita(
        IdCita                  INTEGER PRIMARY KEY AUTOINCREMENT
        ,IdPersona1             INTEGER NOT NULL REFERENCES Persona(IdPersona)
        ,IdPersona2             INTEGER NOT NULL REFERENCES Persona(IdPersona)
        ,FechaCita              DATE NOT NULL
        ,Estado                 CHAR(1) NOT NULL DEFAULT ('A')
        ,FechaCrea              DATETIME NOT NULL  DEFAULT (datetime('now'))
        ,FechaModifica          DATE
);