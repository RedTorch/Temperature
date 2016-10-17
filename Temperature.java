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
		System.out.println("<" + Math.round(getC()*10)/10.0 + "> degrees Celsius, <" + Math.round(getF()*10)/10.0 + "> degrees Fahrenheit");
	}
	public void writeC()   //prints temp(C)
	{
		System.out.println("<" + Math.round(getC()*10)/10.0 + "> degrees Celsius");
	}
	public void writeF()   //prints temp(F)
	{
		System.out.println("<" + Math.round(getF()*10)/10.0 + "> degrees Fahrenheit");
	}

	public double getC()   //Celsius
	{
		if(type == 'F')
		{
			return (Math.round(((degrees * (9/5)) + 32)*10)/10.0);
		}
		else
		{
			return Math.round(degrees*10)/10.0;
		}
	}
	public double getF()   //fahrenheit
	{
		if(type == 'C')
		{
			return (Math.round(((degrees * (9/5)) + 32)*10)/10.0);
		}
		else
		{
			return Math.round(degrees*10)/10.0;
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
		if(type != cType && (cType == 'C' || cType == 'F'))
		{
			if(type == 'C')
			{
				degrees = (degrees-32) * (5/9);
			}
			else
			{
				degrees = (degrees * (9/5)) + 32;
			}
			type = cType;
		}
	}

    public boolean equals(Temperature otherTemp) //WORK ON LATER
	{
		if(otherTemp.getC() == getC()){
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
			toReturn = Math.round(getC()*10)/10.0 + " C";
		}
		else if(type == 'F')
		{
			toReturn = Math.round(getF()*10)/10.0 + " F";
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
        }while(inputType.length() != 1);  // this is to prevent typo
        
        degrees = Double.parseDouble(inputDegrees);
        type = (char)(inputType.charAt(0));  // There is no nextChar() so 
                                            // I had to find a way to convert string to char
                                            // !BUG! There is no restriction of what character it is

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