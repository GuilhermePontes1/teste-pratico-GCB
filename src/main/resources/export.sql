
CREATE SCHEMA `teste-pratico-gcb2` ;

DROP TABLE IF EXISTS `tb_especialidade`;

CREATE TABLE `tb_especialidade` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` varchar(45) DEFAULT NULL,
  `nome` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;


LOCK TABLES `tb_especialidade` WRITE;
INSERT INTO `tb_especialidade` VALUES (1,'2021-09-27 19:05:55','ALERGOLOGIA'),(2,'2021-09-27 19:05:55','ANGIOLOGIA'),(3,'2021-09-27 19:05:55','BUCO MAXILO'),(4,'2021-09-27 19:05:55','CARDIOLOGIA CLINICA'),(5,'2021-09-27 19:05:55','CARDIOLOGIA INFANTIL'),(6,'2021-09-27 19:05:55','CIRURGIA CABECA ESCOCO'),(7,'2021-09-27 19:05:55','CIRURGIA CARDIACA'),(8,'2021-09-27 19:05:55','CIRURGIA DE TORAX');
UNLOCK TABLES;



DROP TABLE IF EXISTS `tb_medico`;

CREATE TABLE `tb_medico` (
  `logradouro` varchar(100) DEFAULT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `localidade` varchar(100) DEFAULT NULL,
  `uf` varchar(100) DEFAULT NULL,
  `cep` int DEFAULT NULL,
  `soft_delete` tinyint(1) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(120) DEFAULT NULL,
  `crm` int DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `telefone_celular` bigint DEFAULT NULL,
  `telefone_fixo` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb3;


LOCK TABLES `tb_medico` WRITE;

UNLOCK TABLES;



DROP TABLE IF EXISTS `tb_medico_especialidade`;

CREATE TABLE `tb_medico_especialidade` (
  `medico_id` bigint NOT NULL,
  `especialidade_id` bigint NOT NULL,
  PRIMARY KEY (`medico_id`,`especialidade_id`),
  KEY `FKc89sx6jhju37lrksqc7aywu9w` (`especialidade_id`),
  CONSTRAINT `FKc89sx6jhju37lrksqc7aywu9w` FOREIGN KEY (`especialidade_id`) REFERENCES `tb_especialidade` (`id`),
  CONSTRAINT `FKij7xa9txxbmmxcr416p9r6kc5` FOREIGN KEY (`medico_id`) REFERENCES `tb_medico` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


LOCK TABLES `tb_medico_especialidade` WRITE;

UNLOCK TABLES;

