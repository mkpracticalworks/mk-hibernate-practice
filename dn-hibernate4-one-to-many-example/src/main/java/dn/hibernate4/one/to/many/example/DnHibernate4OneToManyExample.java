package dn.hibernate4.one.to.many.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;

import dn.hibernate4.one.to.many.example.model.Stock;
import dn.hibernate4.one.to.many.example.model.StockDailyRecord;
import dn.hibernate4.one.to.many.example.util.HibernateUtil;

/**
 * @author Muthukumar Thangavinayagam
 *
 */
public class DnHibernate4OneToManyExample {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockCode("Stock Code 1");
		stock.setStockName("Sample Stock Name One");
		session.save(stock);

		StockDailyRecord stockDailyRecordOne = new StockDailyRecord();
		stockDailyRecordOne.setPriceOpen(new Float("1.2"));
		stockDailyRecordOne.setPriceClose(new Float("1.1"));
		stockDailyRecordOne.setPriceChange(new Float("10.0"));
		stockDailyRecordOne.setVolume(3000000L);
		stockDailyRecordOne.setDate(new Date());

		stockDailyRecordOne.setStock(stock);
		stock.getStockDailyRecords().add(stockDailyRecordOne);
		session.save(stockDailyRecordOne);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7);  
		String newDate = sdf.format(cal.getTime());  
		
		StockDailyRecord stockDailyRecordTwo = new StockDailyRecord();
		stockDailyRecordTwo.setPriceOpen(new Float("2.2"));
		stockDailyRecordTwo.setPriceClose(new Float("2.1"));
		stockDailyRecordTwo.setPriceChange(new Float("20.0"));
		stockDailyRecordTwo.setVolume(4000000L);
		stockDailyRecordTwo.setDate(cal.getTime());

		stockDailyRecordTwo.setStock(stock);
		stock.getStockDailyRecords().add(stockDailyRecordTwo);
		session.save(stockDailyRecordTwo);

		session.getTransaction().commit();
		System.out.println("Stock and StockDaily Record inserted successfully");
	}
}
