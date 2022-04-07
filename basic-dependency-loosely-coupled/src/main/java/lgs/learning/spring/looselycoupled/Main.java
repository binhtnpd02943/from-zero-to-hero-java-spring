package lgs.learning.spring.looselycoupled;

public class Main {
	public static void main(String[] args) {
		SortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		SortAlgorithm quickSortAlgorithm = new QuicksortAlgorithm();
		VeryComplexService business1 = new VeryComplexService(bubbleSortAlgorithm);
		VeryComplexService business2 = new VeryComplexService(quickSortAlgorithm);
	}
}
