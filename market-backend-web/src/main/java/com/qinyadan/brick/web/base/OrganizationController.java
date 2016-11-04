package com.qinyadan.brick.web.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qinyadan.brick.exception.ArgumentValidException;
import com.qinyadan.brick.log.Log;
import com.qinyadan.brick.market.account.api.v1.OrganizationService;
import com.qinyadan.brick.market.account.model.v1.CreateOrganization;
import com.qinyadan.brick.market.account.model.v1.OrganizationModel;
import com.qinyadan.brick.market.account.model.v1.SysOrganization;

@RestController
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	/**
	 * 查询组织机构信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/organization", method = RequestMethod.GET)
	@Log(actionName = "查询组织机构信息")
	public List<OrganizationModel> getOrganizationTree(@RequestParam(value = "id", required = false) Integer id) {
		return organizationService.getOrganizationTree(id);
	}

	/**
	 * 新增机构组织
	 * 
	 * @param createOrganization
	 * @param bindingResult
	 * @throws ArgumentValidException
	 */
	@RequestMapping(value = "/organization", method = RequestMethod.POST)
	@Log(actionName = "新增组织机构")
	public void createOrganization(@RequestBody CreateOrganization createOrganization, BindingResult bindingResult)
			 {

		SysOrganization sysOrganization = new SysOrganization();
		sysOrganization.setName(createOrganization.getName());
		sysOrganization.setDescription(createOrganization.getDescription());
		sysOrganization.setParentId(createOrganization.getParentId());
		organizationService.createOrganization(sysOrganization);
	}

	/**
	 * 删除机构组织
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.DELETE)
	@Log(actionName = "删除组织机构")
	public void deleteOrganization(@PathVariable(value = "id") Integer id) {
		organizationService.delete(id);
	}

	/**
	 * 修改机构组织
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.PUT)
	@Log(actionName = "修改组织机构")
	public void updateOrganization(@PathVariable(value = "id") Integer id,
			@RequestBody CreateOrganization createOrganization, BindingResult bindingResult){
		SysOrganization sysOrganization = new SysOrganization();
		sysOrganization.setId(id);
		sysOrganization.setName(createOrganization.getName());
		sysOrganization.setDescription(createOrganization.getDescription());
		sysOrganization.setParentId(createOrganization.getParentId());
		organizationService.updateOrganization(sysOrganization);
	}

	/**
	 * 新增机构组织用户
	 * 
	 * @param id
	 * @param userIds
	 */
	@RequestMapping(value = "/organization/{id}/user", method = RequestMethod.POST)
	@Log(actionName = "新增组织机构用户")
	public void bindOrganizationUser(@PathVariable(value = "id") Integer id,
			@RequestParam(value = "userIds") Integer[] userIds) {
		organizationService.bindOrganizationUser(id, userIds);
	}

	/**
	 * 删除机构组织用户
	 * 
	 * @param id
	 * @param userIds
	 */
	@RequestMapping(value = "/organization/{id}/user", method = RequestMethod.DELETE)
	@Log(actionName = "删除组织机构用户")
	public void updateOrganization(@PathVariable(value = "id") Integer id,
			@RequestParam(value = "userIds") Integer[] userIds) {
		organizationService.unBindOrganizationUser(id, userIds);
	}
}
