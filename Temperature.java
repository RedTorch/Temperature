import java.util.*;
public class Temperature{

	double degrees;
	char type;
	Scanner scanner;

	public Temperature(double dDegrees, char cType)
	{
		degrees = dDegrees;
		type = cType;
		scanner = new Scanner(System.in);
	}
	public Temperature(double dDegrees)   //defaults to Celsius
	{
		degrees = dDegrees;
		type = 'C';
                scanner = new Scanner(System.in);
	}
	public Temperature(char cType)   //defaults to 0.0 degrees
	{
		degrees = 0.0;
		type = cType;
		scanner = new Scanner(System.in);
	}
	public Temperature()   //defaults to 0.0 degrees Celsius
	{
		type = 'C';
		degrees = 0.0;
                scanner = new Scanner(System.in);
	}

	public void writeOutput()   //prints temp(C), temp(F)
	{
		System.out.println("<" + getC() + "> degrees Celsius, <" + getF() + "> degrees Fahrenheit");
	}
	public void writeC()   //prints temp(C)
	{
		System.out.println("<" + getC() + "> degrees Celsius");
	}
	public void writeF()   //prints temp(F)
	{
		System.out.println("<" + getF() + "> degrees Fahrenheit");
	}

	public double getC()   //Celsius
	{
		
		double conversion = 10.0;	// To see 1 decimal after a number
		if(type == 'F' || type == 'f')  // change from F to C
		{
			// formula F = (C-32) * 5/9
			// Subtracting 32 from C is the key
			double firstStep = degrees - 32.0;
			double secondStep = 5.0/9.0;
			double answer = (double) Math.round(firstStep * secondStep * conversion) / conversion;
			
			return answer;
		}
		else // no change needed
		{
			return Math.round(degrees*conversion)/conversion;
		}
	}
	public double getF()   //Fahrenheit
	{
		double conversion = 10.0;
		if(type == 'C' || type == 'c')
		{
			// formula C = (F * 9/5) + 32
			double add = 32.0;
			double multiply = degrees * 9.0/5.0;
			double answer = (double) Math.round((multiply + add) * conversion) / conversion;
			return answer;
		}
		else
		{
			return Math.round(degrees*conversion)/conversion;
		}
	}
	public void set(double dDegrees, char cType)
	{
		degrees = dDegrees;
		type = cType;
	}
	public void set(double dDegrees)
	{
		degrees = dDegrees;
	}
	public void set(char cType)
	{
		type = cType;
	}

    public boolean equals(Temperature otherTemp) //WORK ON LATER
    {
    	// Doesn't matter which one you compare 
    	// getC or getF will give you the same result
		if(otherTemp.getC() == getC() && otherTemp.getF() == getF())  
		{
			return true;
		}
		else
		{
			return false;
		}
    }

	public String toString()   //returns type & value; Math.round(temperature*10)/10.0
	{
		String toReturn = "ERROR! Invalid value of TYPE variable (not C or F). Called in toString";
		if(type == 'C')
		{
			toReturn = getC() + " C";
		}
		else if(type == 'F')
		{
			toReturn = getF() + " F";
		}
		return toReturn;
	}
	public void readInput()
    { 
        // :important:
        // I am using nextLine() to get String.
        // This is because nextDouble skips nextLine for some reason
        String inputDegrees;  // Intentional!
        String inputType;     // Intentional!
        
        System.out.println("Enter the degrees desired");
        inputDegrees = scanner.nextLine();
        do { // I am not sure if this is needed
            System.out.println("Enter the F for fahrenheit or C for Celsius");
            inputType = scanner.nextLine();
        }while((!inputType.toUpperCase().equals("C") && 
        		!inputType.toUpperCase().equals("F")));  // this is to prevent typo
        
        degrees = Double.parseDouble(inputDegrees);
        type = (char)(inputType.toUpperCase().charAt(0));  // There is no nextChar() so 
                                            // I had to find a way to convert string to char

        //-----------------------------------------------------------------------------------------------
        //------------------------------------------IMPORTANT NOTE---------------------------------------
        //-----------------------------------------------------------------------------------------------
        // I changed the above line:
        //      type = (char) inputType.charAt(0);
        // to this:
        //      type = (char)(inputType.charAt(0));
        // (just to be careful)
    }
}