package boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.dto.AnswerDto;

@Mapper
public interface MysqlAnswerMapper {
	public void insertAnswer(AnswerDto dto);
}
