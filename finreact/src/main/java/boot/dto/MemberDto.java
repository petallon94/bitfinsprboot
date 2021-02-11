package boot.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;

@Alias("Member")
//@Data
public class MemberDto {
   
   //member
   private int mnum;
   private String mpick;
   private String memailid;
   private String mnick;
   private String mpw;
   
   //follower
   private int fmnum;
   private int follower;
	   
	
	public int getMnum() {
	return mnum;
	}
	
	
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	
	
	public String getMpick() {
		return mpick;
	}
	
	
	public void setMpick(String mpick) {
		this.mpick = mpick;
	}
	
	
	public String getMemailid() {
		return memailid;
	}
	
	
	public void setMemailid(String memailid) {
		this.memailid = memailid;
	}
	
	
	public String getMnick() {
		return mnick;
	}
	
	
	public void setMnick(String mnick) {
		this.mnick = mnick;
	}
	
	
	public String getMpw() {
		return mpw;
	}
	
	
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	
	
	public int getFmnum() {
		return fmnum;
	}
	
	
	public void setFmnum(int fmnum) {
		this.fmnum = fmnum;
	}
	
	
	public int getFollower() {
		return follower;
	}
	
	
	public void setFollower(int follower) {
		this.follower = follower;
	}


	@Override
	public String toString() {
		return "MemberDto [mnum=" + mnum + ", memailid=" + memailid + ", mnick=" + mnick + ", mpw=" + mpw + ", fmnum="
				+ fmnum + ", follower=" + follower + "]";
	}
   
   
}