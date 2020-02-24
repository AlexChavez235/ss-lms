package com.ss.lms.librarian.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_publisher")
public class Publisher implements Serializable{

    
	/**
	 * 
	 */
	private static final long serialVersionUID = -4501732281154032227L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="publisherid")
	private Integer publisherId;
	@Column(name="publishername")
    private String publisherName;
	@Column(name="publisheraddress")
    private String publisherAddress;
	@Column(name="publisherphone")
    private String publisherPhone;

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public String getPublisherPhone() {
        return publisherPhone;
    }

    public void setPublisherPhone(String publisherPhone) {
        this.publisherPhone = publisherPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return getPublisherId().equals(publisher.getPublisherId()) &&
                getPublisherName().equals(publisher.getPublisherName()) &&
                Objects.equals(getPublisherAddress(), publisher.getPublisherAddress()) &&
                Objects.equals(getPublisherPhone(), publisher.getPublisherPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublisherId(), getPublisherName(), getPublisherAddress(), getPublisherPhone());
    }
}
