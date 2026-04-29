-- =====================================================
-- Descrição: Script 
-- =====================================================

-- ===============================
-- DROP DAS TABELAS 
-- ===============================

DROP TABLE IF EXISTS receita;
DROP TABLE IF EXISTS animal;
DROP TABLE IF EXISTS lote;
DROP TABLE IF EXISTS raca;
DROP TABLE IF EXISTS sexo;
DROP TABLE IF EXISTS status;
DROP TABLE IF EXISTS tipo_receita;
DROP TABLE IF EXISTS origem;

-- ===============================
-- TABELAS AUXILIARES
-- ===============================

-- -------------------------------
-- Tabela: status
-- -------------------------------
CREATE TABLE status (
    id_status INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(20) NOT NULL UNIQUE
);

-- -------------------------------
-- Tabela: sexo
-- -------------------------------
CREATE TABLE sexo (
    id_sexo INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(20) NOT NULL UNIQUE
);

-- -------------------------------
-- Tabela: raca
-- -------------------------------
CREATE TABLE raca (
    id_raca INT PRIMARY KEY AUTO_INCREMENT,
    nome_raca VARCHAR(50) NOT NULL,
    sigla VARCHAR(5) NOT NULL UNIQUE
);

-- -------------------------------
-- Tabela: tipo_receita
-- -------------------------------
CREATE TABLE tipo_receita (
    id_tipo_receita INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(20) NOT NULL UNIQUE
);

-- -------------------------------
-- Tabela: origem
-- -------------------------------
CREATE TABLE origem (
    id_origem INT PRIMARY KEY AUTO_INCREMENT,
    nome_origem VARCHAR(100) NOT NULL UNIQUE
);

-- -------------------------------
-- Tabela: usuario
-- -------------------------------
CREATE TABLE usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL
);

-- ===============================
-- TABELAS PRINCIPAIS
-- ===============================

-- -------------------------------
-- Tabela: lote
-- -------------------------------
CREATE TABLE lote (
    id_lote INT PRIMARY KEY AUTO_INCREMENT,
    nome_lote VARCHAR(50) NOT NULL,
    data_criacao DATE NOT NULL,
    obs_lote TEXT,
    id_status INT NOT NULL,
    FOREIGN KEY (id_status) REFERENCES status(id_status)
);

-- -------------------------------
-- Tabela: animal
-- -------------------------------
CREATE TABLE animal (
    id_animal INT PRIMARY KEY AUTO_INCREMENT,
    brinco VARCHAR(10) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    id_sexo INT NOT NULL,
    id_raca INT NOT NULL,
    peso_entrada DECIMAL(10,2) NOT NULL,
    data_entrada DATE NOT NULL,
    id_origem INT NOT NULL,
    valor_compra DECIMAL(10,2) NOT NULL,
    id_status INT NOT NULL,
    peso_atual DECIMAL(10,2) NOT NULL,
    valor_atual DECIMAL(10,2) NOT NULL,
    id_lote INT NOT NULL,
    FOREIGN KEY (id_sexo) REFERENCES sexo(id_sexo),
    FOREIGN KEY (id_raca) REFERENCES raca(id_raca),
    FOREIGN KEY (id_origem) REFERENCES origem(id_origem),
    FOREIGN KEY (id_status) REFERENCES status(id_status),
    FOREIGN KEY (id_lote) REFERENCES lote(id_lote)
);

-- -------------------------------
-- Tabela: receita
-- -------------------------------
CREATE TABLE receita (
    id_receita INT PRIMARY KEY AUTO_INCREMENT,
    data_receita DATE NOT NULL,
    id_tipo_receita INT NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    id_animal INT NOT NULL,
    FOREIGN KEY (id_tipo_receita) REFERENCES tipo_receita(id_tipo_receita),
    FOREIGN KEY (id_animal) REFERENCES animal(id_animal)
);