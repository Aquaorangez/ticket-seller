/**
 * @author Mick Campitelli
 */

package edu.sbcc.cs105;

/**
 * This class has a set amount of tickets to sell, initialized by a constructor.
 * The max number of tickets bought at once is 4 - anything over this of over
 * this or over the set total tickets is not allowed. Keeps track of the number
 * of valid purchases
 * 
 */
public class TicketSeller {
	private int buyers;
	private int tickets;
	private final int MAXIMUM_TICKETS_ALLOWED = 4;
	public static final int TOO_MANY_TICKETS_REQUESTED = -1;

	public TicketSeller(int initialTicketAllotment) {
		this.tickets = initialTicketAllotment;
	}

	/**
	 * calculates the remaining tickets after a request with any one transaction
	 * over 4 and anything over the total amount returning an error.
	 * 
	 * @param ticketRequest
	 * @return the amount of int tickets remaining, else returns
	 *         TOO_MANY_TICKETS_REQUESTED
	 */
	public int requestTickets(int ticketRequest) {
		if (ticketRequest == 0) {
			this.buyers++;
			return this.tickets;
		} else if (ticketRequest > this.MAXIMUM_TICKETS_ALLOWED)
			return TicketSeller.TOO_MANY_TICKETS_REQUESTED;
		else if (ticketRequest > this.tickets) {
			return TicketSeller.TOO_MANY_TICKETS_REQUESTED;
		} else
			this.tickets = this.tickets - ticketRequest;
		this.buyers++;
		return this.tickets;

	}

	public int getNumberOfBuyers() {
		return this.buyers;
	}

}
