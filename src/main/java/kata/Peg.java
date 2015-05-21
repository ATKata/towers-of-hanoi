package kata;

import java.util.ArrayDeque;
import java.util.Deque;

public class Peg {
	private final Deque<Disk> stack;

	public Peg() {
		this.stack = new ArrayDeque<Disk>();
	}

	public Disk removeDisk() {
		return stack.pop();
	}

	public boolean addDisk(Disk disk) {
		if (stack.isEmpty() || stack.peek().value > disk.value) {
			stack.push(disk);
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}
}
