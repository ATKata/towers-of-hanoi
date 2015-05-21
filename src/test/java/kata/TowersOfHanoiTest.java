package kata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class TowersOfHanoiTest {

	private TowersOfHanoi puzzle;

	@Before
	public void setUp() {
		this.puzzle = new TowersOfHanoi();
	}

	@Test
	public void shouldInitializeWithAllDisksOnFirstPegInAscendingOrder() {
		Peg peg1 = puzzle.getPeg1();

		assertThat(peg1.withdrawTopDisk(), equalTo(Disk.SIZE_1));
		assertThat(peg1.withdrawTopDisk(), equalTo(Disk.SIZE_2));
		assertThat(peg1.withdrawTopDisk(), equalTo(Disk.SIZE_3));
		assertThat(peg1.withdrawTopDisk(), equalTo(Disk.SIZE_4));
		assertThat(peg1.withdrawTopDisk(), equalTo(Disk.SIZE_5));
		assertThat(peg1.withdrawTopDisk(), equalTo(Disk.SIZE_6));
		assertThat(peg1.withdrawTopDisk(), equalTo(Disk.SIZE_7));
	}

}
