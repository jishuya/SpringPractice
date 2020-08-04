package com.kopo.dao;

import java.util.List;

import com.kopo.dto.MemberVO;

public interface MemberDAO {
	
	public int selectCountById(String id) throws Exception;
	
	public int insertMember(MemberVO member) throws Exception;
	
}