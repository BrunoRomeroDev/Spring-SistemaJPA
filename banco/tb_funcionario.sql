

DROP TABLE IF EXISTS 'tb_funcionario';

CREATE TABLE 'tb_funcionario' (
  'id' int NOT NULL AUTO_INCREMENT,
  'nome' varchar(20) DEFAULT NULL,
  'nome_completo' varchar(100) DEFAULT NULL,
  'cpf' varchar(12) DEFAULT NULL,
  'rg' varchar(10) DEFAULT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO 'tb_funcionario' VALUES (2,'luiz','luzi alberto','352463','6857432'),(3,'kelly','kelly','68742','684354'),(4,'Erica','Erica da silva','68543216','684324');


