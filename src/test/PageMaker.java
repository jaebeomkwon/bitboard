package test;

public class PageMaker {

	private int postPerPage = 10; // 페이지당 게시물수
	private int pagePerBlock = 10; // 블럭당 페이지수
	private int currentPage; // 현재 페이지
	private int totalPage; // 전체 페이지수
	private int pageStart; // 보여줄 게시글 시작 수
	private int pageEnd; // 보여줄 게시글 끝 수
	private int totalBlock; // 전체 블록수
	private int currentBlock; // 현재 페이지가 있는 블록
	private int blockStart; // 블럭에서 페이지 시작 수
	private int blockEnd; // 블럭에서 페이지 끝 수
	private int prevPage; // 이전 블럭 페이지 끝 수 
	private int nextPage; // 다음 블럭 페이지 첫 수

	// 전체 글 수, 현재 페이지 번호
	public PageMaker(int count, int currentPage) {
		this.currentPage = currentPage;
		// 실수값을 내기위해 전체글수에 1.0을 곱하고 페이지당 얼마를 보여줄지 정한다음 전체페이지수를 구한다.
		// (올림으로 해야 깍두기 페이지까지 계산됨)
		totalPage = (int) Math.ceil(count * 1.0 / postPerPage);
		// 현재 페이지에서 보여줄 게시글의 시작 번호랑 끝번호를 구한다.
		pageStart = (currentPage - 1) * postPerPage + 1;
		pageEnd = pageStart + (postPerPage - 1);
		// 실수값을 내기위해 전체페이지수에 1.0을 곱하고 블럭당 얼마를 보여줄지 정한다음 전체블럭수를 구한다.
		// (올림으로 해야 깍두기 블럭까지 계산됨)
		totalBlock = (int) Math.ceil(totalPage * 1.0 / pagePerBlock);
		// 현재페이지가 몇번째 블록에 속하는지 구한다.
		currentBlock = (currentPage - 1) / pagePerBlock + 1;
		// 현재페이지의 블럭의 시작 수를 구한다.
		blockStart = (currentBlock - 1) * pagePerBlock + 1;
		// 현재 페이지의 블럭의 끝 수를 구한다.
		blockEnd = blockStart + (pagePerBlock - 1);
		// 마지막 블럭일 때 블럭의 끝수를 페이지의 전체 수와 비교하여 마지막 블럭 끝수를 구한다.
		if (blockEnd > totalPage) {
			blockEnd = totalPage;
		}
		// [이전] 11 12 13 14 15 16 17 18 19 20 [다음]
		// [이전]을 눌렀을때 이동할 페이지 를 정한다.
		if (currentBlock == 1) {
			prevPage = 1; //이 부분은 현재 블럭이 1일 때는 안나타나므로 실제로는 죽은 코드입니다.
		} else {
			prevPage = (currentBlock - 1) * pagePerBlock;
		}
		// [다음]을 눌렀을 때 이동할 페이지를 정한다.
		if (currentBlock == totalBlock) {
			nextPage = totalPage; //이 부분은 현재 블럭이 마지막일 때는 안나타나므로 실제로는 죽은 코드입니다.
		} else {
			nextPage = currentBlock * pagePerBlock + 1;
		}
	}

	public int getPostPerPage() {
		return postPerPage;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public int getPageStart() {
		return pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public int getBlockStart() {
		return blockStart;
	}

	public int getBlockEnd() {
		return blockEnd;
	}
}
