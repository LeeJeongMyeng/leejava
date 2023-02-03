package a02_;

public class A04_StringTypeExp {

	public static void main(String[] args) {
  String apple = args[0];
  String cost = args[1];
  String count = args[2];
  
  int intCost = Integer.parseInt(cost);
  int intCount = Integer.parseInt(count);
  int total = (intCost*intCount);
  
  System.out.println(apple+"을 "+intCount+" 구매하였으므로 총 가격은"+total+"원 입니다.");
  



	}

}
