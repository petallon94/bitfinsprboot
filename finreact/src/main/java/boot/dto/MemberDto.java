package boot.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Member")
public class MemberDto {
   
   //member
   private int mnum;
   private String memailid;
   private String mnick;
   private String mpw;
   
   //follower
   private int fmnum;
   private int follower;
}