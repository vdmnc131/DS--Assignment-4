import java.io.*;
import java.lang.Integer;
import java.util.*;
class Graduate
{
	String  graduateID;
	String graduateName;
	double cgpa;
	Vector < String >  preferences;
	String bestmatch;
	public Graduate()
	{
		graduateID="";
		graduateName="";
		cgpa=0;
		
	}
	public Graduate(String graduateID,String graduateName ,double cgpa,Vector a)
	{
		this.graduateID=graduateID;
		this.graduateName=graduateName;
		this.cgpa=cgpa;
		preferences=a;
		bestmatch="";

	}
	public Graduate(Graduate A)
	{
		this.graduateID=A.graduateID;
		this.graduateName=A.graduateName;
		this.cgpa=A.cgpa;
		
		
		this.preferences=(Vector)A.preferences.clone();
		this.bestmatch=A.bestmatch;
	}
	
}