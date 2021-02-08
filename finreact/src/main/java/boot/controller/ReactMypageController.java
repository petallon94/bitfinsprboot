package boot.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.dao.MysqlMypageMapper;
import boot.dto.ReviewDto;


@RestController
@CrossOrigin
public class ReactMypageController {
	
	@Autowired
	MysqlMypageMapper mapper;
	
	@GetMapping("/mypage/list")
	public List<ReviewDto> getMypageList()
	{
		System.out.println(mapper.getMypageData());
		return mapper.getMypageData();
	}
	
	@GetMapping("/mypage/listCount")
	public int getMypageListCount()
	{
		return mapper.getMypageListCount();
	}
	

}
