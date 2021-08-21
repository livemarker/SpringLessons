create table products
(
    id       integer,
    сategory varchar
);

alter table products
    owner to postgres;

INSERT INTO public.products (id, сategory) VALUES (1, 'Книги');
INSERT INTO public.products (id, сategory) VALUES (2, 'Мыло');
INSERT INTO public.products (id, сategory) VALUES (3, 'Торты');

create table "Книги"
(
    id    integer,
    name  varchar,
    price numeric
);

alter table "Книги"
    owner to postgres;

INSERT INTO public."Книги" (id, name, price) VALUES (1, 'Война и мир', 12.2);
INSERT INTO public."Книги" (id, name, price) VALUES (2, 'Стихи', 13);

create table "Мыло"
(
    id    integer,
    name  varchar,
    price numeric
);

alter table "Мыло"
    owner to postgres;

INSERT INTO public."Мыло" (id, name, price) VALUES (1, 'Мыло волшебное', 120);
INSERT INTO public."Мыло" (id, name, price) VALUES (2, 'Мыло хозяйственное', 20);
create table "Никита_Ел"
(
    order_number integer,
    name_product varchar,
    price        numeric,
    category     varchar,
    status       varchar
);

alter table "Никита_Ел"
    owner to postgres;

INSERT INTO public."Никита_Ел" (order_number, name_product, price, category, status) VALUES (1, 'Война и мир', 12.2, 'Книги', 'Подготовка к отправке');
INSERT INTO public."Никита_Ел" (order_number, name_product, price, category, status) VALUES (1, 'Стихи', 13, 'Книги', 'Подготовка к отправке');
create table "Торты"
(
    id    integer,
    name  varchar,
    price numeric
);

alter table "Торты"
    owner to postgres;

INSERT INTO public."Торты" (id, name, price) VALUES (1, 'Торт Наполеон', 1300);

create table support_tickets
(
    number_ticket integer,
    name          varchar,
    lastname      varchar,
    topic         varchar,
    text          varchar,
    status        varchar
);

alter table support_tickets
    owner to postgres;

INSERT INTO public.support_tickets (number_ticket, name, lastname, topic, text, status) VALUES (1, 'Никита', 'Ел', 'Магазин', 'шото это шото так', 'Обращение принято');

create table users
(
    id        integer,
    "Имя"     varchar,
    "Фамилия" varchar,
    "Адрес"   varchar,
    "Телефон" varchar
);

alter table users
    owner to postgres;

INSERT INTO public.users (id, "Имя", "Фамилия", "Адрес", "Телефон") VALUES (1, 'admin', 'admin', '0', '0');
INSERT INTO public.users (id, "Имя", "Фамилия", "Адрес", "Телефон") VALUES (2, 'Никита', 'Ел', 'Королев', '223344');