/**
 * Created by Deepak Kumar on 29-Apr-17.
 * <p>
 * Utility methods for use by other classes in the package.
 */
public final class Utils
{
	/**
	 * This private constructor is used to ensure that this class cannot be
	 * instantiated.
	 */
	private Utils()
	{
	}

	/**
	 * Generates Random Integer between lower and upper boundaries(inclusive).
	 *
	 * @param low  Lower boundary
	 * @param high Upper boundary
	 * @return random
	 */
	static int randomInt(int low, int high)
	{
		return (low + (int) (Math.random() * (high - low)));
	}

	/**
	 * Generates Random Double between lower and upper boundaries(inclusive).
	 *
	 * @param low  Lower boundary
	 * @param high Upper boundary
	 * @return random
	 */
	static double randomDouble(double low, double high)
	{
		return (low + Math.random() * (high - low));
	}

}
