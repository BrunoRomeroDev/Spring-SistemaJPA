
DROP TABLE IF EXISTS 'tb_processos';

CREATE TABLE 'tb_processos' (
  'id' int NOT NULL AUTO_INCREMENT,
  'numero_processo' int DEFAULT NULL,
  'descricao' varchar(255) DEFAULT NULL,
  'conteudo_processo' varchar(255) DEFAULT NULL,
  'id_funcionario_tramitacao' int DEFAULT NULL,
  'origem_tramitacao' int DEFAULT NULL,
  'destino_tramitacao' int DEFAULT NULL,
  PRIMARY KEY ('id'),
  KEY 'id_funcionario_tramitacao' ('id_funcionario_tramitacao'),
  KEY 'origem_tramitacao' ('origem_tramitacao'),
  KEY 'destino_tramitacao' ('destino_tramitacao'),
  CONSTRAINT 'tb_processos_ibfk_1' FOREIGN KEY ('id_funcionario_tramitacao') REFERENCES 'tb_funcionario' ('id'),
  CONSTRAINT 'tb_processos_ibfk_2' FOREIGN KEY ('origem_tramitacao') REFERENCES 'tb_local_tramitacao' ('id'),
  CONSTRAINT 'tb_processos_ibfk_3' FOREIGN KEY ('destino_tramitacao') REFERENCES 'tb_local_tramitacao' ('id')
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO 'tb_processos' VALUES (1,74376,'processo de compra','compra de produtos de insumos',2,1,3),(3,32416,'processo de contribuinte','contribuinte reclama da iluminacao',2,2,3),(4,6987,'Interno','Interno',2,1,4),(8,98324,'processo de troca de cargo','troca de local de trabalho para funcionario',2,1,3),(9,98324,'processo de compra de insumo','comprar material de esctitorio',4,3,4),(10,6987,'Interno','Interno',2,1,4);
