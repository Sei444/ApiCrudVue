-- Tabla de Usuario
CREATE TABLE public.user (
                             id integer PRIMARY KEY,
                             username VARCHAR(150) NOT NULL,
                             password VARCHAR(150) NOT NULL,
                             email VARCHAR(150) NOT NULL,
                             created_at TIMESTAMP NOT NULL
);alter table public.user
    owner to postgres;

create sequence public.user_sequence as integer increment 1;

CREATE TABLE public.user_detail (
                                    id integer PRIMARY KEY,
                                    first_name VARCHAR(100) NOT NULL,
                                    last_name VARCHAR(100) NOT NULL,
                                    age INT,
                                    birth_day DATE,
                                    user_id BIGINT,
                                    FOREIGN KEY (user_id) REFERENCES public.user(id)
);

alter table public.user_detail
    owner to postgres;

create sequence public.user_detail_sequence as integer increment 1;
