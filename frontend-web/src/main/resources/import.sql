insert into role (name) values ('ROLE_ADMIN'), ('ROLE_USER'), ('ROLE_ROOT');
--INSERT INTO `role`(`role_id`, `name`) VALUES ('1', 'ROLE_ADMIN');
--INSERT INTO `role`(`role_id`, `name`) VALUES ('2', 'ROLE_USER');
--INSERT INTO `role`(`role_id`, `name`) VALUES ('3', 'ROLE_ROOT');
--INSERT INTO `role`(`name`) VALUES ('ROLE_ADMIN');
--INSERT INTO `role`(`name`) VALUES ('ROLE_USER');
--INSERT INTO `role`(`name`) VALUES ('ROLE_ROOT');
INSERT INTO `user`(`user_id`, `password`, `user_name`, `user_status`, `role_id`) VALUES ('testUser1@naver.com', 'fUVcZWs6qa29DzgpZmRp9BK2blyWSF2V', 'testUser1', 'Y', '1');
INSERT INTO `user`(`user_id`, `password`, `user_name`, `user_status`, `role_id`) VALUES ('testUser2@naver.com', 'Zqsfs3K3YmhwaEF4aKyubw=='        , 'testUser2', 'Y', '2');
INSERT INTO `user`(`user_id`, `password`, `user_name`, `user_status`, `role_id`) VALUES ('testUser3@naver.com', 'Zqsfs3K3YmhwaEF4aKyubw=='        , 'testUser3', 'Y', '2');
INSERT INTO `user`(`user_id`, `password`, `user_name`, `user_status`, `role_id`) VALUES ('hunipapa@nate.com', '$2a$10$222chPET7eP9WJe7.8ubgu4CN0H3AcTAoFkXFiJQ21GvHfaLXcAte', '차상걸', 'Y', '3');
