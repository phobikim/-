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
		System.out.println(memberId+"�� ������ " + 
	info.getId() +"�� �����Ͽ����ϴ�");
	}
}




