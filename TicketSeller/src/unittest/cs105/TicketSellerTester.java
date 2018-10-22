package unittest.cs105;

import static java.lang.System.*;
import static org.junit.Assert.*;

import org.junit.*;

import edu.sbcc.cs105.*;

public class TicketSellerTester {
	private static final int maximumScore = 8;
	private static final int maximumAssignmentScore = 10;
	private static int totalScore;

	@BeforeClass
	public static void beforeTesting() {
		totalScore = 0;
	}

	@AfterClass
	public static void afterTesting() {
		out.printf("Your program's functionality scores %d out of %d.\n\n",
				totalScore, maximumScore);

		int difference = maximumAssignmentScore - maximumScore;
		String correctedPoint = (difference == 1) ? "point" : "points";

		out.printf(
				"The assignment is worth a total of %d where the remainder of %d %s\n",
				maximumAssignmentScore, difference, correctedPoint);
		out.println("comes from grading related to documentation, algorithms, and other");
		out.println("criteria.");
	}

	@Test
	public void testSample() {
		TicketSeller ts = new TicketSeller(8);

		assertEquals("Should have 7 tickets remaining.", 7,
				ts.requestTickets(1));
		assertEquals("Should have 5 tickets remaining.", 5,
				ts.requestTickets(2));
		assertEquals("Too many tickets requested.",
				TicketSeller.TOO_MANY_TICKETS_REQUESTED, ts.requestTickets(5));
		assertEquals("Too many tickets requested.",
				TicketSeller.TOO_MANY_TICKETS_REQUESTED, ts.requestTickets(9));
		assertEquals("Should have 2 tickets remaining.", 2,
				ts.requestTickets(3));
		assertEquals("Should have 0 tickets remaining.", 0,
				ts.requestTickets(2));
		assertEquals("Wrong number of buyers.", 4, ts.getNumberOfBuyers());
		totalScore += 2;
	}

	@Test
	public void testNoTickets() {
		TicketSeller ts = new TicketSeller(0);

		assertEquals("Too many tickets requested.",
				TicketSeller.TOO_MANY_TICKETS_REQUESTED, ts.requestTickets(1));
		assertEquals("Too many tickets requested.",
				TicketSeller.TOO_MANY_TICKETS_REQUESTED, ts.requestTickets(4));
		assertEquals("Should have 0 tickets remaining.", 0,
				ts.requestTickets(0));
		assertEquals("Wrong number of buyers.", 1, ts.getNumberOfBuyers());
		totalScore += 2;
	}

	@Test
	public void test20Tickets() {
		TicketSeller ts = new TicketSeller(20);

		assertEquals("Should have tickets remaining.", 16, ts.requestTickets(4));
		assertEquals("Should have tickets remaining.", 12, ts.requestTickets(4));
		assertEquals("Should have tickets remaining.", 8, ts.requestTickets(4));
		assertEquals("Too many tickets requested.",
				TicketSeller.TOO_MANY_TICKETS_REQUESTED, ts.requestTickets(5));
		assertEquals("Should have tickets remaining.", 5, ts.requestTickets(3));
		assertEquals("Should have tickets remaining.", 2, ts.requestTickets(3));
		assertEquals("Should have tickets remaining.", 1, ts.requestTickets(1));
		assertEquals("Too many tickets requested.",
				TicketSeller.TOO_MANY_TICKETS_REQUESTED, ts.requestTickets(2));
		assertEquals("Should have 0 tickets remaining.", 0,
				ts.requestTickets(1));
		assertEquals("Wrong number of buyers.", 7, ts.getNumberOfBuyers());
		totalScore += 4;
	}
}
