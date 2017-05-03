import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Deepak Kumar on 27-Apr-17.
 * <p>
 * This class takes coordinates as user input and displays the 5 closest
 * cityEvents to the specified location along with the distances.
 */
public class GridSearch
{

	private int userLat;
	private int userLong;

	private ArrayList<CityEvent> allCityEvents;
	private int[] indexes;
	private int[] distances;

	public GridSearch()
	{
		allCityEvents = new ArrayList<CityEvent>();
	}

	public static void main(String args[])
	{
		GridSearch gridSearch = new GridSearch();

		String coordinates = obtainUserInput();
		gridSearch.run(coordinates);
	}

	public static String obtainUserInput()
	{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		String coordinates = "";

		try
		{
			System.out.println("Enter your coordinates: ");
			coordinates = br.readLine();
		} catch (IOException e)
		{
			System.err.print("Invalid User Input");
		}

		return coordinates;
	}

	public void run(String coordinates)
	{
		parseUserLocation(coordinates);
		generateEventsData();
		calculateDistances();
		sortEvents();
		displayClosest();
	}

	/**
	 * Generates Events and sets size for indexes and distances arrays.
	 * Also generates the Ticket types and the prices for these tickets and
	 * sorts the tickets into ascending order.
	 */
	public void generateEventsData()
	{
		int i, j;
		String coords;
		int ticketTypes;
		String tempPrice;
		double[] prices;
		CityEvent cityEvent;

		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);

		for (i = 0; i < 10; i++)
		{
			coords = "";

			coords += Utils.randomInt(-10, 10);
			coords += ",";
			coords += Utils.randomInt(-10, 10);

			ticketTypes = Utils.randomInt(0, 3);
			if (ticketTypes != 0)
			{
				prices = new double[ticketTypes];
			}
			else
			{
				prices = null;
			}

			for (j = 0; j < ticketTypes; j++)
			{
				tempPrice = df.format(Utils.randomDouble(1, 100));
				prices[j] = Double.parseDouble(tempPrice);
			}

			cityEvent = new CityEvent(i + 1, coords, ticketTypes, prices);

			allCityEvents.add(cityEvent);
		}

		indexes = new int[allCityEvents.size()];
		distances = new int[allCityEvents.size()];
	}

	/**
	 * Calculates integer coordinates from String.
	 *
	 * @param coord Coordinates to be converted to integer
	 */
	public void parseUserLocation(String coord)
	{
		String[] aCoords = coord.split(",");
		userLat = Integer.parseInt(aCoords[0]);
		userLong = Integer.parseInt(aCoords[1]);

		if (userLat > 10 || userLat < -10)
		{
			System.out.print("Invalid Coordinates");
			System.exit(-1);
		}
		else if (userLong > 10 || userLong < -10)
		{
			System.out.print("Invalid Coordinates");
			System.exit(-1);
		}
	}

	/**
	 * Stores indexes of Events and their distance from obtainUserInput location.
	 */
	public void calculateDistances()
	{
		int i;
		for (i = 0; i < allCityEvents.size(); i++)
		{
			CityEvent cityEvent = allCityEvents.get(i);
			//Calculate Distances
			int dist = Math.abs(userLat - cityEvent.getLat()) + Math
					.abs(userLong - cityEvent.getLon());
			distances[i] = dist;
			indexes[i] = i;
		}
	}

	/**
	 * Uses Selection sort to sort Events.
	 * Selection sort is used as we are expecting a relatively small data set.
	 */
	public void sortEvents()
	{
		int i, j;
		int temp;
		int lowest;
		int size = distances.length;

		for (i = 0; i < size - 1; i++)
		{
			lowest = i;

			for (j = i + 1; j < size - 1; j++)
			{

				if (distances[lowest] > distances[j])
				{
					lowest = j;
				}
			}

			if (i != lowest)
			{
				//Swaps the distances and indexes respectively
				temp = distances[i];
				distances[i] = distances[lowest];
				distances[lowest] = temp;

				temp = indexes[i];
				indexes[i] = indexes[lowest];
				indexes[lowest] = temp;
			}
		}
	}

	/**
	 * Displays the 5 Closest Events to the obtainUserInput location.
	 */
	public void displayClosest()
	{
		int i;
		int eventCount = 0;

		System.out.println(
				"Closest events to (" + userLat + "," + userLong + "):");

		for (i = 0; i < allCityEvents.size(); i++)
		{
			CityEvent cityEvent = allCityEvents.get(indexes[i]);

			//If event has any non-zero ticket prices, displays them,
			//If not checks for next closest event to display
			if (cityEvent.getCheapestPrice() == 0)
			{
				continue;
			}

			System.out.println(
					"CityEvent " + String.format("%03d", cityEvent.getID()) +
							" - " + "$" + cityEvent.getCheapestPrice()
							+ ", Distance " + distances[i]);
			eventCount++;

			if (eventCount >= 5)
			{
				break;
			}
		}
	}
}