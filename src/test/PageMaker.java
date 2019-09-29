package test;

public class PageMaker {

	private int postPerPage = 10; // �������� �Խù���
	private int pagePerBlock = 10; // ���� ��������
	private int currentPage; // ���� ������
	private int totalPage; // ��ü ��������
	private int pageStart; // ������ �Խñ� ���� ��
	private int pageEnd; // ������ �Խñ� �� ��
	private int totalBlock; // ��ü ��ϼ�
	private int currentBlock; // ���� �������� �ִ� ���
	private int blockStart; // ������ ������ ���� ��
	private int blockEnd; // ������ ������ �� ��
	private int prevPage; // ���� �� ������ �� �� 
	private int nextPage; // ���� �� ������ ù ��

	// ��ü �� ��, ���� ������ ��ȣ
	public PageMaker(int count, int currentPage) {
		this.currentPage = currentPage;
		// �Ǽ����� �������� ��ü�ۼ��� 1.0�� ���ϰ� �������� �󸶸� �������� ���Ѵ��� ��ü���������� ���Ѵ�.
		// (�ø����� �ؾ� ��α� ���������� ����)
		totalPage = (int) Math.ceil(count * 1.0 / postPerPage);
		// ���� ���������� ������ �Խñ��� ���� ��ȣ�� ����ȣ�� ���Ѵ�.
		pageStart = (currentPage - 1) * postPerPage + 1;
		pageEnd = pageStart + (postPerPage - 1);
		// �Ǽ����� �������� ��ü���������� 1.0�� ���ϰ� ���� �󸶸� �������� ���Ѵ��� ��ü������ ���Ѵ�.
		// (�ø����� �ؾ� ��α� ������ ����)
		totalBlock = (int) Math.ceil(totalPage * 1.0 / pagePerBlock);
		// ������������ ���° ��Ͽ� ���ϴ��� ���Ѵ�.
		currentBlock = (currentPage - 1) / pagePerBlock + 1;
		// ������������ ���� ���� ���� ���Ѵ�.
		blockStart = (currentBlock - 1) * pagePerBlock + 1;
		// ���� �������� ���� �� ���� ���Ѵ�.
		blockEnd = blockStart + (pagePerBlock - 1);
		// ������ ���� �� ���� ������ �������� ��ü ���� ���Ͽ� ������ �� ������ ���Ѵ�.
		if (blockEnd > totalPage) {
			blockEnd = totalPage;
		}
		// [����] 11 12 13 14 15 16 17 18 19 20 [����]
		// [����]�� �������� �̵��� ������ �� ���Ѵ�.
		if (currentBlock == 1) {
			prevPage = 1; //�� �κ��� ���� ���� 1�� ���� �ȳ�Ÿ���Ƿ� �����δ� ���� �ڵ��Դϴ�.
		} else {
			prevPage = (currentBlock - 1) * pagePerBlock;
		}
		// [����]�� ������ �� �̵��� �������� ���Ѵ�.
		if (currentBlock == totalBlock) {
			nextPage = totalPage; //�� �κ��� ���� ���� �������� ���� �ȳ�Ÿ���Ƿ� �����δ� ���� �ڵ��Դϴ�.
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
