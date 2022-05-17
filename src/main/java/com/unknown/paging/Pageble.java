package com.unknown.paging;

import com.unknown.sort.Sort;

public interface Pageble {
	public Integer getPage();
	public Integer getFetchNextRows();
	public Integer getOffset();
	public Sort getSort();
}
