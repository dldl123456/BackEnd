-- 将score表中的grades字段中的所有值拷贝到test表中的test字段

INSERT INTO test (test) SELECT grades FROM score ;