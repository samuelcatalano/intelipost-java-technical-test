--LOGINS ROLE
INSERT INTO role (id, type) VALUES (1, 'FULL');
INSERT INTO role (id, type) VALUES (2, 'NORMAL');
INSERT INTO role (id, type) VALUES (3, 'RESTRICT');

--LOGINS
INSERT INTO login (id, name, username, password, tip, role_id, created, modified) VALUES (1, 'Samuel Catalano', 'samuelcatalano', 'e10adc3949ba59abbe56e057f20f883e', 'default', 1, '20017-10-03', '20017-10-03');
INSERT INTO login (id, name, username, password, tip, role_id, created, modified) VALUES (2, 'João da Silva Castro', 'joao123456', 'e10adc3949ba59abbe56e057f20f883e', 'default', 2, '20017-10-03', '20017-10-03');
INSERT INTO login (id, name, username, password, tip, role_id, created, modified) VALUES (3, 'José Pereira Silva', 'jose654321', 'e10adc3949ba59abbe56e057f20f883e', 'default', 3, '20017-10-03', '20017-10-03');