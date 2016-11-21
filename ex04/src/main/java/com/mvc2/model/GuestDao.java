package com.mvc2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mvc2.core.SqlTemplate;

public class GuestDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String driver = "oracle.jdbc.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "scott";
	private final String password = "tiger";
	
	Logger logger = Logger.getLogger(this.getClass());


	
	public GuestDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public List<GuestVo> selectAll() {
		String sql = "select * from guest";

		List<GuestVo> list = new ArrayList<GuestVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new GuestVo(rs.getInt("sabun"),rs.getString("name"),rs.getDate("nalja"),rs.getInt("pay")));
			}
		} catch (SQLException e) {
			logger.error("selectAll메소드에서 오류");
		} finally{
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					logger.error("close() 오류");
				}
		}
		
		return list;
	}

	public GuestVo selectOne(int sabun) {
		
		String sql = "select * from guest where sabun=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return new GuestVo(rs.getInt("sabun"),rs.getString("name"),rs.getDate("nalja"),rs.getInt("pay"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public void insertOne(GuestVo vo) {
		new SqlTemplate().executeUpdate("insert into guest values (?,?,sysdate,?)"
				,new Object[]{vo.getSabun(),vo.getName(),vo.getPay()});
	}

	public void updateOne(GuestVo vo) {

		String sql = "update guest set name=?, pay=? where sabun=?";
		Object[] obj = {vo.getName(),vo.getPay(),vo.getSabun()};
		new SqlTemplate().executeUpdate(sql,obj);
	}
	
	public void deleteOne(int sabun) {
		new SqlTemplate().executeUpdate("delete from guest where sabun=?"
				, new Object[]{sabun});
	}
}
