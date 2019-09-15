package dn.hibernate4.many.to.many.example;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import dn.hibernate4.many.to.many.example.model.Category;
import dn.hibernate4.many.to.many.example.model.Stock;
import dn.hibernate4.many.to.many.example.util.HibernateUtil;

public class DnHibernate4ManyToManyExample {
	public static void main(String[] args) {
		System.out.println("DevNotes Hibernate4 many to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockCode("Stock Code 1");
		stock.setStockName("Sample Stock Name One");

		Category category1 = new Category("Category One", "Cat_One Desc");
		Category category2 = new Category("Category Two", "Cat_Two Desc");
		Category category3 = new Category("Category Three", "Cat_Tree Desc");

		Set<Category> categories = new HashSet<Category>();
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		stock.setCategories(categories);

		session.save(stock);
		
		session.getTransaction().commit();
		
		System.out.println("Stock and Category Record inserted successfully");

	}
}
