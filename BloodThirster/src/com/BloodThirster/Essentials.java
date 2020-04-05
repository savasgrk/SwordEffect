package com.BloodThirster;

public class Essentials 
{
	public static boolean checkIfInteger(String x)
	{
		if(x.isEmpty()) return false;
		char[] temp=x.toCharArray();
		for(int i=0; i<temp.length; i++)
		{
			if(!Character.isDigit(temp[i]))
			{
				return false;
			}
		}
		return true;
	}
}
