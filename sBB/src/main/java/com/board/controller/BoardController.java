package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService service;
	
	//게시물 작성
	@RequestMapping(value="/write", method= RequestMethod.GET)
	public void getWrite() throws Exception{
		
	}
	
	@RequestMapping(value="/write", method= RequestMethod.POST)
	public String postWrite(BoardVO vo) throws Exception{
		
		service.write(vo);
		
		return "redirect:/board/list";
	}
	
	//게시물 출력
	@RequestMapping(value="/list", method=RequestMethod.GET)
	private void getList(Model model) throws Exception { //model은 컨트롤러와 뷰를 연결
		// TODO Auto-generated method stub
		List<BoardVO> list = null;
		list = service.list();
		
		model.addAttribute("list", list);

	}
	
	//게시물 조회
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception{
		
		BoardVO vo = service.view(bno);
		
		model.addAttribute("view", vo);
	}
	
	//게시물 수정
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception{
		BoardVO vo = service.view(bno);
		
		model.addAttribute("view", vo);
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String getModify(BoardVO vo) throws Exception{
		service.modify(vo);
		
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	//게시물 삭제
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno) throws Exception {
		service.delete(bno);
		
		return "redirect:/board/list";
	}
	
	//게시물 목록 + 페이징 추가
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	private void getListPage(Model model, @RequestParam("num") int num) throws Exception { //model은 컨트롤러와 뷰를 연결
		// TODO Auto-generated method stub
		
		int count = service.count(); //게시물 총 갯수
		
		int postNum = 10; //한 페이지에 출력할 게시물 갯수
		
		int pageNum = (int)Math.ceil((double)count/postNum); //하단 페이징 번호(총 개시물 갯수 / 한 페이지에 출력할 개수의 올림)
		
		int displayPost = (num - 1) * postNum; //출력할 게시물
		
		int pageNum_cnt = 10; //한번에 표시할 페이징 번호의 갯수
		int endPageNum = (int)(Math.ceil((double)num/(double)pageNum_cnt) * pageNum_cnt); //표시되는 페이지 번호 중 마지막
		
		int startPageNum = endPageNum - (pageNum_cnt - 1); //표시되는 페이지 번호 중 첫번째
		
		int endPageNum_tmp = (int)(Math.ceil((double)count/(double)pageNum_cnt));//마지막 번호 재계산
		 if(endPageNum_tmp> endPageNum_tmp) {
			 endPageNum = endPageNum_tmp;
		 }
		 
		 boolean prev = startPageNum == 1? false : true;
		 boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		 
		 //시작 및 끝 번호
		 model.addAttribute("startPageNum", startPageNum);
		 model.addAttribute("endPageNum", endPageNum);
		 
		 //이전 및 다음
		 model.addAttribute("prev", prev);
		 model.addAttribute("next", next);
		 
		 //현재 페이지
		 model.addAttribute("select", num);
		
		
		List<BoardVO> list = null;
		list = service.listPage(displayPost, postNum);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);

	}
	
}
