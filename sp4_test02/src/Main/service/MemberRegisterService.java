package Main.service;

import java.util.Date;

import Main.DTO.MemberDTO;
import Main.DTO.MemberDao;
import Main.DTO.RegisterRequest;

public class MemberRegisterService {
	// 의존객체
	private MemberDao memberDao = new MemberDao();
	//무조건 필요할 때가 의존객체
	public void regist(RegisterRequest req) {
		// dto는 주로 의존객체로 사용하지않기 때문에 dao를 이용
//		MemberDTO dto = new MemberDTO();		//req에 값을 받아 dto에 저장
		MemberDTO dto = memberDao.selectByEmail(req.getEmail());
		if (dto == null) {
			dto = new MemberDTO();
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dto.setRegisterDate(new Date()); // dto를 dao에 저장해야한다.
			memberDao.insert(dto);
			System.out.println("사용자 등록 완료");
		}else {
			System.out.println("중복 사용자 입니다.");
		}
	}
}