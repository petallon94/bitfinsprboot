package boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boot.dao.MysqlMemberMapper;
import boot.dto.MemberDto;


@RestController
@CrossOrigin
public class ReactMemberController {
	
	@Autowired
	MysqlMemberMapper mapper;
	
	@PostMapping("/member/add")
	public void dataAdd(@RequestBody MemberDto mdto)
	{
		System.out.println("react 출력 시작");
		System.out.println("memailid="+mdto.getMemailid());
		System.out.println("menick="+mdto.getMnick());//toString 자동호출
		System.out.println("mema="+mdto.getMpw());
		//memberdto 에 추가
		mapper.insertMem(mdto);
		
	}
	

}
