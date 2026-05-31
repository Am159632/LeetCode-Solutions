/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("X,");
            return;
        }
    
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    Queue<Integer> queue = new LinkedList<>();
    for (String s : data.split(",")) {
        if (s.equals("X")) {
            queue.add(null);
        } else {
            queue.add(Integer.parseInt(s));
        }
    }
    return deserializeHelper(queue);
}

private TreeNode deserializeHelper(Queue<Integer> queue) {
    Integer current = queue.poll();
    if (current == null) {
        return null;
    }
    
    TreeNode root = new TreeNode(current);
    root.left = deserializeHelper(queue);
    root.right = deserializeHelper(queue);
    
    return root;
}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));