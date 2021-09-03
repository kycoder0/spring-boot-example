CREATE TABLE person (
	id uuid NOT NULL,
	"name" varchar(100) NOT NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO person (id,"name") VALUES
	 ('4d227923-99d0-42cb-8a37-88d2f4db7503'::uuid,'Brooklyn Blair'),
	 ('43e6627f-d304-4f55-86ab-f2b8ddd1fcc6'::uuid,'Keenan Zimmerman'),
	 ('1c537017-8a1f-4dd9-b441-44a54454abc2'::uuid,'Madihah Weiss'),
	 ('bc4553c6-2db8-4efc-86fe-9bf83a519abb'::uuid,'Bella-Rose Bonner'),
	 ('faede601-41e7-4c67-95c0-d46bf9654e8e'::uuid,'Terence Person'),
	 ('b6e6256f-006a-4874-85c3-4aad800f139c'::uuid,'Matt Dolan'),
	 ('be2ade43-0574-4c01-8320-62ef3ee561ea'::uuid,'Billy Kidd'),
	 ('fa979ca0-f65a-41e9-abaf-41c099a461e9'::uuid,'Diesel Jordan'),
	 ('1b193e6f-c385-4764-a526-ec0e52083b17'::uuid,'Maeve Vazquez'),
	 ('9f04418f-7279-4a50-8591-eebaf23501a1'::uuid,'Ned Hooper'),
	 ('0256a2e9-422f-46d6-bf03-204739edda1f'::uuid,'Asad Sharples'),
	 ('2761f0ff-983c-42c9-b2db-3fec3414877a'::uuid,'Ivan Knott'),
	 ('47cc6aaf-6ecd-46f9-8003-d01e61823abc'::uuid,'Nannie Leach'),
	 ('1c8c58ed-82c0-4d44-b725-78fa92c03a91'::uuid,'Orson Guthrie');
