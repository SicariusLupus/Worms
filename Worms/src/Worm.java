/**
 * A class of worms with specific name, location, orientation, radius, 
 * mass and action points
 *  test 
 * @author Wolf Nuyts and Arnout Verboven
 *
 */
public class Worm {
	
	public Worm() {
		// eerst massa voor getmaximumactionpoints
		setActionPoints(getMaximumActionPoints());
	}
	private double x;
	private double y;
	/**
	 * 
	 */
	public double getX() {
		return x;
	}
	/**
	 * 
	 */
	public double getY() {
		return y;
	}
	/**
	 * 
	 * @return
	 */
	public double[] getLocation() {
		double[] loc = {getX(),getY()};
		return loc;
	}
	/**
	 * 
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * 
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	private double orientation;
	/**
	 * 
	 * @return
	 */
	public double getOrientation() {
		return orientation;
	}
	/**
	 * 
	 * @param orientation
	 */
	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}
	
	private double radius;
	private final double minRadius = 0.25;
	/**
	 * 
	 * @return
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * 
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	private final double density = 1062;
	public double getMass() {
		return (density * 4/3*Math.PI * Math.pow(radius, 3.0));
	}
	
	public int getMaximumActionPoints() {
		return (int) Math.round(getMass());
	}
	
	private int actionPoints;
	public int getActionPoints() {
		return actionPoints;
	}
	public void setActionPoints(int actionPoints) {
		if ((actionPoints >= 0) && (actionPoints <= getMaximumActionPoints()))
			this.actionPoints = actionPoints;
		else if (actionPoints < 0)
			this.actionPoints = 0;
		else
			this.actionPoints = getMaximumActionPoints();		
	}
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


