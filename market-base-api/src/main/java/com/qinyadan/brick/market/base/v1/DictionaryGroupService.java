package com.qinyadan.brick.market.base.v1;

import com.qinyadan.brick.market.base.model.v1.SysDictionary;
import com.qinyadan.brick.market.common.mybatis.Page;

public interface DictionaryGroupService {

	public SysDictionary createDictionary(SysDictionary sysDictionary);

	public Page<SysDictionary> getDictionaryList(String keyword, Integer limit, Integer offset);

	public SysDictionary getDictionary(Integer id);

	public void updateDictionary(SysDictionary sysDictionary);

	public void deleteDictionary(Integer id);

}
