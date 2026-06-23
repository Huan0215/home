USE admin_db;

INSERT INTO users(username,password,role,email,phone) VALUES
('admin','password','ADMIN','admin@example.com','1234567890'),
('user1','password','USER','user1@example.com','1111111111'),
('user2','password','USER','user2@example.com','2222222222'),
('alice','password','MANAGER','alice@example.com','3333333333'),
('bob','password','USER','bob@example.com','4444444444'),
('charlie','password','USER','charlie@example.com','5555555555'),
('david','password','USER','david@example.com','6666666666');
