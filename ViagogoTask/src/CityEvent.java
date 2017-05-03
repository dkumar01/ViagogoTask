import java.util.Arrays;

/**
 * Created by Deepak Kumar on 27-Apr-17.
 * <p>
 * This class represents a cityEvent and contains all of its attributes
 */
public class CityEvent
{

	private final int ID;
	private int lat;
	private int lon;

	private int ticketTypes;
	private double[] prices;

	/**
	 * Creates a new CityEvent that contains a unique id and the coordinates
	 * of the event.
	 *
	 * @param id    CityEvent Id
	 * @param coord Coordinates of the event
	 */
	public CityEvent(int id, String coord, int ticketTypes, double[] prices)
	{
		this.ID = id;
		parseLocation(coord);
		this.ticketTypes = ticketTypes;
		this.prices = prices;

		if (prices != null)
		{
			Arrays.sort(prices);
		}

	}

	public void parseLocation(String coord)
	{
		String[] aCoords = coord.split(",");
		lat = Integer.parseInt(aCoords[0]);
		lon = Integer.parseInt(aCoords[1]);
	}

	public int getID()
	{
		return ID;
	}

	public int getLat()
	{
		return lat;
	}

	public void setLat(int lat)
	{
		this.lat = lat;
	}

	public int getLon()
	{
		return lon;
	}

	public void setLon(int lon)
	{
		this.lon = lon;
	}

	/**
	 * Returns the number of tickets left for the event.
	 *
	 * @return number of tickets left for the event
	 */
	public int getTicketTypes()
	{
		return ticketTypes;
	}

	/**
	 * Returns the price of the lowest priced ticket available.
	 *
	 * @return lowest priced ticket
	 */
	public double getCheapestPrice()
	{
		if (prices != null)
		{
			return prices[0];
		}

		else
		{
			return 0;
		}
	}

}
