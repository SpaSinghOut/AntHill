package com.spartanlaboratories.measurements;

/**
 * Stores a Point with the coordinates (x,y) which will most often designate an object's location in the world. 
 * Has a variety of methods of modifying those coordinates as well as converting them to represent an object's location on screen and visa versa.
 * @author Spartak
 * 
 */
public class Location extends Measurement<Location>{
	/**The x coordinate of this Location 
	 * @see #changeX(double)
	 * */
	public double x;
	/**The y coordinate of this Location 
	 * @see #changeY(double)
	 */
	public double y;
	/**
	 * Creates a location with the given coordinates. Meant to be used when creating a new Location 
	 * at a specific point. When changing the location of an already existing point 
	 * use {@link #setCoords(double,  double)}, or {@link #change(double, double)}
	 * @param setX the new value of the horizontal coordinate
	 * @param setY the new value of the vertical coordinate
	 * @see #Location()
	 * @see #Location(Location)
	 */
	public Location(double setX, double setY){
		x = setX;
		y = setY;
	}
	/**
	 * Creates a new Location which copies the coordinates of the given location. This does NOT 
	 * make this location reference the parameter, 
	 * @param location the location whose coordinates will be copied
	 * @see #Location()
	 * @see #Location(double, double)
	 */
	public Location(Location location){
		x = location!=null?location.x:0;
		y = location!=null?location.y:0;
	}
	/**
	 * Creates a {@link Location} with the coordinates (0,0)
	 * @see #Location(Location)
	 * @see #Location(double, double)
	 */
	public Location(){}
	/**
	 * Changes the {@link #x} coordinate by the given value. Does what {@link #changeY(double)} does for the the {@link #y} coordinate
	 * @param xChange the net change of the {@link #x} coordinate
	 * @see #change(Location)
	 */
	public void changeX(double xChange){
		x += xChange;
	}
	/**
	 * Changes the {@link #y} coordinate by the given value. Does what {@link #changeX(double)} does for the {@link #x} coordinate
	 * @param yChange the net change of the {@link #y} coordinate
	 * @see #change(Location)
	 */
	public void changeY(double yChange){
		y += yChange;
	}
	/**
	 * Sets the coordinates of the location to match those of the given location. This method is the preferred alternative to creating a new location when
	 * the location the coordinates of which need to be changed is declared as final and therefore its reference value cannot be updated.
	 * 
	 * @param location the location whose coordinates will be copied
	 * @see #setCoords(double, double)
	 */
	public void duplicate(Location location){
		x = location.x;
		y = location.y;
	}
	/**
	 * Sets the x coordinate of this location to the specified value
	 * @param newXValue - The new x value
	 */
	public void setX(double newXValue){
		x = newXValue;
	}
	/**
	 * Sets the y coordinate of this location to the specified value
	 * @param newYValue - The new y value
	 */
	public void setY(double newYValue){
		y = newYValue;
	}
	/**
	 * Sets the coordinates of this location to the ones passed in.
	 * 
	 * @param newX the new {@link #x} coordinate
	 * @param newY the new {@link #y} coordinate
	 */
	public void setCoords(double newX, double newY){
		x = newX; y = newY;
	}
	/**
	 * Changes the coordinates of this location by the values stored in the location given as a 
	 * parameter. This will not set this location equal no the paramater nor will it link their
	 * references. 
	 * @param locChange the location by the coordinates of which this locations coordinates will be modified
	 * @see #change(double, double)
	 */
	public void change(Location locChange){
		changeX(locChange.x);
		changeY(locChange.y);
	}
	/**
	 * Changes the coordinates of this location by the specified amounts
	 * @param changeInX the net amount by which the x coordinate will be changed
	 * @param changeInY the net amount by which the y coordinate will be changed
	 */
	public void change(double changeInX, double changeInY){
		changeX(changeInX);
		changeY(changeInY);
	}
	/**
	 * Changes the coordinates of the current location by the negatives of the coordinates of the passed in location. For example if the passed in location has
	 * the coordinates (x1,y1) this function is equivalent of calling <a href="Location.html#change(double,double)">change(-x1,-y1)</a>
	 * @param previousChange the location by the opposite of which this location is being changed
	 */
	public void revert(Location previousChange){
		x -= previousChange.x;
		y -= previousChange.y;
	}
	/**
	 * Returns the coordinate values of this location formatted into a string. The coordinate values will only contain two digits after the decimal point.
	 * <p>
	 * Example: if the coordinate values of this location happen to be 5.286 and 7.291 then this method will return:<br>
	 * "(5.28,7.29)"
	 * 
	 * @return - The string value of this Location
	 */
	@Override
	public String toString(){
		return String.format("(%.2f,%.2f)", x,y);
	}
	/**
	 * Prints the {@link #toString()} value of this location to standard output.
	 */
	public void print(){
		System.out.println(toString());
	}
	/**
	 * Returns a new Location that has the same coordinate values as this location.
	 * 
	 * @return - A copy of this location.
	 */
	public Location copy(){
		return new Location(this);
	}
	/**
	 * Swaps the {@link #x} and {@link #y} values of this location.
	 */
	public void swap(){
		setCoords(y,x);
	}
	/**
	 * Checks whether the coordinates of this location are the same as those of the given location.
	 * 
	 * @param comparedLocation - The Location whose coordinates are being compared to this location's coordinates.
	 * @return {@code true} if both coordinates are the same<br>{@code false} otherwise
	 */
	public boolean equals(Location comparedLocation){
		return x == comparedLocation.x && y == comparedLocation.y;
	}
	/**
	 * Sets each coordinate value of this location to 0.
	 */
	public void clear() {
		setCoords(0,0);
	}
	/**
	 * Makes the coordinate values of the passed in location match those of this location.
	 * @param element - The location the coordinates of which are going to match those of this location.
	 */
	public void copyTo(Location element) {
		element.duplicate(this);
	}
	/** 
	 * Multiplies the value of each coordinate by the given amount and sets the product as the new coordinate value. 
	 * For example if the values of this location's coordinates were (2,3) and this function was called with an argument of 3 like so:
	 * magnify(3) then the new coordinates of this location would be (6,9).
	 * @param d - the value by which the coordinates of this location are being magnified.
	 */
	public void magnify(double d){
		x *= d;
		y *= d;
	}
	/**
	 * Checks and returns whether or not each of this location's coordinates is greater than the coordinates of the specified location.
	 * 
	 * @param comparedLocation - The location to which this location's coordinates are being compared to.
	 * @return {@code true} if both the {@link #x} and the {@link #y} coordinates of this location are greater than those of the 
	 * specified location.
	 * <br>
	 * {@code false} if either of the coordinates are not greater than those of the specified location.
	 */
	public boolean isGreaterThan(Location comparedLocation){
		return x > comparedLocation.x && y > comparedLocation.y;
	}
	/**
	 * Checks and returns whether or not each of this location's coordinates is greater than or equal to the coordinates of the specified location.
	 * 
	 * @param comparedLocation - The location to which this location's coordinates are being compared to.
	 * @return {@code true} if both the {@link #x} and the {@link #y} coordinates of this location are greater than or equal to those of the 
	 * specified location.
	 * <br>
	 * {@code false} if either of the coordinates are not greater than or equal to those of the specified location.
	 */
	public boolean isGreaterThanOrEqualTo(Location comparedLocation){
		return isGreaterThan(comparedLocation) || equals(comparedLocation);
	}
	/**
	 * Checks and returns whether or not each of this location's coordinates is less than the coordinates of the specified location.
	 * 
	 * @param comparedLocation - The location to which this location's coordinates are being compared to.
	 * @return {@code true} if both the {@link #x} and the {@link #y} coordinates of this location are less than those of the 
	 * specified location.
	 * <br>
	 * {@code false} if either of the coordinates are not less than those of the specified location.
	 */
	public boolean isLessThan(Location comparedLocation){
		return x < comparedLocation.x && y < comparedLocation.y;
	}
	/**
	 * Checks and returns whether or not each of this location's coordinates is less than or equal to the coordinates of the specified location.
	 * 
	 * @param comparedLocation - The location to which this location's coordinates are being compared to.
	 * @return {@code true} if both the {@link #x} and the {@link #y} coordinates of this location less than or equal to those of the 
	 * specified location.
	 * <br>
	 * {@code false} if either of the coordinates are not less than or equal to those of the specified location.
	 */
	public boolean isLessThanOrEqualTo(Location comparedLocation){
		return isLessThan(comparedLocation) || equals(comparedLocation);
	}
	/**
	 * Sets both of the coordinates of this location to their opposite. (Effectively multiplies each by -1). For example if a location had the 
	 * coordinates (5.193, -132.2) then calling this function would change those coordinates to (-5.193, 132.2)
	 */
	public void negate(){
		x = -x;
		y = -y;
	}
	/** 
	 * Similar to {@link #negate()} in that the original coordinates of this location are takes and are converted to their negatives. However unlike
	 * {@link #negate()} this method does not make any changes to the coordinates but instead returns a new Location which stores coordinates that 
	 * are the negatives of the coordinates of this location.
	 * 
	 * @return - a new Location with coordinates that are the negatives of the coordinates of this Location
	 */
	public Location getOpposite(){
		return new Location(-x,-y);
	}
	/**
	 * Using (0,0) as the center of an angle and this and the passed in Location as the other two points this method returns the degree of the angle formed 
	 * by the three points.
	 * 
	 * @param location a location with which this location will be forming an angle
	 * @return The degree of the angle ( in radians ) 
	 */
	public double getDegreeFromFulcrum(Location location){
		return Math.asin((y - location.y) / (Math.hypot(y - location.y, x - location.x)));
	}
	/**
	 * Return a new Location the coordinates of which are the reciprocals of the appropriate coordinates in this Location.
	 * 
	 * @return - a new Location the coordinates of which are the reciprocals of their appropriate counterparts in this location
	 */
	public Location getReciprocal() {
		return new Location(1/x,1/y);
	}
	/**
	 * Multiplies the coordinates of this Location by the corresponding coordinates in the passed in location.
	 * 
	 * @param amplification - the Location which stores the amplitude of magnification of the coordinates.
	 */
	public void magnify(Location amplification) {
		x *= amplification.x;
		y *= amplification.y;
	}
	/**
	 * Takes in a String object that was produced as a result of calling the {@link #toString()} method of this class and converts it to and returns 
	 * a new Location object the coordinates of which are read from the String.
	 * <p>
	 * Example: Suppose we have a Location object in which x=1 and y=2. We can call the {@link #toString()} method of this Location to get the 
	 * String: "(1,2)". Now we can use this String as a parameter for this methos like s: Location.parseLocation("(1,2)");
	 * This will return a new Location the coordinates of which will be the same as the Location that we started with.
	 * 
	 * @param string - the String object that stores information about this Location.
	 * @return - a new Location whose coordinates are read from the passed in String object.
	 */
	public static Location parseLocation(String string){
		int at = 0;
		while(!Character.isDigit(string.charAt(at++)));
		String xString = "", yString = "";
		at--;
		while(Character.isDigit(string.charAt(at++)) || string.charAt(at - 1) == '.')xString += string.charAt(at - 1);
		while(!Character.isDigit(string.charAt(at++)));
		at--;
		while(Character.isDigit(string.charAt(at++)) || string.charAt(at - 1) == '.')yString += string.charAt(at - 1);
		return new Location(Double.parseDouble(xString), Double.parseDouble(yString));
	}
	public static void main(String[] args){
		System.out.println("performing a unit test for the class: Location");
		String testString = "(15.732,673.91)";
		System.out.println("Trying to parse the string: " + testString);
		System.out.println(parseLocation(testString));
	}
}
