import javax.swing.JOptionPane;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
public class Main
{
    /*To-Do: Find the range/mean/median of a sorted list of volumes
     of shapes that are calculated and can be inserted by the user
    */
    public static void main(String[] args)
    {
        ArrayList<Double>lst= getUsersChoice();
        ArrayList<Double>origlst = new ArrayList<Double>();
        for(double curNum : lst)
        {
            origlst.add(curNum);
        }//end for loop
        ArrayList<Double>sortlst=sortList(lst);
        double range = calcRange(sortlst);
        double median = calcMedian(sortlst);
        double mean = calcMean(sortlst);
        JOptionPane.showMessageDialog(null,"The original list was: "+origlst
                        +"\n The sorted list is: "+sortlst
                        +"\n The range is: "+range
                        +"\n The median is: "+ median
                        +"\n The mean is: "+ mean);
    }//end of main method
    public static ArrayList<Double> getUsersChoice()
    {
        ArrayList<Double>lst = new ArrayList<Double>();

        String exitWhile = "99";
        do
        {
            String curUsersChoice =
                    JOptionPane.showInputDialog("<html>Choices of math formulas to choose from: <br>"
                +"0. Exit to sorted list, range, median, and mean of calculated values<br>"
                +"1. Volume of a cylinder<br>"
                +"2. Volume of a sphere<br>"
                +"3. Volume of a cone<br>"
                +"4. Volume of a cube<br>"
                +"5. Volume of a rectangular prism");
            if (curUsersChoice.equals("1"))
            {
                //collect user's data, round it, and then add it to the ArrayList "lst"
                String strheight = JOptionPane.showInputDialog("Enter the height of the cylinder: ");
                double dblheight = Double.parseDouble(strheight);
                String strradius = JOptionPane.showInputDialog("Enter the radius of the cylinder: ");
                double dblradius = Double.parseDouble(strradius);
                double volCylinder = Math.PI * dblheight *
                        Math.pow(dblradius, 2);
                String strVolCylinder= String.format("%3.2f",
                        volCylinder);
                JOptionPane.showMessageDialog(null, strVolCylinder);
                double roundedCyl =
                        Double.parseDouble(strVolCylinder);
                lst.add(roundedCyl);
            }//end choice 1
            if (curUsersChoice.equals("2"))
            {
                String strRadius = JOptionPane.showInputDialog("Enter the radius of the sphere: ");
                double dblRadius = Double.parseDouble(strRadius);
                double volSphere = (4.0/3.0) * Math.PI *
                        Math.pow(dblRadius, 3);
                String strVolSphere = String.format("%1.2f",
                        volSphere);
                JOptionPane.showMessageDialog(null, strVolSphere);
                double roundedSphere =
                        Double.parseDouble(strVolSphere);
                lst.add(roundedSphere);
            }//end of choice 2
            if (curUsersChoice.equals("3"))
            {
                String strRadius = JOptionPane.showInputDialog("Enter the radius of the cone: ");
                double dblRadius = Double.parseDouble(strRadius);
                String strheight = JOptionPane.showInputDialog("Enter the height: ");
                double dblheight = Double.parseDouble(strheight);
                double volCone = (1.0/3.0) * Math.PI * dblheight *
                        Math.pow(dblRadius, 2);
                String strVolCone = String.format("%1.2f", volCone);
                JOptionPane.showMessageDialog(null, strVolCone);
                double roundedCone = Double.parseDouble(strVolCone);
                lst.add(roundedCone);
            }//end of choice 3 (cone)
            if (curUsersChoice.equals("4"))
            {
                String strSide = JOptionPane.showInputDialog("Enter a length of one side of a cube: ");
                double dblSide = Double.parseDouble(strSide);
                double volCube = Math.pow(dblSide, 3);
                String strvolCube = String.format("%1.2f", volCube);
                JOptionPane.showMessageDialog(null, strvolCube);
                double roundedCube = Double.parseDouble(strvolCube);
                lst.add(roundedCube);
            }//end of choice 4
            if (curUsersChoice.equals("5"))
            {
                String strLength = JOptionPane.showInputDialog("Enter a length of the prism: ");
                double dblLength = Double.parseDouble(strLength);
                String strWidth = JOptionPane.showInputDialog("Enter a width of the prism: ");
                double dblWidth = Double.parseDouble(strWidth);
                String strHeight = JOptionPane.showInputDialog("Enter a height of the prism: ");
                double dblHeight = Double.parseDouble(strHeight);
                double volPrism = dblLength * dblWidth * dblHeight;
                String strvolPrism = String.format("%1.2f", volPrism);
                JOptionPane.showMessageDialog(null,strvolPrism);
                double roundedPrism = Double.parseDouble(strvolPrism);
                lst.add(roundedPrism);
            }//end of choice 5








            try {
                Double.parseDouble(curUsersChoice);
            }
            catch (NumberFormatException e)
            {
                System.out.println("You dumb fr: " + e.toString());
            }

            double userNum = Double.parseDouble(curUsersChoice);





            if(userNum > 5)
            {
                JOptionPane.showMessageDialog(null, "Too High!");
            }//end of choice >5

            if(userNum <0)
            {
                JOptionPane.showMessageDialog(null, "Too Low!");
            }//end of choice <0









            exitWhile = curUsersChoice;
        }while(!exitWhile.equals("0")); //end while loop
        return lst;
    }//end function getUsersChoice
    public static ArrayList<Double> sortList(ArrayList<Double> lst)
    {
        double temp = 0;
//use temp to swap places with next num in order to sort
        //list by value
        for(int j = 0; j < lst.size(); j++)
        {
            for(int i = 0; i < lst.size()-1; i++)
            {
                if(lst.get(i) > lst.get(i+1))
                {
                    temp = lst.get(i);
                    lst.set(i, lst.get(i+1));
                    lst.set(i+1, temp);
                }//end if statement
            }//end inner for loop
        }//end outer for loop
        return lst;
    }//end function sortList
    public static double calcRange(ArrayList<Double> lst)
    {
        double lastNum = lst.get(lst.size()-1);
        double firstNum = lst.get(0);
        double range = lastNum - firstNum;
        String strRange = String.format("%1.2f", range);
        double roundedRange = Double.parseDouble(strRange);
        return roundedRange;
    }//end calcRange
    public static double calcMedian(ArrayList<Double> lst)
    {
        int size = lst.size();
        double median = 0.0;
        double middle = lst.get(size/2);
        double secondMiddle = lst.get((size/2)-1);
        if(size % 2 == 0)
        {
            median = (middle+secondMiddle)/2;
            String strMedian = String.format("%1.2f", median);
            double roundedMedian = Double.parseDouble(strMedian);
            return roundedMedian;
        }
        else
        {
            median = middle;
            return median;
        }
    }//end calcMedian
    public static double calcMean(ArrayList<Double> lst)
    {
        double total = 0;
        for(int j =0; j<lst.size(); j++)
        {
            total = total + lst.get(j);
        }
        double mean = total/lst.size();
        String strMean = String.format("%1.2f", mean);
        double roundedMean = Double.parseDouble(strMean);
        return roundedMean;
    }//end calcMean
}//end of class createTask
