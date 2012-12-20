-- Table: marcas_de_produtos

-- DROP TABLE marcas_de_produtos;

CREATE TABLE marcas_de_produtos
(
  id serial NOT NULL,
  descricao character varying(255),
  nome character varying(255) NOT NULL,
  data_de_registro timestamp without time zone NOT NULL,
  status boolean NOT NULL,
  CONSTRAINT marcas_de_produtos_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE marcas_de_produtos
  OWNER TO postgres;

-- Table: shelf

-- DROP TABLE shelf;

CREATE TABLE shelf
(
  id serial NOT NULL,
  code character varying(255),
  description character varying(255),
  registerdate timestamp without time zone,
  status boolean,
  CONSTRAINT shelf_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE shelf
  OWNER TO postgres;

-- Table: marcas_de_veiculos

-- DROP TABLE marcas_de_veiculos;

CREATE TABLE marcas_de_veiculos
(
  id serial NOT NULL,
  descricao character varying(255),
  nome character varying(255) NOT NULL,
  data_do_registro timestamp without time zone NOT NULL,
  status boolean,
  CONSTRAINT marcas_de_veiculos_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE marcas_de_veiculos
  OWNER TO postgres;
