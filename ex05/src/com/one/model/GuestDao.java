package com.one.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.sql.RowMapper;
import com.hb.sql.SqlTemplate;

public class GuestDao {
	
	public GuestDao() {
		
	}
	
	public List<GuestVo>listAll(){
		
		RowMapper mapper = new RowMapper() {
			
			@Override
			public List rowMapper(ResultSet rs) throws SQLException {
				List<GuestVo> list = new ArrayList<GuestVo>();
				
				while(rs.next()){
					GuestVo bean = new GuestVo(rs.getInt("sabun")
							,rs.getString("name"),rs.getDate("nalja")
							,rs.getInt("pay"));
					list.add(bean);
				}
				
				return list;
			}
		};
		
		
		return new SqlTemplate().executeList("select * from guest",mapper);
	}
	
}
