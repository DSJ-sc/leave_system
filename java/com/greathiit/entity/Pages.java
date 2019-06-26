package com.greathiit.entity;

public class Pages {
 private Integer pageNum;
 private Integer pageSize;
 private Integer pages;
 
public Integer getPages() {
	return pages;
}
public void setPages(Integer pages) {
	this.pages = pages;
}
public Integer getPageNum() {
	return pageNum;
}
public void setPageNum(Integer pageNum) {
	this.pageNum = pageNum;
}
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
@Override
public String toString() {
	return "Pages [pageNum=" + pageNum + ", pageSize=" + pageSize + ", pages=" + pages + "]";
}

}
