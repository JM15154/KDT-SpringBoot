package com.example.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("BoardDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {
	int num;
	String title;
	String author;
	String content;
	String writeday;
	int readcnt;

}
