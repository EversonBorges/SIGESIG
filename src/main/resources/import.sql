INSERT INTO tb_usuario (ds_nome,ds_login,ds_senha,fl_ativo)
  VALUES('Borges','borges','$2a$10$YYe9VtFGZoWvrNSZNV/AeuVSTOMQLxcGia4IQEl/yVaxrfAnPDcuO',true);

INSERT INTO tb_grupo(ds_nome,ds_descricao) 
 VALUES('ADMINISTRADORES','Adminitrador');

INSERT INTO tb_permissao(ds_permissao,ds_descricao)
   VALUES('ROLE_ADMIN','Adminitrador');

INSERT INTO tb_usuario_x_grupo(id_usuario,id_grupo)VALUES(2,1);

/*ROLE_CADASTROUSUARIO x BACKOFFICE*/
INSERT INTO tb_permissao_x_grupo(id_permissao,id_grupo)VALUES(1,1);



