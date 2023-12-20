use jspservlet;

CREATE TABLE role
(
    id bigint  PRIMARY KEY auto_increment,
    name VARCHAR(150) NOT NULL,
    code VARCHAR(255) NOT NULL,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

CREATE TABLE user
(
    id bigint  PRIMARY KEY auto_increment,
    username VARCHAR(150) NOT NULL,
    password VARCHAR(150) NOT NULL,
    fullname VARCHAR(150) NOT NULL,
    status INT NOT NULL,
    roleid bigint NOT NULL,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

ALTER TABLE user ADD CONSTRAINT fk_user_roleid FOREIGN KEY(roleid) REFERENCES role(id);

CREATE TABLE news
(
    id bigint  PRIMARY KEY auto_increment,
    title VARCHAR(255) NULL,
    thumbnail VARCHAR(255) NULL,
    shortdescription TEXT NOT NULL,
    content TEXT NULL,
    categoryid bigint NOT NULL,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

CREATE TABLE category
(
    id bigint  PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

ALTER TABLE news ADD CONSTRAINT fk_news_categoryid FOREIGN KEY(categoryid) REFERENCES category(id);

CREATE TABLE comment
(
    id bigint  PRIMARY KEY auto_increment,
    content TEXT NOT NULL,
    user_id bigint NOT NULL,
    new_id bigint NOT NULL,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) NULL,
    modifiedby VARCHAR(255) NULL
);

ALTER TABLE comment ADD CONSTRAINT fk_comment_userid FOREIGN KEY(user_id) REFERENCES user(id);
ALTER TABLE comment ADD CONSTRAINT fk_comment_newid FOREIGN KEY(new_id) REFERENCES news(id);

