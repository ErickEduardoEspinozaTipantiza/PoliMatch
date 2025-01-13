-- database: ../database/POLITINDER.sqlite
INSERT INTO PersonaSexo 
    (Nombre)
VALUES 
    ("MASCULINO")
    ,("FEMENINO")
    ,("BINARIO") 
    ,("FLUIDO");

INSERT INTO PersonaRol 
    (IdPersonaRolPadre, Nombre)
VALUES 
    (NULL, "ADMINISTRADOR APP")
    ,(1, "USUARIO") 
    ,(NULL, "ADMIN")
    ,(3, "MENSAJERO");

INSERT INTO RelacionTipo
    (Nombre)
VALUES
    ('AMIGOS')
    ,('FAMILIA')
    ,('TRABAJO')
    ,('LIGUE')
    ,('PAREJA')
    ,('AMANTE')
    ,('ESPOS@');

 INSERT INTO Persona
    (IdPersonaRol, IdPersonaSexo, Nombre)
VALUES
    (1,1, 'Conan')   -- USUARIO ADMIN
    ,(3,2, 'Olivia')
    ,(4,1, 'Adrien Agreste')
    ,(4,1, 'Peter Parker')
    ,(4,1, 'Kanye West')
    ,(4,2, 'Taylor Swift')
    ,(2,1, 'Light Yagami')
    ,(2, 1, 'Gojo Satoru')
    ,(2,1, 'Geto Suguru')
    ,(2,2, 'Rouge')
    ,(2,1, 'Roger')
    ,(2,2, 'Camila')
    ,(2,1, 'Shawn')
    ,(2,1, 'Chayanne' )
    ,(2,2, 'Las mamás')
    ,(2,1, 'Ash')
    ,(2,1, 'Eiji')
    ,(2,2, 'Yo')
    ,(2,1, 'Chrollo')
    ,(2,1, 'Chat noir')
    ,(2,2, 'Ladybug')
    ,(2,2, 'Sana')
    ,(2,2, 'Tzuyu')
    ,(2,1, 'Nanami')
    ,(2,1, 'Joji')
    ,(2,1, 'Kuroko')
    ,(2,1, 'Aomine')
    ,(2,2, 'Lisa')
    ,(2,2, 'Jennie')
    ,(2,4, 'Gege vas a caer')
    ,(2,3, 'Sukuna');
WITH RECURSIVE
  contador(x) AS (SELECT 1 UNION ALL SELECT x+1 FROM contador LIMIT 300
  )
INSERT INTO Relacion (IdRelacion, IdRelacionTipo, IdPersona1, IdPersona2) 

SELECT 
x AS id
, abs(random()) % (7 - 1) + 1 
, abs(random()) % (31 - 7) + 1
, abs(random()) % (31 - 7) + 1  FROM contador;


