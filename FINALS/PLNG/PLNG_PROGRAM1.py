class Node:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def preorder(root):
   
    if root is None:
        return []
    
    return [root.value] + preorder(root.left) + preorder(root.right)


def inorder(root):
    
    if root is None:
        return []
  
    return inorder(root.left) + [root.value] + inorder(root.right)


def postorder(root):
   
    if root is None:
        return []
   
    return postorder(root.left) + postorder(root.right) + [root.value]



root = Node(10)
root.left = Node(5, Node(2), Node(7))
root.right = Node(15, Node(12), Node(20))


pre_res = preorder(root)
in_res = inorder(root)
post_res = postorder(root)


print("Preorder traversal: ", pre_res)
print("Inorder traversal:  ", in_res)
print("Postorder traversal:", post_res)


assert pre_res[0] == 10 and post_res[-1] == 10, "Root position check failed"
assert len(pre_res) == len(in_res) == len(post_res) == 7, "Node count check failed"
assert preorder(None) == [] and inorder(None) == [] and postorder(None) == [], "Empty tree check failed"
print("\nAll required checks passed successfully!")
