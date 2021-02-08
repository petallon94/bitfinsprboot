package boot.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boot.dao.MysqlMypageMapper;
import boot.dto.MemberDto;
import boot.dto.ReviewDto;


@RestController
@CrossOrigin
public class ReactMypageController {
	
	@Autowired
	MysqlMypageMapper mapper;
	
	
	
	
	@GetMapping("/mypage/list")
	public List<ReviewDto> getMypageData(@RequestParam String mnum)
	{
		System.out.println("rmnum값 입력 : ");
		System.out.println(mapper.getMypageData(mnum));
		return mapper.getMypageData(mnum);
	}
	
	@GetMapping("/mypage/listCount")
	public int getMypageListCount(@RequestParam int mnum)
	{
		//System.out.println(mapper.getMypageListCount());
		return mapper.getMypageListCount(mnum);
	}
	
	
	@GetMapping("/mypage/followCount")
	public int getFollowCount(@RequestParam int mnum) {
		return mapper.getFollows(mnum);
	}
	
	
	
	@GetMapping("/mypage/listMember")
	public MemberDto getMyMember(@RequestParam int mnum)
	{
		System.out.println("mnum값 입력 : " + mnum);
		int x=mnum;
		System.out.println(x);
		x =mapper.getfollo(x);
		
		MemberDto dto = new MemberDto();
		if(x==0) {
			dto = mapper.getMyMember(mnum);
		}else {
			dto = mapper.getMypageMember(mnum);
		}
		
		return dto;
	}
	
}
