package Main.service;

import Main.DTO.MemberDTO;
import Main.DTO.MemberDao;

public class MemberInfoPrinter {
	//dao는 의존객체
	private MemberDao memberDao = new MemberDao();
	private MemberPrinter printer = new MemberPrinter();
		
	public void printMemberInfo(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("데이터가 없습니다. \n");
			return;
		}
		printer.print(dto);
		
	}

}
