/**
 * @author Mick Campitelli
 */

package edu.sbcc.cs105;

import java.util.Scanner;

public class Main {

	/**
	 * Creates and tests TicketSeller class. Tests if the requested tickets are
	 * above the maximum, as well as total tickets overload. -1 is error. Prompts
	 * user for easy reading. When the number of available tickets is 0, returns the
	 * number of buyers and terminates
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Input the number of tickets you want to sell: ");
		int input = s.nextInt();
		TicketSeller ts = new TicketSeller(input);

		while (true) {
			System.out.print("Input requested tickets: ");
			input = s.nextInt();
			int check = ts.requestTickets(input);
			if (check == -1) {
				System.out.println("Too many tickets requested, please try again.");
			} else
				System.out.printf("Thank you for your purchase. There are %s tickets remaining \n", check);

			if (check == 0) {
				System.out.println("You have had " + ts.getNumberOfBuyers() + " buyers.");
				break;
			}
		}
		s.close();

	}

}
