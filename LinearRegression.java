package ml;
import java.io.*;
import java.util.*;
/*
		 * The relation between domain (x) and range (y) is assumed to be of form:
		 * y=theta0 + theta1 * x;
		 * alpha is the learning rate
		 * Gradient descent is used to find optimal theta0 and theta1
		 */
public class LinearRegression {
	static Double sum1(Double theta0, Double theta1, ArrayList<Integer> x,ArrayList<Integer> y){
		Double sum=0.0;
		
		for(int j=0;j<x.size();j++)
			sum+=theta0 + theta1*(x.get(j))-y.get(j);
		return sum;
	}
	
	static Double sum2(Double theta0, Double theta1, ArrayList<Integer> x,ArrayList<Integer> y){
		Double sum=0.0;
		for(int j=0;j<x.size();j++)
			sum+=(theta0 + theta1*(x.get(j))-y.get(j))*x.get(j);
		return sum;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		InputStream ipstr=LinearRegression.class.getResourceAsStream("input.txt");
		if(ipstr==null)
			System.out.println("cant read resoursce");
		BufferedReader in = new BufferedReader(new InputStreamReader(ipstr));
			String singleLine=null;
		singleLine=in.readLine();
		String ar[];
		ArrayList<Integer> x=new ArrayList<Integer>();
		ArrayList<Integer> y=new ArrayList<Integer>();
		
		while(singleLine!=null){
			if(singleLine.contains("!"))
				break;
		ar=singleLine.split("\t");
			x.add(Integer.parseInt(ar[0]));
			y.add(Integer.parseInt(ar[1]));
		
		singleLine=in.readLine();
		}	
		System.out.println(x);
		System.out.println(y);
	Double theta0=0.0;
	Double theta1=0.0;
	Double alpha=0.00001;
	double cost=0.0;
	double cost_old=0.0;
	for(int j=0;j<x.size();j++)
		cost_old+=Math.pow((theta0+theta1 * x.get(j) - y.get(j)),2);
	cost_old/=x.size();
	//interation to find optimal parameters starts
	while(cost_old>1){
		System.out.println("cost ="+cost);
		if (cost>cost_old)
		{
			System.out.println("Cost is not converging. Decrease learning rate.");
			break;
		}
		for(int j=0;j<x.size();j++)
			cost+=Math.pow((theta0+theta1 * x.get(j) - y.get(j)),2);
		cost/=x.size();
	theta0-=(alpha/x.size())*	LinearRegression.sum1(theta0,theta1,x,y); //Update paramters theta0 and theta1
	theta1-= (alpha/x.size())*	LinearRegression.sum2(theta0,theta1,x,y);
	System.out.println("theta0 "+theta0);
	System.out.println("theta1 "+theta1);
	cost_old=cost;
	}
	System.out.println("theta0= "+theta0);
	System.out.println("theta1= "+theta1);
	Scanner ip= new Scanner(System.in);
	System.out.println("enter i/p");
	int a=ip.nextInt();
	Double b=theta0+theta1*a;
	System.out.println("o/p predicted= "+b);
		}}
