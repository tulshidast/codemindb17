package javapractices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsClass {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10, 20, 30, 3, 4, 29, 400);

		list.forEach(e -> System.out.println(e));

		System.out.println("####################################");

		Collections.sort(list);

		list.forEach(e -> System.out.println(e));

		System.out.println("####################################");

		Collections.reverse(list);

		list.forEach(e -> System.out.println(e));

		System.out.println("####################################");

		System.out.println(Collections.min(list));

		System.out.println(Collections.max(list));

	}

}
