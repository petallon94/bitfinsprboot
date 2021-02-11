package boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.dto.MemberDto;
import boot.dto.ReviewDto;


@Mapper
public interface MysqlMypageMapper {
	
	//1. 닉네임으로 넘버 가져오기
	public String getMyNumber(String mnick);
	
	//2. 넘버로 member정보(닉네임) 가져오기 ... 사진은 도대체 어디에 있을까...
	public MemberDto getMyMemberDto(String mnum);
	
	//3. 넘버로 게시물 갯수 가져오기 (rmnum은 멤버번호)
	public String getMyListCount(String mnum);
	
	//4. 넘버로 팔로워(나를 팔로잉한 사람) 수 가져오기
	public String getFollower(String mnum);
	
	//5. 넘버로 팔로우(내가 팔로잉한 사람) 수 가져오기
	public String getFollow(String mnum);
	
	//6. 전체 리뷰 가져오기
	public List<ReviewDto> getMyAllList(String mnum);
	
	//7. 한식 리뷰 가져오기
	public List<ReviewDto> getMyKorList(String mnum);
	
	//8. 중식 리뷰 가져오기 
	public List<ReviewDto> getMyCnList(String mnum);
	
	//9. 일식 리뷰 가져오기
	public List<ReviewDto> getMyJapList(String mnum);
	
	//10. 기타 리뷰 가져오기
	public List<ReviewDto> getMyEtcList(String mnum);

	
	
}
