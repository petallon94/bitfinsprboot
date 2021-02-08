package boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.dto.MemberDto;
import boot.dto.ReviewDto;


@Mapper
public interface MysqlMypageMapper {
	
	//전체 리스트
	public List<ReviewDto> getMypageData(String rmnum);
	
	//게시글 갯수
	public int getMypageListCount(int mnum);
	//간단하게 나의 나옴.
	public MemberDto getMyMember(int mnum); 
	
	//내정보
	public MemberDto getMypageMember(int mnum); 
	//나의 팔로워들의 정보
	public MemberDto getFollowing(int mnum); 
	//나를 팔로우한 수
	public int getfollo(int mnum); 
	//팔로우수 구하기
	public int getFollows(int mnum);

	
	
}
