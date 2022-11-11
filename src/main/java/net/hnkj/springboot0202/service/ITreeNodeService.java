package net.hnkj.springboot0202.service;

import net.hnkj.springboot0202.model.TreeNode;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ITreeNodeService {
    int deleteByPrimaryKey(Integer treeNodeId);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    @Transactional(readOnly = true)
    TreeNode selectByPrimaryKey(Integer treeNodeId);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);

    //查询所有的父节点并且级联查询出该节点下的子节点
    List<TreeNode> listTreeNode(TreeNode treeNode);
}