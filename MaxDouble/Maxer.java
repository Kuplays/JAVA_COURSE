public class Maxer {
	public static double getMax(Double ...vars) {
		double peakPoint = 0.0;
		for (Double d : vars) {
			int cmp = Double.compare(d, peakPoint);
			if (cmp > 0) peakPoint = d;
		}
		return peakPoint;
	}
	
	public static void main(String[] args) {
		System.out.println(getMax(0.5, 1.0, 1.333789, 1.333790, 1.333790001));
	}
}
