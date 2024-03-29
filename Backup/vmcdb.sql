PGDMP     *    4                {            vmcdb    12.2    12.2 H    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    33351    vmcdb    DATABASE     �   CREATE DATABASE vmcdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE vmcdb;
                postgres    false            �            1259    33368    calcado    TABLE       CREATE TABLE public.calcado (
    cod integer NOT NULL,
    nome character varying(50),
    cod_marca integer,
    cores character varying(50),
    valorcompra double precision,
    valorvenda double precision,
    genero character varying(15),
    codespe character varying(20)
);
    DROP TABLE public.calcado;
       public         heap    postgres    false            �            1259    33366    calcado_cod_seq    SEQUENCE     �   ALTER TABLE public.calcado ALTER COLUMN cod ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.calcado_cod_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    207            �            1259    33352    cliente    TABLE     >  CREATE TABLE public.cliente (
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
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    33357    cliente_cod_cliente_seq    SEQUENCE     �   ALTER TABLE public.cliente ALTER COLUMN cod_cliente ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cliente_cod_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    202            �            1259    33446    despesa    TABLE     3  CREATE TABLE public.despesa (
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
    DROP TABLE public.despesa;
       public         heap    postgres    false            �            1259    33444    despesa_cod_despesa_seq    SEQUENCE     �   ALTER TABLE public.despesa ALTER COLUMN cod_despesa ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.despesa_cod_despesa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    222            �            1259    33453    entrada    TABLE     �   CREATE TABLE public.entrada (
    cod_entrada integer NOT NULL,
    fornecedor character varying(45),
    dt_compra date,
    metodo_pag character varying(45),
    nr_nf character varying(9),
    qntd_parc integer
);
    DROP TABLE public.entrada;
       public         heap    postgres    false            �            1259    33451    entrada_cod_entrada_seq    SEQUENCE     �   ALTER TABLE public.entrada ALTER COLUMN cod_entrada ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.entrada_cod_entrada_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    224            �            1259    33415    estoque    TABLE     z   CREATE TABLE public.estoque (
    cod_estoque integer NOT NULL,
    cod_cal integer,
    tam integer,
    qntd integer
);
    DROP TABLE public.estoque;
       public         heap    postgres    false            �            1259    33413    estoque_cod_estoque_seq    SEQUENCE     �   ALTER TABLE public.estoque ALTER COLUMN cod_estoque ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.estoque_cod_estoque_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    213            �            1259    33439    fiado    TABLE     �   CREATE TABLE public.fiado (
    cod_fiado integer NOT NULL,
    valorpago double precision,
    datapag date,
    observacao character varying(45),
    dtfiado date,
    vrfiado double precision,
    cod_cliente integer
);
    DROP TABLE public.fiado;
       public         heap    postgres    false            �            1259    33437    fiado_cod_fiado_seq    SEQUENCE     �   ALTER TABLE public.fiado ALTER COLUMN cod_fiado ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.fiado_cod_fiado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    220            �            1259    33375    funcionario    TABLE     `  CREATE TABLE public.funcionario (
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
    DROP TABLE public.funcionario;
       public         heap    postgres    false            �            1259    33373    funcionario_cod_func_seq    SEQUENCE     �   ALTER TABLE public.funcionario ALTER COLUMN cod_func ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.funcionario_cod_func_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    209            �            1259    33458    itens_entrada    TABLE     �   CREATE TABLE public.itens_entrada (
    cod_entrada integer,
    cod_estoque integer,
    qntd integer,
    vr_unit double precision
);
 !   DROP TABLE public.itens_entrada;
       public         heap    postgres    false            �            1259    33427    itens_venda    TABLE     �   CREATE TABLE public.itens_venda (
    cod_venda integer NOT NULL,
    cod_estoque integer NOT NULL,
    qntd integer,
    vr_unit double precision
);
    DROP TABLE public.itens_venda;
       public         heap    postgres    false            �            1259    33361    marca    TABLE     X   CREATE TABLE public.marca (
    cod integer NOT NULL,
    nome character varying(30)
);
    DROP TABLE public.marca;
       public         heap    postgres    false            �            1259    33359    marca_cod_seq    SEQUENCE     �   ALTER TABLE public.marca ALTER COLUMN cod ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.marca_cod_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    205            �            1259    33463    pagamento_despesa    TABLE     �   CREATE TABLE public.pagamento_despesa (
    cod_pag integer NOT NULL,
    valorpago double precision,
    datapag date,
    cod_func integer,
    cod_desp integer
);
 %   DROP TABLE public.pagamento_despesa;
       public         heap    postgres    false            �            1259    33461    pagamento_despesa_cod_pag_seq    SEQUENCE     �   ALTER TABLE public.pagamento_despesa ALTER COLUMN cod_pag ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pagamento_despesa_cod_pag_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    227            �            1259    33468    pagamento_fiado    TABLE     �   CREATE TABLE public.pagamento_fiado (
    cod_pag integer NOT NULL,
    valorpago double precision,
    datapag date,
    cod_fiado integer
);
 #   DROP TABLE public.pagamento_fiado;
       public         heap    postgres    false            �            1259    33466    pagamento_fiado_cod_pag_seq    SEQUENCE     �   ALTER TABLE public.pagamento_fiado ALTER COLUMN cod_pag ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pagamento_fiado_cod_pag_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    229            �            1259    33432    pagamento_venda    TABLE     �   CREATE TABLE public.pagamento_venda (
    cod_pag integer NOT NULL,
    valorpago double precision,
    datapag date,
    cod_func integer,
    cod_venda integer
);
 #   DROP TABLE public.pagamento_venda;
       public         heap    postgres    false            �            1259    33430    pagamento_venda_cod_pag_seq    SEQUENCE     �   ALTER TABLE public.pagamento_venda ALTER COLUMN cod_pag ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pagamento_venda_cod_pag_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    218            �            1259    33382 	   tipoconta    TABLE     \   CREATE TABLE public.tipoconta (
    cod integer NOT NULL,
    nome character varying(30)
);
    DROP TABLE public.tipoconta;
       public         heap    postgres    false            �            1259    33380    tipoconta_cod_seq    SEQUENCE     �   ALTER TABLE public.tipoconta ALTER COLUMN cod ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tipoconta_cod_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    211            �            1259    33422    venda    TABLE     1  CREATE TABLE public.venda (
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
    DROP TABLE public.venda;
       public         heap    postgres    false            �            1259    33420    venda_cod_venda_seq    SEQUENCE     �   ALTER TABLE public.venda ALTER COLUMN cod_venda ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.venda_cod_venda_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            j          0    33368    calcado 
   TABLE DATA           h   COPY public.calcado (cod, nome, cod_marca, cores, valorcompra, valorvenda, genero, codespe) FROM stdin;
    public          postgres    false    207   �U       e          0    33352    cliente 
   TABLE DATA           �   COPY public.cliente (cod_cliente, nome, cpf, telefone, email, rg, uf, cidade, cep, bairro, endereco, numero, limitefiado, fiado, saldofiado, databloqueio, motivobloq) FROM stdin;
    public          postgres    false    202   yV       y          0    33446    despesa 
   TABLE DATA           �   COPY public.despesa (cod_despesa, cod_func, cod_tpconta, cod_entrada, nome, descricao, status, valor, dt_venc, dt_inicio) FROM stdin;
    public          postgres    false    222   �W       {          0    33453    entrada 
   TABLE DATA           c   COPY public.entrada (cod_entrada, fornecedor, dt_compra, metodo_pag, nr_nf, qntd_parc) FROM stdin;
    public          postgres    false    224   -X       p          0    33415    estoque 
   TABLE DATA           B   COPY public.estoque (cod_estoque, cod_cal, tam, qntd) FROM stdin;
    public          postgres    false    213   JX       w          0    33439    fiado 
   TABLE DATA           i   COPY public.fiado (cod_fiado, valorpago, datapag, observacao, dtfiado, vrfiado, cod_cliente) FROM stdin;
    public          postgres    false    220   �X       l          0    33375    funcionario 
   TABLE DATA           �   COPY public.funcionario (cod_func, nome, estadocivil, cpf, rg, uf, cidade, bairro, endereco, numero, telefone, permissao, ativo, senha, login, data_desat, cep, email) FROM stdin;
    public          postgres    false    209   IY       |          0    33458    itens_entrada 
   TABLE DATA           P   COPY public.itens_entrada (cod_entrada, cod_estoque, qntd, vr_unit) FROM stdin;
    public          postgres    false    225   cZ       s          0    33427    itens_venda 
   TABLE DATA           L   COPY public.itens_venda (cod_venda, cod_estoque, qntd, vr_unit) FROM stdin;
    public          postgres    false    216   �Z       h          0    33361    marca 
   TABLE DATA           *   COPY public.marca (cod, nome) FROM stdin;
    public          postgres    false    205   �Z       ~          0    33463    pagamento_despesa 
   TABLE DATA           \   COPY public.pagamento_despesa (cod_pag, valorpago, datapag, cod_func, cod_desp) FROM stdin;
    public          postgres    false    227   [       �          0    33468    pagamento_fiado 
   TABLE DATA           Q   COPY public.pagamento_fiado (cod_pag, valorpago, datapag, cod_fiado) FROM stdin;
    public          postgres    false    229   V[       u          0    33432    pagamento_venda 
   TABLE DATA           [   COPY public.pagamento_venda (cod_pag, valorpago, datapag, cod_func, cod_venda) FROM stdin;
    public          postgres    false    218   �[       n          0    33382 	   tipoconta 
   TABLE DATA           .   COPY public.tipoconta (cod, nome) FROM stdin;
    public          postgres    false    211   �[       r          0    33422    venda 
   TABLE DATA           �   COPY public.venda (cod_venda, descricao, valortotal, fiado, datavenda, comentarios, cod_cliente, quitada, dtquitacao) FROM stdin;
    public          postgres    false    215   (\       �           0    0    calcado_cod_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.calcado_cod_seq', 71, true);
          public          postgres    false    206            �           0    0    cliente_cod_cliente_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.cliente_cod_cliente_seq', 39, true);
          public          postgres    false    203            �           0    0    despesa_cod_despesa_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.despesa_cod_despesa_seq', 68, true);
          public          postgres    false    221            �           0    0    entrada_cod_entrada_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.entrada_cod_entrada_seq', 46, true);
          public          postgres    false    223            �           0    0    estoque_cod_estoque_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.estoque_cod_estoque_seq', 94, true);
          public          postgres    false    212            �           0    0    fiado_cod_fiado_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.fiado_cod_fiado_seq', 9, true);
          public          postgres    false    219            �           0    0    funcionario_cod_func_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.funcionario_cod_func_seq', 24, true);
          public          postgres    false    208            �           0    0    marca_cod_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.marca_cod_seq', 14, true);
          public          postgres    false    204            �           0    0    pagamento_despesa_cod_pag_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.pagamento_despesa_cod_pag_seq', 11, true);
          public          postgres    false    226            �           0    0    pagamento_fiado_cod_pag_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.pagamento_fiado_cod_pag_seq', 14, true);
          public          postgres    false    228            �           0    0    pagamento_venda_cod_pag_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.pagamento_venda_cod_pag_seq', 40, true);
          public          postgres    false    217            �           0    0    tipoconta_cod_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.tipoconta_cod_seq', 16, true);
          public          postgres    false    210            �           0    0    venda_cod_venda_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.venda_cod_venda_seq', 29, true);
          public          postgres    false    214            �
           2606    33356    cliente cliente_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cod_cliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    202            �
           2606    33450    despesa despesa_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.despesa
    ADD CONSTRAINT despesa_pkey PRIMARY KEY (cod_despesa);
 >   ALTER TABLE ONLY public.despesa DROP CONSTRAINT despesa_pkey;
       public            postgres    false    222            �
           2606    33457    entrada entrada_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.entrada
    ADD CONSTRAINT entrada_pkey PRIMARY KEY (cod_entrada);
 >   ALTER TABLE ONLY public.entrada DROP CONSTRAINT entrada_pkey;
       public            postgres    false    224            �
           2606    33419    estoque estoque_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT estoque_pkey PRIMARY KEY (cod_estoque);
 >   ALTER TABLE ONLY public.estoque DROP CONSTRAINT estoque_pkey;
       public            postgres    false    213            �
           2606    33443    fiado fiado_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.fiado
    ADD CONSTRAINT fiado_pkey PRIMARY KEY (cod_fiado);
 :   ALTER TABLE ONLY public.fiado DROP CONSTRAINT fiado_pkey;
       public            postgres    false    220            �
           2606    33379    funcionario funcionario_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (cod_func);
 F   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_pkey;
       public            postgres    false    209            �
           2606    33365    marca marca_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.marca
    ADD CONSTRAINT marca_pkey PRIMARY KEY (cod);
 :   ALTER TABLE ONLY public.marca DROP CONSTRAINT marca_pkey;
       public            postgres    false    205            �
           2606    33472 $   pagamento_fiado pagamento_fiado_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.pagamento_fiado
    ADD CONSTRAINT pagamento_fiado_pkey PRIMARY KEY (cod_pag);
 N   ALTER TABLE ONLY public.pagamento_fiado DROP CONSTRAINT pagamento_fiado_pkey;
       public            postgres    false    229            �
           2606    33436 $   pagamento_venda pagamento_venda_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.pagamento_venda
    ADD CONSTRAINT pagamento_venda_pkey PRIMARY KEY (cod_pag);
 N   ALTER TABLE ONLY public.pagamento_venda DROP CONSTRAINT pagamento_venda_pkey;
       public            postgres    false    218            �
           2606    33372    calcado pk_cal_cod 
   CONSTRAINT     Q   ALTER TABLE ONLY public.calcado
    ADD CONSTRAINT pk_cal_cod PRIMARY KEY (cod);
 <   ALTER TABLE ONLY public.calcado DROP CONSTRAINT pk_cal_cod;
       public            postgres    false    207            �
           2606    33386    tipoconta tipoconta_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.tipoconta
    ADD CONSTRAINT tipoconta_pkey PRIMARY KEY (cod);
 B   ALTER TABLE ONLY public.tipoconta DROP CONSTRAINT tipoconta_pkey;
       public            postgres    false    211            �
           2606    33426    venda venda_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (cod_venda);
 :   ALTER TABLE ONLY public.venda DROP CONSTRAINT venda_pkey;
       public            postgres    false    215            j   �   x�U�1�0@��9'��؀8D�n]u�H4�H�
�o�E�d=[�naY���1eh��y�:�u@����0�>D G��jB|I%!O|�����Ϊ�@ϙ�O��χ��=��Uka�Շ]���gjG�&Ȓ��4��T,���-o�
�b⒤�m���S�OY�S7�����G�      e   4  x�eQ�r�0�W_��btb�%��MZ7�3!��0���"�"aV�^�-O����yK�{��ֵB��sp6��Fi�q)y�P �?`�c,d�*
���)k6)�B��߮0��O×_���TN����w����s(��cϘ(� R��ι���]��P��8XK㞕n�!!N�'J�џ��#**�+�XkAn��u�f�Bt�u�gyi�����{/��y;��ꐃ|Nz�����#�5�v�d��i[�hIۼ�1���+�� D�L0�T�!o�>����+��K	�����Z��/����      y   `   x�3��44�?�����D����TΔ��d(ӏ��������X��P��40�52�23%�=���B��E�9)�е�aՎ��~K4���qqq h]>V      {      x������ � �      p   �   x���D!Ϥ�}( ��ￎ�͋a���nQ�p�NZ��*�*l�sᵍ�sY��0)c�SXJYG�U�,p\��!�W.vp�Č-�����O�������;U�����
��:�X��.��r����҈&�      w   W   x�u�A�0�����/^���X���m�L �� I2�̚��#��)bf�ݨ��ճ�X����E�gB�[{�gf���.9f$�      l   
  x�]�OK�0���O�c{hi�-�Mы �X��K`Mj�
~{'�b�<2���0�1Xx��g�M������5��ɳv�#<��p�aM�7[��`������AC�tk�V4�������`M^���W�%`�S���Ho��'{)(7_	�!�>��uo�'��@*2j$oŎy�i�%u�9�B�L���E	�*�[qY��o�He(X�<'\���c=��4W�b�Q�F���p�
ø��(�\��p`���cÛ����WU��Lp�      |      x������ � �      s   E   x�M���0��QL�0���_G�bK��VK"�*4�����S�'���m;Nd�,Tn.�j��}�����      h      x�3����N�24�LL�LI,����� D�w      ~   C   x�m̱	�0�������e{��?G U@n�8A:s������q��z������Cԅ�if/�R      �   +   x�34�46�4202�5��50��24�4E1�4C����� 3 	�      u   P   x�u���0���� �/	����@D"|��D�#<T|-�!d�N{]���ڏw<��yW��}������:�3; ��      n   '   x�34�LL/M�24��)��24�t�+)JLI����� ���      r   j   x�}�A� �ݿ`�]��\y��?�$L�ڙ68fD��F- iH�e�Y�fm��N[������"r$	��;`��J���G;]�T�n^��Kv-s     