package net.hnkj.springboot0202.controller;

import net.hnkj.springboot0202.model.TreeNode;
import net.hnkj.springboot0202.service.ITreeNodeService;
import net.hnkj.springboot0202.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin
public class TreeNodeController {

    @Autowired
    private ITreeNodeService treeNodeService;

    @RequestMapping("/listMenu")
    public JsonData listMenu(TreeNode treeNode){
        JsonData jsonData = new JsonData();

        //查询所有的父节点，并查询出父节点下的子节点
        List<TreeNode> treeNodes = treeNodeService.listTreeNode(treeNode);

        jsonData.setCode(0);
        jsonData.setMessage("菜单初始化成功");
        //将节点对象放入到jsonData中
        jsonData.setRows(treeNodes);

        return jsonData;
    }

}
