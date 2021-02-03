package boot.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("review")
public class ReviewDto {
	
	//review
	private int rnum;
	private int rmnum;
	private String rcontent;
	private int rscore;
	private Timestamp rwriteday;
	
	//restaurant;
	private int resnum;
	private int revnum;
	private String resname;
	private String resaddr;
	
	//hashtag
	private int crnum;
	private String hashtag;
	
	//repic
	private int pirnum;
	private String picname;
	
	//likere
	private int lmnum;
	private int lrnum;
	

}
