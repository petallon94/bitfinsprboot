package boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import boot.dao.MysqlReviewMapper;
import boot.dto.ReviewDto;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.multipart.MultipartFile;



@CrossOrigin
@RestController
public class ReactReviewController {
	
	@Autowired
	MysqlReviewMapper mapper;
	

	MultipartFile upload;
	String photoname;
	String uploadPath;
	
	
//	@GetMapping("/review/list")
//	public List<ReviewDto> getList(@RequestParam int mnum)
//	{		
//		return mapper.getAllDatas(mnum);
//	}
	

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

	

	
	
	
	@PostMapping(value = "/review/upload", consumes = {"multipart/form-data"})
	public Map<String, String> fileUpload(@RequestParam MultipartFile uploadFile
			, HttpServletRequest request)
	{
		
		
		uploadPath = request.getSession().getServletContext().getRealPath("/reviewsave");
		System.out.println(uploadPath);
		
		// 이미지의 확장자 가져오기
		int pos = uploadFile.getOriginalFilename().lastIndexOf("."); // 마지막 도트의 위치
		String ext = uploadFile.getOriginalFilename().substring(pos);
		
		// 저장할 이미지명 변경하기
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		photoname = "review" + sdf.format(date) + ext;
		
		upload = uploadFile;
		
		try {
			uploadFile.transferTo(new File(uploadPath+"\\"+photoname));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일저장오류:"+e.getMessage());
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("photoname", photoname);
		System.out.println("photoname:"+photoname);
		return map;
	}
	
	
	@PostMapping("review/insertreview")
	public void insertReview(HttpServletRequest request
			, @RequestBody ReviewDto dto
			
			)
	{

		
	System.out.println("hashtag:"+dto.getHashtag());
		//System.out.println(dto.getRcontent());
			//review에 insert
			mapper.insertReview(dto);
			
			//방금 insert한거 넘버갖구오기
			int rnum=mapper.getRnumber(Integer.toString(dto.getRmnum()));
			System.out.println("rnum확인:"+rnum);
			//dto에 저장
			dto.setRevnum(rnum);
			dto.setPirnum(rnum);
			dto.setCrnum(rnum);
		
			mapper.insertRestaurant(dto);
			mapper.insertRepic(dto);
			
			//해시태그안대.....ㅜㅜㅜㅜㅜㅜ
			//mapper.insertHashtag(dto);

		System.out.println(dto.getRnum());

			upload = null;
			photoname = null;
	}

}

