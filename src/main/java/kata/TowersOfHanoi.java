package kata;

public class TowersOfHanoi {
	private Peg peg1;
	private Peg peg2;
	private Peg peg3;

	public TowersOfHanoi() {
		this.peg1 = new Peg();
		this.peg2 = new Peg();
		this.peg3 = new Peg();
	}

	public Peg getPeg1() {
		return peg1;
	}

	public Peg getPeg2() {
		return peg2;
	}

	public Peg getPeg3() {
		return peg3;
	}
}
