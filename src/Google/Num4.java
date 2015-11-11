package Google;
import java.util.*;

//leet code 117
public class Num4 {
    public class TreeLinkNode {
       TreeLinkNode left, right, next;
       int val;
       TreeLinkNode(int x) { val = x; }
    }
    
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        //BFS maintain a list
        List<TreeLinkNode> list = new ArrayList<>();
        list.add(root);
        
        while (list.size() != 0) {
            
            List<TreeLinkNode> next = new ArrayList<>();
            //add the children of nodes in the list to next list
            //connect the nodes in the current list
            for (int i = 0; i < list.size(); i++) {
                TreeLinkNode node = list.get(i);
                //add its childern
                if (node.left != null)
                    next.add(node.left);
                
                if (node.right != null)
                    next.add(node.right);
                    
                //connect to the same level rightside neighbor
                if (i + 1 < list.size())
                    node.next = list.get(i + 1);
                else
                    node.next = null;
            }
            
            list = next;
        }
        
        return;
    }
    
    public static void main(String[] args) {
        Num4 q = new Num4();
        TreeLinkNode root = q.new TreeLinkNode(0);
        connect(root);
    }
}
