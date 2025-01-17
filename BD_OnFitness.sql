PGDMP                       }         
   on_fitness    17.2    17.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16386 
   on_fitness    DATABASE     �   CREATE DATABASE on_fitness WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE on_fitness;
                     postgres    false            �            1259    16472    alunos    TABLE     �  CREATE TABLE public.alunos (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    endereco character varying(200) NOT NULL,
    telefone character varying(15) NOT NULL,
    modalidade character varying(50) NOT NULL,
    peso numeric(5,2) NOT NULL,
    altura numeric(4,2) NOT NULL,
    mensalidade numeric(10,2) NOT NULL,
    status_mensalidade boolean DEFAULT false
);
    DROP TABLE public.alunos;
       public         heap r       postgres    false            �            1259    16471    alunos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.alunos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.alunos_id_seq;
       public               postgres    false    218            �           0    0    alunos_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.alunos_id_seq OWNED BY public.alunos.id;
          public               postgres    false    217            �            1259    16479    instrutores    TABLE     �   CREATE TABLE public.instrutores (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    endereco character varying(200),
    telefone character varying(15),
    modalidade_instrucao character varying(50)
);
    DROP TABLE public.instrutores;
       public         heap r       postgres    false            �            1259    16478    instrutores_id_seq    SEQUENCE     �   CREATE SEQUENCE public.instrutores_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.instrutores_id_seq;
       public               postgres    false    220            �           0    0    instrutores_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.instrutores_id_seq OWNED BY public.instrutores.id;
          public               postgres    false    219            &           2604    16475 	   alunos id    DEFAULT     f   ALTER TABLE ONLY public.alunos ALTER COLUMN id SET DEFAULT nextval('public.alunos_id_seq'::regclass);
 8   ALTER TABLE public.alunos ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    217    218    218            (           2604    16482    instrutores id    DEFAULT     p   ALTER TABLE ONLY public.instrutores ALTER COLUMN id SET DEFAULT nextval('public.instrutores_id_seq'::regclass);
 =   ALTER TABLE public.instrutores ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    220    219    220            �          0    16472    alunos 
   TABLE DATA           y   COPY public.alunos (id, nome, endereco, telefone, modalidade, peso, altura, mensalidade, status_mensalidade) FROM stdin;
    public               postgres    false    218          �          0    16479    instrutores 
   TABLE DATA           Y   COPY public.instrutores (id, nome, endereco, telefone, modalidade_instrucao) FROM stdin;
    public               postgres    false    220   �       �           0    0    alunos_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.alunos_id_seq', 19, true);
          public               postgres    false    217            �           0    0    instrutores_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.instrutores_id_seq', 10, true);
          public               postgres    false    219            *           2606    16477    alunos alunos_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.alunos
    ADD CONSTRAINT alunos_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.alunos DROP CONSTRAINT alunos_pkey;
       public                 postgres    false    218            ,           2606    16484    instrutores instrutores_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.instrutores
    ADD CONSTRAINT instrutores_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.instrutores DROP CONSTRAINT instrutores_pkey;
       public                 postgres    false    220            �   �  x�e��n�0�g�)86�*���n�0��H�E��Ͷ�%Ey�E���_�Gڒ#�-�YZ����T��H�V���[��W�M��Юm���.�]4p�s��H�eI���H[��~Q1��k�w��\�m��Ǘ<D�{�;�{D��U@���RJ.j.�	������TD�"�T��TA��_�^�R5�4�]j`�����l�kNF^����� �h��t�� �޻#�ɸ�l*����?ҵE�`]�B�Ir;��hC�:̭�(�h��e�f��U����d�1M�2J�����d��y�fL~n�����B�w�q��Eπ{���g=�/KV
����(��/�X�@W���{�U�pT�n���,:�;��,T������:�tX�F��`�����4M��Wa=�]�Y�p�K�Je���4s�]��TI����n �<��<_�1EQ��Mj��e��ߊ�b����      �   �   x�u�=N1F��)\B����.C�hA�f��B����^�����Ř��H�;k�y��5�#�M��#<T��iD���;���R�]-]8�Oo��`[�>�#�e;�@	3'L��V�f��	�9b쑷8}�o@�
��{_~0VI!���	�����M��o0���q�I�Dc�1� SpR`�[1�;��JI�%CC[;��JI�8rk�40�"3T+�x:#�@Q�%��qs��yCE�����c�BS��     