package com.sist.exam02;

public class MemberService {
	UpdateInfo info;

	public UpdateInfo getInfo() {
		return info;
	}

	public void setInfo(UpdateInfo info) {
		this.info = info;
	}
	
	public void update(String memberId) {
		System.out.println(memberId+"의 정보를 " + 
	info.getId() +"로 수정하였습니다");
	}
}




