package com.board.dao;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardDAO {
	public List<BoardVO> list() throws Exception; //목록
	public void write(BoardVO vo) throws Exception; //작성
}
