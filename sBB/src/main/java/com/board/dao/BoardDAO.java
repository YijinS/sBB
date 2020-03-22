package com.board.dao;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardDAO {
	public List<BoardVO> list() throws Exception; //목록
	public void write(BoardVO vo) throws Exception; //작성
	public BoardVO view(int bno) throws Exception; //조회
	public void modify(BoardVO vo) throws Exception; // 수정
	public void delete(int bno) throws Exception; //삭제
	
	public int count() throws Exception; // 게시물 종 갯수
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception; //게시물 목록 + 페이징
}
