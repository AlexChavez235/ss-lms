package com.smoothstack.lms.administrator.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_book_copies")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Copies implements Serializable {

	private static final long serialVersionUID = -6189964190586714218L;

	@EmbeddedId
	private CopiesIdentity copiesIdentity;
	
	@Column(name = "noofcopies")
	private Integer noOfCopies;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="bookid", insertable = false, updatable = false)
	@JsonIgnoreProperties("loans")
	private Book book;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="branchid", insertable = false, updatable = false)
	@JsonIgnoreProperties("copies")
	private Branch branch;

	public void setCopiesIdentity(CopiesIdentity copiesIdentity) {
		this.copiesIdentity = copiesIdentity;
	}
	public Integer getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((copiesIdentity == null) ? 0 : copiesIdentity.hashCode());
		result = prime * result + ((noOfCopies == null) ? 0 : noOfCopies.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Copies other = (Copies) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (copiesIdentity == null) {
			if (other.copiesIdentity != null)
				return false;
		} else if (!copiesIdentity.equals(other.copiesIdentity))
			return false;
		if (noOfCopies == null) {
			if (other.noOfCopies != null)
				return false;
		} else if (!noOfCopies.equals(other.noOfCopies))
			return false;
		return true;
	}

}