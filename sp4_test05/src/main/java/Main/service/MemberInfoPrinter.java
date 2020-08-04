package Main.service;

import Main.DTO.MemberDTO;
import Main.DTO.MemberDao;

public class MemberInfoPrinter {
	//dao는 의존객체
	private MemberDao memberDao;
	private MemberPrinter printer;
		
	//setter를 이용한 의존객체 주입 : dependency injection(DI)
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printMemberInfo(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("데이터가 없습니다. \n");
			return;
		}
		printer.print(dto);
		
	}

}
