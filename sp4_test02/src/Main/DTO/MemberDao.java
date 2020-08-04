package Main.DTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId = 0;
	//hashmap은 map을 상속받고 있음
	private static Map<String, MemberDTO> map = new HashMap<String, MemberDTO>();
	public void insert(MemberDTO dto) {
		dto.setId(++nextId); 	//선행이니 1부터 출력된다.
		map.put(dto.getEmail(), dto); 
		
	}
	public MemberDTO selectByEmail(String email) {
		//map으로부터 반환받아와야하므로 
		return map.get(email);
		
	}
	public Collection<MemberDTO> selectAll() {
		return map.values();	//collection이기 때문에
	}
	
}
