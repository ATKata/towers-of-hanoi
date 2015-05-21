package kata;

import java.util.ArrayList;
import java.util.List;

public class Peg {
	private final List<Disk> stack;

	public Peg() {
		this.stack = new ArrayList<Disk>();
	}

	public Disk withdrawTopDisk() {
		Disk disk = stack.get(stack.size() - 1);
		stack.remove(disk);
		return disk;
	}

	public void addDisk(Disk disk) {
		stack.add(disk);
	}
}
