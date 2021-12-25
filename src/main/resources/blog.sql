drop database if exists blog;
create database if not exists blog;
use blog;

-- 文章表
create table article(
	article_id int not null AUTO_INCREMENT,
    article_title varchar(30) not null default "TITLE",
	article_content varchar(15000) ,
    isDeleted int not null default 0,
    primary key (article_id)
);

-- 分类表 
create table category(
	category_id int not null AUTO_INCREMENT,
    category_name varchar(20) not null default "分类",
    isDeleted int not null default 0,
    primary key (category_id)
);
 -- 映射表 
CREATE TABLE article_category(
  id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  a_id INT(10),
  c_id INT(10),
  isDeleted int not null default 0,
  foreign key(a_id) references article(article_id),
  foreign key(c_id) references category(category_id)
);

-- article表测试数据 
INSERT INTO `blog`.`article` (`article_title`, `article_content`) VALUES ('文章标题1', '文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容');
INSERT INTO `blog`.`article` (`article_title`, `article_content`) VALUES ('文章标题2', '文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容');
INSERT INTO `blog`.`article` (`article_title`, `article_content`) VALUES ('文章标题3', '文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容');
INSERT INTO `blog`.`article` (`article_title`, `article_content`) VALUES ('文章标题4', '文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容文章内容');

-- category表测试数据 
INSERT INTO `blog`.`category` (`category_name`, `isDeleted`) VALUES ('html', '0');
INSERT INTO `blog`.`category` (`category_name`, `isDeleted`) VALUES ('css', '0');
INSERT INTO `blog`.`category` (`category_name`, `isDeleted`) VALUES ('JavaScript', '0');
INSERT INTO `blog`.`category` (`category_name`, `isDeleted`) VALUES ('BootStrap', '0');
INSERT INTO `blog`.`category` (`category_name`, `isDeleted`) VALUES ('JQuery', '0');
INSERT INTO `blog`.`category` (`category_name`, `isDeleted`) VALUES ('Android', '0');
INSERT INTO `blog`.`category` (`category_name`, `isDeleted`) VALUES ('Java', '0');
INSERT INTO `blog`.`category` (`category_name`, `isDeleted`) VALUES ('C++', '0');

-- 映射表测试数据
INSERT INTO `blog`.`article_category` (`a_id`, `c_id`) VALUES ('1', '1');
INSERT INTO `blog`.`article_category` (`a_id`, `c_id`) VALUES ('1', '2');
INSERT INTO `blog`.`article_category` (`a_id`, `c_id`) VALUES ('1', '3');
INSERT INTO `blog`.`article_category` (`a_id`, `c_id`) VALUES ('2', '6');
INSERT INTO `blog`.`article_category` (`a_id`, `c_id`) VALUES ('2', '7');
INSERT INTO `blog`.`article_category` (`a_id`, `c_id`) VALUES ('3', '8');
INSERT INTO `blog`.`article_category` (`a_id`, `c_id`) VALUES ('4', '4');
INSERT INTO `blog`.`article_category` (`a_id`, `c_id`) VALUES ('4', '1');
INSERT INTO `blog`.`article_category` (`a_id`, `c_id`) VALUES ('4', '2');
INSERT INTO `blog`.`article_category` (`a_id`, `c_id`) VALUES ('4', '3');
 
