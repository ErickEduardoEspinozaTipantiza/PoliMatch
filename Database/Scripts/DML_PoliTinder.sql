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
    ,(NULL, "ADMIN");

INSERT INTO RelacionTipo
    (Nombre)
VALUES
    ('AMIGOS')
    ,('MEJORES AMIGOS')
    ,('LIGUE')
    ,('PAREJA')
    ,('AMANTE')
    ,('ESPOS@');

 INSERT INTO Persona
    (IdPersonaRol, IdPersonaSexo, Nombre)
VALUES
    (1,1, 'Erick', 'Caicedo', 'erick.caicedo@epn.edu.ec', 'Erickcaicedo1*')  -- ADMIN APP
    ,(1,1, 'Erick', 'Espinoza', 'erick.espinoza@epn.edu.ec', 'Erickespinoza2*') -- ADMIN APP
    ,(3,2, 'Isabella', 'Hernandez', 'isabella.hernandez@epn.edu.ec', 'Isabellahernandez3*'); --ADMIN NORMAL


