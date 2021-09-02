CREATE TABLE public.person (
	id uuid NOT NULL,
	"name" varchar(100) NOT NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);