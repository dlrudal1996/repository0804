package sp4.sp4_test05;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import Main.DTO.RegisterRequest;
import Main.service.ChangePasswordService;
import Main.service.MemberInfoPrinter;
import Main.service.MemberListPrinter;
import Main.service.MemberRegisterService;

public class App2 {
	private static GenericXmlApplicationContext ctx;

	// main 메소드가 컨트롤러가 된다.
	public static void main(String[] args) {
		ctx = new GenericXmlApplicationContext("classpath:configImport.xml");	
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("명령어를 입력하세요 : ");
			String command = sc.nextLine();
			if (command.startsWith("new")) {
				String[] arg = command.split(" ");	// 공백문자를 이용해 new에 있는 이메일, 이름, 암호, 암호확인을 구분하기위해서 split사용
				if (arg.length != 5) { 				// new 이메일 이름 암호 암호확인은 크기가 5이므로
					printHelp();
					System.out.println();
					continue;
				}
				// 의존 객체 : 클래스 안에 있는 객체 //dependency object
				RegisterRequest req = new RegisterRequest();		//dto라서 의존객체가 아니다
				req.setEmail(arg[1]);
				req.setName(arg[2]);
				req.setPassword(arg[3]);
				req.setConfirmPassword(arg[4]);
				boolean bl = req.isPasswordEqualConfirmPassword();
				if (!bl) {
					System.out.println("비밀번호 불일치");
					continue;
				}
				//의존객체 dependency object
				MemberRegisterService mrs = ctx.getBean("memberRegisterService", MemberRegisterService.class);
				mrs.regist(req);
			} else if (command.startsWith("change")) {
				String [] arg = command.split(" ");
				if(arg.length != 4) {					
					printHelp();
					continue;
				}
				ChangePasswordService changePwSvc = ctx.getBean("changePasswordService", ChangePasswordService.class);
				changePwSvc.changePassword(arg[1],arg[2],arg[3]);
				//의존객체 dependency object
				MemberListPrinter listPrint = ctx.getBean("memberListPrinter", MemberListPrinter.class);
				listPrint.printAll();
				
			} else if (command.startsWith("info")) {
				String [] arg = command.split(" ");
				if(arg.length != 2) {
					printHelp();
					continue;
				}
				MemberInfoPrinter infoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);				
										//의존객체 주입
				infoPrinter.printMemberInfo(arg[1]);
			} else if (command.startsWith("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}
		}
	}

	public static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인"); 	// new라는 키워드가 command가 되는 것,이를 이용하여 출력
		System.out.println("change 이메일 현재암호 변경암호");
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("프로그램 종료는 exit");
	}
}
