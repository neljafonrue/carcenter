CREATE VIEW vista_clientes AS
    SELECT 
        TID.ID_TIPO_DOCUMENTO AS ID_TIPO_DOCUMENTO,
        TID.NOMBRE AS NOMBRE_TIPO_DOCUMENTO,
        PER.NUMERO_DOCUMENTO AS NUMERO_DOCUMENTO,
        PER.PRIMER_NOMBRE AS PRIMER_NOMBRE,
        PER.SEGUNDO_NOMBRE AS SEGUNDO_NOMBRE,
        PER.PRIMER_APELLIDO AS PRIMER_APELLIDO,
        PER.SEGUNDO_APELLIDO AS SEGUNDO_APELLIDO
    FROM
        PERSONAS PER
        ,TIPOS_DOCUMENTO TID
    WHERE
        TID.ID_TIPO_DOCUMENTO = PER.ID_TIPO_DOCUMENTO
         AND PER.ID_TIPO_PERSONA = 2;