package com.board.service;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> list() throws Exception;
	public void write(BoardVO vo) throws Exception;
	public BoardVO view(int bno) throws Exception; //조회
	public void modify(BoardVO vo) throws Exception; //수정
	public void delete(int bno) throws Exception; //삭제
	public int count() throws Exception; //총 갯수
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception;
}
