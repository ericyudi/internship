--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2023-10-20 22:20:17

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 207 (class 1259 OID 33368)
-- Name: calcado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.calcado (
    cod integer NOT NULL,
    nome character varying(50),
    cod_marca integer,
    cores character varying(50),
    valorcompra double precision,
    valorvenda double precision,
    genero character varying(15),
    codespe character varying(20)
);


ALTER TABLE public.calcado OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 33366)
-- Name: calcado_cod_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.calcado ALTER COLUMN cod ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.calcado_cod_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 202 (class 1259 OID 33352)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    cod_cliente integer NOT NULL,
    nome character varying(60),
    cpf character varying(20),
    telefone character varying(30),
    email character varying(40),
    rg character varying(16),
    uf character varying(3),
    cidade character varying(40),
    cep character varying(13),
    bairro character varying(50),
    endereco character varying(50),
    numero integer,
    limitefiado double precision,
    fiado character varying(10),
    saldofiado double precision,
    databloqueio date,
    motivobloq character varying(100)
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 33357)
-- Name: cliente_cod_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.cliente ALTER COLUMN cod_cliente ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cliente_cod_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 222 (class 1259 OID 33446)
-- Name: despesa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.despesa (
    cod_despesa integer NOT NULL,
    cod_func integer,
    cod_tpconta integer,
    cod_entrada integer,
    nome character varying(45),
    descricao character varying(45),
    status character varying(45),
    valor double precision,
    dt_venc date,
    dt_inicio date
);


ALTER TABLE public.despesa OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 33444)
-- Name: despesa_cod_despesa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.despesa ALTER COLUMN cod_despesa ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.despesa_cod_despesa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 224 (class 1259 OID 33453)
-- Name: entrada; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.entrada (
    cod_entrada integer NOT NULL,
    fornecedor character varying(45),
    dt_compra date,
    metodo_pag character varying(45),
    nr_nf character varying(9),
    qntd_parc integer
);


ALTER TABLE public.entrada OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 33451)
-- Name: entrada_cod_entrada_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.entrada ALTER COLUMN cod_entrada ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.entrada_cod_entrada_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 213 (class 1259 OID 33415)
-- Name: estoque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estoque (
    cod_estoque integer NOT NULL,
    cod_cal integer,
    tam integer,
    qntd integer
);


ALTER TABLE public.estoque OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 33413)
-- Name: estoque_cod_estoque_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.estoque ALTER COLUMN cod_estoque ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.estoque_cod_estoque_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 220 (class 1259 OID 33439)
-- Name: fiado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fiado (
    cod_fiado integer NOT NULL,
    valorpago double precision,
    datapag date,
    observacao character varying(45),
    dtfiado date,
    vrfiado double precision,
    cod_cliente integer
);


ALTER TABLE public.fiado OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 33437)
-- Name: fiado_cod_fiado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.fiado ALTER COLUMN cod_fiado ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.fiado_cod_fiado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 209 (class 1259 OID 33375)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionario (
    cod_func integer NOT NULL,
    nome character varying(60),
    estadocivil character varying(20),
    cpf character varying(20),
    rg character varying(16),
    uf character varying(3),
    cidade character varying(40),
    bairro character varying(50),
    endereco character varying(50),
    numero integer,
    telefone character varying(20),
    permissao character varying(10),
    ativo character varying(2),
    senha character varying(30),
    login character varying(30),
    data_desat date,
    cep character varying(13),
    email character varying(40)
);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 33373)
-- Name: funcionario_cod_func_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.funcionario ALTER COLUMN cod_func ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.funcionario_cod_func_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 225 (class 1259 OID 33458)
-- Name: itens_entrada; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.itens_entrada (
    cod_entrada integer,
    cod_estoque integer,
    qntd integer,
    vr_unit double precision
);


ALTER TABLE public.itens_entrada OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 33427)
-- Name: itens_venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.itens_venda (
    cod_venda integer NOT NULL,
    cod_estoque integer NOT NULL,
    qntd integer,
    vr_unit double precision
);


ALTER TABLE public.itens_venda OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 33361)
-- Name: marca; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marca (
    cod integer NOT NULL,
    nome character varying(30)
);


ALTER TABLE public.marca OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 33359)
-- Name: marca_cod_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.marca ALTER COLUMN cod ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.marca_cod_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 227 (class 1259 OID 33463)
-- Name: pagamento_despesa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagamento_despesa (
    cod_pag integer NOT NULL,
    valorpago double precision,
    datapag date,
    cod_func integer,
    cod_desp integer
);


ALTER TABLE public.pagamento_despesa OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 33461)
-- Name: pagamento_despesa_cod_pag_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.pagamento_despesa ALTER COLUMN cod_pag ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pagamento_despesa_cod_pag_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 229 (class 1259 OID 33468)
-- Name: pagamento_fiado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagamento_fiado (
    cod_pag integer NOT NULL,
    valorpago double precision,
    datapag date,
    cod_fiado integer
);


ALTER TABLE public.pagamento_fiado OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 33466)
-- Name: pagamento_fiado_cod_pag_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.pagamento_fiado ALTER COLUMN cod_pag ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pagamento_fiado_cod_pag_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 218 (class 1259 OID 33432)
-- Name: pagamento_venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagamento_venda (
    cod_pag integer NOT NULL,
    valorpago double precision,
    datapag date,
    cod_func integer,
    cod_venda integer
);


ALTER TABLE public.pagamento_venda OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 33430)
-- Name: pagamento_venda_cod_pag_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.pagamento_venda ALTER COLUMN cod_pag ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pagamento_venda_cod_pag_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 211 (class 1259 OID 33382)
-- Name: tipoconta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipoconta (
    cod integer NOT NULL,
    nome character varying(30)
);


ALTER TABLE public.tipoconta OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 33380)
-- Name: tipoconta_cod_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.tipoconta ALTER COLUMN cod ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tipoconta_cod_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 215 (class 1259 OID 33422)
-- Name: venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.venda (
    cod_venda integer NOT NULL,
    descricao character varying(45),
    valortotal double precision,
    fiado character varying(10),
    datavenda date,
    comentarios character varying(45),
    cod_cliente integer,
    quitada character varying(10),
    dtquitacao date
);


ALTER TABLE public.venda OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 33420)
-- Name: venda_cod_venda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.venda ALTER COLUMN cod_venda ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.venda_cod_venda_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2922 (class 0 OID 33368)
-- Dependencies: 207
-- Data for Name: calcado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.calcado (cod, nome, cod_marca, cores, valorcompra, valorvenda, genero, codespe) FROM stdin;
57	yeezy boost	6	azul	399.99	400	Masculino	424.4234
64	nome entrada	6	azul	20	30	Masculino	321
70	batatinha frita	6	azul	100	100	Masculino	123
71	cazin	6	azul	40	40	Masculino	524
54	teste	6	azul	44.34	50	Masculino	423.424
63	peper	6	rosa	32.32	30	Unissex	3232
\.


--
-- TOC entry 2917 (class 0 OID 33352)
-- Dependencies: 202
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (cod_cliente, nome, cpf, telefone, email, rg, uf, cidade, cep, bairro, endereco, numero, limitefiado, fiado, saldofiado, databloqueio, motivobloq) FROM stdin;
34	testeemotivo	389.859.018-69	(42)34234-2342	eric	43423	AC	dfdfsdfsd	34234-234	fsdfdsfsdfsdfsd	fdfdfsd	43242	500	S	500	\N	cara chato
39	marcos furuti	389.859.018-69					alvares machado				\N	1001	S	999.98	\N	\N
21	sdfsdfds	423.423	(23)4234-23	fgggfg	4234234	AC	gfgd	42423	gfgdfgdf	rfdfds	555	11	S	11	\N	\N
24	ericviic	062.997.998-70	(17)5464-5645	eric-sian@	423423	AC	fdfsd	42342-34	fdfsdfsd	ffweerwe	54	900	S	100	\N	
35	testemovitodois	389.859.018-69	(45)2342-3423	rerwerwe	rwerwerwe	AC	rerwer	42342-3	rerwer	werwerwer	454	0	N	0	2023-08-16	
\.


--
-- TOC entry 2937 (class 0 OID 33446)
-- Dependencies: 222
-- Data for Name: despesa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.despesa (cod_despesa, cod_func, cod_tpconta, cod_entrada, nome, descricao, status, valor, dt_venc, dt_inicio) FROM stdin;
68	15	15	\N	conta teste	desc teste	N	100	2023-11-30	2023-07-27
65	15	15	\N	conta teste	desc teste	S	100	2023-08-31	2023-07-27
67	15	15	\N	conta teste	desc teste	S	100	2023-10-31	2023-07-27
66	15	15	\N	conta testee	desc testee	S	100	2023-09-30	2023-07-27
\.


--
-- TOC entry 2939 (class 0 OID 33453)
-- Dependencies: 224
-- Data for Name: entrada; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.entrada (cod_entrada, fornecedor, dt_compra, metodo_pag, nr_nf, qntd_parc) FROM stdin;
\.


--
-- TOC entry 2928 (class 0 OID 33415)
-- Dependencies: 213
-- Data for Name: estoque; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estoque (cod_estoque, cod_cal, tam, qntd) FROM stdin;
84	70	35	1
85	64	34	1
86	64	35	1
88	70	32	1
90	70	38	2
92	70	41	3
93	70	43	3
94	71	37	2
91	70	40	3
53	57	35	3
60	57	37	1
82	70	33	0
83	70	34	0
71	63	40	1
72	64	40	13
87	64	20	0
89	70	39	0
54	57	36	3
74	64	42	10
37	54	41	5
38	54	42	5
73	64	41	11
75	54	40	1
76	54	32	1
\.


--
-- TOC entry 2935 (class 0 OID 33439)
-- Dependencies: 220
-- Data for Name: fiado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fiado (cod_fiado, valorpago, datapag, observacao, dtfiado, vrfiado, cod_cliente) FROM stdin;
4	300	2023-07-12		2023-07-12	400	24
5	100	2023-07-31		2023-07-31	400	24
6	20	2023-08-01	teste	2023-08-01	30	24
7	20	2023-08-01		2023-08-01	30	24
8	40	2023-08-01		2023-08-01	100	24
9	100	2023-08-01		2023-08-01	100	24
\.


--
-- TOC entry 2924 (class 0 OID 33375)
-- Dependencies: 209
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.funcionario (cod_func, nome, estadocivil, cpf, rg, uf, cidade, bairro, endereco, numero, telefone, permissao, ativo, senha, login, data_desat, cep, email) FROM stdin;
15	Dona	Viuvo	389.859.018-69	50.42342.423-4	SP	Iepe	Centro	Rua minas gerais	268	(18)99853-4534	Total	S	admin	admin	\N	\N	\N
24	ericon yudon sian	Solteiro	432.432.44	23423423	AL	cidade	bairro	end	4524	(42)3423-4	Parcial	S	pepo	pepo	\N	14823-483	ericc
23	testeeee	Solteiro	389.859.018-69	45923489	AL	presidente prudente	bairroteste	endteste	32423	(28)39128-3128	Parcial	S	123	teste	\N	19061-323	erique@sian
\.


--
-- TOC entry 2940 (class 0 OID 33458)
-- Dependencies: 225
-- Data for Name: itens_entrada; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.itens_entrada (cod_entrada, cod_estoque, qntd, vr_unit) FROM stdin;
\.


--
-- TOC entry 2931 (class 0 OID 33427)
-- Dependencies: 216
-- Data for Name: itens_venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.itens_venda (cod_venda, cod_estoque, qntd, vr_unit) FROM stdin;
22	53	1	400
23	54	2	400
24	53	1	400
25	60	1	400
26	82	2	100
26	83	2	100
27	72	1	30
28	87	1	30
29	89	1	100
\.


--
-- TOC entry 2920 (class 0 OID 33361)
-- Dependencies: 205
-- Data for Name: marca; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.marca (cod, nome) FROM stdin;
6	nike
14	adidas
\.


--
-- TOC entry 2942 (class 0 OID 33463)
-- Dependencies: 227
-- Data for Name: pagamento_despesa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagamento_despesa (cod_pag, valorpago, datapag, cod_func, cod_desp) FROM stdin;
5	50	2023-08-01	15	67
6	25	2023-08-01	15	67
7	3	2023-08-01	15	67
8	22	2023-08-01	15	67
9	30	2023-08-02	15	66
10	5	2023-08-02	15	66
11	65	2023-08-02	15	66
\.


--
-- TOC entry 2944 (class 0 OID 33468)
-- Dependencies: 229
-- Data for Name: pagamento_fiado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagamento_fiado (cod_pag, valorpago, datapag, cod_fiado) FROM stdin;
12	30	2023-08-02	9
13	5	2023-08-02	9
14	65	2023-08-02	9
\.


--
-- TOC entry 2933 (class 0 OID 33432)
-- Dependencies: 218
-- Data for Name: pagamento_venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagamento_venda (cod_pag, valorpago, datapag, cod_func, cod_venda) FROM stdin;
18	800	2023-07-12	15	23
19	200	2023-07-31	15	24
35	200	2023-07-31	15	24
36	0	2023-08-01	15	23
37	50	2023-08-01	15	26
38	30	2023-08-01	15	26
39	200	2023-08-01	15	26
40	120	2023-08-01	15	26
\.


--
-- TOC entry 2926 (class 0 OID 33382)
-- Dependencies: 211
-- Data for Name: tipoconta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipoconta (cod, nome) FROM stdin;
10	agua
15	luz
16	Entrada
\.


--
-- TOC entry 2930 (class 0 OID 33422)
-- Dependencies: 215
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venda (cod_venda, descricao, valortotal, fiado, datavenda, comentarios, cod_cliente, quitada, dtquitacao) FROM stdin;
24		400	N	2023-07-31		21	S	2023-07-31
23		800	N	2023-07-12		24	S	2023-08-01
26		400	N	2023-08-01		21	S	2023-08-01
27	teste	30	S	2023-08-01		24	N	\N
28		30	S	2023-08-01		24	N	\N
29		100	S	2023-08-01		24	N	\N
22		400	S	2023-07-12		24	N	\N
25		400	S	2023-07-31		24	N	\N
\.


--
-- TOC entry 2950 (class 0 OID 0)
-- Dependencies: 206
-- Name: calcado_cod_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.calcado_cod_seq', 71, true);


--
-- TOC entry 2951 (class 0 OID 0)
-- Dependencies: 203
-- Name: cliente_cod_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_cod_cliente_seq', 39, true);


--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 221
-- Name: despesa_cod_despesa_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.despesa_cod_despesa_seq', 68, true);


--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 223
-- Name: entrada_cod_entrada_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.entrada_cod_entrada_seq', 46, true);


--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 212
-- Name: estoque_cod_estoque_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estoque_cod_estoque_seq', 94, true);


--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 219
-- Name: fiado_cod_fiado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fiado_cod_fiado_seq', 9, true);


--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 208
-- Name: funcionario_cod_func_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.funcionario_cod_func_seq', 24, true);


--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 204
-- Name: marca_cod_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.marca_cod_seq', 14, true);


--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 226
-- Name: pagamento_despesa_cod_pag_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pagamento_despesa_cod_pag_seq', 11, true);


--
-- TOC entry 2959 (class 0 OID 0)
-- Dependencies: 228
-- Name: pagamento_fiado_cod_pag_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pagamento_fiado_cod_pag_seq', 14, true);


--
-- TOC entry 2960 (class 0 OID 0)
-- Dependencies: 217
-- Name: pagamento_venda_cod_pag_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pagamento_venda_cod_pag_seq', 40, true);


--
-- TOC entry 2961 (class 0 OID 0)
-- Dependencies: 210
-- Name: tipoconta_cod_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipoconta_cod_seq', 16, true);


--
-- TOC entry 2962 (class 0 OID 0)
-- Dependencies: 214
-- Name: venda_cod_venda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.venda_cod_venda_seq', 29, true);


--
-- TOC entry 2768 (class 2606 OID 33356)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cod_cliente);


--
-- TOC entry 2786 (class 2606 OID 33450)
-- Name: despesa despesa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.despesa
    ADD CONSTRAINT despesa_pkey PRIMARY KEY (cod_despesa);


--
-- TOC entry 2788 (class 2606 OID 33457)
-- Name: entrada entrada_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entrada
    ADD CONSTRAINT entrada_pkey PRIMARY KEY (cod_entrada);


--
-- TOC entry 2778 (class 2606 OID 33419)
-- Name: estoque estoque_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT estoque_pkey PRIMARY KEY (cod_estoque);


--
-- TOC entry 2784 (class 2606 OID 33443)
-- Name: fiado fiado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fiado
    ADD CONSTRAINT fiado_pkey PRIMARY KEY (cod_fiado);


--
-- TOC entry 2774 (class 2606 OID 33379)
-- Name: funcionario funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (cod_func);


--
-- TOC entry 2770 (class 2606 OID 33365)
-- Name: marca marca_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marca
    ADD CONSTRAINT marca_pkey PRIMARY KEY (cod);


--
-- TOC entry 2790 (class 2606 OID 33472)
-- Name: pagamento_fiado pagamento_fiado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento_fiado
    ADD CONSTRAINT pagamento_fiado_pkey PRIMARY KEY (cod_pag);


--
-- TOC entry 2782 (class 2606 OID 33436)
-- Name: pagamento_venda pagamento_venda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento_venda
    ADD CONSTRAINT pagamento_venda_pkey PRIMARY KEY (cod_pag);


--
-- TOC entry 2772 (class 2606 OID 33372)
-- Name: calcado pk_cal_cod; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calcado
    ADD CONSTRAINT pk_cal_cod PRIMARY KEY (cod);


--
-- TOC entry 2776 (class 2606 OID 33386)
-- Name: tipoconta tipoconta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipoconta
    ADD CONSTRAINT tipoconta_pkey PRIMARY KEY (cod);


--
-- TOC entry 2780 (class 2606 OID 33426)
-- Name: venda venda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (cod_venda);


-- Completed on 2023-10-20 22:20:17

--
-- PostgreSQL database dump complete
--

