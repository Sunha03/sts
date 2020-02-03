package multi.erp.board;

import java.util.List;

public interface BoardService {
	List<BoardVO> boardList(String category);	//게시글 조회 - 전체 및 카테고리별 조회 작업
	int txinsert(BoardVO board);
	int insert(BoardVO board);		//게시글 등록
	List<BoardVO> searchList(String search);
	List<BoardVO> searchList(String tag,String search);
	List<BoardVO> pageList();
	BoardVO read(String board_no);
	int update(BoardVO board);
	int delete(String board_no);
	
	
	List<BoardVO> findByCategory(String category);
	
}









