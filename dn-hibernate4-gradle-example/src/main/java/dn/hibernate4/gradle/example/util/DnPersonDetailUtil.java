package dn.hibernate4.gradle.example.util;

import dn.hibernate4.gradle.example.model.DnPersonDetail;

/**
 * @author Muthukumar Thangavinayagam
 *
 */
public final class DnPersonDetailUtil {
	
	public static DnPersonDetail[] arrayOfPersons = {

			new DnPersonDetail("person1", 53, "person1@domain.com", "111111", "India"),
			new DnPersonDetail("person2", 63, "person2@domain.com", "22222", "India"),
			new DnPersonDetail("person3", 33, "person3@domain.com", "33333", "India"),
			new DnPersonDetail("Muthukumar", 37, "mk@domain.com", "44444", "India")

	};
}
