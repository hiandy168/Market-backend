package com.qinyadan.brick.account.v1.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qinyadan.brick.account.v1.dao.OrganizationDao;
import com.qinyadan.brick.market.account.api.v1.OrganizationService;
import com.qinyadan.brick.market.account.model.v1.OrganizationModel;
import com.qinyadan.brick.market.account.model.v1.SysOrganization;

public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDao organizationDao;

	@Override
	public List<OrganizationModel> getOrganizationTree(Integer id) {
		SysOrganization sysOrganization = new SysOrganization();
		List<OrganizationModel> result = new ArrayList<OrganizationModel>();
		if (id == null) {
			sysOrganization.setParentId(null);
			List<SysOrganization> sysOrganizationList = organizationDao.selectByModel(sysOrganization);
			for (SysOrganization sys : sysOrganizationList) {
				List<OrganizationModel> organizationModels = organizationDao.getOrganizationTree(sys.getId());
				result.add(getTree(organizationModels, id));
			}
		}
		return result;
	}

	private OrganizationModel getTree(List<OrganizationModel> list, Integer id) {
		OrganizationModel root = new OrganizationModel();
		for (OrganizationModel organization : list) {
			if (organization.getParentId() == id) {
				root = organization;
			} else {
				getTreeNode(organization, root);
			}
		}
		return root;
	}

	/**
	 * 获取子节点
	 * 
	 * @param child
	 * @param parent
	 */
	private void getTreeNode(OrganizationModel child, OrganizationModel parent) {
		if (child.getParentId() != null && child.getParentId().equals(parent.getId())) {
			if (parent.getNodes() == null) {
				List<OrganizationModel> childes = new ArrayList<OrganizationModel>();
				childes.add(child);
				parent.setNodes(childes);
			} else {
				parent.getNodes().add(child);
			}
		} else {
			if (parent.getNodes() != null && parent.getNodes().size() > 0) {
				for (int i = 0; i < parent.getNodes().size(); i++) {
					OrganizationModel childTree = parent.getNodes().get(i);
					getTreeNode(child, childTree);
				}
			}
		}
	}

	@Override
	public SysOrganization createOrganization(SysOrganization sysOrganization) {
		 organizationDao.saveByModel(sysOrganization);
		 return sysOrganization;
	}

	@Override
	public int delete(int id) {
		return organizationDao.deleteByPrimaryKey(id);
	}

	@Override
	public int updateOrganization(SysOrganization sysOrganization) {
		try {
			organizationDao.updateByModel(sysOrganization);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int bindOrganizationUser(int id, Integer[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int unBindOrganizationUser(int id, Integer[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

}
