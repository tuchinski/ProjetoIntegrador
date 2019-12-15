insert into projPI.role(nome_role) values
	('ROLE_ADMIN'),
	('ROLE_GERENTE'),
	('ROLE_FUNCIONARIO'),
	('ROLE_DIRETOR'),
	('ROLE_CHEFEDEPTO');

INSERT INTO `projPI`.`funcionario` (`cpf`, `e_mail`, `rg`, `cargo`, `endereco`, `nome_funcionario`, `senha`, `sexo`, `telefone`)
VALUES ('000.000.000-00', 'admin@admin.com', '0', 'ROLE_ADMIN', '0', 'ADMIN', '$2a$10$S.HAItSaVWpa3uHHvu4l3.ZpMVCBrqdTrQKGYLkgZUmiHMi.TZ.hG', 'F', '(44)0000-0000');

INSERT INTO `projPI`.`funcionarios_roles` (`funcionario_id`, `role_id`) VALUES ('000.000.000-00', 'ROLE_ADMIN');
