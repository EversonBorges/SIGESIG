
INSERT INTO tb_usuario (id_usuario,ds_nome,ds_login,ds_senha,fl_ativo)
  VALUES(1,'Admin','admin','$2a$10$YYe9VtFGZoWvrNSZNV/AeuVSTOMQLxcGia4IQEl/yVaxrfAnPDcuO',true);

INSERT INTO tb_grupo(id_grupo,ds_nome,ds_descricao)
   VALUES(1,'ADM','Administrador');

INSERT INTO tb_permissao(id_permissao,ds_permissao,ds_descricao)
   VALUES(1,'ROLE_ADMIN','Administrador');

INSERT INTO tb_usuario_x_grupo(id_usuario,id_grupo)VALUES(1,1);
 
 /*ROLE_CADASTROUSUARIO x BACKOFFICE*/
INSERT INTO tb_permissao_x_grupo(id_permissao,id_grupo)VALUES(1,1); 

