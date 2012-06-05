package recursion;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BreadCrumbTrail {

	int breadCrumbTrail(int level,String key,DataInputStream dis) throws IOException
	{
		String line="";
		StringTokenizer st;
		dis.mark(2000);
		while((line=dis.readLine())!=null)	
		{
			st = new StringTokenizer(line,"\\");
			line = st.nextToken();
			switch(line.charAt(0))
			{
			case '-' :
				st = new StringTokenizer(line, "-");
				line = st.nextToken();
				if(level==2)
				{
					if(line.equals(key))
					{
						System.out.print(line+ "  >>  ");
						return 0;
						
					}
					else
					{
						int flag=breadCrumbTrail(3,key,dis);
						if(flag == 0)
						{
							System.out.print(line + "  >>  ");
							return 0;
								
						}
						else if(flag==2)
						{
							continue;
						}
						else if(flag==1)
							
						{
							return 1;
						}
						
					}
					
				}
				else
				{
					dis.reset();
					return(2); 
					
				}
			
				break;
				
			case '#' :
				st = new StringTokenizer(line, "##");
				line = st.nextToken();
				if(level==3)
				{
					if(line.equals(key))
					{
						System.out.print(line + "   >>  ");
						return 0;
						
					}
					else
					{
						continue;
					}
				}
				break;
			
			default :	
				if(level==1)
				{
					if(line.equals(key))
					{
						System.out.print(line);
						return 0;
						
					}
					else
					{
						int flag=breadCrumbTrail(2,key,dis);
						if(flag == 0)
						{
							System.out.print(line);
							return 0;
								
						}
						else if(flag==1)
						{
							continue;
						}
						
					}
				}
				else
				{
					dis.reset();
					return(1); 
					
				}
			}
			
		}
			
		return -1;
	
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BreadCrumbTrail breadcrumbtrail = new BreadCrumbTrail(); 
		int flag;
		String input;
		File f= new File("/home/pravin/java workspace/BreadCrumbTrail/src/category.txt");
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis =new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		System.out.println("Enter Input  => ");
		Scanner sc= new Scanner(System.in);
		input = sc.nextLine();
		System.out.println();
		System.out.println("Output  => ");
		flag=breadcrumbtrail.breadCrumbTrail(1,input,dis);
		if(flag==-1)
		{
			System.out.println("Input is Invalid");
		}
		
	}
	
}
