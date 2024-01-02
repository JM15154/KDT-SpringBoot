package com.example.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.DeptDTO;

@Repository
public class DeptDAO {

	
	@Autowired
	SqlSessionTemplate session;  // 이전 mybatis의 Sqlsession과 동일
	
	public List<DeptDTO> findAll() {
		return session.selectList("com.config.DeptMapper.findAll");
	}
	
	public int save(DeptDTO dto) throws Exception {
		return session.insert("com.config.DeptMapper.save", dto);
	}
	
	public int update(DeptDTO dto) {
		return session.insert("com.config.DeptMapper.update", dto);
	}
	
	public int remove(int deptno) {
		return session.insert("com.config.DeptMapper.remove", deptno);
	}
}
