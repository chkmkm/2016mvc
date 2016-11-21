package com.mvc2.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.junit.Test;

public class GuestDaoTest {
	
	private final String driver = "oracle.jdbc.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "scott";
	private final String password = "tiger";

	@Test
	public void testSelectAll() {
		GuestDao dao = new GuestDao();
		List<GuestVo> list = dao.selectAll();
		assertNotNull(list);
		assertTrue(list.size()>0);
		
		for(GuestVo vo:list){
			System.out.println(vo);
		}
		
	}
	
	@Test
	public void testSelectOne(){
		
		int sabun = 1111;
		
		GuestDao dao = new GuestDao();
		GuestVo vo = dao.selectOne(sabun);
		assertNotNull(vo);
		assertEquals(sabun, vo.getSabun());
		
		GuestVo bean = new GuestVo(sabun, "aaaa", null, 1000);
		
		assertEquals(bean, vo);
		
	}
	
	@Test
	public void testInsertOne() throws Exception{

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		conn.setAutoCommit(false);
		
		GuestDao dao = new GuestDao();
		dao.setConn(conn);
		GuestVo vo =new GuestVo(4444, "dddd", null, 4000);
		
		dao.insertOne(vo);
		
	}
	
	@Test
	public void testUpdateOne() throws Exception{
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		conn.setAutoCommit(false);
		
		GuestDao dao = new GuestDao();
		dao.setConn(conn);
		GuestVo vo =new GuestVo(1111, "aaaa", null, 1000);
		
		dao.updateOne(vo);
		dao = new GuestDao();
		
		assertEquals(vo, dao.selectOne(1111));
		
	}

}
