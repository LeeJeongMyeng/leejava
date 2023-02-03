package a01_begin;

public class A01_Start {

	public static void main(String[] args) {


/*
		String sfrrn = "951231";
		String sbrrn = "1111111";
		String sfullrrn = sfrrn+"-"+sbrrn;
		String rrnpat = "^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$";
		System.out.println(sfullrrn);
		System.out.println(sfullrrn.matches(rrnpat));
		
		if(sfullrrn.matches(rrnpat)==true) {
			System.out.println("매치성공");
		} else {
			System.out.println("매치실패");
		}
		*/
		String rtrrrr = "9508281861529";
		StringBuffer buf = new StringBuffer(rtrrrr);
		buf.insert(6, "-");
		String sfullpnum2 = buf.toString();
		System.out.println(sfullpnum2);
	}

}
