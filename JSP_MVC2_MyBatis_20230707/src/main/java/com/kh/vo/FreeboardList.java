package com.kh.vo;

import java.util.ArrayList;
import java.util.List;

// 한 페이지 분량의 메인 글 목록과 페이징 작업에 사용할 8개의 변수를 기억하는 클래스
public class FreeboardList {
  List<FreeboardVO> list = new ArrayList<>();

  private int pageSize = 10;
  private int totalCount = 0;
  private int totalPage = 0;
  private int currentPage = 1;
  private int startNo = 0;
  private int endNo = 0;
  private int startPage = 0;
  private int endPage = 0;

  public FreeboardList() {}

  public FreeboardList(List<FreeboardVO> list, int pageSize, int currentPage) {
    this.list = list;
    this.pageSize = pageSize;
    this.currentPage = currentPage;
    this.calculate();
  }

  public void calculate() {
    this.totalCount = this.list.size();
    this.totalPage =
        this.totalCount / this.pageSize + (this.totalCount % this.pageSize > 0 ? 1 : 0);
    this.startPage = (this.currentPage - 1) / this.pageSize * this.pageSize + 1;
    this.endPage = this.startPage + this.pageSize - 1;
    this.endPage = this.endPage > this.totalPage ? this.totalPage : this.endPage;
    this.currentPage = this.currentPage > this.totalPage ? this.totalPage : this.currentPage;
    this.startNo = (this.currentPage - 1) / this.pageSize;
    this.endNo = this.startNo + this.pageSize - 1;

    if (this.endNo > this.totalCount) {
      this.endNo = this.totalCount;
    }
  }

  public List<FreeboardVO> getList() {
    return list;
  }

  public void setList(List<FreeboardVO> list) {
    this.list = list;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    this.calculate();
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
    this.calculate();
  }

  public int getTotalPage() {
    return totalPage;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
    this.calculate();
  }

  public int getStartNo() {
    return startNo;
  }

  public int getEndNo() {
    return endNo;
  }

  public int getStartPage() {
    return startPage;
  }

  public int getEndPage() {
    return endPage;
  }

  @Override
  public String toString() {
    return "FreeboardList {\"list\": \"" + list + "\", \"pageSize\": \"" + pageSize
        + "\", \"totalCount\": \"" + totalCount + "\", \"totalPage\": \"" + totalPage
        + "\", \"currentPage\": \"" + currentPage + "\", \"startNo\": \"" + startNo
        + "\", \"endNo\": \"" + endNo + "\", \"startPage\": \"" + startPage + "\", \"endPage\": \""
        + endPage + "\"}";
  }
}
