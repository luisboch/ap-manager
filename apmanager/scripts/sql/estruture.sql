--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.7
-- Dumped by pg_dump version 9.1.7
-- Started on 2012-12-20 11:56:21 BRST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 173 (class 3079 OID 11685)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1949 (class 0 OID 0)
-- Dependencies: 173
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_with_oids = false;

--
-- TOC entry 161 (class 1259 OID 17678)
-- Dependencies: 5
-- Name: marcas_de_produtos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE marcas_de_produtos (
    id serial NOT NULL,
    descricao character varying(255),
    nome character varying(255) NOT NULL,
    data_de_registro timestamp without time zone NOT NULL,
    status boolean NOT NULL
);


--
-- TOC entry 164 (class 1259 OID 17702)
-- Dependencies: 5
-- Name: marcas_de_veiculos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE marcas_de_veiculos (
    id serial NOT NULL,
    descricao character varying(255),
    nome character varying(255) NOT NULL,
    data_do_registro timestamp without time zone NOT NULL,
    status boolean
);


--
-- TOC entry 162 (class 1259 OID 17686)
-- Dependencies: 5
-- Name: product; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE product (
    id serial NOT NULL,
    additionalcode character varying(255),
    minquantity integer,
    name character varying(255),
    status boolean,
    shelf_id integer
);


--
-- TOC entry 163 (class 1259 OID 17694)
-- Dependencies: 5
-- Name: shelf; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE shelf (
    id serial NOT NULL,
    code character varying(255),
    description character varying(255),
    registerdate timestamp without time zone,
    status boolean
);


--
-- TOC entry 165 (class 1259 OID 17710)
-- Dependencies: 5
-- Name: veiculos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE veiculos (
    id serial NOT NULL,
    nome character varying(255),
    observacao character varying(255),
    data_de_registro timestamp without time zone NOT NULL,
    status boolean,
    marca_id integer
);


--
-- TOC entry 166 (class 1259 OID 17718)
-- Dependencies: 5
-- Name: veiculos_modelos; Type: TABLE; Schema: public; Owner: -
--

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


--
-- TOC entry 1929 (class 2606 OID 17685)
-- Dependencies: 161 161 1944
-- Name: marcas_de_produtos_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marcas_de_produtos
    ADD CONSTRAINT marcas_de_produtos_pkey PRIMARY KEY (id);


--
-- TOC entry 1935 (class 2606 OID 17709)
-- Dependencies: 164 164 1944
-- Name: marcas_de_veiculos_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marcas_de_veiculos
    ADD CONSTRAINT marcas_de_veiculos_pkey PRIMARY KEY (id);


--
-- TOC entry 1931 (class 2606 OID 17693)
-- Dependencies: 162 162 1944
-- Name: product_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 1933 (class 2606 OID 17701)
-- Dependencies: 163 163 1944
-- Name: shelf_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY shelf
    ADD CONSTRAINT shelf_pkey PRIMARY KEY (id);


--
-- TOC entry 1939 (class 2606 OID 17725)
-- Dependencies: 166 166 1944
-- Name: veiculos_modelos_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY veiculos_modelos
    ADD CONSTRAINT veiculos_modelos_pkey PRIMARY KEY (id);


--
-- TOC entry 1937 (class 2606 OID 17717)
-- Dependencies: 165 165 1944
-- Name: veiculos_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY veiculos
    ADD CONSTRAINT veiculos_pkey PRIMARY KEY (id);


--
-- TOC entry 1940 (class 2606 OID 17726)
-- Dependencies: 163 162 1932 1944
-- Name: fk_product_shelf_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY product
    ADD CONSTRAINT fk_product_shelf_id FOREIGN KEY (shelf_id) REFERENCES shelf(id);


--
-- TOC entry 1941 (class 2606 OID 17731)
-- Dependencies: 165 164 1934 1944
-- Name: fk_veiculos_marca_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY veiculos
    ADD CONSTRAINT fk_veiculos_marca_id FOREIGN KEY (marca_id) REFERENCES marcas_de_veiculos(id);


--
-- TOC entry 1942 (class 2606 OID 17736)
-- Dependencies: 166 1936 165 1944
-- Name: fk_veiculos_modelos_veiculo_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY veiculos_modelos
    ADD CONSTRAINT fk_veiculos_modelos_veiculo_id FOREIGN KEY (veiculo_id) REFERENCES veiculos(id);


-- Completed on 2012-12-20 11:56:21 BRST

--
-- PostgreSQL database dump complete
--

