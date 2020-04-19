/*
 Navicat Premium Data Transfer

 Source Server         : MySQL Local
 Source Server Type    : MySQL
 Source Server Version : 100411
 Source Host           : localhost:3306
 Source Schema         : movie_reservation

 Target Server Type    : MySQL
 Target Server Version : 100411
 File Encoding         : 65001

 Date: 19/04/2020 12:21:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS ` customer `;
CREATE TABLE ` customer `
(
    `id` BIGINT
(
    20
) NOT NULL,
    ` NAME ` VARCHAR
(
    255
) DEFAULT NULL,
    PRIMARY KEY
(
    `id`
)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for dis_count
-- ----------------------------
DROP TABLE IF EXISTS ` dis_count `;
CREATE TABLE ` dis_count `
(
    `id` BIGINT
(
    20
) NOT NULL,
    ` dis_count_type ` VARCHAR
(
    255
) DEFAULT NULL,
    ` price ` DECIMAL
(
    19,
    2
) DEFAULT NULL,
    ` movie_id ` BIGINT
(
    20
) DEFAULT NULL,
    PRIMARY KEY
(
    `id`
),
    KEY ` FKiohrfd6pjfu5r39ctj9x1g5rw `
(
    `movie_id`
),
    CONSTRAINT ` FKiohrfd6pjfu5r39ctj9x1g5rw ` FOREIGN KEY
(
    `movie_id`
) REFERENCES ` movie `
(
    `id`
)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dis_count
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for dis_count_rule
-- ----------------------------
DROP TABLE IF EXISTS ` dis_count_rule `;
CREATE TABLE ` dis_count_rule `
(
    `id` BIGINT
(
    20
) NOT NULL,
    ` seq ` INT
(
    11
) DEFAULT NULL,
    ` discount_id ` BIGINT
(
    20
) DEFAULT NULL,
    PRIMARY KEY
(
    `id`
),
    KEY ` FKoirlomiplmxi6uaqp6xxefg3r `
(
    `discount_id`
),
    CONSTRAINT ` FKoirlomiplmxi6uaqp6xxefg3r ` FOREIGN KEY
(
    `discount_id`
) REFERENCES ` dis_count `
(
    `id`
)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dis_count_rule
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS ` hibernate_sequence `;
CREATE TABLE ` hibernate_sequence `
(
    `next_val` BIGINT
(
    20
) DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
BEGIN;
INSERT INTO ` hibernate_sequence `
VALUES (1);
INSERT INTO ` hibernate_sequence `
VALUES (1);
INSERT INTO ` hibernate_sequence `
VALUES (1);
INSERT INTO ` hibernate_sequence `
VALUES (1);
INSERT INTO ` hibernate_sequence `
VALUES (1);
INSERT INTO ` hibernate_sequence `
VALUES (1);
COMMIT;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS ` movie `;
CREATE TABLE ` movie `
(
    `id` BIGINT
(
    20
) NOT NULL,
    ` price ` DECIMAL
(
    19,
    2
) DEFAULT NULL,
    ` running_time ` VARCHAR
(
    255
) DEFAULT NULL,
    ` title ` VARCHAR
(
    255
) DEFAULT NULL,
    PRIMARY KEY
(
    `id`
)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of movie
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS ` reservation `;
CREATE TABLE ` reservation `
(
    `id` BIGINT
(
    20
) NOT NULL,
    ` price ` DECIMAL
(
    19,
    2
) DEFAULT NULL,
    ` customer_id ` BIGINT
(
    20
) DEFAULT NULL,
    ` screen_id ` BIGINT
(
    20
) DEFAULT NULL,
    PRIMARY KEY
(
    `id`
),
    KEY ` FK41v6ueo0hiran65w8y1cta2c2 `
(
    `customer_id`
),
    KEY ` FKkwmc33a48pxxop9w5y2rwd3s5 `
(
    `screen_id`
),
    CONSTRAINT ` FK41v6ueo0hiran65w8y1cta2c2 ` FOREIGN KEY
(
    `customer_id`
) REFERENCES ` customer `
(
    `id`
),
    CONSTRAINT ` FKkwmc33a48pxxop9w5y2rwd3s5 ` FOREIGN KEY
(
    `screen_id`
) REFERENCES ` screen `
(
    `id`
)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of reservation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for screen
-- ----------------------------
DROP TABLE IF EXISTS ` screen `;
CREATE TABLE ` screen `
(
    `id` BIGINT
(
    20
) NOT NULL,
    ` screen_time ` datetime
(
    6
) DEFAULT NULL,
    ` seq ` INT
(
    11
) DEFAULT NULL,
    ` movie_id ` BIGINT
(
    20
) DEFAULT NULL,
    PRIMARY KEY
(
    `id`
),
    KEY ` FK19or81yns51vp76dwleoltne9 `
(
    `movie_id`
),
    CONSTRAINT ` FK19or81yns51vp76dwleoltne9 ` FOREIGN KEY
(
    `movie_id`
) REFERENCES ` movie `
(
    `id`
)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of screen
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
