package com.example.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.BoardDTO;
import com.example.dto.PageDTO;

@Repository				
public class BoardDAO {

	@Autowired
	SqlSessionTemplate session;
	
//	public List<BoardDTO> findAll () {
//		
//		return session.selectList("com.config.BoardMapper.findAll");
//	}
	public int totalCount() {
		return session.selectOne("com.config.BoardMapper.totalCount");
	}
	
	
	public PageDTO findAll (int curPage) {
		
		PageDTO pageDTO = new PageDTO();
		
		int perPage = pageDTO.getPerPage();
		// 시작위치
		int offset = (curPage-1) * 3;
		
		List<BoardDTO> list = session.selectList("com.config.BoardMapper.findAll", null , new RowBounds(offset, perPage));
		
		int totalCount = totalCount();
		
		pageDTO.setList(list);
		pageDTO.setCurPage(curPage);
		pageDTO.setTotalCount(totalCount);
		
		return pageDTO;
	}
	
	public int write(BoardDTO dto) {
		
		return session.insert("com.config.BoardMapper.write", dto);
	}
	
	public BoardDTO retrieve(int x) {
		
		HashMap<String, Object> map = 
				session.selectOne("com.config.BoardMapper.retrieve",x);
		
		// HashMap --> DTO
		int num = (Integer)map.get("num");
		String title = (String)map.get("title");
		String author = (String)map.get("author");
		String content = (String)map.get("content");
		
		// 컬럼 writeday Date ------------> String
		Date yyy = (Date)map.get("writeday");
		// java.sql.Date ==> String
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String writeday = sdf.format(yyy);
		int readcnt = (Integer)map.get("readcnt");
		
		
		// DTO 생성방법
		// 1. 생성자 이용
		/*
		   단점 여러 오버로딩 생성자가 필요
		         인자값에 대한 의미전달이 어렵다.
		         필수항목에 대한 인지가 어렵다.
		  
		 */
		BoardDTO dto3 = 
				new BoardDTO(num, title, author, content, writeday, readcnt);

	
		
		//2. set메서드
		/*
		 * 생성자보다 인자의 의미파악이 쉬워졌다.
		 * 1회 호출해서는 생성완료가 안된다.
		 * 필수항목에 대한 인지가 어렵다.
		 */
		BoardDTO dto2 = new BoardDTO();
		dto2.setNum(num);
		dto2.setTitle(title);
		dto2.setAuthor(author);
		dto2.setContent(content);
		dto2.setWriteday(writeday);
		dto2.setReadcnt(readcnt);
		
		//3. 빌더 패턴 ==> lombok이 제공해줌 @Builder
		/*
		 * 인자의 의미파악이 확실.
		 * 한번 호출로 객체 생성 가능
		 * 현업에서 주로 사용됨
		 * 
		 * */
		BoardDTO dto = BoardDTO.builder()
				.num(num)
				.title(title)
				.author(author)
				.content(content)
				.writeday(writeday)
				.readcnt(readcnt)
				.build();
		
		System.out.println(dto);
		return dto;
	}
	
	public int readcnt (int num) {
		return session.update("com.config.BoardMapper.readcnt",num);
	}
	
	public int update (BoardDTO dto) {
		return session.update("com.config.BoardMapper.update",dto);
	}
	
	public int delete (int num) {
		return session.delete("com.config.BoardMapper.delete",num);
	}
	
}
