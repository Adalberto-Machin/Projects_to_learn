import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Get the number of points for this shape
        int num_of_points = getNumPoints(s);
        // print this information
        System.out.println("number of points = " + num_of_points);
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int number_of_points = 0;
        for (Point currPT : s.getPoints()){
            // Count the number of points in the shape by iterating over each point in the shape
            number_of_points = number_of_points + 1;
        }
        
        
        return number_of_points;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        // need to calculate sum of all sides lengths/ number of sides\
        // for a 2d shape, number of sides = number of points
        double num_of_sides = getNumPoints(s);
        double all_side_length = getPerimeter(s);
        double AverageLength = all_side_length/num_of_sides;
        return AverageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largest_side = 0.0; //declare an initial largest side of 0
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if(largest_side <= currDist){
                largest_side = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largest_side;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largest_x = 0.0; //declare an initial largest side of 0
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            // Find the current X point value
            double currX = currPt.getX();
            if(largest_x <= currX){
                largest_x = currX;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largest_x;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(largestPerimeter <= length){
                largestPerimeter = length;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
          double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(largestPerimeter <= length){
                largestPerimeter = length;
                temp = f;
            }
        }
        return temp.getName();

    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        double average_length = getAverageLength(s);
        System.out.println("average length = " + average_length);
        double largest_side = getLargestSide(s);
        System.out.println("largest side length = " + largest_side);
        double largest_x = getLargestX(s);
        System.out.println("largest X = " + largest_x);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largest_perimeter = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter = " + largest_perimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String filename = getFileWithLargestPerimeter();
        System.out.println("largest perimeter file = " + filename);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
