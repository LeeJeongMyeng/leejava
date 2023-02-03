package a06_Object;

public class A05_Constructor {

	public static void main(String[] args) {

House h2 = new House('b');
System.out.println(h2.home);
System.out.println(h2.long1);
System.out.println(h2.hieght);
House h3 = new House('c',300);
System.out.println(h3.home);
System.out.println(h3.long1);
System.out.println(h3.hieght);
House h4 = new House('d',300,30.0);
System.out.println(h4.home);
System.out.println(h4.long1);
System.out.println(h4.hieght);
House h5 = new House('d',300,30.0,30>=40);
System.out.println(h4.home);
System.out.println(h4.long1);
System.out.println(h4.hieght);
System.out.println(h4.name);
	}

}
class House{
	char home;
	int long1;
	double hieght;
	boolean name;
	

	House(char home){
		
		this.home=home;
	}
	House(char home, int long1){
		this(home);
		this.long1 = 300;
	}
	House(char home, int long1,double hiegth){
		this(home,long1);
		this.hieght = 30.0;
	}
	House(char home, int long1,double hiegth, boolean name){
		this(home,long1,hiegth);
		this.name = name;
		
	}
}
