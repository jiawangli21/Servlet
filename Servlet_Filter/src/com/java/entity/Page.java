package com.java.entity;

public class Page {

	private int page=1;
	private int maxPage;
	private int maxNumber=3;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	public int getMaxPage(int count){
		if(count%maxNumber==0){
			return count/maxNumber;
		}else{
			return count/maxNumber+1;
		}
	}
	public int CountPage(Page p){
		if(p.getPage() <= 0){
			page = 1;
		}else if(p.getMaxPage()<p.getPage()){
			page = p.getMaxPage();
		}else{
			page = p.getPage();
		}
        return page;
	}
	@Override
	public String toString() {
		return "Page [page=" + page + ", maxPage=" + maxPage + ", maxNumber="
				+ maxNumber + "]";
	}
	
}
