package boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.dto.MemberDto;

@Mapper
public interface MysqlMemberMapper {
	
	public List<MemberDto> getData(String mnum);
	public List<MemberDto> getFollowing(String mnum);
	public void insertMem(MemberDto mdto);

}
