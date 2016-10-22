/**
 * Temperature --- Blueprint for Celsius and Fahrenheit conversion
 * @author         David Ye Luo, Kenta Medina
 * @version        1.0
 * @since          2016/10/22
 */
import java.util.*;
public class Temperature
{
	double degrees;
	char type;
	Scanner scanner;
	
	//-------------------------------------------------------------------
	//	Constructor: Sets up temperature with specified data.
	//-------------------------------------------------------------------
	public Temperature(double dDegrees, char cType)
	{
		degrees = dDegrees;
		type = cType;
		scanner = new Scanner(System.in);
	}
	
	//-------------------------------------------------------------------
	//	Constructor: Sets up degrees with specified value.
	//-------------------------------------------------------------------
	public Temperature(double dDegrees)   //defaults to Celsius
	{
		degrees = dDegrees;
		type = 'C';
		scanner = new Scanner(System.in);
	}
	
	//-------------------------------------------------------------------
	//	Constructor: Sets up type with specified value.
	//-------------------------------------------------------------------
	public Temperature(char cType)
	{
		degrees = 0.0;
		type = cType;
		scanner = new Scanner(System.in);
	}
	
	//-------------------------------------------------------------------
	//	Default Constructor: Sets up temperature with default values.
	//-------------------------------------------------------------------
	public Temperature()
	{
		type = 'C';
		degrees = 0.0;
		scanner = new Scanner(System.in);
	}

	//-------------------------------------------------------------------
	//	Prints degrees in Celsius and Fahrenheit.
	//-------------------------------------------------------------------
	public void writeOutput()
	{
		System.out.println("<" + getC() + "> degrees Celsius, <" + 
								 getF() + "> degrees Fahrenheit");
	}
	
	//-------------------------------------------------------------------
	//	Prints degrees in Celsius.
	//-------------------------------------------------------------------
	public void writeC()
	{
		System.out.println("<" + getC() + "> degrees Celsius");
	}
	
	//-------------------------------------------------------------------
	//	Prints degrees in Fahrenheit.
	//-------------------------------------------------------------------
	public void writeF()
	{
		System.out.println("<" + getF() + "> degrees Fahrenheit");
	}

	//-------------------------------------------------------------------
	//	Returns the degree in Celsius.
	//-------------------------------------------------------------------
	public double getC()
	{
		double conversion = 10.0;  // To see 1 decimal after a number
		if(type == 'F' || type == 'f')  // change from Fahrenheit to Celsius
		{
			// formula F = (C-32) * 5/9
			double firstStep = degrees - 32.0;
			double secondStep = 5.0/9.0;
			/*
			 * Math.round() gives a format number of XX.0 but we want XX.X
			 * to get around it, we just multiply by 10 and divide by 10
			 * Note: Math.round() returns long
			 */
			double answer = (double) Math.round(firstStep * secondStep * conversion) / conversion;
			
			return answer;
		}
		else // When it's this.type is C
		{
			return Math.round(degrees*conversion)/conversion;
		}
	}
	
	//-------------------------------------------------------------------
	//	Returns the degree in Fahrenheit.
	//-------------------------------------------------------------------
	public double getF()
	{
		double conversion = 10.0;
		if(type == 'C' || type == 'c')  // change from Celsius to Fahrenheit
		{
			// formula C = (F * 9/5) + 32
			double add = 32.0;
			double multiply = degrees * 9.0/5.0;
			/*
			 * Math.round() gives a format number of XX.0 but we want XX.X
			 * to get around it, we just multiply by 10 and divide by 10
			 * Note: Math.round() returns long
			 */
			double answer = (double) Math.round((multiply + add) * conversion) / conversion;
			return answer;
		}
		else  // When this.type is F
		{
			return Math.round(degrees*conversion)/conversion;
		}
	}
	
	//-------------------------------------------------------------------
	//	Degrees and Type mutator.
	//-------------------------------------------------------------------
	public void set(double dDegrees, char cType)
	{
		degrees = dDegrees;
		type = cType;
	}
	
	//-------------------------------------------------------------------
	//	Degrees mutator.
	//-------------------------------------------------------------------
	public void set(double dDegrees)
	{
		degrees = dDegrees;
	}
	
	//-------------------------------------------------------------------
	//	Type mutator.
	//-------------------------------------------------------------------
	public void set(char cType)
	{
		type = cType;
	}

	//-------------------------------------------------------------------
	//	Returns true if the temperature is the same.
	//-------------------------------------------------------------------
	public boolean equals(Temperature otherTemp)
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

	//-------------------------------------------------------------------
	//	Returns the temperature as a string.
	//-------------------------------------------------------------------
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
	
	//-------------------------------------------------------------------
	//	Extra credit: get input from user.
	//-------------------------------------------------------------------
	public void readInput()
    { 
        // :important:
        // I am using nextLine() to get String.
        // This is because nextDouble() skips nextLine for some unknown reason
        String inputDegrees;  // Intentional!
        String inputType;     // Intentional!
        
        System.out.println("Enter the degrees desired");
        inputDegrees = scanner.nextLine();
        do {  // this is to prevent typo
            System.out.println("Enter the F for fahrenheit or C for Celsius");
            inputType = scanner.nextLine();
        }while((!inputType.toUpperCase().equals("C") && 
        		!inputType.toUpperCase().equals("F")));
        
        degrees = Double.parseDouble(inputDegrees);
        type = (char)inputType.toUpperCase().charAt(0);  // There is no nextChar() so 
                                            // I had to find a way to convert string to char
    }
}