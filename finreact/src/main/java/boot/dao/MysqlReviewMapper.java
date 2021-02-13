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

}
