package kata;

public enum Disk {
	SIZE_1(1), // Smallest
	SIZE_2(2),
	SIZE_3(3),
	SIZE_4(4),
	SIZE_5(5),
	SIZE_6(6),
	SIZE_7(7); // Largest
	
	public final int value;
	
	Disk(int value) {
		this.value = value;
	}
}
