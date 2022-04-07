package lgs.learning.spring.looselycoupled;

public class VeryComplexService {
	private SortAlgorithm sortAlgorithm;

	public VeryComplexService(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}

	public void complexBusiness(int array[]) {
		sortAlgorithm.sort(array);
		// TODO: more logic here
	}
}
