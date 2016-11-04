package com.qinyadan.brick.market.base.v1;

import com.qinyadan.brick.market.base.model.v1.CreateMember;
import com.qinyadan.brick.market.base.model.v1.UpdateMember;

public interface MemberSercvice {
	
	public void createMember(CreateMember createMember);

	public void updateMember(Integer id, UpdateMember updateMember);

	public void delete(Integer id);

}
