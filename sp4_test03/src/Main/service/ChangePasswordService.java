package Main.service;

import Main.DTO.MemberDTO;
import Main.DTO.MemberDao;

public class ChangePasswordService {
	private MemberDao memberDao;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPw, String newPw) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("이메일이 존재하지않습니다. \n");
			return;
		}
		dto.changePassword(oldPw, newPw);
		memberDao.update(dto);	//dao에 업데이트시킴
		System.out.println("변경완료");
	}

}
