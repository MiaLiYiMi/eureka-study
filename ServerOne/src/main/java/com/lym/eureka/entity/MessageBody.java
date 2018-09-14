package com.lym.eureka.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class MessageBody {
	private String HttpUserId;
	private String HttpOtherJnlNo;
	private String HttpReqTime;
	private String AcNo;
	private String SubAcNo;
	private String Currency;
	private String BeginDate;
	private String EndDate;
	private String QryDir;
	private String QHTranstype;
	private String pageSize;
	private String currentIndex;
	private String recordNumber;
	
	@XmlElement(name="HttpUserId")
	public String getHttpUserId() {
		return HttpUserId;
	}
	public void setHttpUserId(String httpUserId) {
		HttpUserId = httpUserId;
	}
	@XmlElement(name="HttpOtherJnlNo")
	public String getHttpOtherJnlNo() {
		return HttpOtherJnlNo;
	}
	public void setHttpOtherJnlNo(String httpOtherJnlNo) {
		HttpOtherJnlNo = httpOtherJnlNo;
	}
	@XmlElement(name="HttpReqTime")
	public String getHttpReqTime() {
		return HttpReqTime;
	}
	public void setHttpReqTime(String httpReqTime) {
		HttpReqTime = httpReqTime;
	}
	@XmlElement(name="AcNo")
	public String getAcNo() {
		return AcNo;
	}
	public void setAcNo(String acNo) {
		AcNo = acNo;
	}
	@XmlElement(name="SubAcNo")
	public String getSubAcNo() {
		return SubAcNo;
	}
	public void setSubAcNo(String subAcNo) {
		SubAcNo = subAcNo;
	}
	@XmlElement(name="Currency")
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	@XmlElement(name="BeginDate")
	public String getBeginDate() {
		return BeginDate;
	}
	public void setBeginDate(String beginDate) {
		BeginDate = beginDate;
	}
	@XmlElement(name="EndDate")
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	@XmlElement(name="QryDir")
	public String getQryDir() {
		return QryDir;
	}
	public void setQryDir(String qryDir) {
		QryDir = qryDir;
	}
	@XmlElement(name="QHTranstype")
	public String getQHTranstype() {
		return QHTranstype;
	}
	public void setQHTranstype(String qHTranstype) {
		QHTranstype = qHTranstype;
	}
	@XmlElement(name="pageSize")
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	@XmlElement(name="currentIndex")
	public String getCurrentIndex() {
		return currentIndex;
	}
	public void setCurrentIndex(String currentIndex) {
		this.currentIndex = currentIndex;
	}
	@XmlElement(name="recordNumber")
	public String getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	@Override
	public String toString() {
		return "MessageBody [HttpUserId=" + HttpUserId + ", HttpOtherJnlNo=" + HttpOtherJnlNo + ", HttpReqTime="
				+ HttpReqTime + ", AcNo=" + AcNo + ", SubAcNo=" + SubAcNo + ", Currency=" + Currency + ", BeginDate="
				+ BeginDate + ", EndDate=" + EndDate + ", QryDir=" + QryDir + ", QHTranstype=" + QHTranstype
				+ ", pageSize=" + pageSize + ", currentIndex=" + currentIndex + ", recordNumber=" + recordNumber + "]";
	}



	
}
