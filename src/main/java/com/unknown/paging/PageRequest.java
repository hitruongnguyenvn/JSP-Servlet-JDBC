package com.unknown.paging;

import com.unknown.sort.Sort;

public class PageRequest implements Pageble {

	private Integer page;
	private Integer maxPageItem;
	private Sort sort;

	public PageRequest() {
		super();
	}

	public PageRequest(Integer page, Integer maxPageItem, Sort sort) {
		super();
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sort = sort;
	}

	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getFetchNextRows() {
		return this.maxPageItem;
	}

	@Override
	public Integer getOffset() {
		if(this.getPage() != null) {
			return (this.getPage() - 1) * this.getFetchNextRows();
		}
		return null;
	}

	@Override
	public Sort getSort() {
		return this.sort;
	}

}
