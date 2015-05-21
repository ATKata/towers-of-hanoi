package kata;

public class TowersOfHanoi {
	private Peg peg1;
	private Peg peg2;
	private Peg peg3;

	public TowersOfHanoi() {
		this.peg1 = new Peg();
		this.peg2 = new Peg();
		this.peg3 = new Peg();

		peg1.addDisk(Disk.SIZE_3);
		peg1.addDisk(Disk.SIZE_2);
		peg1.addDisk(Disk.SIZE_1);
	}

	public Peg getPeg(int pegIndex) {
		switch (pegIndex) {
		case 1:
			return peg1;
		case 2:
			return peg2;
		case 3:
			return peg3;
		default:
			return null;
		}

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

	public boolean move(int fromPegIndex, int toPegIndex) {
		Peg fromPeg = getPeg(fromPegIndex);
		if (fromPeg.isEmpty()) {
			return false;
		}
		Disk disk = fromPeg.removeDisk();
		if (!getPeg(toPegIndex).addDisk(disk)) {
			fromPeg.addDisk(disk);
			return false;
		}
		return true;
	}
}
