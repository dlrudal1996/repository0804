package Main.service;

import Main.DTO.MemberDao;

public class Assembler {		//객체조립기(운영객체 조립)
	private MemberDao memberDao;												
	private MemberPrinter printer;
	private MemberRegisterService memberRegisterService;
	private MemberListPrinter memListPrinter;
	private ChangePasswordService changePasswordService;
	private MemberInfoPrinter memberInfoPrinter;
	
	public Assembler() {														//생성자
		//객체생성
		this.memberDao = new MemberDao();
		this.printer = new MemberPrinter();
		this.memberRegisterService = new MemberRegisterService(memberDao);		//생성자를 통해 객체주입을 시켰으므로 반환가능
		this.memListPrinter = new MemberListPrinter(memberDao, printer);		//생성자를 통해 객체주입을 시켰으므로 반환가능
		this.changePasswordService = new ChangePasswordService();				//생성자를 통해 초기화를 안시켰으므로 객체반환을 해줘야함
		this.memberInfoPrinter = new MemberInfoPrinter();						//생성자를 통해 초기화를 안시켰으므로 객체반환을 해줘야함
	}
	//객체를 주입하기 위해서 반환해한다.
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public MemberPrinter getMemberPrinter() {
		return printer;
	}
	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}
	public MemberListPrinter getMemberListPrinter() {
		return memListPrinter;
	}
	public ChangePasswordService getChangePasswordService() {					
		//의존객체가 초기화가 안됐으므로 객체생성을 이용해 초기화시킴
		changePasswordService.setMemberDao(memberDao);
		return changePasswordService;											//위와 같은 방법으로 초기화된 객체를 반환
	}
	public MemberInfoPrinter getMemberInfoPrinter() {							
		//의존객체가 초기화가 안됐으므로 객체생성을 이용해 초기화시킴
		memberInfoPrinter.setPrinter(printer);
		memberInfoPrinter.setMemberDao(memberDao);
		return memberInfoPrinter;
	}
}
