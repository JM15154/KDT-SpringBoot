package com.example.service;

import java.util.List;

import com.example.dto.*;
import com.example.exception.DuplicatedDeptnoException;

public interface DeptService {
	public List<DeptDTO> findAll();
	public int save(DeptDTO dto) throws DuplicatedDeptnoException;
	public int update(DeptDTO dto);
	public int remove(int deptno);
}
