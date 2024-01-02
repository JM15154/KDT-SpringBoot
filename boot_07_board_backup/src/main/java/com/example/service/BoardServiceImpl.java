package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BoardDAO;
import com.example.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	
	BoardDAO dao;
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<BoardDTO> findAll() {
		
		return dao.findAll();
	}

	
	@Transactional
	@Override
	public int write(BoardDTO dto) {
		// TODO Auto-generated method stub
		return dao.write(dto);
	}

	
	@Override
	public BoardDTO retrieve(int x) {
		int n = dao.readcnt(x);
		return dao.retrieve(x);
	}

	@Override
	public int update(BoardDTO dto) {
	
		return dao.update(dto);
	}

	@Override
	public int delete(int num) {
		// TODO Auto-generated method stub
		return dao.delete(num);
	}


}
