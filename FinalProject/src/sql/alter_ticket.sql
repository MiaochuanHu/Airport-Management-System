ALTER TABLE ticket ADD COLUMN carryDanger TINYINT DEFAULT 0 COMMENT 'user for secruity check: 1 true' AFTER idLaggage;
ALTER TABLE ticket ADD COLUMN `from` VARCHAR(10) DEFAULT "" COMMENT 'departure' AFTER carryDanger;
ALTER TABLE ticket ADD COLUMN `to` VARCHAR(10) DEFAULT "" COMMENT 'arrive' AFTER `from` ;