import java.io.*;
import java.lang.Integer;
import java.util.*;
class Company
{
	String companyID;
	String companyInformation;
	int capacity;
	Vector < String >  list;
	Vector < String> match;
	
	public Company()
	{
	 	companyID="";
	 	companyInformation="";
	 	capacity=0;
	}
	public Company(String companyID,String companyInformation,int capacity)
	{
		this.companyID=companyID;
		this.companyInformation=companyInformation;
		this.capacity=capacity;
		list= new Vector<String>();
		match=new Vector<String>();

	}

	public Company(Company A)
	{
		this.companyID=A.companyID;
		this.companyInformation=A.companyInformation;
		this.capacity=A.capacity;
		// list= new Vector<String>();
		this.list=(Vector)A.list.clone();
		// match=new Vector<String>();
		this.match=(Vector)A.match.clone();
	}
	
}