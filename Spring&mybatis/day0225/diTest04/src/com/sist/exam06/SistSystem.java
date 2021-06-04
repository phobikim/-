package com.sist.exam06;

public class SistSystem {
	private MemberDao memberDao;
	private BoardDao boardDao;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	public void execute() {
		memberDao.insertMember();
		boardDao.insertBoard();
	}
}
