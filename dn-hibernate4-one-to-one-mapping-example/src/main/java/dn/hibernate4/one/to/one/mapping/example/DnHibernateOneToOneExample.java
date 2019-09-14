package dn.hibernate4.one.to.one.mapping.example;

import java.util.Date;

import org.hibernate.Session;

/**
 * @author Muthukumar Thangavinayagam
 *
 */

import dn.hibernate4.one.to.one.mapping.example.model.Stock;
import dn.hibernate4.one.to.one.mapping.example.model.StockDetail;
import dn.hibernate4.one.to.one.mapping.example.util.HibernateUtil;

public class DnHibernateOneToOneExample {
	public static void main(String[] args) {

		System.out.println("DevNotes Hibernate one to one (Annotation)");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockCode("Stock Code1");
		stock.setStockName("Example Stock One");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("Stock One Company Name");
		stockDetail.setCompDesc("Stock One Comp Desc");
		stockDetail.setRemark("Stock One Remark");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

		System.out.println(" Stock Detail inserted into DB ");
	}
}
