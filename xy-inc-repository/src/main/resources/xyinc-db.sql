CREATE TABLE tb_xy_poi (
   id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1),
   nm_poi VARCHAR(75) NOT NULL,
   nu_x INTEGER NOT NULL,
   nu_y INTEGER NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO tb_xy_poi (nm_poi, nu_x, nu_y) VALUES ('Lanchonete', 27, 12);
INSERT INTO tb_xy_poi (nm_poi, nu_x, nu_y) VALUES ('Posto', 31, 18);
INSERT INTO tb_xy_poi (nm_poi, nu_x, nu_y) VALUES ('Joalheria', 15, 12);
INSERT INTO tb_xy_poi (nm_poi, nu_x, nu_y) VALUES ('Floricultura', 19, 21);
INSERT INTO tb_xy_poi (nm_poi, nu_x, nu_y) VALUES ('Pub', 12, 8);
INSERT INTO tb_xy_poi (nm_poi, nu_x, nu_y) VALUES ('Supermercado', 23, 6);
INSERT INTO tb_xy_poi (nm_poi, nu_x, nu_y) VALUES ('Churrascaria', 28, 2);