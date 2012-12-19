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
