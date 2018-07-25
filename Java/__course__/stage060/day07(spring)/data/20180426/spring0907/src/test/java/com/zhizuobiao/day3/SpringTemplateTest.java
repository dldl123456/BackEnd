package com.zhizuobiao.day3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhizuobiao.day3.entity.Account;

/**
 * springtemplate使用
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class SpringTemplateTest {

	@Autowired
	private JdbcTemplate template;

	@Test
	public void demo1() {
		String sql = "select * from account";
		// rowMapper -- 行映射
		List<Account> list = template.query(sql, new RowMapper<Account>() {

			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {

				// 映射一行数据 -- Account对象的 关系
				Account account = new Account();
				account.setAmount(rs.getDouble("amount"));
				account.setId(rs.getInt("id"));
				account.setName(rs.getString("name"));

				return account;
			}

		});

		System.out.println(list);
	}

	@Test
	public void demo2() {
		String sql = "select * from account where id = ?";

		int id = 6;

		Account account = template.query(sql, new Object[] { id }, new ResultSetExtractor<Account>() {

			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {

				// 防止查询结果为null，导致下面的映射代码，出空指针。
				// 所以需要判断是否有查询结果
				Account account = null;
				if (rs.next()) {
					// 映射一行数据 -- Account对象的 关系
					account = new Account();
					account.setAmount(rs.getDouble("amount"));
					account.setId(rs.getInt("id"));
					account.setName(rs.getString("name"));

				}
				return account;
			}

		});

		System.out.println(account);
	}
}
