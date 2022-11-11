package net.hnkj.springboot0202.mapper;

import net.hnkj.springboot0202.model.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeNodeMapper {
    int deleteByPrimaryKey(Integer treeNodeId);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    TreeNode selectByPrimaryKey(Integer treeNodeId);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);

    //查询所有的父节点
    List<TreeNode> listTreeNode(TreeNode treeNode);

    //查询父节点下面的子节点
    List<TreeNode> listChildrenTreeNode(Integer parentNodeId);
}