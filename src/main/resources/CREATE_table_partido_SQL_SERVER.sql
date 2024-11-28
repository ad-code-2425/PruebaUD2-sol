USE empresa;

-- Comprobamos se a táboa 'PARTIDO' existe
IF OBJECT_ID('PARTIDO', 'U') IS NULL
BEGIN
    SET ANSI_NULLS ON;
    SET QUOTED_IDENTIFIER ON;

    -- Creamos a táboa PARTIDO
    CREATE TABLE PARTIDO (
        id INT IDENTITY(1,1) NOT NULL,
        nombre VARCHAR(50) NOT NULL,
        porcentaje REAL NOT NULL,
        numero_votos INT NOT NULL,
        CONSTRAINT UC_PARTIDO_NOMBRE UNIQUE (nombre),
        CONSTRAINT PK_PARTIDO PRIMARY KEY CLUSTERED 
        (
            id ASC
        ) WITH (
            PAD_INDEX = OFF, 
            STATISTICS_NORECOMPUTE = OFF, 
            IGNORE_DUP_KEY = OFF, 
            ALLOW_ROW_LOCKS = ON, 
            ALLOW_PAGE_LOCKS = ON
        ) ON [PRIMARY]
    ) ON [PRIMARY];
END;
