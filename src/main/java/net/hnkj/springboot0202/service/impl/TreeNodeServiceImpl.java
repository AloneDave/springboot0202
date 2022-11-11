package net.hnkj.springboot0202.service.impl;

import net.hnkj.springboot0202.mapper.TreeNodeMapper;
import net.hnkj.springboot0202.model.TreeNode;
import net.hnkj.springboot0202.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeNodeServiceImpl implements ITreeNodeService {

    @Autowired
    private TreeNodeMapper treeNodeMapper;

    @Override
    public int deleteByPrimaryKey(Integer treeNodeId) {
        return 0;
    }

    @Override
    public int insert(TreeNode record) {
        return 0;
    }

    @Override
    public int insertSelective(TreeNode record) {
        return 0;
    }

    @Override
    public TreeNode selectByPrimaryKey(Integer treeNodeId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TreeNode record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TreeNode record) {
        return 0;
    }

    @Override
    public List<TreeNode> listTreeNode(TreeNode treeNode) {

        //1、查询所有的父节点
        List<TreeNode> treeNodes = treeNodeMapper.listTreeNode(treeNode);

        //2、遍历父节点，获取父节点的id
        for (TreeNode node : treeNodes) {
            //3、通过父节点id，查询该节点下的子节点
            List<TreeNode> childrens = treeNodeMapper.listChildrenTreeNode(node.getTreeNodeId());
            //4、将该节点下的子节点放入到父节点的children属性中
            node.setChildren(childrens);
        }
        return treeNodes;
    }
}
