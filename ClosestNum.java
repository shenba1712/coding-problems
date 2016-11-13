package example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ClosestNum {

	public static void main(String[] args)
	{
		
		int n,m,p,x,y,k;
		int start, end, mid;
		
		System.out.println("enter the length of sequence");
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		ArrayList<Integer> seq= new ArrayList<Integer>();
		System.out.println("Enter the numbers of the sequence");
		for (int i=0; i<n; i++)
		{
			k=s.nextInt();
			seq.add(k); // original sequence
		}

		System.out.println("Enter number of queries");
		m=s.nextInt();
		for(int i=0; i<m; i++)
		{
			System.out.println("enter p");
			p=s.nextInt();
			seq.add(p);
			Collections.sort(seq);
			start=0;
			end=seq.size()-1;
			for(int t:seq)
				System.out.print(t+"\t");
			System.out.println();
			while(true)
			{
				mid=(start+end)/2;
				if(seq.get(mid)== p)
				{
					System.out.println(p + " is at index "+mid);
					if((mid-1)!= -1)
					{
						x=seq.get(mid-1);
						if ((mid+1)!=(seq.size()))
							y=seq.get(mid+1);
						else
						{
							System.out.println(x+" is closer to "+p);
							break;
						}
					}
					else
					{
						y=seq.get(mid+1);
						System.out.println(y +" is closer to "+p);
						break;
					}
					y=seq.get(mid+1);
					if(Math.abs(p-x)>= Math.abs(p-y))
					{
						System.out.println(y +" is closer to "+p);
						break;
					}
					else
					{
						System.out.println(x+" is closer to "+p);
						break;
					}
				}
				else if (seq.get(mid)> p)
				{
					end=mid-1;
					continue;
				}
				else
				{
					start=mid+1;
					continue;
				}
			}
			seq.remove(mid);
			for(int t:seq)
				System.out.print(t+"\t");
			System.out.println();
		}
	}
}
