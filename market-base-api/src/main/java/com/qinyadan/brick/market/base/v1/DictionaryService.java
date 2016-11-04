package com.qinyadan.brick.market.base.v1;

import com.qinyadan.brick.market.base.model.v1.SysDictionary;
import com.qinyadan.brick.market.base.model.v1.SysDictionaryParameter;
import com.qinyadan.brick.market.common.mybatis.Page;

public interface DictionaryService {

	public SysDictionaryParameter createDictionary(SysDictionaryParameter sysDictionaryParameter);

	public Page<SysDictionary> getDictionaryList(Integer groupId, Integer limit, Integer offset);

	public SysDictionaryParameter getDictionary(Integer id);

	public void updateDictionary(SysDictionaryParameter sysDictionary);

	public void deleteDictionary(Integer id);

}
