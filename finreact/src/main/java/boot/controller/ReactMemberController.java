package boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
		//System.out.println("react 출력 시작");
		//System.out.println("memailid="+mdto.getMemailid());
		//System.out.println("menick="+mdto.getMnick());//toString 자동호출
		//System.out.println("mema="+mdto.getMpw());
		//memberdto 에 추가
		mapper.insertMem(mdto);
		
	}
	
	@PostMapping("/member/checkEmail")
	public int checkEmail(@RequestBody MemberDto mdto) {
		String memailid = mdto.getMemailid();
		int ce = mapper.checkEmail(memailid);
		System.out.println("memeilid : "+memailid + "   ce : "+ ce);
	
		return ce;
	}
	
	@PostMapping("/member/checkNick")
	public int checkNick(@RequestBody MemberDto mdto) {
		String mnick = mdto.getMnick();
		int ce = mapper.checkNick(mnick);
		System.out.println("meNICK : "+ mnick + "   ce : "+ ce);
	
		return ce;
	}
	
	@PostMapping("/member/memCheck")
	public MemberDto memberCheck(@RequestBody MemberDto mdto){
		
		System.out.println(mdto.getMemailid()+" "+mdto.getMpw());
		MemberDto mlist = mapper.LoginCheck(mdto);
		System.out.println(mlist);
		return mlist;
	}

}
