import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double radius,heightRect,width,side,base,heightTri;
		Area area = new Area();
		System.out.println("Enter radius of circle : ");
		radius = input.nextDouble();
		System.out.println("Enter the Height and width of rectangle : ");
		System.out.print("Height : ");
		heightRect = input.nextDouble();
		System.out.print("Width : ");
		width = input.nextDouble();
		System.out.println("Enter the Side of Square : ");
		side = input.nextDouble();
		System.out.println("Enter the base and height of triangle : ");
		System.out.print("Base : ");
		base = input.nextDouble();
		System.out.print("Height : ");
		heightTri = input.nextDouble();
		System.out.println("area of circle is : "+area.areaOfCircle(radius));
		System.out.println("area of rectangle is : "+area.areaOfRecatangle(width,heightRect));
		System.out.println("aea of square is : "+area.areaOfSquare(side));
		System.out.println("area of triangle is : "+area.areaOfTriangle(base, heightTri));
	}
}
