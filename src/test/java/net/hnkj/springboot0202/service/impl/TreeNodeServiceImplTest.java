package net.hnkj.springboot0202.service.impl;

import net.hnkj.springboot0202.model.TreeNode;
import net.hnkj.springboot0202.service.ITreeNodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TreeNodeServiceImplTest {

    @Autowired
    private ITreeNodeService treeNodeService;
    private TreeNode treeNode;

    @BeforeEach
    void setUp() {
        treeNode = new TreeNode();
    }

    @Test
    void listTreeNode() {
        List<TreeNode> treeNodes = treeNodeService.listTreeNode(treeNode);
        for (TreeNode node : treeNodes) {
            System.out.println(node);
        }

    }
}