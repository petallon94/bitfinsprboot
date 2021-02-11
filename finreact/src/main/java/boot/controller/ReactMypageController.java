package boot.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boot.dao.MysqlMypageMapper;
import boot.dto.MemberDto;
import boot.dto.MypageInfo;
import boot.dto.ReviewDto;


@RestController
@CrossOrigin
public class ReactMypageController {
	
	@Autowired
	MysqlMypageMapper mapper;
	
	//1. 닉네임으로 넘버 가져오기
	//2. 넘버로 member정보(닉네임) 가져오기 ... 사진은 도대체 어디에 있을까...
	//3. 넘버로 게시물 갯수 가져오기 (rmnum은 멤버번호)
	//4. 넘버로 팔로워(나를 팔로잉한 사람) 수 가져오기
	//5. 넘버로 팔로우(내가 팔로잉한 사람) 수 가져오기
	@GetMapping("/mypage/myInformation")
	public MypageInfo getMyInformation(@RequestParam String mnick) {
		String mnum=mapper.getMyNumber(mnick);
		MemberDto ProfileDto=mapper.getMyMemberDto(mnum);
		MypageInfo dto = new MypageInfo();
		dto.setMnum(mnum);
		dto.setMnick(mnick);
		dto.setMpcik(ProfileDto.getMpick());
		dto.setFollow(mapper.getFollow(mnum));
		dto.setFollower(mapper.getFollower(mnum));
		dto.setListCount(mapper.getMyListCount(mnum));
		return dto;
	}
	
	//6. 전체 리뷰 가져오기
	@GetMapping("/mypage/myAllList")
	public List<ReviewDto> getMyAllList(@RequestParam String mnick) {
		return mapper.getMyAllList(mapper.getMyNumber(mnick));
	}
	//7. 한식 리뷰 가져오기
	@GetMapping("/mypage/myKorList")
	public List<ReviewDto> getMyKorList(@RequestParam String mnick) {
		return mapper.getMyKorList(mapper.getMyNumber(mnick));
	}
	//8. 중식 리뷰 가져오기
	@GetMapping("/mypage/myCnList")
	public List<ReviewDto> getMyCnList(@RequestParam String mnick) {
		return mapper.getMyCnList(mapper.getMyNumber(mnick));
	}
	//9. 일식 리뷰 가져오기
	@GetMapping("/mypage/myJapList")
	public List<ReviewDto> getMyJapList(@RequestParam String mnick) {
		return mapper.getMyJapList(mapper.getMyNumber(mnick));
	}
	//10. 기타 리뷰 가져오기
	@GetMapping("/mypage/myEtcList")
	public List<ReviewDto> getMyEtcList(@RequestParam String mnick) {
		return mapper.getMyEtcList(mapper.getMyNumber(mnick));
	}
}
