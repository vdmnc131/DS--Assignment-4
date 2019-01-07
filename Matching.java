
import java.io.*;
import java.lang.Integer;
import java.util.*;


public class Matching
{
	HashMap<String, Company> company;
	HashMap<String,Graduate> graduate;
	
	
	public Matching()
	{
		company= new HashMap<String, Company>();
		graduate=new HashMap<String,Graduate>();
	}

	public void ADD_COMPANY(String P,String Q ,int k)
	{
		Company	temp1 =new Company(P,Q,k);
		company.put(P,temp1);
	}
	public void ADD_GRADUATE(String graduateID ,String graduateName ,double cgpa ,Vector preferences)
	{
		Graduate temp2= new Graduate(graduateID,graduateName,cgpa,preferences);
		graduate.put(graduateID,temp2);
	}
	public void PREFERENCE_BY_COMPANY(String companyID,Vector a) throws Exception
	{
		if(company.containsKey(companyID))
		company.get(companyID).list=a;
		else
		{
        	System.out.println("Exception");
        	throw new Exception();
        }

	}
	public void  DISPLAY_COMPANY( String companyID) throws Exception
	{
		if(company.containsKey(companyID))
		System.out.println(company.get(companyID).companyInformation + ", " +company.get(companyID).capacity);
		else
		{
        	System.out.println("Exception");
        	throw new Exception();
        }	
	}
	public void DISPLAY_GRADUATE(String graduateID) throws Exception
	{
		if(graduate.containsKey(graduateID))
		{	
			System.out.print(graduate.get(graduateID).graduateName + ", " + graduate.get(graduateID).cgpa );
			Iterator < String> it = graduate.get(graduateID).preferences. iterator ();
 			while (it. hasNext ())
 			{
				System . out . print (", "+ it. next ());
 			}
 			System.out.println("");
 		}
 		else
		{
        	System.out.println("Exception");
        	throw new Exception();
        }			
 		
	}
	public void DISPLAY_PREFERENCE_BY_COMPANY(String companyID) throws Exception
	{
		if(company.containsKey(companyID))
		{
			if(company.get(companyID).list.size()>0)
			{
				System.out.print(company.get(companyID).list.get(0));
				// System.out.println(company.get(companyID).list.size());
				for(int i=1;i<company.get(companyID).list.size();i++)
					System.out.print(", " + company.get(companyID).list.get(i));
					System.out.println("");
			}
		}
		else
		{
        	System.out.println("Exception");
        	throw new Exception();
        }			
	}
	public void UPDATE_CAPACITY(String companyID,int a) throws Exception
	{
		if(company.containsKey(companyID))
		company.get(companyID).capacity=a;
		else
		{
        	System.out.println("Exception");
        	throw new Exception();
        }	
	}
	public void UPDATE_CGPA(String graduateID, double k) throws Exception
	{
		if(graduate.containsKey(graduateID))
		graduate.get(graduateID).cgpa=k;
		else
		{
        	System.out.println("Exception");
        	throw new Exception();
        }		
	}
	public void UPDATE_PREFERENCE_OF_GRADUATE(String graduateID,Vector a) throws Exception
	{
		if(graduate.containsKey(graduateID))
		{
			Iterator < String > it = graduate.get(graduateID).preferences. iterator ();
			while (it. hasNext ())
			{
				String z= it.next();

 				if(! a.contains(z))
 				{
 				
 					if(company.get(z).list.contains(graduateID))
 					{
 						company.get(z).list.remove(graduateID);
 					}
 				}

 			} 
 			graduate.get(graduateID).preferences=a;
 		}
		else
		{
        	System.out.println("Exception");
        	throw new Exception();
        }	 		


	}
	public void DELETE_COMPANY(String companyID) throws Exception
	{
		if(company.containsKey(companyID))
		{	
			company.remove(companyID);
			Iterator < String > it= graduate. keySet (). iterator ();
			while (it. hasNext ())
			{
 				String tmp = it. next ();
 				Vector <String> temp= graduate.get(tmp).preferences;
 				if(temp.contains(companyID))
 				{
 					temp.remove(companyID);
 				}
 		
 			}
 		}
		else
		{
        	System.out.println("Exception");
        	throw new Exception();
        }	 		

	} 

	public void DELETE_GRADUATE(String graduateID) throws Exception
	{
		if(graduate.containsKey(graduateID))
		{
			graduate.remove(graduateID);	
			Iterator < String > it= company. keySet (). iterator ();
			while (it. hasNext ())
			{
 				String tmp = it. next ();
 				Vector <String> temp= company.get(tmp).list;
 				if(temp.contains(graduateID))
 				{
 					temp.remove(graduateID);
 				}
 		
 			}
 		}
		else
		{
        	System.out.println("Exception");
        	throw new Exception();
        }	 					
	}
	public void PERFORM_ASSIGNMENT()
	{
		// long startMatch=System.currentTimeMillis();
		boolean U=true;
		Iterator < String > itw= graduate. keySet (). iterator ();
		while (itw. hasNext ())
			{
 				String tmp = itw. next ();
 				Vector <String> temp= graduate.get(tmp).preferences;
 				for(int i=0;i<temp.size();i++)
 				{
 					if(!company.get(temp.get(i)).list.contains(tmp))
 					{	
 						U=false;
 						break;
 					}
 				}

 		
 			}
		if(U){
		Iterator < String > its= company. keySet (). iterator ();
		while (its. hasNext ())
			{
 				String tmp = its. next ();
 				Vector <String> temp= company.get(tmp).list;
 				for(int i=0;i<temp.size();i++)
 				{
 					if(!graduate.get(temp.get(i)).preferences.contains(tmp))
 					{	
 						U=false;
 						break;
 					}
 				}

 		
 			} 	
 			}		
 		if(U)
 		{		
		 HashMap<String,Company> c= new HashMap<String, Company>();
		 HashMap<String,Graduate> g=new HashMap<String,Graduate>();	
	

		for (Map.Entry<String, Company> entry : company.entrySet())
	    {
	        c.put(entry.getKey(), new Company(entry.getValue()));
	    }
	    for (Map.Entry<String, Graduate> entry : graduate.entrySet())
	    {
	        g.put(entry.getKey(), new Graduate(entry.getValue()));
	    }




	
	 	
		int counter=0;
		int i=0;
		int Rj=0;
		String value="";
		String x="";
		String temp4="";
	
		
		while(counter<g.size())
		{
			
			Iterator < String > it1= g. keySet (). iterator ();
			while(it1.hasNext())
			{
				 temp4=it1.next();
				// System.out.println(temp4);
				if(g.get(temp4).bestmatch.equals(""))
					break;

			}
			value=temp4;
			// System.out.println(value);
			if(g.get(value).preferences.size()>0)
			{
	
				x=g.get(value).preferences.get(0);
				 // System.out.println(x);
				g.get(value).bestmatch=x;
				counter++;
				c.get(x).match.add(g.get(value).graduateID);
				c.get(x).capacity--;	
				// System.out.println(c.get(x).capacity);			
				if(c.get(x).capacity<0)
				{
					Rj= worst(c.get(x).match,c.get(x).list);
					// System.out.println("lol");
					
					g.get(c.get(x).list.get(Rj)).bestmatch="";
					counter--;
					String  w=c.get(x).list.get(Rj); // w=p3,p4 and so on
					g.get(w).preferences.remove(c.get(x).companyID);
					c.get(x).list.remove(Rj);
					c.get(x).match.remove(w);


					
					c.get(x).capacity=0;
				}	
			
				if(c.get(x).capacity==0)
				{
					Rj= worst(c.get(x).match,c.get(x).list);
						// System.out.println("lul"); 	
					for(int j=Rj+1;j<c.get(x).list.size();j++)
					{
						String  w=c.get(x).list.get(j); // w=p3,p4 and so on
						g.get(w).preferences.remove(c.get(x).companyID);
						c.get(x).list.remove(j);


					}

				}

			}
			else
			{
				g.get(value).bestmatch="TRASH";
				counter++;
			}

		}
		Iterator < String > it2= g. keySet (). iterator ();
		while(it2.hasNext())
		{
			String l=it2.next();
			if(g.get(l).bestmatch != "TRASH")
			System.out.println(g.get(l).graduateID+ ", "+g.get(l).bestmatch);
			else
			{
				System.out.println(g.get(l).graduateID+ ", ");
			}
		}
				// long stopMatch=System.currentTimeMillis();
				// System.out.println(stopMatch-startMatch);
			}
			else{
			System.out.println("Exception");
        	
			}
	}

	public int  worst(Vector a,Vector b)
	{
		int index=0;
		Iterator < Integer > it = a. iterator ();
		while (it. hasNext ())
		{
 			int temp=b.indexOf(it.next());
 			if(temp>index)
 				index=temp;
 		}
 		return(index);
	}





}