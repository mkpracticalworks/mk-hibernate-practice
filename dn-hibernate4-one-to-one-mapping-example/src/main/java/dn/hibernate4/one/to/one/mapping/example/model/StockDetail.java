package dn.hibernate4.one.to.one.mapping.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author Muthukumar Thangavinayagam
 *
 */

@Entity
@Table(name = "stock_detail", catalog = "dn_hib4db")
public class StockDetail {

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "stock"))
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	private Integer stockId;

	@OneToOne(fetch = FetchType.LAZY)
	private Stock stock;

	@Column(name = "COMP_NAME", nullable = false, length = 100)
	private String compName;

	@Column(name = "COMP_DESC", nullable = false)
	private String compDesc;

	@Column(name = "REMARK", nullable = false)
	private String remark;

	@Temporal(TemporalType.DATE)
	@Column(name = "LISTED_DATE", nullable = false, length = 10)
	private Date listedDate;

	public StockDetail() {
	}

	public StockDetail(Stock stock, String compName, String compDesc, String remark, Date listedDate) {
		this.stock = stock;
		this.compName = compName;
		this.compDesc = compDesc;
		this.remark = remark;
		this.listedDate = listedDate;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompDesc() {
		return compDesc;
	}

	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getListedDate() {
		return listedDate;
	}

	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}

}
