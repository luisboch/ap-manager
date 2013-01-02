
CREATE TABLE aplicacoes (
    id serial NOT NULL,
    descricao character varying(255),
    modelo_id integer NOT NULL,
    produto_id bigint
);


CREATE TABLE marcas_de_produtos (
    id serial NOT NULL,
    descricao character varying(255),
    nome character varying(255) NOT NULL,
    data_de_registro timestamp without time zone NOT NULL,
    status boolean NOT NULL
);


CREATE TABLE marcas_de_veiculos (
    id serial NOT NULL,
    descricao character varying(255),
    nome character varying(255) NOT NULL,
    data_do_registro timestamp without time zone NOT NULL,
    status boolean
);


CREATE TABLE prateleiras (
    id serial NOT NULL,
    codigo character varying(255),
    descricao character varying(255),
    data_de_registro timestamp without time zone NOT NULL,
    status boolean
);


CREATE TABLE produtos (
    id serial NOT NULL,
    codigo_adicional character varying(255),
    codigo_de_barras character varying(255),
    codigo character varying(255),
    descricao character varying(255),
    percentual_desc_max integer,
    quantidade_min integer,
    nome character varying(255),
    preco_compra double precision,
    quantidade integer,
    data_de_registro timestamp without time zone NOT NULL,
    preco_venda double precision,
    status boolean,
    produto_marca_id integer,
    prateleira_id integer
);

CREATE TABLE veiculos (
    id serial NOT NULL,
    nome character varying(255),
    observacao character varying(255),
    data_de_registro timestamp without time zone NOT NULL,
    status boolean,
    marca_id integer
);

CREATE TABLE veiculos_modelos (
    id serial NOT NULL,
    fueltype character varying(255),
    nome character varying(255),
    potencia double precision NOT NULL,
    data_de_registro timestamp without time zone NOT NULL,
    status boolean,
    ano character varying(255),
    veiculo_id integer
);

ALTER TABLE ONLY aplicacoes
    ADD CONSTRAINT aplicacoes_pkey PRIMARY KEY (id);


--
-- TOC entry 1940 (class 2606 OID 17960)
-- Dependencies: 163 163 1968
-- Name: marcas_de_produtos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY marcas_de_produtos
    ADD CONSTRAINT marcas_de_produtos_pkey PRIMARY KEY (id);


--
-- TOC entry 1946 (class 2606 OID 17984)
-- Dependencies: 166 166 1968
-- Name: marcas_de_veiculos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY marcas_de_veiculos
    ADD CONSTRAINT marcas_de_veiculos_pkey PRIMARY KEY (id);


--
-- TOC entry 1944 (class 2606 OID 17976)
-- Dependencies: 165 165 1968
-- Name: prateleiras_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY prateleiras
    ADD CONSTRAINT prateleiras_pkey PRIMARY KEY (id);


--
-- TOC entry 1942 (class 2606 OID 17968)
-- Dependencies: 164 164 1968
-- Name: produtos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY produtos
    ADD CONSTRAINT produtos_pkey PRIMARY KEY (id);


--
-- TOC entry 1950 (class 2606 OID 18000)
-- Dependencies: 168 168 1968
-- Name: veiculos_modelos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY veiculos_modelos
    ADD CONSTRAINT veiculos_modelos_pkey PRIMARY KEY (id);


--
-- TOC entry 1948 (class 2606 OID 17992)
-- Dependencies: 167 167 1968
-- Name: veiculos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY veiculos
    ADD CONSTRAINT veiculos_pkey PRIMARY KEY (id);


--
-- TOC entry 1958 (class 2606 OID 18031)
-- Dependencies: 169 168 1949 1968
-- Name: fk_aplicacoes_modelo_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aplicacoes
    ADD CONSTRAINT fk_aplicacoes_modelo_id FOREIGN KEY (modelo_id) REFERENCES veiculos_modelos(id);


--
-- TOC entry 1957 (class 2606 OID 18026)
-- Dependencies: 169 164 1941 1968
-- Name: fk_aplicacoes_produto_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aplicacoes
    ADD CONSTRAINT fk_aplicacoes_produto_id FOREIGN KEY (produto_id) REFERENCES produtos(id);


--
-- TOC entry 1954 (class 2606 OID 18011)
-- Dependencies: 164 165 1943 1968
-- Name: fk_produtos_prateleira_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produtos
    ADD CONSTRAINT fk_produtos_prateleira_id FOREIGN KEY (prateleira_id) REFERENCES prateleiras(id);


--
-- TOC entry 1953 (class 2606 OID 18006)
-- Dependencies: 164 163 1939 1968
-- Name: fk_produtos_produto_marca_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produtos
    ADD CONSTRAINT fk_produtos_produto_marca_id FOREIGN KEY (produto_marca_id) REFERENCES marcas_de_produtos(id);


--
-- TOC entry 1955 (class 2606 OID 18016)
-- Dependencies: 167 166 1945 1968
-- Name: fk_veiculos_marca_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY veiculos
    ADD CONSTRAINT fk_veiculos_marca_id FOREIGN KEY (marca_id) REFERENCES marcas_de_veiculos(id);


--
-- TOC entry 1956 (class 2606 OID 18021)
-- Dependencies: 1947 167 168 1968
-- Name: fk_veiculos_modelos_veiculo_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY veiculos_modelos
    ADD CONSTRAINT fk_veiculos_modelos_veiculo_id FOREIGN KEY (veiculo_id) REFERENCES veiculos(id);



CREATE TABLE produto_palavras_chave
(
  id serial NOT NULL,
  palavra character varying(255),
  produto_id bigint,
  CONSTRAINT produto_palavras_chave_pkey PRIMARY KEY (id ),
  CONSTRAINT fk_produto_palavras_chave_produto_id FOREIGN KEY (produto_id)
      REFERENCES produtos (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Table: computadores

-- DROP TABLE computadores;

CREATE TABLE computadores
(
  id serial NOT NULL,
  ipv4 character varying(255),
  ipv6 character varying(255),
  nome character varying(255) not null,
  status boolean not null default true ,
  CONSTRAINT computadores_pkey PRIMARY KEY (id )
);

-- Table: vendas

-- DROP TABLE vendas;

CREATE TABLE vendas
(
  id serial NOT NULL,
  fechada boolean not null default false,
  cancelada boolean not null default false,
  data_criacao timestamp without time zone default now(),
  data_fechamento timestamp without time zone ,
  total double precision not null default 0,
  computador_id integer not null,
  CONSTRAINT vendas_pkey PRIMARY KEY (id ),
  CONSTRAINT fk_vendas_computador_id FOREIGN KEY (computador_id)
      REFERENCES computadores (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE vendas_produtos
(
  id serial NOT NULL,
  preco_compra double precision not null default 0,
  quantidade integer not null default 0,
  preco_venda double precision not null default 0, 
  produto_id bigint NOT NULL,
  venda_id bigint NOT NULL,
  CONSTRAINT vendas_produtos_pkey PRIMARY KEY (id ),
  CONSTRAINT fk_vendas_produtos_produto_id FOREIGN KEY (produto_id)
      REFERENCES produtos (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_vendas_produtos_venda_id FOREIGN KEY (venda_id)
      REFERENCES vendas (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);