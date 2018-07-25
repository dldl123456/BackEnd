-- 获取系统日期
#select curdate(), current_date(), curdate()+0
-- 获取系统时间
#select curtime(), current_time(), curtime()+0
-- 获取日期和时间（as后面跟别名）
-- select now() as '现在', sysdate() '...'  #select now() '现在';
-- 获取月份
#select month('2017-12-25')
-- 获取月份名字
#select monthname('2017-12-25')
-- 获取星期
#select dayname('2017-12-25')
#select dayofweek('2017-12-25')
#select weekday('2017-12-25')
#select week('2017-12-25'), weekofyear ('2017-12-25')
-- 获取天数
#select dayofyear('2017-12-25'), dayofmonth ('2017-12-25')
-- 获取时间
#select year('2017-12-25')  #年
#select quarter('2017-12-25')  #季度

