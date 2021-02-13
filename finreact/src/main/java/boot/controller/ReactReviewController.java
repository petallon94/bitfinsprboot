package boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import boot.dao.MysqlReviewMapper;
import boot.dto.ReviewDto;


@CrossOrigin
@RestController
public class ReactReviewController {
	
	@Autowired
	MysqlReviewMapper mapper;
	
	@GetMapping("/review/list")
	public List<ReviewDto> getPostList(@RequestParam String mnum)
	{	
		
		return mapper.getPostDatas(mnum);
	}
	
	//getData:dto보내기
	@GetMapping("/review/detail")
	public ReviewDto getReview(@RequestParam int rnum)
	{
			
			return mapper.selectNumOfReview(rnum);
	}
		
	//리뷰에 대한 사진불러오기
	@GetMapping("/review/pic")
	public ReviewDto getPicture(@RequestParam int rnum)
	{
			
			return mapper.getPicOfReview(rnum);
	}
	//리뷰에 대한 레스토랑정보가져오기
	@GetMapping("/review/res")
	public ReviewDto getRestaurant(@RequestParam int rnum)
	{
			
			 return mapper.getResInfoOfReview(rnum);
	}
	//리뷰에 대한 해시태그가져오기
	@GetMapping("/review/hash")
	public ReviewDto getHashtaglist(@RequestParam int rnum)
	{
			
			return mapper.getHashtagOfReview(rnum);
	}
	//리뷰에 대한 댓글1개 가져오기
	@GetMapping("/review/re")
	public ReviewDto getOneAnswer(@RequestParam int rnum)
	{
			
			return mapper.getAnswerOfReview(rnum);
	}

	@GetMapping("/review/detail")
	public ReviewDto getData(@RequestParam String rnum) {
		return mapper.getData(rnum);
	}

}
