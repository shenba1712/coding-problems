public class DiamondPatternPgm {

	public static void main(String args[])
	{
	String[][] array= new String[20][20];
	int i,j,k,n;
	
	k=1;
	n=array.length-2;
	for( i=9; i>0; i--)
	{
		for (j=k;j<n ; j=j+2)
		{
			array[i][j]="*";
		}
		n=n-1;
		k++;
	}
	
	n=array.length-1;
	k=0;
	for( i=10; i<20; i++)
	{
		for (j=k;j<=n ; j=j+2)
		{
			array[i][j]="*";
		}
		n=n-1;
		k++;
	}
	for(i=0; i<array.length; i++)
	{
		for(j=0; j<array.length; j++)
		{
			if(array[i][j]==null)
				System.out.print(" ");
			else
			System.out.print(array[i][j]);
		}
		System.out.println();
	}
	}
}
