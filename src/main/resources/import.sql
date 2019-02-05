
insert into templo (bairro, celular, cep, cidade, complemento, email, fixo, numero, rua, uf, whatsaap, cnpj, dt_abertura, nome_fantasia, pastor_aux_id_membro, pastor_titular_id_membro, razao_social, tipo, id_templo)values (null, null, null, null, null, null, null, null, null, null, null, 46896946000189, null, null, null, null, null, null, 1) 


INSERT INTO tb_usuario (id_usuario,ds_nome,ds_login,ds_senha,fl_ativo,templo_id_templo)VALUES(1,'Admin','admin','$2a$10$YYe9VtFGZoWvrNSZNV/AeuVSTOMQLxcGia4IQEl/yVaxrfAnPDcuO',true,1);

INSERT INTO tb_grupo(id_grupo,ds_nome,ds_descricao)VALUES(1,'ADM','Administrador');

INSERT INTO tb_permissao(id_permissao,ds_permissao,ds_descricao)VALUES(1,'ROLE_ADMIN','Administrador');

INSERT INTO tb_usuario_x_grupo(id_usuario,id_grupo)VALUES(1,1);
 
 /*ROLE_CADASTROUSUARIO x BACKOFFICE*/
INSERT INTO tb_permissao_x_grupo(id_permissao,id_grupo)VALUES(1,1); 


