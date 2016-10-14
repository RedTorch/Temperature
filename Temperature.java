Public class Temperature{

	double degrees;
	char type;

	public Temperature(double dDegrees, char cType)
	{
		degrees = dDegrees;
		type = cType;
	}
	public Temperature(double dDegrees)   //defaults to Celsius
	{
		degrees = dDegrees;
		type = "C";
	}
	public Temperature(char cType)   //defaults to 0.0 degrees
	{
		degrees = 0.0;
		type = cType;
	}
	public Temperature()   //defaults to 0.0 degrees Celsius
	{
		type = "C";
		degrees = 0.0;
	}

	public void writeOutput()   //prints temp(C), temp(F)
	{
		system.out.println("<" + Math.round(degrees*10)/10.0 + "> degrees <" + type + ">");
	}
	public void writeC()   //prints temp(C)
	{
		system.out.println("<" + Math.round(degrees*10)/10.0 + "> degrees");
	}
	public void writeF()   //prints temp(F)
	{
		system.out.println("Type <" + type + ">");
	}

	public double getC()   //Celsius
	{
		if(type == "F")
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
		if(type == "C")
		{
			return (Math.round(((degrees * (9/5)) + 32)*10)/10.0);
		}
		else
		{
			return Math.round(degrees*10)/10.0;
		}
	}

	public void setTemperature(double dDegrees, char cType)
	{
		degrees = dDegrees;
		type = cType;
	}
	public void setDegrees(double dDegrees)
	{
		degrees = dDegrees;
	}
	public void setType(char cType)
	{
		if(type != cType && (cType == "C" || cType == "F"))
		{
			if(type == "C")
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
		if(otherTemp.getC())
	}

	public String toString()   //returns type & value; Math.round(temperature*10)/10.0

	public void readInput()
}