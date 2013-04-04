package studyhomework;

import java.io.*;

public class S130330 {
  
  private int num1,num2,num3,num4,menu;
  float numsosu;
  char choice;
  
  BufferedReader br;
  
  public S130330() {
  	br = new BufferedReader(new InputStreamReader(System.in));
  	this.num1=0; //피제수 
  	this.num2=0; //제수
  	this.num3=0; //몫
  	this.num4=0; //나머지
  	this.menu=0; //메뉴 입력
  	this.numsosu=0; //소숫점 결과값
  	char choice =0; //재시작 

  }

  public void division1 () throws IOException { // 몫과 나머지 출력하는 나눗셈
  	try{
  		System.out.print("첫번째 정수 입력 : ");
  		num1=Integer.parseInt(br.readLine());		
  		System.out.print("두번째 정수 입력 : ");
  		num2=Integer.parseInt(br.readLine());	
  		num3 = num1/num2;
  		num4 = num1%num2;
  		System.out.println("몫은 "+num3+" 나머지는"+num4);
  		
  	}
  	catch(ArithmeticException e){ //0으로 나눌경우 
  		System.out.println("0으로 나눌 수 없습니다. 다시입력하세요");
  		division1(); 
  	}
  	catch(NumberFormatException e){  // 입력받은 수가 정수가 아닐경우 
  		System.out.println("잘못 입력하셨습니다 다시 정수를 입력해주세요 ");
  		division1();
  	}

  	replay(); //재시작 여부 
  }
  public void division2 ()throws IOException{ //나눗셈의 결과가 소숫점까지 나오게 
  	try{
  		System.out.print("첫번째 정수 입력 : ");
  		num1=Integer.parseInt(br.readLine());		
  		System.out.print("두번째 정수 입력 : ");
  		num2=Integer.parseInt(br.readLine());
  		numsosu = (float)num1/num2;
  		System.out.printf("결과는 %.2f\n",numsosu); //printf를 이용하여 소숫점 둘째짜리까지만 출력
  		
  	}//자료형이 float와 double의 경우 0으로 나눠도 에러가 나지 않음.
  	catch(NumberFormatException e){
  		System.out.println("잘못 입력하셨습니다 다시 정수를 입력해주세요 "); //입력받은 수가 정수가 아닐경우 
  		division2();
  	}
  	replay();
  }
  public void replay()throws IOException{ //재실행 여부 판단 
  	
  	System.out.print("다시하시겠습니까? [y/n]");
  	choice = br.readLine().charAt(0);
  	switch(choice){
  	
  	case 'y' : case 'Y' : menu(); break;
  	case 'n' : case 'N' : System.out.println("종료합니다");System.exit(0);
  	default : System.out.println("다시 입력해주세요 ");replay();
  	
  	}
  	
  	
  }
  
  public void menu() throws IOException{ //메뉴

  	try{
  	System.out.println("[1] 몫과 나머지 구하는 나눗셈 [2] 소숫점까지 나오는 나눗셈");
  	System.out.print("입력 : ");
  	int menu = Integer.parseInt(br.readLine());
  	switch(menu) {
  	case 1: division1(); break;
  	case 2: division2(); break;
  	default : System.out.println("잘못입력하셨습니다. 다시 입력해주세요"); 
  	menu();
  	}
  	}catch(NumberFormatException e){ //숫자가 아닌 값이 입력될 경우 
  		System.out.println("잘못 입력하셨습니다");
  		System.out.println("다시 입력해주세요");
  		menu();
  	}
  	
  }
  public static void main(String[] args) throws IOException {
  	
  	S130330 s = new S130330();	
  	System.out.println("*****나눗셈 프로그램*****");		
  	s.menu();

  }

}
