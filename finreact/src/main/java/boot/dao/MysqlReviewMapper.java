package boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import boot.dto.ReviewDto;


@Mapper
public interface MysqlReviewMapper {
	

	public int getTotalCount();
	public List<ReviewDto> getAllDatas();
	public ReviewDto getData(String rnum);
	public List<ReviewDto> getPostDatas(String mnum);
	public ReviewDto selectNumOfReview(int rnum);
	public ReviewDto getPicOfReview(int rnum); 
	public ReviewDto getResInfoOfReview(int rnum); 
	public ReviewDto getHashtagOfReview(int rnum);
	public ReviewDto getAnswerOfReview(int rnum); 


//	public int getTotalCount();
//	//public List<ReviewDto> getAllDatas(int mnum);
	
	//public List<ReviewDto> getAllDatas(String rmnum);
	
	public void insertReview (ReviewDto dto);
	public void insertRestaurant (ReviewDto dto);
	public void insertRepic (ReviewDto dto);
	public void insertHashtag (ReviewDto dto);
	
	public int getRnumber(String rmnum);
	
	public ReviewDto getContent(int rnum);

}
