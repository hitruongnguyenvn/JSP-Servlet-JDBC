package com.unknown.model;

import java.sql.Timestamp;
import java.util.List;

public abstract class AbstractModel<T> {
	protected Integer id;
	protected Timestamp createdDate;
	protected Timestamp modifiedDate;
	protected Timestamp createdBy;
	protected Timestamp modifiedBy;
	protected int ids[];
	protected List<T> models;
	protected int page;
	protected int maxPageItem;
	protected int totalPage;
	protected String sortName;
	protected String sortBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Timestamp getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Timestamp createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Timestamp modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public List<T> getModels() {
		return models;
	}

	public void setModels(List<T> models) {
		this.models = models;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxPageItem() {
		return maxPageItem;
	}

	public void setMaxPageItem(int maxPageItem) {
		this.maxPageItem = maxPageItem;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public AbstractModel() {
		super();
	}

	public AbstractModel(int id, Timestamp createdDate, Timestamp modifiedDate, Timestamp createdBy,
			Timestamp modifiedBy) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}

}
