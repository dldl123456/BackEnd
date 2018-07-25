-- alter table 外键表名 add constraint 约束名称 foreign key（外键字段）  references 主键表名(约束列名) 
-- 
-- 如表A中的Ids是主键，要约束表B中的Aid列，那么语句应该是：
-- 
-- alter table B add constraint A_B_Ids foreign key(Aid) references A(Ids) 
-- commodity_category(主键CategoryID)     commodityinfo(外键CategoryID)
alter table commodityinfo add constraint market_FK foreign key(CategoryID)  references commodity_category(CategoryID)


-- 名字为默认
-- ALTER TABLE commodityinfo
-- ADD FOREIGN KEY market_FK (CategoryID)
-- REFERENCES commodity_category (CategoryID);