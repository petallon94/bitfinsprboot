package boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.dto.ReviewDto;


@Mapper
public interface MysqlMypageMapper {
	
	public List<ReviewDto> getMypageData();
	
	public int getMypageListCount();

}
