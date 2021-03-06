package com.kh.finalProject.board.model.vo;

public class PageInfo implements java.io.Serializable{
	private int currentPage;
	private int listCount;
	private int limit;
	private int maxPage;
	private int startPage;
	private int endPage;
	private boolean searchflag;
	private boolean monthflag;
	
	public PageInfo() {}

	public PageInfo(int currentPage, int listCount, int limit, int maxPage, int startPage, int endPage,
			boolean searchflag, boolean monthflag) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.searchflag = searchflag;
		this.monthflag = monthflag;
	}
	
	

	public PageInfo(int currentPage, int listCount, int limit, int maxPage, int startPage, int endPage,
			boolean searchflag) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.searchflag = searchflag;
	}

	
	public PageInfo(int currentPage, int listCount, int limit, int maxPage, int startPage, int endPage) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isSearchflag() {
		return searchflag;
	}

	public void setSearchflag(boolean searchflag) {
		this.searchflag = searchflag;
	}

	public boolean isMonthflag() {
		return monthflag;
	}

	public void setMonthflag(boolean monthflag) {
		this.monthflag = monthflag;
	}

	@Override
	public String toString() {
		return "PageInfo [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit + ", maxPage="
				+ maxPage + ", startPage=" + startPage + ", endPage=" + endPage + ", searchflag=" + searchflag
				+ ", monthflag=" + monthflag + "]";
	}
	
	

	
}
