
DROP TABLE IF EXISTS 'tb_local_tramitacao';

CREATE TABLE 'tb_local_tramitacao' (
  'id' int NOT NULL AUTO_INCREMENT,
  'descricao' varchar(255) DEFAULT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO 'tb_local_tramitacao' VALUES (1,'SEILA'),(2,'SEDUC'),(3,'SESAU'),(4,'SEICOM');


