package ConsolProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;




public class LogApp_NonOverLap {
   
   private static Scanner scanUser = new Scanner(System.in); //Scanner 생성
   private static UserInfo2[] user = new UserInfo2[10];
   // 맨아래의 UserInfo 클래스를 가져와 10개의 크기를 가진 배열로 설정
   // [UserName,UserPass,UserNic]
   private static int Usernumber = 0;
   // 회원가입시, 1씩 늘려 남은 배열수 확인.
   
   //==================회원가입 부분========================    
   private static void SignUp(){ 

      System.out.println("현재 가입가능한 인원:"+(10-Usernumber));
      //아래 user[Usernumber]의 해열을 통해 0번 배열에 ID/PASS/NicName이 설정된다.
      System.out.print("아이디를 정해주세요:");
      String SignId = scanUser.next();
      System.out.println("입력하신ID: "+SignId);
      user[Usernumber].setUserName(SignId);
      
      //입력된 SginId는 user[0] 배열의 setUserName에 할당된다.
      System.out.print("패스워드를 정해주세요:");
      String SignPass = scanUser.next();
      user[Usernumber].setUserPass(SignPass);
      //입력된 SignPass는 user[0] 배열의 setUserPass에 할당된다.
      System.out.print("닉네임을 정해주세요:");
      String SignNick = scanUser.next();
      user[Usernumber].setUserNic(SignNick);
      //입력된 SignNick는 user[0] 배열의 setUserNic에 할당된다.
      System.out.println("<회원가입이 완료 되었습니다!!>");
      Usernumber++; // 이후 회원가입을 위해 user[0]에서 user[1]로 진행되게끔 숫자1을 올려준다.
   }
//====================로그인 부분===========================================
   private static void Login_User(){
      System.out.print("아이디를 입력해주세요:");
      String logId = scanUser.next();
      System.out.print("패스워드를 입력해주세요:");
      String logPass = scanUser.next();
      
      int login = 0;
      // for문을 돌려 38번,40번줄에서 입력한 내용이 일치하지않으면 출력하지않고
      // 일치한다면 해당 내용을 출력한뒤 42번줄에서 언급한 login=0이 1로 변한다.
      // 
      for(int logcnt=0;logcnt<10;logcnt++) {
         if(logId.equals(user[logcnt].getUserName())&&logPass.equals(user[logcnt].getUserPass())) {
            System.out.println("로그인이 완료 되었습니다.");
            System.out.print("로그인ID: "+user[logcnt].getUserName()+"\t");
            System.out.println("닉네임: "+user[logcnt].getUserNic());
            login = 1;
         }
      // 위 for문(46번)을 돌려도 일치하지않는다면 login은 1이되지못하고 0인그대로 인상태가 되어 아래와같은 문구가 뜬다.
         }if(login==0) {
            System.out.println("일치하는 정보가 없습니다. 다시 진행해 주세요");      
      }
   }
         
//======================회원 내용 조회 부분======================================      
   
   private static void LookUp_User(){
      //ex) for문(65번줄)을 통해 회원 내용을 출력하는데, 만약 회원 탈퇴를 진행하여 user[0]의 회원 내용이 지워져 null이 표시되면
      // NullPointerException 에러가 나기때문에 trycatch문으로 잡아준다.
         try {
            // for문을 통해 user[0~9]까지 돌려 null이 아닌 내용을 찾아 해당 내용들을 출력한다.
            for(int cnt=0;cnt<10;cnt++) { 
               if(user[cnt].getUserNic() != null) {
               System.out.print("<"+(cnt+1)+"번 아이디:"+user[cnt].getUserName()+">   ");
               System.out.print("<"+(cnt+1)+"번 비밀번호:"+user[cnt].getUserPass()+">\t ");
               System.out.print("<"+(cnt+1)+"번 닉네임:"+user[cnt].getUserNic()+">");
               System.out.println("");
            }
               
            }
         }catch(NullPointerException e) {
            e.getMessage();
         }System.out.println("\n"); // 복잡해보이지 않도록 여백처리
   }
 // ====================회원 탈퇴 부분=========================================================
   private static void Delete_User(){
      System.out.print("삭제할 아이디입력: ");
      String DeletId = scanUser.next();
      System.out.print("삭제할 아이디의 비밀번호 입력: ");
      String DeletPass = scanUser.next();
      int stop = 0;
      // for문을 통해 84번,86번줄의 내용이 user[seach]를 통해 일치한다면 해당 내용 삭제하고
      // 96~98번줄을 통해 해당 배열의 내용들을 다시 null로 처리함
      for(int search=0;search<10;search++) {
         if(DeletId.equals(user[search].getUserName())&&DeletPass.equals(user[search].getUserPass())) {
            System.out.print("아이디:"+user[search].getUserName()+"\t");
            System.out.println("닉네임:"+user[search].getUserNic()+"이(가) 삭제됩니다.");
            System.out.println("");
            
            user[search].setUserName(null);
            user[search].setUserPass(null);
            user[search].setUserNic(null);
            stop=1; //위의 for문성공시 0이었던 stop은 1이되며 바로아래 if문을 거치지않고 끝난다.
         }
         // 바로위의 for문으로 내용을 찾지못하면 int stop은 그대로 0으로 나오고 아래와같은 문구가 출력된다.
         
      }if(stop==0) {
          System.out.println("해당 아이디가 존재하지않습니다.");
       }
   }
//====================메인화면====================================================================   
public static void main(String[] args) {
      for(int cnt=0; cnt<10;cnt++) {
         user[cnt]=new UserInfo2(); //각 배열을 초기화 시켜줌으로써 NullPointException에러 방지
      }
      boolean end = true;
      do {
         System.out.println("*-----------------------------------------------*");
         System.out.println(" 안녕하세요. 원하시는 메뉴가 있으시다면, 해당 숫자를 입력해주세요");
         System.out.println("   1.회원가입  2.회원조회  3.회원탈퇴  4.로그인  5.종료");
         System.out.println("*-----------------------------------------------*");
         //Scanner(맨위 전역 변수로 설정함)를 통해 120번줄 if문으로 위에서 작성한 메뉴들 호출하도록 설정. 
         int selecMenu = scanUser.nextInt();
         if(selecMenu==1) {
            if(Usernumber>=10) {
               System.out.println("가입 정원 초과로 회원가입이 불가능합니다.");
               break;
               }else
            SignUp(); //로그인 메서드 호출
   
         }else if(selecMenu==2) {
            LookUp_User(); // 가입된 회원 닉네임리스트 호출
         }else if(selecMenu==3) {
            Delete_User(); //회원탈퇴 메서드 호출
         }else if(selecMenu==4) {
            Login_User(); //로그인 메서드 호출
         }else if(selecMenu==5) {
            
            end=false;
         }
      }while(end);
      System.out.println("시스템을 종료합니다.");
         
      
   

      
   }

}

class UserInfo2{
	//필드
   private String UserName; // 사용자 아이디
   private String UserPass;// 사용자 패스워드
   private String UserNic;//사용자 닉네임
   public UserInfo2() {}
   public UserInfo2(String userName, String userPass, String userNic) {
      this.UserName=userName;
      this.UserPass = userPass;
      this.UserNic = userNic;
   }
   public String getUserName() {
      return UserName;
   }
   public void setUserName(String userName) {
      UserName = userName;
   }
   public String getUserPass() {
      return UserPass;
   }
   public void setUserPass(String userPass) {
      UserPass = userPass;
   }
   public String getUserNic() {
      return UserNic;
   }
   public void setUserNic(String userNic) {
      UserNic = userNic;
   }
}


