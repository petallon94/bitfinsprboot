package boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.dto.ReviewDto;


@Mapper
public interface MysqlReviewMapper {
	
	public int getTotalCount();
	public List<ReviewDto> getAllDatas();

}
