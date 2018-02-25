import be.kuleuven.cs.som.annotate.*;

/**
 * A class of worms with specific name, location, orientation, radius, 
 * mass and action points
 * 
 * @invar ...
 * 		| isValidOrientation(getOrientation())
 *  @invar ...
 * 		| isValidRadius(getRadius())
 *  @invar ...
 * 		| isValidName(getName())
 * 
 * @author Wolf Nuyts and Arnout Verboven
 *
 */
public class Worm {
	
	/**
	 * 
	 */
	public Worm() {
		// eerst massa voor getmaximumactionpoints
		setActionPoints(getMaximumActionPoints());
	}
	
	/**
	 * Variable registering the x-coordinate of the worm in meters.
	 */
	private double x;
	
	/**
	 * Variable registering the y-coordinate of the worm in meters.
	 */
	private double y;
	
	/**
	 * Returns the x-coordinate of the worm.
	 */
	@Basic
	public double getX() {
		return x;
	}
	/**
	 * Returns the y-coordinate of the worm.
	 */
	@Basic
	public double getY() {
		return y;
	}
	/**
	 * Returns an array with the x- and y-coordinate of the worm.
	 * @return ...
	 * 		| result == {getX(),getY()}
	 */
	public double[] getLocation() {
		double[] loc = {getX(),getY()};
		return loc;
	}
	/**
	 * Sets the x-coordinate of the worm.
	 * @param x
	 * 		the new x-coordinate of the worm
	 * @post ...
	 * 		| new.getX() == x
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Sets the y-coordinate of the worm.
	 * @param y
	 * 		the new y-coordinate of the worm
	 *  @post ...
	 * 		| new.getY() == y
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Variable registering the orientation of the worm as an angle in radians.
	 */
	private double orientation;
	
	/**
	 * Returns the orientation of the worm.
	 */
	@Basic
	public double getOrientation() {
		return orientation;
	}
	/**
	 * Sets the orientation of the worm.
	 * @param orientation
	 * 		the new orientation of the worm
	 * @pre ...
	 * 		|isValidOrientation(orientation)
	 * @post ...
	 * 		|new.orientation() == orientation
	 */
	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}
	
	/**
	 * Checks if orientation is valid.
	 * @param orientation
	 * 		the orientation of the worm
	 * @return ...
	 * 		| result == (0 <= orientation < 2*Math.PI)
	 */
	public static boolean isValidOrientation(double orientation) {
		return (0 <= orientation) && (orientation < 2*Math.PI);
	}
	
	/**
	 * Variable registering the radius of the worm in meters.
	 */
	private double radius;
	
	/**
	 * Variable registering the minimum radius of the worm in meters.
	 */
	private final double minRadius = 0.25; //0.25 kan later veranderen
	
	/**
	 * Returns the minimum radius of the worm.
	 */
	@Basic
	@Immutable
	public double getMinRadius() {
		return minRadius;
	}
	
	/**
	 * Returns the radius of the worm.
	 */
	@Basic
	public double getRadius() {
		return radius;
	}
	
	/**
	 * Sets the radius of the worm.
	 * @param radius
	 * 		the new radius of the worm
	 * @post ...
	 * 		| new.getRadius() = radius
	 * @throws IllegalRadiusExcpetion
	 * 			...
	 * 		| ! isValidRadius(radius)
	 */
	public void setRadius(double radius) throws IllegalRadiusException{ //exception nog maken
		if (! isValidRadius(radius))
			throw new IllegalRadiusException(radius);
		this.radius = radius;
	}
	
	/**
	 * Checks if radius is valid.
	 * @param radius
	 * 		the radius of the worm
	 * @return ...
	 * 		| radius >= getMinRadius()
	 */
	public boolean isValidRadius(double radius) {
		return (radius >= getMinRadius());
	}
	
	/**
	 * Variable registering the density of the worm in kg/m³.
	 */
	private final double density = 1062;
	
	/**
	 * Returns the mass of the worm in kg.
	 * @return ...
	 * 		| result == density * 4/3*Math.PI * Math.pow(radius, 3.0)
	 */
	public double getMass() {
		return (density * 4/3*Math.PI * Math.pow(radius, 3.0));
	}
	
	/**
	 * Returns the maximum amount of action points.
	 * @return ...
	 * 		| result == Math.round(getMass())
	 */
	public int getMaximumActionPoints() {
		return (int) Math.round(getMass());
	}
	
	/**
	 * Variable registering the amount of action points of the worm.
	 */
	private int actionPoints;
	
	/**
	 * Returns the amount of action points of the worm.
	 */
	@Basic
	public int getActionPoints() {
		return actionPoints;
	}
	
	/**
	 * Sets the amount of action points of the worm.
	 * @param actionPoints
	 * 		the new amount of action points of the worm
	 * @post ...
	 * 		| if ((actionPoints >= 0) && (actionPoints <= getMaximumActionPoints()))
	 * 		  new.getActionPoints() == actionPoints
	 * @post ...
	 * 		| if (actionPoints < 0)
			  new.getActionPoints() == 0
	 * @post ...
	 * 		| if (actionPoints > getMaximumActionPoints())
	 * 		  new.getActionPoints() == getMaximumActionPoints();
	 */
	public void setActionPoints(int actionPoints) {
		if ((actionPoints >= 0) && (actionPoints <= getMaximumActionPoints()))
			this.actionPoints = actionPoints;
		else if (actionPoints < 0)
			this.actionPoints = 0;
		else
			this.actionPoints = getMaximumActionPoints();		
	}
	
	/**
	 * Variable registering the name of the worm.
	 */
	private String name;
	
	/**
	 * Returns the name of the worm.
	 */
	@Basic
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the worm.
	 * @param name
	 * 		the new name of the worm
	 * @post ...
	 * 		| new.getName() == name
	 * @throws IllegalNameException
	 * 		| ! isValidName(name)
	 */
	public void setName(String name) throws IllegalNameException {
		if (! isValidName(name))
			throw new IllegalNameException(name);
		this.name = name;
	}
	
	/**
	 * Checks if the name is valid.
	 * @param name
	 * 		the name of the worm
	 * @return ...
	 * 		| result == ((name.length() >= 2) && (Character.isUpperCase(name.charAt(0)))
				&& (validCharacters))
	 */
	public static boolean isValidName(String name) {
		boolean validCharacters = true;
		for (int i = 0; i<name.length(); i++) {
			if (!isValidCharacter(name.charAt(i)))
				validCharacters = false;
		}
						
		return ((name.length() >= 2) && (Character.isUpperCase(name.charAt(0)))
				&& (validCharacters));
		
	}
	
	/**
	 * Checks if the character is valid.
	 * @param c
	 * 		the checked character
	 * @return ...
	 * 		| result == ((Character.isLetter(c)) || (c == ' ') || (c == '\'') || (c == '"'))
	 */
	public static boolean isValidCharacter(char c) {
		return ((Character.isLetter(c)) || (c == ' ') || (c == '\'') || (c == '"'));
	}
}


