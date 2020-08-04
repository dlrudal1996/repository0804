package Main.service;

import java.util.Collection;

import Main.DTO.MemberDTO;
import Main.DTO.MemberDao;

public class MemberListPrinter {
	private MemberDao memberDao;
	//map으로부터 value만 받아오면 collection이 된다(list)
	//print 하려면 메소드필요
	private MemberPrinter printer;
	
	//의존객체 주입 : dependency injection(DI)
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao  = memberDao;
		this.printer = printer;
	}
	public void printAll() {
		Collection<MemberDTO> lists = memberDao.selectAll();
		System.out.println("총 회원수는 : "+lists.size());
		for(MemberDTO dto : lists) {
			printer.print(dto);
			
		}
	}
	
}
