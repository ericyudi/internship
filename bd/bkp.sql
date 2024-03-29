PGDMP     )                
    {            vmcdb    12.2    12.2 H    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    33351    vmcdb    DATABASE     �   CREATE DATABASE vmcdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE vmcdb;
                postgres    false            �            1259    33575    calcado    TABLE       CREATE TABLE public.calcado (
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
       public         heap    postgres    false            �            1259    33578    calcado_cod_seq    SEQUENCE     �   ALTER TABLE public.calcado ALTER COLUMN cod ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.calcado_cod_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    202            �            1259    33580    cliente    TABLE     >  CREATE TABLE public.cliente (
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
       public         heap    postgres    false            �            1259    33583    cliente_cod_cliente_seq    SEQUENCE     �   ALTER TABLE public.cliente ALTER COLUMN cod_cliente ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cliente_cod_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    204            �            1259    33585    despesa    TABLE     3  CREATE TABLE public.despesa (
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
       public         heap    postgres    false            �            1259    33588    despesa_cod_despesa_seq    SEQUENCE     �   ALTER TABLE public.despesa ALTER COLUMN cod_despesa ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.despesa_cod_despesa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    206            �            1259    33590    entrada    TABLE     �   CREATE TABLE public.entrada (
    cod_entrada integer NOT NULL,
    fornecedor character varying(45),
    dt_compra date,
    metodo_pag character varying(45),
    nr_nf character varying(9),
    qntd_parc integer
);
    DROP TABLE public.entrada;
       public         heap    postgres    false            �            1259    33593    entrada_cod_entrada_seq    SEQUENCE     �   ALTER TABLE public.entrada ALTER COLUMN cod_entrada ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.entrada_cod_entrada_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    208            �            1259    33595    estoque    TABLE     z   CREATE TABLE public.estoque (
    cod_estoque integer NOT NULL,
    cod_cal integer,
    tam integer,
    qntd integer
);
    DROP TABLE public.estoque;
       public         heap    postgres    false            �            1259    33598    estoque_cod_estoque_seq    SEQUENCE     �   ALTER TABLE public.estoque ALTER COLUMN cod_estoque ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.estoque_cod_estoque_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210            �            1259    33600    fiado    TABLE     �   CREATE TABLE public.fiado (
    cod_fiado integer NOT NULL,
    valorpago double precision,
    datapag date,
    observacao character varying(45),
    dtfiado date,
    vrfiado double precision,
    cod_cliente integer
);
    DROP TABLE public.fiado;
       public         heap    postgres    false            �            1259    33603    fiado_cod_fiado_seq    SEQUENCE     �   ALTER TABLE public.fiado ALTER COLUMN cod_fiado ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.fiado_cod_fiado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212            �            1259    33605    funcionario    TABLE     `  CREATE TABLE public.funcionario (
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
       public         heap    postgres    false            �            1259    33608    funcionario_cod_func_seq    SEQUENCE     �   ALTER TABLE public.funcionario ALTER COLUMN cod_func ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.funcionario_cod_func_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    214            �            1259    33610    itens_entrada    TABLE     �   CREATE TABLE public.itens_entrada (
    cod_entrada integer,
    cod_estoque integer,
    qntd integer,
    vr_unit double precision
);
 !   DROP TABLE public.itens_entrada;
       public         heap    postgres    false            �            1259    33613    itens_venda    TABLE     �   CREATE TABLE public.itens_venda (
    cod_venda integer NOT NULL,
    cod_estoque integer NOT NULL,
    qntd integer,
    vr_unit double precision
);
    DROP TABLE public.itens_venda;
       public         heap    postgres    false            �            1259    33616    marca    TABLE     X   CREATE TABLE public.marca (
    cod integer NOT NULL,
    nome character varying(30)
);
    DROP TABLE public.marca;
       public         heap    postgres    false            �            1259    33619    marca_cod_seq    SEQUENCE     �   ALTER TABLE public.marca ALTER COLUMN cod ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.marca_cod_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    218            �            1259    33621    pagamento_despesa    TABLE     �   CREATE TABLE public.pagamento_despesa (
    cod_pag integer NOT NULL,
    valorpago double precision,
    datapag date,
    cod_func integer,
    cod_desp integer
);
 %   DROP TABLE public.pagamento_despesa;
       public         heap    postgres    false            �            1259    33624    pagamento_despesa_cod_pag_seq    SEQUENCE     �   ALTER TABLE public.pagamento_despesa ALTER COLUMN cod_pag ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pagamento_despesa_cod_pag_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    220            �            1259    33626    pagamento_fiado    TABLE     �   CREATE TABLE public.pagamento_fiado (
    cod_pag integer NOT NULL,
    valorpago double precision,
    datapag date,
    cod_fiado integer
);
 #   DROP TABLE public.pagamento_fiado;
       public         heap    postgres    false            �            1259    33629    pagamento_fiado_cod_pag_seq    SEQUENCE     �   ALTER TABLE public.pagamento_fiado ALTER COLUMN cod_pag ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pagamento_fiado_cod_pag_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    222            �            1259    33631    pagamento_venda    TABLE     �   CREATE TABLE public.pagamento_venda (
    cod_pag integer NOT NULL,
    valorpago double precision,
    datapag date,
    cod_func integer,
    cod_venda integer
);
 #   DROP TABLE public.pagamento_venda;
       public         heap    postgres    false            �            1259    33634    pagamento_venda_cod_pag_seq    SEQUENCE     �   ALTER TABLE public.pagamento_venda ALTER COLUMN cod_pag ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pagamento_venda_cod_pag_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    224            �            1259    33636 	   tipoconta    TABLE     \   CREATE TABLE public.tipoconta (
    cod integer NOT NULL,
    nome character varying(30)
);
    DROP TABLE public.tipoconta;
       public         heap    postgres    false            �            1259    33639    tipoconta_cod_seq    SEQUENCE     �   ALTER TABLE public.tipoconta ALTER COLUMN cod ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tipoconta_cod_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    226            �            1259    33641    venda    TABLE     1  CREATE TABLE public.venda (
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
       public         heap    postgres    false            �            1259    33644    venda_cod_venda_seq    SEQUENCE     �   ALTER TABLE public.venda ALTER COLUMN cod_venda ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.venda_cod_venda_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    228            e          0    33575    calcado 
   TABLE DATA           h   COPY public.calcado (cod, nome, cod_marca, cores, valorcompra, valorvenda, genero, codespe) FROM stdin;
    public          postgres    false    202   �U       g          0    33580    cliente 
   TABLE DATA           �   COPY public.cliente (cod_cliente, nome, cpf, telefone, email, rg, uf, cidade, cep, bairro, endereco, numero, limitefiado, fiado, saldofiado, databloqueio, motivobloq) FROM stdin;
    public          postgres    false    204   �V       i          0    33585    despesa 
   TABLE DATA           �   COPY public.despesa (cod_despesa, cod_func, cod_tpconta, cod_entrada, nome, descricao, status, valor, dt_venc, dt_inicio) FROM stdin;
    public          postgres    false    206   �W       k          0    33590    entrada 
   TABLE DATA           c   COPY public.entrada (cod_entrada, fornecedor, dt_compra, metodo_pag, nr_nf, qntd_parc) FROM stdin;
    public          postgres    false    208   �X       m          0    33595    estoque 
   TABLE DATA           B   COPY public.estoque (cod_estoque, cod_cal, tam, qntd) FROM stdin;
    public          postgres    false    210   �X       o          0    33600    fiado 
   TABLE DATA           i   COPY public.fiado (cod_fiado, valorpago, datapag, observacao, dtfiado, vrfiado, cod_cliente) FROM stdin;
    public          postgres    false    212   `Y       q          0    33605    funcionario 
   TABLE DATA           �   COPY public.funcionario (cod_func, nome, estadocivil, cpf, rg, uf, cidade, bairro, endereco, numero, telefone, permissao, ativo, senha, login, data_desat, cep, email) FROM stdin;
    public          postgres    false    214   �Y       s          0    33610    itens_entrada 
   TABLE DATA           P   COPY public.itens_entrada (cod_entrada, cod_estoque, qntd, vr_unit) FROM stdin;
    public          postgres    false    216   �Z       t          0    33613    itens_venda 
   TABLE DATA           L   COPY public.itens_venda (cod_venda, cod_estoque, qntd, vr_unit) FROM stdin;
    public          postgres    false    217   	[       u          0    33616    marca 
   TABLE DATA           *   COPY public.marca (cod, nome) FROM stdin;
    public          postgres    false    218   h[       w          0    33621    pagamento_despesa 
   TABLE DATA           \   COPY public.pagamento_despesa (cod_pag, valorpago, datapag, cod_func, cod_desp) FROM stdin;
    public          postgres    false    220   �[       y          0    33626    pagamento_fiado 
   TABLE DATA           Q   COPY public.pagamento_fiado (cod_pag, valorpago, datapag, cod_fiado) FROM stdin;
    public          postgres    false    222   �[       {          0    33631    pagamento_venda 
   TABLE DATA           [   COPY public.pagamento_venda (cod_pag, valorpago, datapag, cod_func, cod_venda) FROM stdin;
    public          postgres    false    224   4\       }          0    33636 	   tipoconta 
   TABLE DATA           .   COPY public.tipoconta (cod, nome) FROM stdin;
    public          postgres    false    226   �\                 0    33641    venda 
   TABLE DATA           �   COPY public.venda (cod_venda, descricao, valortotal, fiado, datavenda, comentarios, cod_cliente, quitada, dtquitacao) FROM stdin;
    public          postgres    false    228   �\       �           0    0    calcado_cod_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.calcado_cod_seq', 72, true);
          public          postgres    false    203            �           0    0    cliente_cod_cliente_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.cliente_cod_cliente_seq', 39, true);
          public          postgres    false    205            �           0    0    despesa_cod_despesa_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.despesa_cod_despesa_seq', 72, true);
          public          postgres    false    207            �           0    0    entrada_cod_entrada_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.entrada_cod_entrada_seq', 47, true);
          public          postgres    false    209            �           0    0    estoque_cod_estoque_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.estoque_cod_estoque_seq', 95, true);
          public          postgres    false    211            �           0    0    fiado_cod_fiado_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.fiado_cod_fiado_seq', 9, true);
          public          postgres    false    213            �           0    0    funcionario_cod_func_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.funcionario_cod_func_seq', 24, true);
          public          postgres    false    215            �           0    0    marca_cod_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.marca_cod_seq', 14, true);
          public          postgres    false    219            �           0    0    pagamento_despesa_cod_pag_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.pagamento_despesa_cod_pag_seq', 13, true);
          public          postgres    false    221            �           0    0    pagamento_fiado_cod_pag_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.pagamento_fiado_cod_pag_seq', 14, true);
          public          postgres    false    223            �           0    0    pagamento_venda_cod_pag_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.pagamento_venda_cod_pag_seq', 44, true);
          public          postgres    false    225            �           0    0    tipoconta_cod_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.tipoconta_cod_seq', 16, true);
          public          postgres    false    227            �           0    0    venda_cod_venda_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.venda_cod_venda_seq', 32, true);
          public          postgres    false    229            �
           2606    33647    cliente cliente_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cod_cliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    204            �
           2606    33649    despesa despesa_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.despesa
    ADD CONSTRAINT despesa_pkey PRIMARY KEY (cod_despesa);
 >   ALTER TABLE ONLY public.despesa DROP CONSTRAINT despesa_pkey;
       public            postgres    false    206            �
           2606    33651    entrada entrada_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.entrada
    ADD CONSTRAINT entrada_pkey PRIMARY KEY (cod_entrada);
 >   ALTER TABLE ONLY public.entrada DROP CONSTRAINT entrada_pkey;
       public            postgres    false    208            �
           2606    33653    estoque estoque_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT estoque_pkey PRIMARY KEY (cod_estoque);
 >   ALTER TABLE ONLY public.estoque DROP CONSTRAINT estoque_pkey;
       public            postgres    false    210            �
           2606    33655    fiado fiado_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.fiado
    ADD CONSTRAINT fiado_pkey PRIMARY KEY (cod_fiado);
 :   ALTER TABLE ONLY public.fiado DROP CONSTRAINT fiado_pkey;
       public            postgres    false    212            �
           2606    33657    funcionario funcionario_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (cod_func);
 F   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_pkey;
       public            postgres    false    214            �
           2606    33659    marca marca_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY public.marca
    ADD CONSTRAINT marca_pkey PRIMARY KEY (cod);
 :   ALTER TABLE ONLY public.marca DROP CONSTRAINT marca_pkey;
       public            postgres    false    218            �
           2606    33661 $   pagamento_fiado pagamento_fiado_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.pagamento_fiado
    ADD CONSTRAINT pagamento_fiado_pkey PRIMARY KEY (cod_pag);
 N   ALTER TABLE ONLY public.pagamento_fiado DROP CONSTRAINT pagamento_fiado_pkey;
       public            postgres    false    222            �
           2606    33663 $   pagamento_venda pagamento_venda_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.pagamento_venda
    ADD CONSTRAINT pagamento_venda_pkey PRIMARY KEY (cod_pag);
 N   ALTER TABLE ONLY public.pagamento_venda DROP CONSTRAINT pagamento_venda_pkey;
       public            postgres    false    224            �
           2606    33665    calcado pk_cal_cod 
   CONSTRAINT     Q   ALTER TABLE ONLY public.calcado
    ADD CONSTRAINT pk_cal_cod PRIMARY KEY (cod);
 <   ALTER TABLE ONLY public.calcado DROP CONSTRAINT pk_cal_cod;
       public            postgres    false    202            �
           2606    33667    tipoconta tipoconta_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.tipoconta
    ADD CONSTRAINT tipoconta_pkey PRIMARY KEY (cod);
 B   ALTER TABLE ONLY public.tipoconta DROP CONSTRAINT tipoconta_pkey;
       public            postgres    false    226            �
           2606    33669    venda venda_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (cod_venda);
 :   ALTER TABLE ONLY public.venda DROP CONSTRAINT venda_pkey;
       public            postgres    false    228            e   �   x�U�Kn�0��)tA"�>D��u�$,*4�K��t�|p�0|rᦺ������ �.�i
�#�I;-�\*0r`$v�R�k鳜径�'Ln�p�.=�/�s�:Yw��'$7&8ɚ˝�͓���еu}0�aث���)�U�::�&�7���[�_݈Vh����m�_�X�.c��`��9�=�Y      g   4  x�eQ�r�0�W_��btb�%��MZ7�3!��0���"�"aV�^�-O����yK�{��ֵB��sp6��Fi�q)y�P �?`�c,d�*
���)k6)�B��߮0��O×_���TN����w����s(��cϘ(� R��ι���]��P��8XK㞕n�!!N�'J�џ��#**�+�XkAn��u�f�Bt�u�gyi�����{/��y;��ꐃ|Nz�����#�5�v�d��i[�hIۼ�1���+�� D�L0�T�!o�>����+��K	�����Z��/����      i   �   x���1�0��9He���te����A��WPԔ����/����Y��`crU
K
��2�BF�%����F��9���ʚ���	K���w�ߖ�[�9�C�#_�}E���O�KF�LI���Ӡ\c��w��)LO��LV9��/B�lin�      k   .   x�31�,H-��4202�54�52�L.JM�,��46�@NC�=... ��	�      m   �   x���1߸�S�^��:����7��E�㖝�H�r�6�t�qg�m<�v���j������E��aN�c��|A�&�E�I~�+܃O'2&W��}��˖esP}:ux�/L��|a�Һ�!�ͧFi�F�8�����(l      o   W   x�u�A�0�����/^���X���m�L �� I2�̚��#��)bf�ݨ��ճ�X����E�gB�[{�gf���.9f$�      q   
  x�]�OK�0���O�c{hi�-�Mы �X��K`Mj�
~{'�b�<2���0�1Xx��g�M������5��ɳv�#<��p�aM�7[��`������AC�tk�V4�������`M^���W�%`�S���Ho��'{)(7_	�!�>��uo�'��@*2j$oŎy�i�%u�9�B�L���E	�*�[qY��o�He(X�<'\���c=��4W�b�Q�F���p�
ø��(�\��p`���cÛ����WU��Lp�      s      x�31�4�4�41������ >      t   O   x�M���0���?�K��#D1RnO�]U��"M�9����'K����c+ov
K:���0��܉z�r�}���      u      x�3����N�24�LL�LI,����� D�w      w   S   x�m�A
�0D���.�dB�z��T���-~ Tz���`��`T���d���rj�)b�����a�8�]��{��K�CDn s      y   +   x�34�46�4202�5��50��24�4E1�4C����� 3 	�      {   d   x�u���0г�KQ�Pva�9~?Q�r��-����[a�!���q��4�_qk+�kE�WS�f<�<����b�'�[^JKM�a�����bf?�F-�      }   '   x�34�LL/M�24��)��24�t�+)JLI����� ���         �   x�}�K� D�=w!5�lغ����Q������A#����x&�
J��:Kԭ�[)�[��k��jX��2ø[_ƔIn�_Q������~�O;��	H�Y�_Q�=�ԚuӃ�>�d=Y     