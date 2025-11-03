package javapractices;

public class ArraySorting {

	public static void main(String[] args) {
		
		// create an array
		// aaray sorting logic

		int array[] = { 10, 20, 4, 3, 100, 40, 50 };

		for (int i = 0; i < array.length; i++) {
			
			for (int j = i + 1; j < array.length; j++) {

				if (array[i] > array[j]) {

					int a = array[i];

					array[i] = array[j];

					array[j] = a;

				}

			}
		}

		for (int a : array) {
			System.out.println(a);
		}

		System.out.println("#############################################");
		System.out.println("Largest element from array = " + array[(array.length - 1)]);
		System.out.println("#############################################");
		System.out.println("Smallest element from array = " + array[0]);
		System.out.println("#############################################");
		System.out.println("Second smallest element from array = " + array[1]);
		System.out.println("#############################################");
		System.out.println("Second largest element from array = " + array[array.length - 2]);
		System.out.println("#############################################");
	
		
	}

}
